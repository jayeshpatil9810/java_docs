ejb-tut1: Deployment of an EAR Containing a JSP,Servlet WAR and EJB JAR

The ejb-tut1 demonstrates how to deploy an EAR archive that contains a JSP,Servlet WAR and an EJB JAR.
What is it?
The ejb-tut1 demonstrates the deployment of an EAR artifact to Red Hat JBoss Enterprise Application Platform. The EAR contains a JSF WAR and an EJB JAR.

This example consists of the following Maven projects, each with a shared parent.

Project	Description
1.ejb- This project contains the EJB code and can be built independently to produce the JAR archive.

2.web- This project contains the JSP pages and the Servlet.

3.ear-This project builds the EAR artifact and pulls in the EJB and web artifacts.

The root pom.xml builds each of the subprojects in the above order and deploys the EAR archive to the server.

The example follows the common "Hello World" pattern, using the following workflow.

* A JSP page asks for a user name.

* On clicking Greet, the name is sent to a servlet named GreetingServlet.

* On setting the name,It performs a JNDI lookup to locate a remote EJB named "GreetingEJB." This EJB is expected to be registered in the JNDI namespace with the specified JNDI name.
 The obtained greeting message is stored as a request attribute named "responseMessage." Request attributes are used to pass data between servlets and JSPs or between different parts of a servlet.
 Finally, the servlet forwards the request and response objects to an "index.jsp" page, which is likely responsible for displaying the greeting message to the user.

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
The application will be running at the following URL http://localhost:8080/ejb-tut1-war/.

Enter a name in the input field and click the Greet button to see the response.

Undeploy the Quickstart
When you are finished testing the quickstart, follow these steps to undeploy the archive.

Make sure you start the JBoss EAP server as described above.

Open a terminal and navigate to the root directory of this quickstart.

Type this command to undeploy the archive:

$ mvn wildfly:undeploy
Run the Quickstart in Red Hat CodeReady Studio or Eclipse
You can also start the server and deploy the quickstarts or run the Arquillian tests in Red Hat CodeReady Studio or from Eclipse using JBoss tools. For general information about how to import a quickstart, add a JBoss EAP server, and build and deploy a quickstart, see Use Red Hat CodeReady Studio or Eclipse to Run the Quickstarts.

For this quickstart, follow the special instructions to build Quickstarts Containing an EAR.

Right-click on the ejb-tut1-ear subproject, and choose Run As → Run on Server.

Choose the server and click Finish.

This starts the server, deploys the application, and opens a browser window that accesses the running application.

To undeploy the project, right-click on the ejb-tut1-ear project and choose Run As → Maven build. Enter wildfly:undeploy for the Goals and click Run.

Debug the Application
If you want to debug the source code of any library in the project, run the following command to pull the source into your local repository. The IDE should then detect it.

$ mvn dependency:sources
JBoss EAP for OpenShift Incompatibility
This quickstart is not compatible with JBoss EAP for OpenShift or JBoss EAP for OpenShift Online templates.

