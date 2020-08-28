package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

	private String url = "http://the-internet.herokuapp.com/secure";
	
	private By logoutbutton = By.xpath("//a[@class='button secondary radius']");
	private By message = By.id("flash");
	
	

	public SecureAreaPage(WebDriver driver , Logger log) {
		// TODO Auto-generated constructor stub

		super(driver , log);
		
	}

	public String getpageurl() {
		return url;
	}
	
	public boolean isLogOutButtonVisible() {
		return find(logoutbutton).isDisplayed();
	}
	
	public String getSuccessMessageText() {
		return find(message).getText();
	}
}
