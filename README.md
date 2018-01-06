# MySpringApplication

## Description
This project is my attempt to develop a simple web application with a "backend service" 
using Spring 4, JUnit 4, Java 8, RestTemplate, Gradle, and Tomcat.  

## Getting Started
1. Use 'tomcatRun' or 'tomcatRunWar' gradle task to start a tomcat instance, and deploy to it.
2. Either run [http://localhost:8080/application](http://localhost:8080/application) from the
browser, or run 'Application.main()' from your IDE.

## Next Steps
- Migrate application to Java 9.
- Add an in-memory database, like H2.

## Known Issues
- I wanted to develop this application using Spring Annotation Configuration (no xml configuration), but the
'tomcatRun' gradle task would not work (returned a 404 message) until I added a .../main/webapp/WEB-INF/web.xml file.  

## References
[Gradle Tomcat Plugin](https://github.com/bmuschko/gradle-tomcat-plugin)  
[Spring4 Restful Example](https://github.com/viralpatel/spring4-restful-example)  
[Spring4 Annotation Configuration](http://javacodeimpl.blogspot.com/2017/02/spring-4-annotation-configuration.html)  

