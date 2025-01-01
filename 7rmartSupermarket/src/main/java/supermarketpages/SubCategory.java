package supermarketpages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
import utilities.WaitUtility;
public class SubCategory {
	public WebDriver driver;
	public SubCategory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement dropdown;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchbtn;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	WebElement resultpage;
	public SubCategory subCategorySearch() {
		searchbutton.click();
		return this;
	}
	public SubCategory dropdownlist() {
		PageUtility pageutility = new PageUtility();
		pageutility.elementSelectByIndex(dropdown, 6);
		return this;
	}
	public SubCategory searchButton() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitforElementToBeClickable(driver, searchbtn);
		searchbtn.click();
		return this;
	}
	public boolean isresultpageisloaded() {
		return resultpage.isDisplayed();// checking assertion
	}
}
