package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.CommonUtils;

public class DirectoryPageObjects {

	private static DirectoryPageObjects directoryinstance;
	private  DirectoryPageObjects() {
		// TODO Auto-generated constructor stub
	}
	public static DirectoryPageObjects getinstance() {
		if(directoryinstance==null) {
			directoryinstance= new DirectoryPageObjects();
		}
		return directoryinstance;
		
	}
	@FindBy(id="searchDirectory_job_title")
	public  WebElement Jobtitle;
	
	@FindBy(id="searchBtn")
	public  WebElement Search;

	@FindBy(xpath = "//ul/li/b")
	public  WebElement Name;

	public WebElement getJobtitle() {
		return Jobtitle;
	}
/*
	public WebElement getSearch() {
		return Search;
	}

	public WebElement getName() {
		return Name;
	}*/
	/*
	public void Selecttitle(String jobtitle) {
		Select select= new Select(Jobtitle);
		select.selectByVisibleText(jobtitle);
	}*/ 
	public void clicksearch() {
		CommonUtils.getinstance().highlightelement(Search);
		Search.click();
	}
	public String Getname() {

		return Name.getText();
	}
}
