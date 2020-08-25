package base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Factory {
	
	ThreadLocal<WebDriver>	 driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;
	
	public Factory (String browser ,Logger log){
		this.browser = browser.toLowerCase();
		this.log = log;
		
	}
	
	public WebDriver createDriver() {
		log.info("Create driver: " + browser);

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\jaju_v\\Downloads\\geckodriver-64\\geckodriver.exe");
			driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Do not know how to start: " + browser + ", starting chrome.");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jaju_v\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver.set(new ChromeDriver());
			break;
		}
		return driver.get();
	}

}
