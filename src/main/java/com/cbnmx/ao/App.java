package com.cbnmx.ao;

import com.cbnmx.ao.database.T3ConnectionManager;

public class App 
{
    public static void main( String[] args )
    {
        T3ConnectionManager.getConnection();
        T3ConnectionManager.closeConnection();
    }
}
