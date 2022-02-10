package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CommonUtils;

public class TimePageObjects {
private static TimePageObjects Timepageinstance;
private  TimePageObjects() {
	// TODO Auto-generated constructor stub
}
public static TimePageObjects getinstance() {
	if(Timepageinstance==null) {
		Timepageinstance=new TimePageObjects();
	}
	return Timepageinstance;
	
}
	@FindBy(id="employee")
	public static WebElement EmployeeName;
	
	@FindBy(id="btnView")
	public static WebElement Viewbutton;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div[1]")
	public static WebElement Message;
	public void enteremployeename(String ename) {
		CommonUtils.getinstance().highlightelement(EmployeeName);
		EmployeeName.clear();
		EmployeeName.sendKeys(ename);
	}
	
	public void  Clickviewbutton() {
		CommonUtils.getinstance().highlightelement(Viewbutton);

		Viewbutton.click();
		
	}
	public String Getmessage() {
		
		return Message.getText();
		
		
	}
}
