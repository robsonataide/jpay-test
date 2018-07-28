# Code Challenge for jpay-test

[![License](https://img.shields.io/aur/license/yaourt.svg)](https://www.gnu.org/licenses/gpl.html)

Rest API that consuming another API and translate for an expectated json

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

Call url
```shell
curl -H "http://localhost:8080/card-scheme/verify/5342123453"
```
