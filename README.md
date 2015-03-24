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

To install the archetype in your local repository execute following commands:

```bash
    git clone https://github.com/kolorobot/spring-mvc-quickstart-archetype.git
    cd spring-mvc-quickstart-archetype
    mvn clean install
```

Create a project
----------------

```bash
    mvn archetype:generate \
        -DarchetypeGroupId=com.github.spring-mvc-archetypes \
        -DarchetypeArtifactId=spring-mvc-quickstart \
        -DarchetypeVersion=1.0.0 \
        -DgroupId=my.groupid \
        -DartifactId=my-artifactId \
        -Dversion=version
```

Run the project
----------------

```bash
	mvn test tomcat7:run
```

Test on the browser
-------------------

	http://localhost:8080/

Note: No additional services are required in order to start the application. Mongo DB configuration is in place but it is not used in the code.

Creating a new project in Eclipse
----------------------------------

* Import archetype URI by `Import ... > Projects from Git > Clone URI`
* Install the archetype in local repository with `mvn install`
* Go to `Preferences > Maven > Archetypes` and `Add Local Catalog`
* Select the catalog from file (`archetype-catalog.xml`) 
* Create new Maven project and select the archetype (remember so select `Include snapshot archetypes`)

If you have any troubles with installation in Eclipse, you may want to have a look at this issue: #74
