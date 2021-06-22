Buggy Rating JustTestIT - TTest Automation Framework & Automation Tests

Web Application - https://buggy.justtestit.org/

Tools & Technologies of the Framework 
- Programming Language - Java
- Unit Test Framework - JUnit 
- UI Automation Framework - Selenium 
- Build & Dependency Management - Maven 
- Design Pattern - Page Object Model 

Feature Areas - Following feature areas are covered by the tests, 
1. Login
2. Registration 
3. Manage Profile
4. Update Password
5. Voting 

Steps to execute the tests locally

1. Install GIT from - https://git-scm.com/download/win 
2. Install Eclipse IDE- https://www.eclipse.org/downloads/
3. Go to https://github.com/rlokuge/buggyrating
4. Clone the project from Github to your local 
5. Import the project into Eclipse (Import Projects > Existing Maven Project)
6. To execute the tests 
        a. Right-click any test case or test class 
        b. Select Run-As > JUnit Test

Test Framework supports following browsers, 
        1. Chrome
        2. Firefox
        3. Edge
        4. IE
        
By default, the framework is configured to run in Chrome but this can be changed by updating the config.properties file. 
To update the config.properties, go to scr/test/resources package and open the config.properties file. 
Update the browser value to any of the below, 
        1. chrome
        2. ie
        3. firefox
        4. edge
