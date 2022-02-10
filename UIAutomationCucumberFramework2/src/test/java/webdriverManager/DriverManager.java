package webdriverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver= null;
	private static final Logger logger=LogManager.getLogger(DriverManager.class);
	public static WebDriver getDriver() {
		return driver;
	}
	public static void launchbrowser() {
		// TODO Auto-generated method stub
		try {
			switch (Constants.Browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				logger.info("Launching" +Constants.Browser);
				driver= new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				logger.info("Launching" +Constants.Browser);
				driver= new FirefoxDriver();
				break;
			case "edge":
			WebDriverManager.edgedriver().setup();
				logger.info("Launching" +Constants.Browser);
				driver= new EdgeDriver();
				break;
			default:
				WebDriverManager.firefoxdriver().setup();
				logger.info("Launching" +Constants.Browser);
				driver= new FirefoxDriver();
				break;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
