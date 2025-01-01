package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constant;
import utilities.FileUploadUtility;
import utilities.WaitUtility;

public class AddCategory {
	public WebDriver driver;

	public AddCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement categoryname;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectgroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement chooseimg;
	@FindBy(xpath = "(//label[@class='radio-inline'])[1]")
	WebElement topmenu;
	@FindBy(xpath = "(//label[@class='radio-inline'])[3]")
	WebElement leftmenu;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savecategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public AddCategory newCategory() throws InterruptedException {
		newbutton.click();
		Thread.sleep(2000);
		return this;
	}

	public AddCategory nameCategory(String categorynamefield) {
		categoryname.sendKeys(categorynamefield);
		return this;
	}

	public AddCategory groupSelect() throws InterruptedException {
		selectgroup.click();
		Thread.sleep(2000);
		return this;
	}

	public AddCategory browseImg() {
		FileUploadUtility fileupload = new FileUploadUtility();
		fileupload.sendkeyforFileUpload(chooseimg, Constant.CATIMG);
		return this;
	}

	public AddCategory menuTop() throws InterruptedException {
		topmenu.click();
		Thread.sleep(2000);
		return this;
	}

	public AddCategory menuLeft() throws InterruptedException {
		leftmenu.click();
		Thread.sleep(2000);
		return this;
	}

	public AddCategory categorySave() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, savecategory);
		savecategory.click();
		return this;
	}

	public boolean isalertisloaded() {
		return alert.isDisplayed();// checking assertion

	}
}
