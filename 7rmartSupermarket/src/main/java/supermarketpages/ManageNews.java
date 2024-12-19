package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageNews {
	public WebDriver driver;

	public ManageNews(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement newsinput;
	@FindBy(xpath = "//button[@name='create']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;
	
	public ManageNews newNewsBtn() {
		newbutton.click();
		return this;
	}
	public ManageNews newNews(String newsinputfield) {
		newsinput.sendKeys(newsinputfield);
		return this;
	}
	public ManageNews saveNews() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}
	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion
	}
}
