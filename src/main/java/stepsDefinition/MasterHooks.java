package stepsDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageObjects.BasePage;
import utils.DriverFactory;

public class MasterHooks extends DriverFactory {

	@Before
	public void setup() {
		driver = getDriver();
	}

	@After
	public void teadDownandScreenshotOnFailure(Scenario scenario) {
		try {
			if (driver != null && scenario.isFailed()) {
				scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
				BasePage.captureScreenShot();
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}

			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Method failed : teadDownandScreenshotOnFailure, Exception: " + e.getMessage());
		}
	}
}
