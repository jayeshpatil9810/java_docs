# java-pocs
#POC-1

# Login Form Application

## Overview
The `rasmita.v2.app` project demonstrates how to deploy an EAR (Enterprise Archive) that contains a JSP, Servlet WAR, and an EJB (Enterprise JavaBeans) JAR to Red Hat JBoss Enterprise Application Platform. This example follows a "Hello World" pattern, allowing users to input their name and get a greeting message.

### Project Structure
This project is organized into several Maven modules:
1. **ejb**: Contains EJB code and can be built independently to produce a JAR archive.
2. **web**: Contains JSP pages and Servlets.
3. **ear**: Builds the EAR artifact, pulling in the EJB and web artifacts.

The root `pom.xml` builds each of the subprojects in the specified order and deploys the EAR archive to the server.

### Workflow
Here's a high-level overview of the project's workflow:
- A JSP page, `rasmi.jsp`, asks for a user name.
- On clicking "Login," the name is sent to a servlet named `RasmiServlet`.
- The servlet performs a JNDI lookup to locate a remote EJB named `GreetingEJB`. This EJB is expected to be registered in the JNDI namespace with the specified JNDI name.
- The obtained greeting message is stored as a request attribute named "responseMessage." Request attributes are used to pass data between servlets and JSPs or between different parts of a servlet.
- Finally, the servlet forwards the request and response objects to an "index.jsp" page, which is likely responsible for displaying the greeting message to the user.

### System Requirements
The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform 7.4 or later.

All you need to build this project is Java 8.0 (Java SDK 1.8) or later and Maven 3.3.1 or later. See Configure Maven to Build and Deploy the Quickstarts to make sure you are configured correctly for testing the quickstarts.

### Getting Started
1. Start the JBoss EAP Standalone Server by navigating to the root of the JBoss EAP directory and running the following command:

#$ EAP_HOME/bin/standalone.sh
(For Windows, use `EAP_HOME\bin\standalone.bat`.)

2. Build and deploy the application by running the following command in the root directory of the project:

#$ mvn clean install wildfly:deploy
This deploys the EAR artifact to the running instance of the server.

3. Access the application in a web browser at the following URL: `http://localhost:8080/rasmita-in-web/RasmiServlet`.

4. Enter a name in the input field and click the "Login" button to see the response.

### Undeploying the Application
When you're finished testing the application, follow these steps to undeploy the archive:
1. Ensure the JBoss EAP server is running as described above.

2. Navigate to the root directory of the project in a terminal.

3. Run the following command to undeploy the archive:

#$ mvn wildfly:undeploy

### Debugging the Application
If you want to debug the source code of any library in the project, you can run the following command to pull the source into your local repository, allowing your IDE to detect it:


