package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.TimePageObjects;
import utils.CommonUtils;
import webdriverManager.DriverManager;

public class VerifyPendingTimesheetStep {
	
	private static final Logger logger= LogManager.getLogger();
	@Given("User is  in homepage")
	public void user_is_in_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		try {
String url=DriverManager.getDriver().getCurrentUrl();
if(url.contains("dashboard")) {
	logger.info("User is on homepage");
}
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			//CommonUtils.getinstance().takescrenshot();
			
		}
}	
	@When("User selects timesheet option")
	public void user_selects_timesheet_option() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			HomePageObjects.getinstance().Clicktime();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			logger.error(e);
			//CommonUtils.getinstance().takescrenshot();
}
	
	}
	@When("Enters the name as {string}")
	public void enters_the_name_as(String name) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			
TimePageObjects.getinstance().enteremployeename(name);
	}catch (Exception e) {
		// TODO: handle exception	
		logger.error(e);
		//CommonUtils.getinstance().takescrenshot();

	}
		}
	@When("User clicks view button")
	public void user_clicks_view_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
TimePageObjects.Viewbutton.click();
logger.info("User clicks view button");
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			//CommonUtils.getinstance().takescrenshot();

		}
}
	@Then("User should see Message  as {string}")
	public void user_should_see_message_as(String expectedmessage) {
	    // Write code here that turns the phrase above into concrete actions
		try {
String actualmessage=TimePageObjects.getinstance().Getmessage();
Assert.assertEquals(expectedmessage, actualmessage);
if(actualmessage.equals(expectedmessage)) {
	logger.info("expected message is visible");
}
	}catch (Exception e) {
		// TODO: handle exception
		logger.error(e);
		//CommonUtils.getinstance().takescrenshot();
		Assert.fail(e.getMessage());
	}
		}
	

}
