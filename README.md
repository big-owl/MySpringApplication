# MySpringApplication

## Description
This project is my attempt to develop a simple web application with a "backend service" 
using Spring 5, JUnit 5, Java 9, RestTemplate, Gradle, SLF4J and Tomcat.  

## Getting Started
1. Use 'tomcatRun' or 'tomcatRunWar' gradle task to start a tomcat instance, and deploy to it.
2. Either run [http://localhost:8080/application](http://localhost:8080/application) from the
browser, or run 'ClientTest' from your IDE.

## Next Steps
- Improve unit testing using MockMvc.
- Replace hard-coded values with dependency injection.
- Modularize services.
- Upgrade to Spring Boot.
- Add an in-memory database, like H2.

## Considerations
- Standard Spring MVC project structure seems to be that the view directory is under the 
WEB-INF directory.  This enforces good habits (like MVC), but it prevents you from accessing
the page directly.

## Known Issues
- I wanted my default home page to be an html file (index.html), but I kept getting 404 errors.  Either no mapping could 
be found, or I was unable to get the ViewResolver to ignore the html files. 
- The application must be running (tomcatRun) before the "unit tests" can be started.  Otherwise, you will get a 
"connection refused" message.  This also throws off the test coverage metrics.

## References
[Gradle Tomcat Plugin](https://github.com/bmuschko/gradle-tomcat-plugin)<br/>
[Spring4 Restful Example](https://github.com/viralpatel/spring4-restful-example)<br/>
[Spring4 Annotation Configuration](http://javacodeimpl.blogspot.com/2017/02/spring-4-annotation-configuration.html)<br/>
[Spring Validation Example](https://www.journaldev.com/2668/spring-validation-example-mvc-validator)<br/>
[Slf4J Example](http://makble.com/gradle-slf4j-integration-example-with-eclipse)<br/>
[JUnit 5 with Gradle](https://github.com/junit-team/junit5-samples/blob/r5.4.0/junit5-jupiter-starter-gradle/build.gradle)<br/>
  

