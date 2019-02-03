package stepsDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ProductSteps extends DriverFactory {

	@Given("^user navigate to \"([^\"]*)\" website$")
	public void user_navigate_to_website(String url) throws InterruptedException {
		getDriver().get(url);
	}

	@When("^user click on \"([^\"]*)\"$")
	public void user_click_on(String button) throws InterruptedException {
		basepage.WaitUntilWebElementIsVisibleUsingByLocator(By.cssSelector(button));
		getDriver().findElement(By.cssSelector(button)).click();
	}

	@Then("^user should be presented with a promo alert$")
	public void user_should_be_presented_with_a_promo_alert() throws InterruptedException, IOException {
		productspage.printSpecialOfferCode();
		productspage.clickonProceedBtn_popup();
	}
}
