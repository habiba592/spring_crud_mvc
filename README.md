# Spring MVC Project

This is a basic Spring MVC project that demonstrates how to create a simple CRUD API's in web application using Spring MVC.

## Technologies Used
- Spring MVC
- Java
- Maven

## Getting Started

### Project Creation:
   1. create new project Of Maven Archetype.
   2. give the name to the project
   3. select location where you want to place your project.
   4. add the Archetype which is "org.apache.maven.archetypes:maven-archetype-webapp"
   5. Click on create button.

### Setup:

1. Add the dependencies in pom.xml which is required according to your project.

2. Create a dispatcher-servlet.xml file. This file is used to configure the Spring MVC framework for a web application.

3. In web.xml, configure the sets up of the Servlet container for the web application, including specifying the display name, welcome files, servlet, and servlet mapping for the Spring MVC framework.


### Application Design
The application has the following package structure:
- `com.springmvc.controller`: Contains the CRUD APIs.
- `com.springmvc.model`: Contains the entitiy.
- `com.springmvc.service`: Contains the service layer.

### Endpoints
The following endpoints are available for the CRUD operations:
- GET `/api/getAllUsers`: Retrieves a list of all users.
- GET `/api/getUserById/{id}`: Retrieves a specific user by id.
- POST `/api/addUser`: Creates a new user. 
- DELETE `/api/DeleteUser/{id}`: Delete a user by Id. 
- UPDATE `/api/updateUser/{id}`: Update a user by Id. 

## Tomcat SetUp
1. Click on File -> Settings => Add tomcat and install it.
2. Click on Edit Configuration => + => add the Tomcat path.
3. Click on Deployment Next to Server and Add the war file in it.
4. Click Apply and Ok.

### Autowiring in Spring MVC:
Spring Mvc directly not support @autowired, So for that we required
1. In the spring-mvc-servlet.xml file, the <context:annotation-config/> and <context:component-scan/> tags are used to enable annotation-based configuration and to scan for components in the com.springmvc.* package and its subpackages, respectively.
2. The web.xml file configure the spring framework to load the spring-mvc-servlet.xml file at the time of application startup.