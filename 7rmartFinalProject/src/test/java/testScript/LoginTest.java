package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(description = "Verifying user login with valid credentials")
	public void verifyUsercansuccessfullyloginwithvalidcredentials() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username);
		login.enterPasswordonPasswordField(password);
		login.clickOnsubmit();
        // Assert equal
		String expected = "dashBoard";
		String actual = login.getDashboardText();
		Assert.assertEquals(actual, expected, "User was unable to login with valid credentials");

	}

	@Test(description = "Verify the login with invalid username and password")
	public void verifyfailureloginwithinvalidcredentials() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "LoginPage");
		String password = ExcelUtility.getStringData(1, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username);
		login.enterPasswordonPasswordField(password);
		login.clickOnsubmit();
		// Assertion
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed, "User login successful with invalid password");
	}

	@Test(description = "Verify the login with valid username and invalid password")
	public void verifyfailureloginwithinvalidpasswordvalidusername() throws IOException {
		String username = ExcelUtility.getStringData(2, 0, "LoginPage");
		String password = ExcelUtility.getStringData(2, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username);
		login.enterPasswordonPasswordField(password);
		login.clickOnsubmit();

		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed, "User Successfully logged in with invalid password");
	}

	@Test(description = "Verify the login with invalid username and valid password")
	public void verifyfailureloginwithinvalidpasswordinvalidusername() throws IOException {
		String username = ExcelUtility.getStringData(3, 0, "LoginPage");
		String password = ExcelUtility.getStringData(3, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username);
		login.enterPasswordonPasswordField(password);
		login.clickOnsubmit();
		
		boolean isalertDisplayed = login.alertVisibility();
		Assert.assertTrue(isalertDisplayed,"User successfully logged in with invalid username");
	}

}
