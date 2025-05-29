package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	HomePage homepage;

	@Test(description = "Verifying user login with valid credentials", priority = 1, groups = {
			"smoke" }, retryAnalyzer = retry.Retry.class)
	public void verifyUsercansuccessfullyloginwithvalidcredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password);
		homepage = login.clickOnsubmit();
		// Assert equal
		String expected = "Dashboard";
		String actual = login.getDashboardText();
		Assert.assertEquals(actual, expected, Messages.VALIDCREDENTIALERROR);

	}

	@Test(description = "Verify the login with invalid username and password", dataProvider = "loginProvider", groups = {
			"smoke" }, priority = 4)
	public void verifyfailureloginwithinvalidcredentials(String username, String password) throws IOException {
		// String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		// String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password).clickOnsubmit();
		// Assertion
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed, Messages.INVALIDCREDENTIALERROR);
	}

	@Test(description = "Verify the login with valid username and invalid password", priority = 3, retryAnalyzer = retry.Retry.class)
	public void verifyfailureloginwithinvalidpasswordvalidusername() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password).clickOnsubmit();

		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed, Messages.INVALIDPASSWORDERROR);
	}

	@Test(description = "Verify the login with invalid username and valid password", priority = 2)
	public void verifyfailureloginwithinvalidpasswordinvalidusername() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password).clickOnsubmit();

		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed, Messages.INVALIDUSERNAMEERROR);
	}

	@DataProvider(name = "loginProvider")
	public Object[][] getDataFromDataProvider() throws IOException {
		return new Object[][] { new Object[] { "admin", "admin" }, new Object[] { "admin123", "123" }
				//new Object[] {ExcelUtility.getStringData(3, 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};

	}

}
