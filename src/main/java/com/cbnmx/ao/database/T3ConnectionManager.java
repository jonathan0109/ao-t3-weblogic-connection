package com.cbnmx.ao.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author Jonathan Martínez Hernández
 * @version 1.0
 */

public final class T3ConnectionManager {

    private static Properties properties;
    private static Context context;
    private static DataSource dataSource;
    private static Connection connection;

    private static DataSource getDataSource() {

        properties = new Properties();

        properties.put(Context.INITIAL_CONTEXT_FACTORY, 
            "weblogic.jndi.WLInitialContextFactory");

        properties.put(Context.PROVIDER_URL, 
            "t3://localhost:7001");

        try
        {
            context = new InitialContext(properties);
            dataSource = (DataSource)context.lookup("jdbc/AOAppDS");

            System.out.println("Datasource was found!");
        
        } catch(NamingException namingException) {

            System.out.println("Searching datasource failed : " 
                + namingException);
        }

        return dataSource;
    }

    public static Connection getConnection() {

        if (connection == null) {

            try
            {
                connection = getDataSource().getConnection();

                System.out.println("Successful connection!");

            } catch(SQLException sqlException) {

                System.out.println("Database connection failed : " 
                + sqlException);
            }
        }

        return connection;
    }

    public static void closeConnection() {

        if (connection != null) {

            try
            {
                connection.close();
                context.close();

                connection = null;
                context = null;

                System.out.println("Connection closed!");

            }catch(SQLException sqlException) {

                System.out.println("Closing connection failed : " 
                    + sqlException);

            }catch(NamingException namingException) {

                System.out.println("Closing context failed : " 
                    + namingException);
            }
        }
    }
}