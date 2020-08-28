package loginpage;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestUtilities;
import pages.LoginPage;
import pages.WelcomePageObject;

public class NegativeLoginTest extends TestUtilities {
	

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		log.info("Starting negativeTest");

		// open main page
		WelcomePageObject welcomepage = new WelcomePageObject(driver , log);
		welcomepage.openpage();

		// Click on Form Authentication link
	    LoginPage loginpage = welcomepage.clickformlinklocator();
	    		
	    		
		// enter username and password
		loginpage.login(username, password);
		
//		loginpage.
//
//		// Verification
//		String actualErrorMessage = driver.findElement(By.id("flash")).getText();
//		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
//				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
//						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);
//	}


	
}
}


