package stepDefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DirectoryPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import utils.CommonUtils;
import webdriverManager.DriverManager;

public class VerifyCEOnameStep {
	
	private static final Logger logger=LogManager.getLogger(VerifyCEOnameStep.class);

	@Given("User logged in successfully")
	public void user_logged_in_successfully() {
	    // Write code here that turns the phrase above into concrete actions
		try {
		/*DriverManager.getDriver().get(Constants.App_URL);
		LoginPageObjects.getinstance().Enterusername(Constants.Username);
		//loginpage.getUsername().sendKeys(Constants.Username);
	LoginPageObjects.getinstance().Enterpassword(Constants.Password);
		LoginPageObjects.getinstance().Clickloginbtn();*/
		
String url=DriverManager.getDriver().getCurrentUrl();

if(url.contains("dashboard")) {
	logger.info("User logged in successfully");
}
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			//CommonUtils.getinstance().takescrenshot();
		}
		
	}
	@When("User selects directory option")
	public void user_selects_directory_option() {
	    // Write code here that turns the phrase above into concrete actions
		/*Actions action =new Actions(DriverManager.getDriver());
		action.moveToElement(HomePageObjects.getinstance().Clickdirectory()).click(HomePageObjects.getinstance().Clickdirectory()).perform();*/
		
		try{
			HomePageObjects.getinstance().Clickdirectory();
		
		logger.info("User selects directory option");
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			//CommonUtils.getinstance().takescrenshot();

		}/*
		WebDriverWait wait= new WebDriverWait(DriverManager.getDriver(), 10);
		wait.until(ExpectedConditions.elementToBeClickable(HomePageObjects.Directory)).click();
		System.out.println("User clicks on directory option ");	*/
	}
	@When("select the job title as {string} from drop down using {string}")
	public void select_the_job_title_as(String jobtitle,String howto) {
	    // Write code here that turns the phrase above into concrete actions
		try {
DriverManager.getDriver().get("https://opensource-demo.orangehrmlive.com/index.php/directory/viewDirectory");
CommonUtils.getinstance().selectfromdropdown(DirectoryPageObjects.getinstance().getJobtitle(), howto, jobtitle);
//DirectoryPageObjects.getinstance().Selecttitle(jobtitle);
logger.info("select the job title as {string}");
		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error(e);
			//CommonUtils.getinstance().takescrenshot();

		}
	}
	@When("User clicks Search button")
	public void user_clicks_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
DirectoryPageObjects.getinstance().clicksearch();
logger.info("User clicks Search button");
	}catch (Exception e) {
		// TODO: handle exception
		logger.error(e);
		//CommonUtils.getinstance().takescrenshot();

	}
		}
	@Then("User should name as {string}")
	public void user_should_name_as_ceo_name(String expectedname) {
	    // Write code here that turns the phrase above into concrete actions
		try {
String Actualname=DirectoryPageObjects.getinstance().Getname();
if 	(Actualname.equalsIgnoreCase(expectedname)) {
	logger.info("User should name as John Smith");
}
	}catch (Exception e) {
		// TODO: handle exception
		logger.error(e);
		//CommonUtils.getinstance().takescrenshot();

	}
		}
}
