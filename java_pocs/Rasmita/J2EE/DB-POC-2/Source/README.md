# java-pocs

#DB-POC-2

# User Management Application

## Overview
This User Management Application focuses on CRUD (Create, Read, Update, Delete) operations for managing user data. It allows you to add new users, retrieve user data in tabular form, update existing user information, and delete user records. The application is built using Java and utilizes JDBC for connecting to and interacting with a MySQL database.

## Project Structure
This project consists of several Maven modules, each serving a specific purpose:
1. **ejb**: Contains the EJB (Enterprise JavaBeans) code and can be built independently to produce the JAR archive.
2. **web**: Contains JSP (JavaServer Pages) pages and Servlets.
3. **ear**: Builds the EAR (Enterprise Archive) artifact, incorporating the EJB and web modules.

The root `pom.xml` builds each of the subprojects in the specified order and deploys the EAR archive to the server.

## Workflow
Here's a high-level overview of the project's workflow:
- A JSP page collects user details like FirstName, LastName.
- Upon clicking "submit," all user details are sent to a servlet named `UserServlet`.
- The servlet performs a JNDI lookup to locate a remote EJB named `UserSessionRemote`. This EJB handles CRUD operations on user data, interacting with a MySQL database via a DataSource.
- Finally, the servlet forwards the request and response objects to a `userList.jsp` page, responsible for displaying user messages.

## MySQL Database Configuration
To configure a MySQL DataSource in JBoss, follow these steps:
1. Download the MySQL JDBC Driver from the official MySQL Connector/J download page.
2. Deploy the MySQL JDBC Driver JAR file to the JBoss server's `standalone/deployments` directory.
3. Configure the MySQL DataSource in the appropriate JBoss configuration file (e.g., `standalone.xml`) with connection details, username, and password.
4. Define the MySQL Driver Module in JBoss's `modules` directory.

## System Requirements
This application is designed to run on Red Hat JBoss Enterprise Application Platform 7.4 or later. You need Java 8.0 (Java SDK 1.8) or later and Maven 3.3.1 or later for building and testing.

## Running the Application
1. Start the JBoss EAP Standalone Server.
2. Build and deploy the application using Maven (`mvn clean install wildfly:deploy`).
3. Access the application in a web browser at `http://localhost:8080/v2-pov-web/userList.jsp`.

## Undeploying the Application
To undeploy the application, use the command: `mvn wildfly:undeploy`.

## Debugging the Application
If you need to debug the source code of any library in the project, run `mvn dependency:sources` to pull the source into your local repository.

## Note on JBoss EAP for OpenShift
This application is not compatible with JBoss EAP for OpenShift or JBoss EAP for OpenShift Online templates.

Enjoy using this User Management Application for your CRUD operations!



