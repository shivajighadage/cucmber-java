package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products_Page extends BasePage {

	public @FindBy(css = "#container-special-offers") WebElement btn_SpecialOffer;
	public @FindBy(css = "#container-product2") WebElement btn_Laptops;
	public @FindBy(xpath = "//*[@id='myModal']//b[contains(text(),'NEWCUSTOMER')]") WebElement voucher_number;
	public @FindBy(xpath = "//button[text()= 'Proceed']") WebElement btn_Proceed_pupup;
	public @FindBy(xpath = "//button[text()= 'Close']") WebElement btn_Close_pupup;

	public Products_Page() throws IOException {
		super();
	}

	public Products_Page clickonProceedBtn_popup() throws InterruptedException, IOException {
		waitAndClickElement(btn_Proceed_pupup);
		return new Products_Page();
	}

	public String printSpecialOfferCode() throws IOException {
		WaitUntilWebElementIsVisible(voucher_number);
		String offerCode = voucher_number.getText();
		System.out.println("Use " + offerCode + " code for avail special discount..");
		return offerCode;
	}
}
