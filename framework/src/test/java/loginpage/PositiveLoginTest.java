package loginpage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.TestUtilities;
import pages.LoginPage;
import pages.SecureAreaPage;
import pages.WelcomePageObject;


public class PositiveLoginTest extends TestUtilities {
	
	@Test 
	public void loginTest() {
		log.info("Strat Login Test");
		
		WelcomePageObject welcomepage = new WelcomePageObject(driver ,log);
		welcomepage.openpage();
		LoginPage loginpage = welcomepage.clickformlinklocator();
		
		welcomepage.getcurrenturl();
		
		SecureAreaPage secureareapage = loginpage.login("tomsmith", "SuperSecretPassword!");
		
		

		
	
		
		
		
		
		String expectedurl = "https://the-internet.herokuapp.com/secure";
		Assert.assertEquals(secureareapage.getcurrenturl(), secureareapage.getpageurl());
		
		
		Assert.assertTrue("logOutButton is not visible.",secureareapage.isLogOutButtonVisible());
		
		String expectedmessage = "You logged into a secure area!";
		String actualmessage = secureareapage.getSuccessMessageText();
		
		Assert.assertTrue("actualmessage does not contain expectesmessage\nexpectedmessage: " 
				+expectedmessage+ "\nactualmessage: " +actualmessage,actualmessage.contains(expectedmessage));
		

		
		
		
	}

}
