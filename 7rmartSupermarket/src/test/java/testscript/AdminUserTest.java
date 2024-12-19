package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketpages.AdminUser;
import supermarketpages.HomePage;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	public HomePage homepage;
	public AdminUser adminuser;

	@Test
	@Parameters({ "adminusername", "adminpassword" })
	public void adminuserpage(String adminusername, String adminpassword) throws IOException {

		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		// String adminusername = ExcelUtility.readStringData(1, 0, "AdminPage");
		// String adminpassword = ExcelUtility.readStringData(1, 1, "AdminPage");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();

		adminuser = homepage.adminuser();

		adminuser.newuser().newusername(adminusername).newpassword(adminpassword).dropdownlist().save();

		boolean alertmsgisloaded = adminuser.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);

	}
}
