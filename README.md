# Java RestAPI with GRPC, Java 13, Tomcat 9, Spring Boot 2.4.0-SNAPSHOT and Docker
* 4 controllers:
  - Greeting
  - Book
  - Author
  - Course (GRPC)

# The following protocols are used:
* HTTP/2
* GRPC
  
# Build

## Database
* Create "library" database:
```
CREATE DATABASE `library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
```
* Import "Library" database tables from src/main/resources/db folder

## Protocol Buffer
* Download procotol buffer compiler from https://github.com/protocolbuffers/protobuf/releases
* Extract the downloaded .zip and copy protoc binary to system folders, /usr/local/bin, for instance

## To build Tomcat-deployable WAR application and docker image:
`mvn clean install`

## Continuous Integration
* Integrated with CircleCI

# Start the application:
`docker run -d -t -p 8081:8080 khteh/restapi:latest`

* visit http://localhost:port/restapi/greeting
* visit http://localhost:port/restapi/greeting?name=Mickey%20Mouse
* visit http://localhost:port/restapi/book
* visit http://localhost:port/restapi/author
* visit http://localhost:port/restapi/course
