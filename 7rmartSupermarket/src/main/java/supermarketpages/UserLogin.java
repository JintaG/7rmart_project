package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLogin{
public WebDriver driver;

public UserLogin(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

}

@FindBy(xpath = "//input[@name='username']")
WebElement username;
@FindBy(xpath = "//input[@name='password']")
WebElement password;
@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
WebElement submit;
@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/home']")
WebElement home;

public  UserLogin enterUserNamePasswordField(String usernamefield,String passwordfield) {
	username.sendKeys(usernamefield);
	password.sendKeys(passwordfield);
	return this;

}

public HomePage loginButton() {
	submit.click();
	return new HomePage(driver);
}

public boolean isHomepageisloaded() {
	return home.isDisplayed();// checking assertion

}
}