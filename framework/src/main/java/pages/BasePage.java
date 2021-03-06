package pages;

import java.io.Serializable;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver ;
	protected Logger log;
	
	public BasePage(WebDriver driver , Logger log) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.log = log;
		
	}

	protected void openurl(String url) {
		driver.get(url);
	}
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	protected void click(By locator) {
		waitForVisibilityOf(locator);
		find(locator).click();
	}
	
	protected void type(String text , By locator) {
		waitForVisibilityOf(locator ,5);
		find(locator).sendKeys(text);
		
				
	}
	
	public String getcurrenturl () {
		return driver.getCurrentUrl();
	}
	private void waitFor(ExpectedCondition<WebElement> condition,Integer timeOutInSeconds) {
	timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
	WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
	wait.until(condition);
	}
		
		private void waitForVisibilityOf(By locator , Integer...timeOutInSeconds) { 
		int attempts = 0;
		while(attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
				
			} catch (StaleElementReferenceException e) {
				
			}
		attempts++;
		}
		
	}
}

