# MySpringApplication

## Description
This project is my attempt to develop a simple web application with a "backend service" 
using Spring 4, JUnit 4, Java 8, RestTemplate, Gradle, and Tomcat.  

## Getting Started
1. Use 'tomcatRun' or 'tomcatRunWar' gradle task to start a tomcat instance, and deploy to it.
2. Either run [http://localhost:8080/application](http://localhost:8080/application) from the
browser, or run 'ClientTest' from your IDE.

## Next Steps
- Update welcome (default view) page.
- Migrate application to Java 9.
- Add an in-memory database, like H2.

## Considerations
- Standard Spring MVC project structure seems to be that the view directory is under the 
WEB-INF directory.  This enforces good habits (like MVC), but it prevents you from accessing
the page directly.

## Known Issues
- I wanted my default home page to be an html file (index.html), but I kept getting 404 errors.  Either no mapping could 
be found, or I was unable to get the ViewResolver to ignore the html files. 

## References
[Gradle Tomcat Plugin](https://github.com/bmuschko/gradle-tomcat-plugin)  
[Spring4 Restful Example](https://github.com/viralpatel/spring4-restful-example)  
[Spring4 Annotation Configuration](http://javacodeimpl.blogspot.com/2017/02/spring-4-annotation-configuration.html)  

