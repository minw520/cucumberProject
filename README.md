
cucumberProjectecho "# cucumberProject" >> README.mdecho "# cucumberProject" >> README.mdcreate a new login in gmail.
address: minw520w520
password: w520750125

then create a login in github.
name: minw520
minw520w520@gmail.com
w520750125


install eclipse in ubuntu
install git in ubuntu with "sudo apt install git"

http://toolsqa.com/cucumber-tutorial/

Cucumber Introduction

    Test Driven Development (TDD)
    Cucumber & Behavior Driven Development
    Gherkin – Business Driven Development
    Cucumber BBD for Testing

 
Set Up Cucumber with Selenium in Eclipse

    Download and Install Java
    Download and Start Eclipse
    Install Cucumber Eclipse Plugin
    Download Cucumber for Eclipse
    Download Webdriver Java client
    Configure Eclipse with Cucumber

 
Cucumber Basics
	___Create two packages and one folder

	   TestRunner(p, inside src)
	   TestDefinition(p, inside src)
	   Features(f, beside src)
	   
	   create three files
	   testrunner.java in TestRunner
	   testdefinition.java in TestDefinition
	   .feature in Features

    ___Cucumber Selenium Java Test
    ___Feature File
    
					Feature: Login Action
				Scenario: Successful Login with Valid Credentials
					Given User is on Home Page
					When User Navigate to LogIn Page
					And User enters UserName and Password
					Then Message displayed Login Successfully
				
				Scenario: Successful LogOut
					When User LogOut from the Application
					Then Message displayed LogOut Successfully
				
    ___JUnit Test Runner Class
    
				package cucumberTest;
				import org.junit.runner.RunWith;
				import cucumber.api.CucumberOptions;
				import cucumber.api.junit.Cucumber;
				 
				@RunWith(Cucumber.class)
				@CucumberOptions(
						features = "Features"
						,glue={"TestDefinition"}
						)
				public class TestRunner {
				}

				
    ___Gherkin Keywords
    
		    Feature
		    Background
		    Scenario
		    Given
		    When
		    Then
		    And
		    But
		    *
     
    ___Step Definition
    
    ran the Test_Runner class.
    copy extents in console into testdefinition.java 
    Add Selenium Java code in the Step Definition methods
    run testdefinition.java
    
    
    ___Cucumber Options

		CucumberOptions are used to set some specific properties for the Cucumber test.
		Format Option is used to specify different formatting options for the output reports
		
		features = "Feature"
		,glue={"stepDefinition"
		,dryRun = true
		,monochrome = false
		
		}
		
		Pretty: Prints the Gherkin source with additional colours and stack traces for errors. Use below code:

			format = {“pretty“}
			HTML: This will generate a HTML report at the location mentioned in the for-matter itself. Use below code:
			format = {“html:Folder_Name“}
			
			JSON: This report contains all the information from the gherkin source in JSON Format. This report is meant to be post-processed into another visual format by 3rd party tools such as Cucumber Jenkins. Use the below code:
			format = {“json:Folder_Name/cucumber.json“}

			JUnit: This report generates XML files just like Apache Ant’s JUnit report task. This XML format is understood by most Continuous Integration servers, who will use it to generate visual reports. use the below code:
			format = { “junit:Folder_Name/cucumber.xml“}
 
Data Driven Testing

    ___Parameterization in Cucumber
     
    Parameterization without Example Keyword, original, change feature with data_anotation"/(.*)/"_method([string aug_i])_sendkey(aug_i)
    
    ___Data Driven Testing Using Examples Keyword
    
    
     	There are no changes in TestRunner class.
     
		Feature: Login Action
		 
		Scenario Outline: Successful Login with Valid Credentials
			Given User is on Home Page
			When User Navigate to LogIn Page
			And User enters "<username>" and "<password>"
			Then Message displayed Login Successfully
		Examples:
		    | username   | password |
		    | testuser_1 | Test@153 |
		    | testuser_2 | Test@153 |
    
		@When("^User enters \"(.*)\" and \"(.*)\"$")
		public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
			driver.findElement(By.id("log")).sendKeys(username); 	 
		    driver.findElement(By.id("pwd")).sendKeys(password);
		    //driver.findElement(By.id("login")).click();
		}
		
		Run the test by Right Click on TestRunner class and Click Run As  > JUnit Test Application.


    ___Data Tables in Cucumber
    
	    Scenario: Successful Login with Valid Credentials
		Given User is on Home Page
		When User Navigate to LogIn Page
		And User enters Credentials to LogIn
	    | testuser_1 | Test@153 |
		Then Message displayed Login Successfully
		
		We declared the data under the step only. So we are using Tables as arguments to Steps.
		
		@When("^User enters Credentials to LogIn$")
		public void user_enters_testuser__and_Test(DataTable usercredentials) throws Throwable {
 
		//Write the code to handle Data Table
		List<List<String>> data = usercredentials.raw();
 
		//This is to get the first data of the set (First Row + First Column)
		driver.findElement(By.id("log")).sendKeys(data.get(0).get(0)); 
 
		//This is to get the first data of the set (First Row + Second Column)
	    driver.findElement(By.id("pwd")).sendKeys(data.get(0).get(1));
 
	    driver.findElement(By.id("login")).click();
	}
		
    
    ___Maps in Data Tables
    
	    Scenario: Successful Login with Valid Credentials
		Given User is on Home Page
		When User Navigate to LogIn Page
		And User enters Credentials to LogIn
		| Username   | Password |
	    | testuser_1 | Test@153 |
		Then Message displayed Login Successfully
		
		@When("^User enters Credentials to LogIn$")
		public void user_enters_testuser_and_Test(DataTable usercredentials) throws Throwable {
 
		//Write the code to handle Data Table
		List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
		driver.findElement(By.id("log")).sendKeys(data.get(0).get("Username")); 
	    driver.findElement(By.id("pwd")).sendKeys(data.get(0).get("Password"));
	    driver.findElement(By.id("login")).click();
           }
	
	
	Map Data Tables to Class Objects
		
		Luckily there are easier ways to access your data than DataTable. For instance you can create a Class-Object and have Cucumber map the data in a table to a list of these.
		
		Feature File Scenario
		Scenario: Successful Login with Valid Credentials
			Given User is on Home Page
			When User Navigate to LogIn Page
			And User enters Credentials to LogIn
			| Username   | Password |
		    | testuser_1 | Test@153 |
		    | testuser_2 | Test@154 |
			Then Message displayed Login Successfully
					
		Scenario: Successful Login with Valid Credentials
			Given User is on Home Page
			When User Navigate to LogIn Page
			And User enters Credentials to LogIn
			| Username   | Password |
		    | testuser_1 | Test@153 |
		    | testuser_2 | Test@154 |
			Then Message displayed Login Successfully
				
		The implementation of the above step will be like this:
			@When("^User enters Credentials to LogIn$")
			public void user_enters_testuser_and_Test(List<Credentials>  usercredentials) throws Throwable {
		
				//Write the code to handle Data Table
				for (Credentials credentials : usercredentials) {			
					driver.findElement(By.id("log")).sendKeys(credentials.getUsername()); 
				    driver.findElement(By.id("pwd")).sendKeys(credentials.getPassword());
				    driver.findElement(By.id("login")).click();
					}		
			}
					
			@When("^User enters Credentials to LogIn$")
			public void user_enters_testuser_and_Test(List<Credentials>  usercredentials) throws Throwable {
		 
				//Write the code to handle Data Table
				for (Credentials credentials : usercredentials) {			
					driver.findElement(By.id("log")).sendKeys(credentials.getUsername()); 
				    driver.findElement(By.id("pwd")).sendKeys(credentials.getPassword());
				    driver.findElement(By.id("login")).click();
					}		
			}
 

			Class Credentials
			package stepDefinition;
			
			public class Credentials {
				private String username;
				private String password;
			
				public String getUsername() {
			        return username;
			    }
				public String getPassword() {
			        return password;
			    }	
			}

				
			package stepDefinition;
			 
			public class Credentials {
				private String username;
				private String password;
			 
				public String getUsername() {
			        return username;
			    }
				public String getPassword() {
			        return password;
			    }	
			}
	
 
Cucumber Annotations

    Tags
    Hooks
    Tagged Hooks
    Execution Order of Hooks
    Background Keyword

 
Cucumber Framework

    Cucumber Automation Framework
    Chapter 1 : End 2 End Selenium Test
    Chapter 2 : Convert Selenium Test to Cucumber
    Chapter 3 : Page Object Pattern using Selenium Page Factory
    Chapter 4 : Page Object Manager
    Chapter 5 : Config File Reader
    Chapter 6 : File Reader Manager
    Chapter 7 : WebDriver Manager
    Chapter 8 : Sharing Test Context with PicoContainer
    Chapter 9 : Before and After Hooks
    Chapter 10 : JSON Data Reader
    Chapter 11 : Wait Utility for Ajax Wait
    Chapter 12 : Sharing Scenario Context
    Chapter 13 : Cucumber Report Plugins 
    Chapter 14 : Extend Reports with Screenshots
    Chapter 15 : Run Test from Command Line



…or create a new repository on the command line

echo "# cucumberProject" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/minw520/cucumberProject.git
git push -u origin master

…or push an existing repository from the command line

git remote add origin https://github.com/minw520/cucumberProject.git
git push -u origin master
