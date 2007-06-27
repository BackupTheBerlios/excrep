Quick-Start FAQ
===============
                                                          Christoph Knabe, 2007-06-27
                                                          
The Central Exception Reporting Sample Application.

- It's a little application for managing clients. You can create, edit, list, and delete clients.
- You can run it in 4 variants:  {Struts|Swing} * {Java|AspectJ}
- It is derived from the Struts Blank application.
- You can get the complete distribution from http://excrep.berlios.de/ by CVS

What platform does this application need?

- JDK 5.0, and
- AspectJ 5
- Tomcat 5 (Servlet 2.4 and JSP 2.0 container)
- Struts 1.3.8 (contained in folder WEB-INF/lib)

How do I run and test the web application?

- type   ant java   or   ant aspectj   at the command prompt.
- See the example Context file excrep.xml at the end of this document. Use it to ...
- Deploy the directory excrep/sample/web to the web container as context /excrep
- Browse http://localhost:8180/excrep
- Elect "Create Client"
- Type in and Save some clients, they will be stored in file Persistence.ser in the working directory
- Observe exception messages after data errors (e.g. empty birth date)
- Click button List
- Provoke a low-level exception by making the file Persistence.ser read-only and trying to Save a client.

How do i run and test the Swing application?

- type   ant runJ   or   ant runA   at the command prompt.
- You can do the same things as above for testing the Swing application.

What targets does the build file accept?

- "clean" to delete the old class, resource, and configuration files. 

- "java" to rebuild the Java class files and copy over the resource and configuration files. 

- "aspectj" to rebuild the Java class files by the AspectJ compiler and copy over the resource and configuration files. 

- "runJ" to compile and run the Swing app using only Java

- "runA" to compile and run the Swing app using AspectJ

- "project" to also generate the Javadoc.

- "all" for a clean rebuild the project and binary distributions.

Where are the binary distributions placed?

- By default, under /projects/lib on your default drive. You can change these through the "distpath.project" variable in the build file.

Where's the Message Resources (fka Application Resources)?

- It's named MessageResources.properties. The original is under WEB-INF/src/java/. The resource bundle is copied under classes during a build.

Why did the changes to my classes/MessageResources.properties or other resource file disappear?
Why didn't the changes to my java/MessageResources.properties or other resource file appear?

- The original resource files are under WEB-INF/src/java and copied under classes during a build. Change the WEB-INF/src/java versions and rebuild before redeploying.





<!--
    D:\Java\jakarta-tomcat-5.0.27\conf\Catalina\localhost\excrep.xml
    Context configuration file for the Central Exception Reporting Sample Application
    Knabe 04-09-29
-->

<Context path="/excrep" docBase="D:/excrep/sample/web"
        debug="3" privileged="true">

  <!-- Link to the user database we will get roles from -->
  <ResourceLink name="users" global="UserDatabase"
                type="org.apache.catalina.UserDatabase"/>

</Context>

###