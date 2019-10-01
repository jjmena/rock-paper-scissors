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

By default it's configured to be launched (for all profiles)

* Port: 8080
* Context Path: /
* CORS enabled for: http://localhost:3000

There are two profiles:

- dev
- default

Both are configured with the same configuration in 

``` application.properties ```
``` application-dev.properties ```

Both could be configured to change even port, root path and CORS enabled. For example:

```
application.cors.origins=http://localhost:4000
server.port=9090
server.contextPath =/myapi
```

## Documentation
REST API documentation is built in RAML. This file is located in

```spec/api.raml```

It is used to document API exposed and it's used to validate it through existing tests.

It's not exposed in the API as public document. It could be exposed copying it to a `static` folder to enable to share it.

Furthermore, there are existing tools to convert it from RAML to a prettier format such as HTML.
