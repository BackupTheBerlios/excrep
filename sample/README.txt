Quick-Start FAQ
===============

The Central Exception Reporting Sample Application.

- It's a little application for managing clients. You can create, edit, list, and delete clients.
- It is derived from the Struts Blank application.

What platform does this application need?

- JDK 5.0, and
- AspectJ 5
- Tomcat 5 (Servlet 2.4 and JSP 2.0 container)
- Struts 1.3.8 (contained in folder WEB-INF/lib)

How do I start the web application?

- type   ant compile  at the command prompt.
- Deploy the directory excrep to the web container as context /excrep
- Browse http://localhost:8180/excrep
- Elect "Create Client"
- Type in and Save some clients, they will be stored in file Persistence.ser in the working directory
- Observe exception messages after data errors (e.g. empty birth date)
- Click button List
- Provoke a low-level exception by making the file Persistence.ser read-only and trying to Save a client.

How do i start the Swing application?

- Start java with swing_ui.ClientSwingApplication as main class and WEB-INF/classes and all .jar files
from WEB-INF/lib in the classpath. 
- You can do the same things for testing the Swing application.

What targets does the build file accept?

- "clean" to delete the old class, resource, and configuration files. 

- "compile" to rebuild the Java class files and copy over the resource and configuration files. 

- "project" to also generate the Javadoc.

- "all" for a clean rebuild the project and binary distributions.

Where are the binary distributions placed?

- By default, under /projects/lib on your default drive. You can change these through the "distpath.project" variable in the build file.

Where's the Message Resources (fka Application Resources)?

- It's named MessageResources.properties. The original is under WEB-INF/src/java/. The resource bundle is copied under classes during a build.

Why did the changes to my classes/MessageResources.properties or other resource file disappear?
Why didn't the changes to my java/MessageResources.properties or other resource file appear?

- The original resource files are under WEB-INF/src/java and copied under classes during a build. Change the WEB-INF/src/java versions and rebuild before redeploying.

###