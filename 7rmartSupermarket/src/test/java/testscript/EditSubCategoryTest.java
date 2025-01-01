package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import constants.Constant;
import supermarketpages.EditSubCategory;
import supermarketpages.HomePage;
import supermarketpages.SubCategory;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;

public class EditSubCategoryTest extends Base {
	public HomePage homepage;
	public SubCategory subcategorypage;
	public EditSubCategory editsubcategorypage;

	@Test
	@Parameters({ "subcategoryname" })
	public void editSubCategoryPage(String subcategoryname) throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		subcategorypage = homepage.subCategory();
		editsubcategorypage = homepage.subCategoryEditButton();
		editsubcategorypage.subCatName(subcategoryname).updateButtonClick();
		boolean alertmsgisloaded = editsubcategorypage.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);
	}
}
