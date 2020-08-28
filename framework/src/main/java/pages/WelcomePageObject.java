package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject {

	private WebDriver driver;
    private Logger log;
	private String url = "http://the-internet.herokuapp.com/";
	
	public WelcomePageObject(WebDriver driver , Logger log) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.log = log;
		
	}
	public void openpage() {
		log.info("opening page ==>" + url);
		driver.get(url);
		log.info("Page opened");
	}

}
