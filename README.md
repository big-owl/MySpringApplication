# MySpringApplication

## Description
This project is my attempt to develop a simple web application with a "backend service" 
using Spring Boot 3.3.6, Java 17, Gradle 9.3.0, and Tomcat 10.1.33.

## Setup
1. Install sdkman - https://sdkman.io/install/.
2. You should have Java 17 installed.
- To see which Java version is currently active in your shell: "sdk current java". 
- If not java 17, then you can run: "sdk use java 17.0.6-amzn".
3. You should have Gradle 9.3.0 installed. 
- To verify, run "gradle -v"
- If gradle 9.3.0 is not running, then you can run: "sdk install gradle 9.3.0" and then "sdk use gradle 9.3.0".
4. Clone this repository. 
- First navigate to the desired directory. Then run: "git clone https://github.com/big-owl/MySpringApplication.git"

## Getting Started
1. Use the 'bootRun' gradle task to start a tomcat instance (running in the background), and deploy to it. 
- For example: "gradle bootRun".
2. Either run [http://localhost:8080/application](http://localhost:8080/application) from the
browser, or run 'ClientTest' from your IDE.
3. To stop the tomcat instance, press 'Ctrl + C' in the terminal window where 'bootRun' is running.

## How to Use

Run unit tests only (no server required):
> gradle test

Run full build (no server required):
> gradle build

Run integration tests (server must be running):  
// Terminal 1  
> gradlew bootRun

// Terminal 2  
> gradle integrationTest

## Next Steps
- Improve the user entry & store functionality.
- Improve the API user documentation.
- Add Spring Security (authentication + CSRF protection).
- Add logging functionality using Slf4J + Logback.
- Add integration tests using Testcontainers.
- Upgrade Java, Gradle, and Spring versions.
- Improve unit testing using MockMvc.
- Add an in-memory database, like H2.

## Notes
- Both URLs below work the same. But the first option is the standard convention and what users expect.
    - http://localhost:8080/application/ → serves index.html (cleaner, preferred)
    - http://localhost:8080/application/index.html → also serves index.html (explicit)
- If you get an error during "git push" stating "Your push would publish a private email address.", then try this:
    - Find your GitHub noreply address in your GitHub's Personal Settings --> Emails.
    - git config user.email ""
    - git config user email {ID}+{username}@users.noreply.github.com
    - git commit --amend --reset-author
    - git push

## Known Issues
- None at this time.

## References
[Gradle Tomcat Plugin](https://github.com/bmuschko/gradle-tomcat-plugin)<br/>
[Spring4 Restful Example](https://github.com/viralpatel/spring4-restful-example)<br/>
[Spring4 Annotation Configuration](http://javacodeimpl.blogspot.com/2017/02/spring-4-annotation-configuration.html)<br/>
[Spring Validation Example](https://www.journaldev.com/2668/spring-validation-example-mvc-validator)<br/>
[Slf4J Example](http://makble.com/gradle-slf4j-integration-example-with-eclipse)<br/>
[JUnit 5 with Gradle](https://github.com/junit-team/junit5-samples/blob/r5.4.0/junit5-jupiter-starter-gradle/build.gradle)<br/>
  

