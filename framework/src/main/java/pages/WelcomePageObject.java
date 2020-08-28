package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePage{


	private String url = "http://the-internet.herokuapp.com/";
	
	private By formlinklocator = By.linkText("Form Authentication");
	
	public WelcomePageObject(WebDriver driver , Logger log) {
 
		super(driver , log);
		
	}
	public void openpage() {
		log.info("opening page ==>" + url);
	    openurl(url);
		log.info("Page opened");
	}

	public LoginPage clickformlinklocator() {
		log.info("Click on form autenticator link");
	    click(formlinklocator);
		return new LoginPage(driver ,log);
	}
}
