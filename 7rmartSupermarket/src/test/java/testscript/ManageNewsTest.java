package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constant;
import supermarketpages.HomePage;
import supermarketpages.ManageNews;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	public HomePage homepage;
	public ManageNews managenews;

	@Test
	public void manageNewsPage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		managenews = homepage.manageNews();
		String newsinfo = ExcelUtility.readStringData(1, 0, "News");
		managenews.newNewsBtn().newNews(newsinfo).saveNews();
		boolean alertmsgisloaded = managenews.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);
	}
}
