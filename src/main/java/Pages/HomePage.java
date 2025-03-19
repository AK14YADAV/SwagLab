package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import TestCases.BaseClass;

public class HomePage {
	
	WebDriver driver = BaseClass.driver;
	
	@FindBy(xpath= "//div[@class='product_label']")
	WebElement productText;
	
	@FindBy(xpath ="//button[@class='btn_primary btn_inventory'][1]")
	WebElement CartBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateErrorMsg(String ExpMsg) {

		String ActMsg = productText.getText();
		Assert.assertEquals(ExpMsg, ActMsg);
	}
	public void AddCart() {
	
		CartBtn.click();
		
	}
	
	

}
