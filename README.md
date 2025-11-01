# MySpringApplication

## Description
This project is my attempt to develop a simple web application with a "backend service" 
using Spring 5, JUnit 5, Java 8, RestTemplate, Gradle, SLF4J and Tomcat.  

## Setup
1. Install sdkman - https://sdkman.io/install/.
2. You must have Java 8 installed.
- To see which Java version is currently active in your shell: "sdk current java". 
- If not java 8, then you can run: "sdk use java 8.0.462-amzn".
3. You must have Gradle 4.9 installed. 
- To verify, run "gradle -v"
- If gradle 4.9 is not running, then you can run: "sdk install gradle 4.9" and then "sdk use gradle 4.9".
4. Clone this repository. 
- First navigate to the desired directory. Then run: "git clone https://github.com/big-owl/MySpringApplication.git"

## Getting Started
1. Use 'tomcatRun' or 'tomcatRunWar' gradle task to start a tomcat instance (running in the background), and deploy to it. 
- For example: "gradle tomcatRun".
2. Either run [http://localhost:8080/application](http://localhost:8080/application) from the
browser, or run 'ClientTest' from your IDE.
3. To stop the tomcat instance, run "gradle --stop".

## Next Steps
- Upgrade Java, Gradle, and Spring versions.
- Improve unit testing using MockMvc.
- Replace hard-coded values with dependency injection.
- Modularize services.
- Upgrade to Spring Boot.
- Add an in-memory database, like H2.

## Notes
- Both URLs below work the same. But the first option is the standard convention and what users expect.
    - http://localhost:8080/application/ → serves index.html (cleaner, preferred)
    - http://localhost:8080/application/index.html → also serves index.html (explicit)

## Known Issues
- My controller should be stateless.
- The application must be running (tomcatRun) before the "unit tests" can be started.  Otherwise, you will get a 
"connection refused" message.  This also throws off the test coverage metrics.

## References
[Gradle Tomcat Plugin](https://github.com/bmuschko/gradle-tomcat-plugin)<br/>
[Spring4 Restful Example](https://github.com/viralpatel/spring4-restful-example)<br/>
[Spring4 Annotation Configuration](http://javacodeimpl.blogspot.com/2017/02/spring-4-annotation-configuration.html)<br/>
[Spring Validation Example](https://www.journaldev.com/2668/spring-validation-example-mvc-validator)<br/>
[Slf4J Example](http://makble.com/gradle-slf4j-integration-example-with-eclipse)<br/>
[JUnit 5 with Gradle](https://github.com/junit-team/junit5-samples/blob/r5.4.0/junit5-jupiter-starter-gradle/build.gradle)<br/>
  

