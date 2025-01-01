package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public void elementSelectByIndex(WebElement dropdown, int index) {
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	public void selectByVisibleText(WebElement dropdown, String visibletext) {
		Select drp = new Select(dropdown);
		drp.selectByVisibleText(visibletext);
	}

	public void selectByValue(WebElement dropdown, String value) {
		Select drp = new Select(dropdown);
		drp.selectByValue(value);
	}

	public void dragAndDrop(WebElement source, WebElement destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, destination).build().perform();
	}

	public void rightClick() {
		Actions action = new Actions(driver);
		action.contextClick().build().perform();
	}

	public void scrollPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public boolean isElementVisible(WebElement element) {
		return (element.isDisplayed());
	}
}
