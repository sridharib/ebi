## Person service

This is a sample project to demonstrate person service. 

###### Commands to build & run this application
```
cd person-service
mvn clean install
sudo docker build -t person-service .
sudo docker run -p 8080:8080 person-service  
```

Once the server is up & running then go to

> http://localhost:8080/swagger-ui/

**The delete endpoint is secured with basic authentication. Use the credentials user/user.**

###### Technologies used
```
Java 11, Spring Boot, Spring Security, Lombok, Swagger, H2 in memory DB, jUnit & Mockito  
Maven, Docker
```
