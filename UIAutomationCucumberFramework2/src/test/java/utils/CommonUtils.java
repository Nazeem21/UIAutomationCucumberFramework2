package utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.DirectoryPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.TimePageObjects;
import webdriverManager.DriverManager;

public class CommonUtils {
	private static final Logger logger=LogManager.getLogger(CommonUtils.class);
	private static CommonUtils commonutilsinstance=null;
	private CommonUtils() {
		
	}
	public static CommonUtils getinstance() {
		if(commonutilsinstance==null) {
			commonutilsinstance= new CommonUtils();
		}
		return commonutilsinstance;
		
	}
	
	public  void loadpropertyfile() {
		 Properties properties=new Properties();
		 try {
				properties.load(getClass().getResourceAsStream("/config.properties"));
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			 
			 Constants.App_URL=properties.getProperty("App_URL");
			 Constants.Browser=properties.getProperty("Browser");
			 Constants.Username= properties.getProperty("Username");
			 Constants.Password=properties.getProperty("Password");
			 Constants.Chrome_location=properties.getProperty("chrome_driver_location");
			 Constants.Firefox_location=properties.getProperty("firefox_driver_location");
			 Constants.Edge_location=properties.getProperty("edge_driver_location");
	}
	public void initwebeleements() {
		PageFactory.initElements(DriverManager.getDriver(), LoginPageObjects.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), HomePageObjects.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), DirectoryPageObjects.getinstance());
		PageFactory.initElements(DriverManager.getDriver(), TimePageObjects.getinstance());
	}
	public void takescrenshot() {
		File screenshot=((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(screenshot, new File("screenshot.png"));
} catch (IOException e) {
	// TODO Auto-generated catch block
System.out.println(e.getMessage());
}
	}

	public void highlightelement(WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');", element);
	}
	public void selectfromdropdown(WebElement element, String howto, String value) {
		Select select = new Select(element);
		 switch (howto) {
		case "index":
			select.selectByIndex(Integer.parseInt(value));
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
			break;
		default:
			logger.info("Please provide a valid selection: Text, Value, index in feature file");
			break;
		}
	}
}
