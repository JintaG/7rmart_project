package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constant;
import supermarketpages.HomePage;
import supermarketpages.SubCategory;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;

public class SubCategoryTest extends Base {
	public HomePage homepage;
	public SubCategory subcategorypage;

	@Test(retryAnalyzer = retry.Retry.class)
	public void subcategorysearchpage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		subcategorypage = homepage.subCategory();
		subcategorypage.subCategorySearch().dropdownlist().searchButton();
		boolean resultisloaded = subcategorypage.isresultpageisloaded();
		Assert.assertTrue(resultisloaded, Constant.ERRORMESSAGEFORSUBCATSEARCH);
	}
}
