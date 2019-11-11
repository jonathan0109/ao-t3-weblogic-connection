# T3 Client

RMI communications in WebLogic Server use the T3 protocol to transport data between WebLogic Server and other Java programs, including clients and other WebLogic Server instances. A server instance keeps track of each Java Virtual Machine (JVM) with which it connects, and creates a single T3 connection to carry all traffic for a JVM.

This type of connection maximizes efficiency by eliminating multiple protocols used to communicate between networks, thereby using fewer operating system resources. The protocol used for the T3 connection also enhances efficiency and minimizes packet sizes, increasing the speed of the delivery method.

## Getting Started

A T3 client:

* Is an RMI client that uses the Java-to-Java model of distributed computing. 
* **You cannot integrate clients written in languages other than Java**
* Uses BEA’s proprietary T3 protocol to communicate with Java programs
* The URL used for the initial context takes the form **t3://ip address:port**

External clients do not care if an application is hosted on domain level or inside a partition. For external clients this MUST be completely transparent. Using http requests, this is relatively easy as a virtual target either has a unique set of host and port or a unique URL prefix.

### Prerequisites

Requires in your classpath : 

```
wlfullclient.jar
```

If you are using Maven, the easiest thing to do is, to install this specific jar to your local repository. Usually that resides in the ~/.m2 folder (Mac/Unix) or C:\Documents and Settings{your-username}.m2 for windows. 

So what you need to do is apply the following command (example):

```
mvn install:install-file -Dfile=wlfullclient-x.x.x.jar 
                         -DpomFile=wlfullclient-x.x.x.pom 
                         -DgroupId=com.weblogic 
                         -DartifactId=wlfullclient 
                         -Dversion=x.x.x 
                         -Dpackaging=jar
```
For more information :

https://maven.apache.org/guides/mini/guide-3rd-party-jars-local.html