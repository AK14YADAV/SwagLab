package TestCases;

import org.testng.annotations.Test;

import Pages.LoginPage;

public class TC_LoginPage extends BaseClass {

	@Test(groups= {"sanity","regression"})
	public void TC01_LoginSuccessTest() {
		LoginPage lp = new LoginPage();
		lp.LoginSucess("standard_user	", "secret_sauce");
	}

	@Test(groups= {"sanity","regression"})
	public void TC02_LoginFailureTest() {

		LoginPage lp = new LoginPage();
		lp.LoginFailure("abc@gmail.com", "123");
		lp.ValidateErrorMsg("Epic sadface: Username and password do not match any user in this service");
	}

	@Test(groups= {"sanity","regression"})
	public void TC03_LockedUserTest() {

		LoginPage lp = new LoginPage();
		lp.LockedUserTest("locked_out_user	", "secret_sauce");
		lp.ValidateErrorMsg("Epic sadface: Sorry, this user has been locked out.");
	}

}
