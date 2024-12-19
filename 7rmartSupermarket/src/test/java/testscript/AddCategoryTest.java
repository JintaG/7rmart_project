package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constant;
import supermarketpages.AddCategory;
import supermarketpages.HomePage;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;

public class AddCategoryTest extends Base {
	public HomePage homepage;
	public AddCategory addcategory;

	@Test
	@Parameters({"namecategory"})
	public void addCategoryPage(String namecategory) throws IOException, InterruptedException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		addcategory= homepage.categorypg();
		addcategory.newCategory().nameCategory(namecategory).groupSelect().browseImg().menuTop().menuLeft().categorySave();
		boolean alertmsgisloaded =addcategory.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);
}
}
