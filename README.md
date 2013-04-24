Spring MVC 3.2 Quickstart Maven Archetype
=========================================

Summary
-------
The project is a Maven archetype for Spring MVC 3.2 web application.

Generated project characteristics
-------------------------
* No-xml Spring MVC 3.2 web application for Servlet 3.0 environment
* Apache Tiles with configuration in place, Bootstrap
* JPA 2.0 (Hibernate/HSQLDB)
* JUnit/Mockito
* Spring Security 3.1

Installation
------------

run `mvn install` to install the archetype in your local repository

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

	mvn tomcat7:run
	
Creating a new project in Eclipse
----------------------------------

* Install the archetype in local repository with `mvn install`
* Go to `Preferences > Maven > Archetypes` and `Add Local Catalog`
* Select the catalog from file (`archetype-catalog.xml`) 
* Create new Maven project and select the archetype (remember so select `Include snapshot archetypes`).


