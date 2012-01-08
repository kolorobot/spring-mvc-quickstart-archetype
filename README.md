Spring MVC 3.1 Quickstart Maven Archetype
=========================================

Summary
-------
The project is a Maven archetype for Spring MVC 3.1 web application.

Generated project characteristics
-------------------------
* Spring MVC 3.1.0.RELEASE configured using @Configuration classes
* Apache Tiles with configuration in place
* JPA 2.0 (Hibernate/HSQLDB)
* JUnit/Mockito

Usage
-----
1. run `mvn install` to install the archetype in your local repository
2. create project using the archetype:

    mvn archetype:generate
    -DarchetypeGroupId=com.github.spring-mvc-archetypes
    -DarchetypeArtifactId=spring-mvc-quickstart
    -DarchetypeVersion=1.0.0-SNAPSHOT
    -DgroupId=my.groupid
    -DartifactId=my-artifactId
    -Dversion=version

3. run `mvn tomcat:run` in the generated project directory

      