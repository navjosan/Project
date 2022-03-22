package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pageObjects.LoginPage;
import pageObjects.LoginToQaAcademy;
import resources.Base;

@RunWith(Cucumber.class)
public class stepDefinition extends Base {

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser() throws Throwable {

		driver = InitializeDriver();

	}

	@When("^Land on the \"([^\"]*)\"$")
	public void land_on_the_something(String strArg1) throws Throwable {

		driver.get(strArg1);

	}

	@Then("^click on the login link (.+) and (.+)$")
	public void click_on_the_login_link_and(String username, String password) throws Throwable {

		LoginPage loginPage = new LoginPage(driver);
		if (loginPage.CheckedAlertSize().size() > 0) {
			loginPage.CheckedAlert().click();
		}
		loginPage.Login().click();
	}
}
