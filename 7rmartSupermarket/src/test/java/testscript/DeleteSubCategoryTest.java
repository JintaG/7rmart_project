package testscript;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constant;
import supermarketpages.DeleteSubCategory;
import supermarketpages.HomePage;
import supermarketpages.SubCategory;
import supermarketpages.UserLogin;
import utilities.ExcelUtility;
public class DeleteSubCategoryTest extends Base {
	public HomePage homepage;
	public SubCategory subcategorypage;
	public DeleteSubCategory deletesubcategory;
 @Test
 public void deleteSubCategoryPage() throws IOException, InterruptedException {
	 String username = ExcelUtility.readStringData(1, 0, "Login");
		String password = ExcelUtility.readStringData(1, 1, "Login");
		UserLogin login = new UserLogin(driver);
		login.enterUserNamePasswordField(username, password);
		homepage = login.loginButton();
		subcategorypage=homepage.subCategory();
		deletesubcategory=homepage.subCategoryDelete();
		Thread.sleep(2000);
		deletesubcategory.alert();
		Thread.sleep(2000);
		boolean alertmsgisloaded =deletesubcategory.isalertisloaded();
		Assert.assertTrue(alertmsgisloaded, Constant.ERRORMESSAGEFORALERT);
 }
}
