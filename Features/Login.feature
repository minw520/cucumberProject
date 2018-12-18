Feature: Login functionality for demoqa.com

Scenario: Verify that user is able to successfully login to demoqa.com website 
   Given A user is on Demoqa.com
   When user clicks on MyAccount link
   Then user is taken to Login page
   When user enters a valid username and password 
   Then user is able to login successfully