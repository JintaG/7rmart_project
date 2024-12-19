package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import supermarketpages.HomePage;
import supermarketpages.ManageFooterText;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base {
	public HomePage homepage;
	public ManageFooterText managefootertextpg;

	@Test
	public void manageFooterPage() throws IOException {
		String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		managefootertextpg=homepage.managefooter();
		String address = ExcelUtility.readStringData(1, 0, "Footertext");
		String emailid= ExcelUtility.readStringData(1, 1, "Footertext");
	String phonenum=ExcelUtility.readIntegerCellValue(1, 2, "Footertext");
	managefootertextpg.editFooterText().newAddress(address).newEmail(emailid).newPhoneNum(phonenum).updateFooterText();
	boolean alertmsgisloaded = managefootertextpg.isalertisloaded();
	Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);
	}
}
