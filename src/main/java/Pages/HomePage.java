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

	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateErrorMsg(String ExpMsg) {

		String ActMsg = productText.getText();
		Assert.assertEquals(ExpMsg, ActMsg);
	}
	
	@FindBy(xpath ="//button[@class='btn_primary btn_inventory'][1]")
	WebElement cartBtn;
	
	@FindBy(xpath="//span[@class='fa-layers-counter shopping_cart_badge']")
	WebElement cartValue;
	
	@FindBy(id="shopping_cart_container")
	WebElement shoppingCart;
	
	public void AddCart() {	

		cartBtn.click();
		String ActValue = cartValue.getText();
		Assert.assertEquals("1", ActValue);
		shoppingCart.click();
	
	}
	
	@FindBy(xpath="//*[text()='Your Cart']")
	WebElement yourCartTxt;
	
	@FindBy(xpath="//a[text()='CHECKOUT']")
	WebElement checkoutTxt;
	
	public void verifyCart() {
		String actTxt = yourCartTxt.getText();
		String exptTxt ="Your Cart";
		Assert.assertEquals(exptTxt,actTxt);
		checkoutTxt.click();
		
	}
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement postoalCode;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement continueBtn;
	
	public void addInformation() {
		firstName.sendKeys("Ajay");
		lastName.sendKeys("Kumar");
		postoalCode.sendKeys("110014");
		continueBtn.click();
	}
}
