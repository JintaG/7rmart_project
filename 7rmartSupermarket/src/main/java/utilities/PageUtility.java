package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	public void elementSelectByIndex(WebElement dropdown,int index)
	{
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	}

}
