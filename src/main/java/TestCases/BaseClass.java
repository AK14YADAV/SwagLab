package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser") // Accept the browser parameter from TestNG XML
	public void StartDriver(String browserFromTestNG) {
		// Try to get browser name from System property first
		String browser = System.getProperty("browser", browserFromTestNG); // Default to TestNG XML parameter
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}

		driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void CloseDriver() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.close();
	}

}
