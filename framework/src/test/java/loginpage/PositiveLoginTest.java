package loginpage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestUtilities;


public class PositiveLoginTest extends TestUtilities {
	
	@Test 
	public void loginTest() {
		log.info("Strat Login Test");
		
	
		
		String url = "https://the-internet.herokuapp.com/";
		driver.get(url);
		
		log.info("The main page is opened");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.findElement(By.linkText("Form Authentication")).click();
		
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		sleep(3000);
		
		WebElement loginbutton = driver.findElement(By.className("radius"));
		wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
		loginbutton.click();
		
		
		String expectedurl = "https://the-internet.herokuapp.com/secure";
		Assert.assertEquals(driver.getCurrentUrl(), expectedurl);
		
		
		Assert.assertTrue("logOutButton is not visible.",driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed());
		
		String expectedmessage = "You logged into a secure area!";
		String actualmessage = driver.findElement(By.id("flash")).getText();
		
		Assert.assertTrue("actualmessage does not contain expectesmessage\nexpectedmessage: " 
				+expectedmessage+ "\nactualmessage: " +actualmessage,actualmessage.contains(expectedmessage));
		

		
		
		
	}

}
