package TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;
	@BeforeMethod
	public void StartDriver() {
		
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void CloseDriver() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.close();
	}
}
