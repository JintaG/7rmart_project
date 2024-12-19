package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketpages.AdminUser;
import supermarketpages.AdminUserSearch;
import supermarketpages.HomePage;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;

public class AdminUserSearchTest extends Base {
	public HomePage homepage;
	public AdminUser adminuser;
	public AdminUserSearch adminusersearch;

	@Test
	@Parameters({ "usrname" })
	public void adminusersearchpage(String usrname) throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		adminuser = homepage.adminuser();
		adminusersearch = adminuser.adminUserSearch();
		adminusersearch.searchuser().inUserName(usrname).dropdownlist().search();
		boolean resultisloaded = adminusersearch.isResultIsLoaded();
		Assert.assertTrue(resultisloaded, Constant.ERRORMESSAGEFORUSERSEARCH);
	}
}
