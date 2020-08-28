package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	

	private By usernamelocator = By.id("username");
	private By passwordlocator = By.name("password");
	private By loginbuttonlocator = By.tagName("button");
	
	

	public LoginPage(WebDriver driver , Logger log) {
		super(driver , log);
	}

	public SecureAreaPage login(String username , String password) {

		type(username, usernamelocator);
		type(password, passwordlocator);
		click(loginbuttonlocator);
		
		return new SecureAreaPage (driver , log);
	}
}
