db-project: User Management Application -Deployment of an EAR Containing a JSP,Servlet WAR and EJB JAR with MySQL database

This is a User Management App focusing on CRUD operations. This has a basic functionality of managing user data in form of tables. We can add a new user, Getting all the user in the form of table, update an existing user, and delete the user completely.
This project is built using Java and it utilizes JDBC for connecting to and interacting with the database.
The servlet interacts with an EJB (EJBUserSessionBeanRemote) to perform various operations on user data, including adding, editing, deleting, and retrieving users. This demonstrates the integration of servlets with EJBs in a Java EE (Enterprise Edition) application.

What is it?
The db-project demonstrates the deployment of an EAR artifact to Red Hat JBoss Enterprise Application Platform. The EAR contains a JSP,Servlet WAR and an EJB JAR.

This project consists of the following Maven projects, each with a shared parent.

Project	Description
1.ejb- This project contains the EJB code and can be built independently to produce the JAR archive.

2.web- This project contains the JSP pages and the Servlet.

3.ear-This project builds the EAR artifact and pulls in the EJB and web artifacts.

The root pom.xml builds each of the subprojects in the above order and deploys the EAR archive to the server.

 workflow of the project.

* A JSP page asks for a user details like FirstName,LastName,Mobile,Address etc.

* On clicking submit,all the user details sent to a servlet named UsersServlet.

* After that,it performs a JNDI lookup to locate a remote EJB named "EJBUserSessionBeanRemote".This EJB is responsible for performing CRUD (Create, Read, Update, Delete) operations on user data and interacts with a database via a DataSource.
 Finally, the servlet forwards the request and response objects to an "userDetails.jsp" page, which is responsible for displaying the message to the user.


Steps to configure a MySQL DataSource in JBoss:

1.Download MySQL JDBC Driver:
Visit the official MySQL Connector/J download page: https://dev.mysql.com/downloads/connector/j/
Download the latest version of the MySQL JDBC driver (usually a JAR file). Ensure you choose the appropriate version based on your MySQL server version and Java version.
2.Deploy MySQL JDBC Driver:
Copy the downloaded MySQL JDBC driver JAR file to the JBoss server's standalone/deployments directory. JBoss will automatically deploy the driver
3.Configure a MySQL DataSource:
In JBoss, DataSource configurations are typically defined in a configuration file, which can vary depending on your JBoss version and server mode (standalone or domain mode). Common configuration files are standalone.xml for standalone mode and domain.xml for domain mode.
Locate and open the appropriate configuration file using a text editor. For example, if you are using standalone mode, you would edit standalone.xml.
4.Add DataSource Configuration:
<datasource jndi-name="java:jboss/datasources/MySqlDS" pool-name="MySqlDS" enabled="true" use-java-context="true">
  <connection-url>jdbc:mysql://localhost:3306/UserManagement</connection-url>
  <driver>mysql</driver>
  <security>
    <user-name>root</user-name>
    <password>password</password>
  </security>
</datasource>
<drivers>
  <driver name="mysql" module="com.mysql">
    <xa-datasource-class>com.mysql.cj.jdbc.MysqlXADataSource</xa-datasource-class>
  </driver>
</drivers>
5.Define the MySQL Driver Module:
JBoss uses modules to manage drivers. You need to create a module directory and module.xml file for the MySQL driver.
Create a directory for the MySQL driver module in JBoss's modules directory (e.g., <JBoss_Home>/modules/system/layers/base/com/mysql/main).
Inside the module directory, place the MySQL JDBC driver JAR file.
Create a module.xml file in the same module directory with the following content:
<module xmlns="urn:jboss:module:1.3" name="com.mysql">
  <resources>
    <resource-root path="mysql-connector-java-8.0.1.jar"/> 
  </resources>
  <dependencies>
    <module name="javax.api"/>
    <module name="javax.transaction.api"/>
  </dependencies>
</module>

6.Restart JBoss: After making these changes, save the configuration file and restart your JBoss server for the changes to take effect.

System Requirements
The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform 7.4 or later.

All you need to build this project is Java 8.0 (Java SDK 1.8) or later and Maven 3.3.1 or later. See Configure Maven to Build and Deploy the Quickstarts to make sure you are configured correctly for testing the quickstarts.

Use of the EAP_HOME and QUICKSTART_HOME Variables
In the following instructions, replace EAP_HOME with the actual path to your JBoss EAP installation. The installation path is described in detail here: Use of EAP_HOME and JBOSS_HOME Variables.

When you see the replaceable variable QUICKSTART_HOME, replace it with the path to the root directory of all of the quickstarts.

Start the JBoss EAP Standalone Server
Open a terminal and navigate to the root of the JBoss EAP directory.

Start the JBoss EAP server with the default profile by typing the following command.

$ EAP_HOME/bin/standalone.sh 
NOTE
For Windows, use the EAP_HOME\bin\standalone.bat script.
Build and Deploy the Quickstart
Make sure you start the JBoss EAP server as described above.

Open a terminal and navigate to the root directory of this quickstart.

Type the following command to build the artifacts.

$ mvn clean install wildfly:deploy
This deploys the ejb-tut1/ear/target/ejb-tut1.ear to the running instance of the server.

You should see a message in the server log indicating that the archive deployed successfully.

**Access the Application
The application will be running at the following URL http://localhost:8080/db-project-web/userDetails.jsp

Enter all the input field and click on submit to see the response.

Undeploy the Quickstart
When you are finished testing the quickstart, follow these steps to undeploy the archive.

Make sure you start the JBoss EAP server as described above.

Open a terminal and navigate to the root directory of this quickstart.

Type this command to undeploy the archive:

$ mvn wildfly:undeploy
Run the Quickstart in Red Hat CodeReady Studio or Eclipse
You can also start the server and deploy the quickstarts or run the Arquillian tests in Red Hat CodeReady Studio or from Eclipse using JBoss tools. For general information about how to import a quickstart, add a JBoss EAP server, and build and deploy a quickstart, see Use Red Hat CodeReady Studio or Eclipse to Run the Quickstarts.

For this quickstart, follow the special instructions to build Quickstarts Containing an EAR.

Right-click on the db-project-ear subproject, and choose Run As → Run on Server.

Choose the server and click Finish.

This starts the server, deploys the application, and opens a browser window that accesses the running application.

To undeploy the project, right-click on the db-project-ear project and choose Run As → Maven build. Enter wildfly:undeploy for the Goals and click Run.

Debug the Application
If you want to debug the source code of any library in the project, run the following command to pull the source into your local repository. The IDE should then detect it.

$ mvn dependency:sources
JBoss EAP for OpenShift Incompatibility
This quickstart is not compatible with JBoss EAP for OpenShift or JBoss EAP for OpenShift Online templates.




