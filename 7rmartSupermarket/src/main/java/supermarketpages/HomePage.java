package supermarketpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admindropdown;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logout;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/login']")
	WebElement loginpage;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	WebElement adminusers;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	WebElement categorypage;
	@FindBy(xpath = "(//p[text()='Sub Category'])[1]")
	WebElement subcategorypg;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement deletebutton;
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-primary btncss'])[1]")
	WebElement editbutton;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]")
	WebElement managenewsbtn;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[10]")
	WebElement managefooterbtn;

	public void admin() {
		admindropdown.click();
	}

	public void logout() {
		logout.click();
	}

	public AdminUser adminuser() {
		adminusers.click();
		return new AdminUser(driver);
	}

	public AddCategory categorypg() {
		categorypage.click();
		return new AddCategory(driver);
	}

	public SubCategory subCategory() {
		subcategorypg.click();
		return new SubCategory(driver);
	}

	public DeleteSubCategory subCategoryDelete() {
		deletebutton.click();
		return new DeleteSubCategory(driver);
	}

	public EditSubCategory subCategoryEditButton() {
		editbutton.click();
		return new EditSubCategory(driver);
	}

	public ManageNews manageNews() {
		managenewsbtn.click();
		return new ManageNews(driver);
	}

	public ManageFooterText managefooter() {
		managefooterbtn.click();
		return new ManageFooterText(driver);
	}
}
