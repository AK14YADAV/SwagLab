package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestCases.BaseClass;



public class LoginPage {
	
	WebDriver driver =BaseClass.driver;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user-name")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(id="login-button")
	WebElement LoginBtn;
	
	@FindBy(tagName = "h3")
	WebElement Error;
	
	
	public void LoginSucess(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
		
	}
	
	public void LoginFailure(String username, String password) {
		
		UserName.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
		
	}
	
	public void ValidateErrorMsg(String ExpMsg) {

		String ActMsg = Error.getText();
		Assert.assertEquals(ExpMsg, ActMsg);
	}
	public void LockedUserTest(String username, String password) {
		UserName.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
		
	}
}
