Test Automation For Premier Farnell Site Registration
======================================================

### Framework Design Approach

Selenium-cucumber is a behavior driven development (BDD) approach to write automation test script to test Web. Framework
has been built using Page Object Model and Page Factory. Page Object Model is a design pattern which has become popular
in test automation for enhancing test maintenance and reducing code duplication. Page Factory is an inbuilt Page Object
Model concept for Selenium WebDriver, but it is very optimized. With the help of PageFactory class, we use annotations
@FindBy to find WebElement and use initElements method to initialize web elements. WebDriverManager library is used,
which allows to automate the management of the binary drivers (e.g. chromedriver, geckodriver, etc.) required by
Selenium WebDriver.

### Tools And Environment

1. IntelliJ IDEA
2. Java-8
3. Maven
4. Enable cucumber-java plugin in IntelliJ
5. Git

If using Windows OS, Configure JAVA_HOME and MAVEN_HOM in the Environmental Variables : Follow the setup instructions
specified in here https://www.mkyong.com/maven/how-to-install-maven-in-windows/

### The project directory structure

The project has build scripts for Maven and below is describes the directory structure of the project

~~~~
src
  + test
    + java                          Test runners and supporting code
    + resources
      + features                    Feature files
          Registration.feature
      config.properties      
      log4j.xml       
      
~~~~

### **Executing the tests**

Please make sure to have all the tools and libraries mentioned in the "Tools And Environment" section.

Step-1: Clone the repository from  https://github.com/arti-seth/premier-farnell-test

Step-2: Use the following maven commands to run the tests.

Run all tests (default: chrome)

~~~~
mvn clean verify
~~~~

Run all UI tests with firefox

~~~~
mvn clean verify -Dbrowser=firefox
~~~~

Run all UI tests with IE

~~~~
mvn clean verify -Dbrowser=ie
~~~~

Run all tests with a specific tag

~~~~
mvn clean verify -Dcucumber.options="--tags @regremember"
or 
mvn clean verify -Dcucumber.options="--tags @regdontremember"

~~~~

### Cucumber Test Reports

An HTML report is generated in `target/cucumber-html-reports` directory

~~~~
overview-features.html - The graphs show passing and failing statistics for features in web format
overview-steps.html    - The graph shows step statistics for this build
~~~~

#### Logging

Log4j logging is configured in the log4j.properties to output at INFO level to the console.
