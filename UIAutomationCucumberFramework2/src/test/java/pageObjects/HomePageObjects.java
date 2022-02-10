package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import webdriverManager.DriverManager;

public class HomePageObjects {

	private static HomePageObjects Homepageinstance;
	private  HomePageObjects() {
		// TODO Auto-generated constructor stub
	}
	public static HomePageObjects getinstance() {
		if(Homepageinstance==null) {
			
			Homepageinstance = new HomePageObjects();
		}
		return Homepageinstance;
		
	}
	/*
	@FindBy(xpath = "//*[text()='Directory']")
	public static WebElement Directory;

	/*public static WebElement getDirectory() {
		return Directory;
	}*/
	@FindBy(xpath = "//*[@id=\"menu_time_viewTimeModule\"]/b")
	public static WebElement Time;
	
	By Directory=By.xpath("//*[text()='Directory']");
	
	public void Clickdirectory() {
		try {
		//	CommonUtils.getinstance().highlightelement(Directory);
			//Directory.click();
			CommonUtils.getinstance().highlightelement(DriverManager.getDriver().findElement(Directory));
			DriverManager.getDriver().findElement(Directory).click();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Element not found, trying to find one more time using explicit wait");
			try {
				
				WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 15);
				wait.until(ExpectedConditions.visibilityOfElementLocated(Directory));
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Element not found");
			}
		}
		
	}
	public void Clicktime() {
		CommonUtils.getinstance().highlightelement(Time);
		Time.click();
	}
}
