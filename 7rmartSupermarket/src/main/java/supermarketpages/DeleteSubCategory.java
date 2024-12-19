package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class DeleteSubCategory {
	public WebDriver driver;

	public DeleteSubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}
@FindBy(xpath ="(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
WebElement deletebutton;
@FindBy(xpath ="//a[@onclick='return confirm('Do you want to delete this Sub Category?')']")
WebElement confirmalert;
@FindBy(xpath ="//div[@class='alert alert-success alert-dismissible']")
WebElement alert;
public DeleteSubCategory subCategoryDelete() {
	deletebutton.click();
	return this;
}
public DeleteSubCategory alert() throws InterruptedException {
	WaitUtility waitutility = new WaitUtility();
	waitutility.waitforElementToBeClickable(driver,confirmalert);
	Thread.sleep(3000);
	confirmalert.click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	return this;
}
//public boolean isalertisenabled() {
	//return confirmalert.isEnabled();// checking assertion

//}
public boolean isalertisloaded() {
	return alert.isDisplayed();// checking assertion

}
}
