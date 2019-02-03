package runner;

import java.io.File;
import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import pageObjects.BasePage;

@RunWith(Cucumber.class)

@CucumberOptions(features = {
		"D:\\2019\\eclipse_workspace\\FinalCucumberFramework\\src\\test\\java\\others\\featureFiles" }, glue = {
				"stepsDefinition" }, dryRun = false, monochrome = true, tags = {}, plugin = { "pretty",
						"html:target/cucumber", "json:target/cucumber.json",
						"com.cucumber.listener.ExtentCucumberFormatter:target/report.html" })

public class MainRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void writeExtension() throws IOException {
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "\\src\\main\\java\\utils\\ReportsConfig.xml"));
		BasePage.copyLatestExtentReport();
	}
}
