package Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinitions {

	
	
	@Given("^A user is on Demoqa\\.com$")
	public void a_user_is_on_Demoqa_com() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("A user is on Demoqa");
	}

	@When("^user clicks on MyAccount link$")
	public void user_clicks_on_MyAccount_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user clicks on MyAccount link");
		}

	@Then("^user is taken to Login page$")
	public void user_is_taken_to_Login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user is taken to Login page");
		}

	@When("^user enters a valid username and password$")
	public void user_enters_a_valid_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user enters a valid username and password");
		}

	@Then("^user is able to login successfully$")
	public void user_is_able_to_login_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("user is able to login successfully");
	}

}
