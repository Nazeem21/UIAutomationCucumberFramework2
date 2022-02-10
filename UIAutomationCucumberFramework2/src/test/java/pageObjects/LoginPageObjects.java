package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.CommonUtils;

public class LoginPageObjects {
	
	private static LoginPageObjects logininstance;
	
	private  LoginPageObjects() {
		// TODO Auto-generated constructor stub
	} 
	
	public static LoginPageObjects getinstance() {
		if(logininstance==null)
		{
			logininstance = new LoginPageObjects();
		}
		return logininstance;
		
	}
	
	@FindBy(id="txtUsername")
	public   WebElement Username;
	@FindBy(id="txtPassword")
	public   WebElement Password;
	@FindBy(id="btnLogin")
	public  WebElement LoginButton;
/*	public WebElement getUsername() {
		return Username;
	}
	public WebElement getPassword() {
		return Password;
	}
	public WebElement getLoginButton() {
		return LoginButton;
	}*/
	public void Enterusername(String uid) {
		CommonUtils.getinstance().highlightelement(Username);
		Username.sendKeys(uid);
	}
public void Enterpassword(String upwd) {
	CommonUtils.getinstance().highlightelement(Password);
		Password.sendKeys(upwd);
	}
public void Clickloginbtn() {
	CommonUtils.getinstance().highlightelement(LoginButton);
	LoginButton.click();
}
}
