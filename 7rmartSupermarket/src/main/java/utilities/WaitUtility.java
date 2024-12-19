package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WaitUtility {
	public WebDriver driver;
	//1)Wait for element to be clickable
	public void waitforElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));//explicit wait
		wait.until(ExpectedConditions.elementToBeClickable(element));//explicit wait
	}
	//2)Wait for text to be visible in the element(to view preview pg after filling a form)
		public void waitForTextToBePresentInTheElement(WebDriver driver,WebElement element,String text) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElement(element,text));
		}
		//3)Wait for element to be selected
		public void waitForElementToBeSelected(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeSelected(element));
		}
	//4)Wait for the attribute to be
		public void waitForAttributeToBe(WebDriver driver,WebElement element,String attribute,String value) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
		}
		//5)Wait for visibility of an element
		public void waitForVisibilityOfAnElement(WebDriver driver,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
}
