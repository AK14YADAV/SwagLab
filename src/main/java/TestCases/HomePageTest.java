package TestCases;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends BaseClass {

	@Test(groups= {"sanity","regression"})
	public void tc01_AddToCartTest() {

		LoginPage lp = new LoginPage();
		lp.LoginSucess("standard_user	", "secret_sauce");
		HomePage hp = new HomePage();
		hp.ValidateErrorMsg("Products");
		hp.AddCart();

	}

}
