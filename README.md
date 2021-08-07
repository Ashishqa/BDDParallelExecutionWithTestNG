# Cucumber-BDD-Automation-Framework-TestNG

**Behavior Driven Development Cucumber - Selenium based automation framework including Extent reports**

**This framework contains sample code containing:**

 1. 1 Feature 
 
 2. 1 Scenario
 
 3. Users are able to perform the following actions:

    - Login

    - Add/Delete products to the shopping cart

    - View product’s details by clicking on the product’s name

    - Check out the shopping cart ( no payment information required)

    - Logout

4. POM(Page Object Model) for each page

5. TestNG for parallel execution on different browser

6. POM.xml(Maven) for build and execute test suite on CI server  

7. Properties file for grid configuration and local execution

**Framework Structure:**

![image](https://user-images.githubusercontent.com/26184674/128612842-a10d9722-3de8-4fb4-925a-6bb57f3476ea.png)


![image](https://user-images.githubusercontent.com/26184674/128612870-e7a93f5d-4eea-411a-aad6-51a45bb0d3ec.png)



**Software Pre-requisite:**

JDK8

Eclipse

Maven

Cucumber plug-in in Eclipse

TestNG

Chrome

FireFox


**Steps to run automation suite:**

Clone the repository using "git clone "

Update user credentials and shipping details in scenario in feature file

To execute on grid node then set **"NodeUrl"** in config.properties file

To execute on local set **"ExecuteLocal"** True. 

Update **TestNG.xml** file if you want to execute in sequence or parallel browser

Either go to project directory and run **"mvn clean test"** in cmd or right click on pom.xml file and run as **"mvn clean"**

Either go to project directory and run **"mvn install"** in cmd or right click on pom.xml file and run as **"mvn install"**


**Reports:**

Two report will be generated after execution

1. Default cucumber report- It will be activated for 24 hrs only. Path: **Console output window**

2. Extent Repor. Path: **"BDDParallelExecutionWithTestNG\test-output\SparkReport\Index.html"
**



