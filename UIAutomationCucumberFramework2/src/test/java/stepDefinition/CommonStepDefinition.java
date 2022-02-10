package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import constants.Constants;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pageObjects.LoginPageObjects;
import utils.CommonUtils;
import webdriverManager.DriverManager;

public class CommonStepDefinition {
	public static final Logger logger=LogManager.getLogger(CommonStepDefinition.class);
	@Before
	public void beforescenario() {
		logger.info("Execution started");
		try {
			//removing below line because it gives us error since we changed the load property file to non-static
			/*LoadProperties.loadpropertyfile();*/
			logger.info("Starting commonutilfile");
			logger.info("Loading Property file");
			CommonUtils.getinstance().loadpropertyfile(); 
			logger.info("Opening Browser only once");
			if (DriverManager.getDriver()==null) {
				DriverManager.launchbrowser();
		CommonUtils.getinstance().initwebeleements();
		login();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void login() {
		// TODO Auto-generated method stub
		DriverManager.getDriver().get(Constants.App_URL);
		LoginPageObjects.getinstance().Enterusername(Constants.Username);
		//loginpage.getUsername().sendKeys(Constants.Username);
	LoginPageObjects.getinstance().Enterpassword(Constants.Password);
		LoginPageObjects.getinstance().Clickloginbtn();
	}
	
	@AfterStep
	public void attachscreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot screenshot=(TakesScreenshot)DriverManager.getDriver();
			byte[] screenshottaken=screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshottaken, "image/png", "errorscreenshot");
		}
	}
}
