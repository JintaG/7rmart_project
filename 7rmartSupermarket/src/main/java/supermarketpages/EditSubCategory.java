package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class EditSubCategory {
	public WebDriver driver;

	public EditSubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement editbutton;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcatname;
	@FindBy(xpath = "//button[@name='update']")
	WebElement updatebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public EditSubCategory subCategoryEditButton() {
		editbutton.click();
		return this;
	}

	public EditSubCategory subCatName(String subcatfield) {
		subcatname.sendKeys(subcatfield);
		return this;
	}

	public EditSubCategory updateButtonClick() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, updatebutton);
		updatebutton.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion
	}

}
