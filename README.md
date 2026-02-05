# MySpringApplication

## Description
This project is my attempt to develop a simple web application with a "backend service" 
using Spring Boot 4.0.2, Java 25, Gradle 9.3.1, and Tomcat 11.0.15.

## Setup (for Mac)
1. Install sdkman - https://sdkman.io/install/.
2. You should have Java 25 installed.
- To see which Java version is currently active in your shell: "sdk current java". 
- If not java 25, then you can run: "sdk install java <version>" for example "sdk install java 25.0.1-amzn".
3. You should have Gradle 9.3.1 installed. 
- To verify, run "gradle -v"
- If gradle 9.3.1 is not running, then you can run: "sdk install gradle 9.3.1" and then "sdk use gradle 9.3.1".
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
- There appears to be a bug with Gradle that causes it to think there is a JVM version mismatch (running Java 25 with 
Java 17-compiled libraries). This JVM version attribute mismatch causes Gradle to exclude spring-web from the
dependency tree.

  

