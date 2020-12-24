package stepdefinations;

import java.util.List;
import java.util.Map;

import com.factory.DriverFactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class AccountPageSteps {

	private LoginPage loginPage = new LoginPage(DriverFactory.getWebDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
	    List<Map<String,String>> credList=dataTable.asMaps();
	    String username = credList.get(0).get("username");
	    String password = credList.get(0).get("password");
	    
	    DriverFactory.getWebDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountsPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	    String title = accountsPage.getAccontsPageTitle();
	    System.out.println("Accounts Page Title "+title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
	
		List<String> expAccountSectionList=sectionsTable.asList();
		System.out.println("Expected Accounts Section List "+expAccountSectionList);
		accountsPage.getAccountSectionList();
		List<String> actualAccountSectionList = accountsPage.getAccountSectionList();
		System.out.println("Actual accounts section list: "+actualAccountSectionList);
		
		Assert.assertTrue(actualAccountSectionList.containsAll(expAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSessionCount) {
		Assert.assertTrue(accountsPage.getAccountSectionCount()==expectedSessionCount);
	}
}
