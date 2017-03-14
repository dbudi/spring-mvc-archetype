Spring MVC 4 Maven Archetype Project Template
=============================================

Summary
-------
The project is a source to create Maven archetype for Spring MVC 4 web application.

Generated project characteristics
-------------------------
* No-xml Spring MVC 4 web application for Servlet 3.0 environment
* Spring Security 4
* CSS3 Template : [Twitter Bootstrap v3.3.6](http://getbootstrap.com/)
* View Resolver : [Thymeleaf](http://www.thymeleaf.org/)
* Javascript: [Jquery 1.12.4](http://jquery.com/)
* Grid/Paging: [Jquery Datatables 1.10.13](http://datatables.net/)
* Spring Security
* Spring Data JPA [Spring Data JPA](http://projects.spring.io/spring-data-jpa/)
* MongoDB (Spring Data Mongo)
* JUnit/Mockito

Prerequisites
-------------

- JDK 8
- Maven 3

Features
--------
* Support various database connection (oracle, mysql, postgresql, sqlserver, derby, hsqldb, h2). Default: hsqldb
* Audit trail already implemented
* Support Active Directory authentication
* User Management already implemented
* Access Role

Create maven archetype and install it locally
---------------------------------------------

```bash
    git clone https://github.com/dbudi/spring-mvc4-archetype.git
    cd spring-mvc4-archetype
    mvn archetype:create-from-project
```

After that, go to `target/generated-source/archetype/` to find the archetype the plugin generates for you.

Edit `generated-sources/archetype/src/main/resources/archetype-resources/src/main/webapp/WEB-INF/web.xml` and `generated-sources/archetype/src/main/resources/archetype-resources/src/main/resources/logback.xml`, replace `version="${version}"` with `version="1.0"`

After you clean up the code, run

```bash
    mvn clean install 
```

to install the archetype to local repository. 

Create a project from a local repository
----------------------------------------

Create a new empty directory for your project and navigate into it and then run:

```bash
    mvn archetype:generate -DarchetypeCatalog=local
```

Apply filter `spring-mvc4` then choose `com.github.dbudi:spring-mvc4-archetype`

Define value for property `groupId`,`artifactId`, `version` and `package`

Alternatively, you can run this command:

```bash
    mvn archetype:generate \
        -DarchetypeGroupId=com.github.dbudi \
        -DarchetypeArtifactId=spring-mvc4-archetype \
        -DarchetypeVersion=1.0 \
        -DgroupId=my-groupid \
        -DartifactId=my-artifactId \
        -Dversion=version
```

Change the value of `my-groupid`, `my-artifactId`, and `version` in the command above.

Note: The above command will bootstrap a project using the archetype published in your local repository.

Compile the project
-------------------

Navigate to newly created project directory (`my-artifactId`) and then run:

```bash
	mvn clean install
```
Compile, generate database table and run test

```bash
	mvn clean install -Dhbm2ddl=create -DskipTests=false
```


Run the project
----------------

Navigate to newly created project directory (`my-artifactId`) and then run:

```bash
	mvn clean tomcat7:run
```

Test in the browser
-------------------

	http://localhost:8080/my-artifactId

Note: No additional services are required in order to start the application. Mongo DB configuration is in place but it is not used in the code.

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

Reference
---------
1. Rafal Borowiec blog [codeleak.pl](http://blog.codeleak.pl/2016/01/spring-mvc-4-quickstart-maven-archetype.html)
2. Spring Data JPA Tutorial: Auditing [petrikainulainen.net](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-auditing-part-one/)
3. Spring Data JPA Tutorial: Introduction to Query Methods [petrikainulainen.net](https://www.petrikainulainen.net/programming/spring-framework/spring-data-jpa-tutorial-introduction-to-query-methods/)
