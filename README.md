Spring MVC 4 Quickstart Maven Archetype
=========================================

Summary
-------
The project is a Maven archetype for Spring MVC 4 web application.

Generated project characteristics
-------------------------
* No-xml Spring MVC 4 web application for Servlet 3.0 environment
* Thymeleaf, Bootstrap
* JPA 2.0 (Hibernate/HSQLDB/Spring Data JPA)
* MongoDB (Spring Data Mongo)
* JUnit/Mockito
* Spring Security 3.2

Installation
------------

run `mvn clean install` to install the archetype in your local repository

Create a project
----------------

    mvn archetype:generate \
        -DarchetypeGroupId=com.github.spring-mvc-archetypes \
        -DarchetypeArtifactId=spring-mvc-quickstart \
        -DarchetypeVersion=1.0.0-SNAPSHOT \
        -DgroupId=my.groupid \
        -DartifactId=my-artifactId \
        -Dversion=version

Run the project
----------------

	mvn test tomcat7:run

Note: No additional services are required in order to start the application. Mongo DB configuration is in place but it is not used in the code.

Creating a new project in Eclipse
----------------------------------

* Import this archetyp's URI by `Import ... > Projects from Git > Clone URI`
* Install the archetype in local repository with `mvn install`
* Go to `Preferences > Maven > Archetypes` and `Add Local Catalog`
* Select the catalog from file (`archetype-catalog.xml`) 
* Create new Maven project and select the archetype (remember so select `Include snapshot archetypes`).
