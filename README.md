# RestAPI with Java 11, Tomcat 9, Spring Boot 2.1.2-SNAPSHOT and Docker

# Build
## To build Tomcat-deployable WAR application and docker image:
```mvn clean package install```

# Start the application:
```docker run -d -t -p 8081:8080 khteh/tomcat:restapi-1.0```

* visit http://localhost:8888/restapi/greeting
* visit http://localhost:8888/restapi/greeting?name=Mickey%20Mouse
