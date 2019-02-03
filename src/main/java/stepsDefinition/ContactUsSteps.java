package stepsDefinition;

import java.io.IOException;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ContactUsSteps extends DriverFactory {

	@Given("^I access to webdriveruniversity site$")
	public void i_access_to_webdriveruniversity_site() throws InterruptedException, IOException {
		contactuspage.getContactUsPage();
	}

	@And("^I Enter valid firstname$")
	public void i_Enter_valid_firstname() throws Exception {
		contactuspage.enterFirstName("Shivaji");
	}

	@And("^I enter valid lastname$")
	public void i_enter_valid_lastname(DataTable dataTable) throws Exception {
		contactuspage.enterLastName(dataTable, 0, 1);
	}

	@And("^I enter valid email address$")
	public void i_enter_valid_email_address() throws Exception {
		contactuspage.enterEmail("shivaji.ghadage@gmail.com");
	}

	@And("^I enter comment$")
	public void i_enter_comment(DataTable dataTable) throws Exception {
		contactuspage.enterComments(dataTable, 0, 1);
	}

	@When("^I click on submit button to save data$")
	public void i_click_on_submit_button_to_save_data() throws Exception {
		contactuspage.ClickSubmit();
	}

	@Then("^The information should saved succesfully to contact us form\\.$")
	public void the_information_should_saved_succesfully_to_contact_us_form() throws Exception {
		contactuspage.ConfirmContactUsSubmissionWasSuccesfull();
	}
}
