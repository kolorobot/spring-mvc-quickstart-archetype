Spring MVC Quickstart Maven Archetype
======================================

Summary
-------
The project is a Maven archetype for Spring MVC web application.

Generated project characteristics
-------------------------
* No-xml Spring MVC web application
* Thymeleaf, Bootstrap
* JPA (Hibernate/HSQLDB/Spring Data JPA)
* JUnit/Mockito
* Spring Security
* MongoDB (Spring Data Mongo)

Prerequisites
-------------

- JDK 8 (tested with Java 11)
- Maven 3 (tested with 3.6.0)

Create a project
----------------

```bash
    mvn archetype:generate \
        -DarchetypeGroupId=pl.codeleak \
        -DarchetypeArtifactId=spring-mvc-quickstart \
        -DarchetypeVersion=5.0.1 \
        -DgroupId=my.groupid \
        -DartifactId=my-artifactId \
        -Dversion=version \
        -DarchetypeRepository=http://kolorobot.github.io/spring-mvc-quickstart-archetype
```

Note: The above command will bootstrap a project using the archetype published here: http://kolorobot.github.io/spring-mvc-quickstart-archetype

Run the project
----------------

Navigate to newly created project directory (`my-artifactId`) and then run:

```bash
    mvn test tomcat7:run
```

> Note: I do not recommend this way of running the artifact. Tomcat Maven Plugin Version 2.2 was released on 2013-11-11 

Test in the browser
-------------------

	http://localhost:8080/

Note: No additional services are required in order to start the application. Mongo DB configuration is in place but it is not used in the code.

Create a new project in IntelliJ
--------------------------------

* Create new project `File > New > Project`
* Click Maven on the left hand side of the new project dialog
* Check `Create from archetype`
* Click the `Add Archetype` button
* Set `Group Id` to `pl.codeleak`
* Set `Artifact Id` to `spring-mvc-quickstart`
* Set `Version` to `5.0.1`
* Set `Repository` to `http://kolorobot.github.io/spring-mvc-quickstart-archetype`
* Click next and create the project

Note: If you would like to create a project using archetype published in your local repository, skip repository field and make sure it is installed locally (see below).

Creating a new project in Spring Tool Suite
-------------------------------------------

* Create new project `File > New > Maven Project`
* Make sure `Create a simple project` option is not selected
* Click `Next` to navigate to `Select an Archetype` screen
* Make sure `Include snapshot archetypes` is selected
* Click `Add Archetype` button
* Set `Archetype Group Id` to `pl.codeleak`
* Set `Archetype Artifact Id` to `spring-mvc-quickstart`
* Set `Archetype Version` to `5.0.1`
* Set `Repository URL` to `http://kolorobot.github.io/spring-mvc-quickstart-archetype`
* Click `OK` so the Archetype is added to the list
* Click `Next` and fill in `Group Id`, `Artifact Id` and `Version` of your new project

Note: Remember so select `Include snapshot archetypes`. 

If you have any troubles with installation in Eclipse, you may want to have a look at this issue: #74


Install archetype locally
-------------------------

To install the archetype in your local repository execute the following commands:

```bash
    git clone https://github.com/kolorobot/spring-mvc-quickstart-archetype.git
    cd spring-mvc-quickstart-archetype
    mvn clean install
```

Create a project from a local repository
----------------------------------------

Create a new empty directory for your project and navigate into it and then run:

```bash
    mvn archetype:generate \
        -DarchetypeGroupId=pl.codeleak \
        -DarchetypeArtifactId=spring-mvc-quickstart \
        -DarchetypeVersion=5.0.1 \
        -DgroupId=my.groupid \
        -DartifactId=my-artifactId \
        -Dversion=version
```

Note: The above command will bootstrap a project using the archetype published in your local repository.

Switching to PostgreSQL
-----------------------

* Add dependency to PostgreSQL driver in POM:

```
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>9.4.1207</version>
</dependency>
```

* Change `persistence.properties`:

```
dataSource.driverClassName=org.postgresql.Driver
dataSource.url=jdbc:postgresql:postgres
dataSource.username=postgres
dataSource.password=postgres

hibernate.dialect=org.hibernate.dialect.PostgreSQL9Dialect
hibernate.hbm2ddl.auto=create
hibernate.show_sql=true
hibernate.format_sql=true
hibernate.use_sql_comments=true
```

Enabling MongoDB repositories
-----------------------------

* Open MongoConfig class and uncomment the following line:

```
// @EnableMongoRepositories(basePackageClasses = Application.class)
```

Now you can add repositories to your project:

```
@Repository
public interface MyRepository extends MongoRepository<MyDocument, String> {

}
```
