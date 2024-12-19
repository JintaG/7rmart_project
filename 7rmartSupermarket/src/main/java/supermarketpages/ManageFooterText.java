package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageFooterText {
	public WebDriver driver;
	public ManageFooterText(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath ="(//a[@class='btn btn-sm btn btn-primary btncss'])[2]")
	WebElement actionbutton;
	@FindBy(xpath ="//textarea[@class='form-control']")
	WebElement address;
	@FindBy(xpath ="//input[@id='email']")
	WebElement emailid;
	@FindBy(xpath ="//input[@id='phone']")
	WebElement phonenumber;
	@FindBy(xpath ="//button[@class='btn btn-block-sm btn-info']")
	WebElement updatebtn;
	@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	public ManageFooterText editFooterText() {
		actionbutton.click();
		return this;
	}
	public ManageFooterText newAddress(String addressfield) {
		address.sendKeys(addressfield);
		return this;
	}
	public ManageFooterText newEmail(String emailidfield) {
		emailid.sendKeys(emailidfield);
		return this;
	}
	public ManageFooterText newPhoneNum(String phonenumfield) {
		phonenumber.sendKeys(phonenumfield);
		return this;
	}
	public ManageFooterText updateFooterText() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver,updatebtn );
		updatebtn.click();
		return this;
	}
	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion
	}
}
