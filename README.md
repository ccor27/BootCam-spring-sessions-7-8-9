# BootCamp-spring-sessions-7-8-9

  Project spring boot to practice JPA and testing.
  
## tools

-Spring boot
-H2 with database
-Spring web
-Spring DevTools
-Spring JPA
-Swagger to document the application

## built with 

-java
-Spring boot

## About the application 

API REST that store objects "laptops" in database but in this case we use H2 like a database, 
you can use a real database like postgresql, mysql or any other, you should configure it from
application.properties.
This application has documentation that explain more clear as run the methods.

## How access to the methods and documentation

After you run the application, you can access to the documentation from browser there you find the
methods that can you use.

with this link you can see the documentation: http://localhost:8081/swagger-ui/
if you want change the port, you can change in application.properties.


## Security

This application has two users to access, there are:
 - user 1:
     user 
     password: 1234
 - user 2:
     admin 
     password: 5678

Currently the only user that can permission to access is user 2 "admin", if you want change it, you can  
modify the class "WebSecurityConfig" into the package "config".  

