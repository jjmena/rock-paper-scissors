# Rock, Paper, Scissors API

## Overview
REST API to play Rock, Paper, Scissors game

## Requirements
To build it:

- Java JDK 8+
- Maven 3+

If you want to launch it in local you can launch it using these mvn command:

To compile and build it:

``` mvn clean package ```

To run it:
 
``` mvn spring-boot:run -Dspring-boot.run.profiles=dev ```

## Container

It's enabled a way to generate a docker image executable with the application itself. To generate it this command should be launched:

``` mvn clean package ```

It will generate a new image tagged with: ciklum/rock-paper-scissors:0.0.1-SNAPSHOT. 

After that it would be launched with: 

``` docker run -p 8080:8080  ciklum/rock-paper-scissors:0.0.1-SNAPSHOT ```

## Documentation
REST API documentation is built in RAML. This file is located in

```spec/api.raml```








