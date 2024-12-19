package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import supermarketpages.HomePage;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;
	public class HomePageTest extends Base {
		public HomePage homepage;

		@Test
		public void logout() throws IOException {
			String username=ExcelUtility.readStringData(1, 0, "Login");
			String password=ExcelUtility.readStringData(1, 1, "Login");
			UserLogin login = new UserLogin(driver);
		    login.enterUserNamePasswordField(username, password);
			homepage=login.loginButton();
			homepage.admin();
			homepage.logout();
			Assert.assertEquals(driver.getTitle(), "Login | 7rmart supermarket", "Logout failed");

		}
	}

