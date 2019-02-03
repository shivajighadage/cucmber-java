package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import cucumber.api.DataTable;
import org.junit.Assert;

public class ContactUs_Page extends BasePage {

	public @FindBy(xpath = "//input[@name='first_name']") WebElement textField_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textField_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textField_Email;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textField_Comments;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement btn_Submit;
	public @FindBy(xpath = "//input[@name='RESET ']") WebElement btn_Reset;

	public ContactUs_Page() throws IOException {
		super();
	}

	public ContactUs_Page getContactUsPage() throws IOException {
		getDriver().get("http://webdriveruniversity.com/Contact-Us/contactus.html");
		return new ContactUs_Page();
	}

	public ContactUs_Page enterFirstName(String fname) throws Exception {
		sendKeysToWebElement(textField_FirstName, fname);
		return new ContactUs_Page();
	}

	public ContactUs_Page enterLastName(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textField_LastName, data.get(row).get(column));
		return new ContactUs_Page();
	}

	public ContactUs_Page enterEmail(String email) throws Exception {
		sendKeysToWebElement(textField_Email, email);
		return new ContactUs_Page();
	}

	public ContactUs_Page enterComments(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textField_Comments, data.get(row).get(column) + "\n");
		return new ContactUs_Page();
	}

	public ContactUs_Page ClickSubmit() throws Exception {
		waitAndClickElement(btn_Submit);
		return new ContactUs_Page();
	}

	public ContactUs_Page ConfirmContactUsSubmissionWasSuccesfull() throws Exception {
		WebElement thankSuccesfulMsg = getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));
		WaitUntilWebElementIsVisible(thankSuccesfulMsg);
		Assert.assertEquals("thankyouforyourmessage!hhh",
				thankSuccesfulMsg.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
		return new ContactUs_Page();
	}
}
