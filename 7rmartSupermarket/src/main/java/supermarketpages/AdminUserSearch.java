package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUserSearch {
	public WebDriver driver;

	public AdminUserSearch(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement usernamein;
	@FindBy(xpath = "//select[@class='form-control']")
	WebElement dropdwn;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchbtn;
	@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")
	WebElement alert;

	public AdminUserSearch searchuser() {
		searchbutton.click();
		return this;
	}

	public AdminUserSearch inUserName(String inusernamefield) {
		usernamein.sendKeys(inusernamefield);
		return this;
	}

	public AdminUserSearch dropdownlist() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(dropdwn, 2);
		return this;
	}

	public AdminUserSearch search() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, searchbtn);
		searchbtn.click();
		return this;
	}

	public boolean isResultIsLoaded() {
		return alert.isDisplayed();// checking assertion
	}
}
