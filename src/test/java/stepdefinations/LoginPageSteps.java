package stepdefinations;

import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LoginPageSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());
	
	@Given("user is on the login page")
	public void user_is_on_the_login_page() {
	   DriverFactory.getWebDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		   title= loginPage.getLoginPageTitle();
		   System.out.println("page title is "+title);
	}

	@Then("the title of the login page should be {string}")
	public void the_title_of_the_login_page_should_be(String expectedTitleName) {
	  
			
		   Assert.assertTrue(title.contains(expectedTitleName));
	}

	@Then("forgot password link should be displayed")
	public void forgot_password_link_should_be_displayed() {
	    Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	  loginPage.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {
	    loginPage.enterPassword(pwd);
	}

	@When("user clicks on sign in button")
	public void user_clicks_on_sign_in_button() {
	   loginPage.clickOnLogin();
	}

	

	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
	   
	}
}
