package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	@Test(description = "Verify user able logout from home page")
	public void verifyWhetherUserisabletosuccessfullyLogoutfromeHomePage() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		HomePage homepage = new HomePage(driver);
		homepage.enterusernameOnUsernameField(username);
		homepage.enterPasswordonPasswordField(password);
		homepage.clickOnsubmit();
		homepage.clickOnAdminlink();
		homepage.clickOnLogout();
		
		String expected = "Sign in to start your session";
		String actual = homepage.getAdminText();
		Assert.assertEquals(actual, expected, "User not logged out from the session");
	}

}
