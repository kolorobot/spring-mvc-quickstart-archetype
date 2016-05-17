Spring MVC 4 Quickstart Maven Archetype
=========================================

Summary
-------
The project is a Maven archetype for Spring MVC 4 web application.

Generated project characteristics
-------------------------
* No-xml Spring MVC 4 web application
* Thymeleaf, Bootstrap
* JPA (Hibernate/HSQLDB/Spring Data JPA)
* MongoDB (Spring Data Mongo)
* JUnit/Mockito
* Spring Security

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

Create a new empty directory for your project and navigate into it.

```bash
    mvn archetype:generate \
        -DarchetypeGroupId=pl.codeleak \
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

Creating a new project in IntelliJ
----------------------------------

* Create new project `File > New > Project`
* Click Maven on the left hand side of the new project dialog
* Check `Create from archetype`
* Click the `Add Archetype` button
* Set Group Id to `com.github.spring-mvc-archetypes`
* Set Artifact Id to `spring-mvc-quickstart`
* Set Version to `1.0.0`
* Click next and create the project

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
