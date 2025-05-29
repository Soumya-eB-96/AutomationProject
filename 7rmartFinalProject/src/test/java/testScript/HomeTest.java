package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	
	HomePage homepage;
	

	@Test(description = "Verify user able logout from home page")
	public void verifyWhetherUserisabletosuccessfullyLogoutfromeHomePage() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
        
		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password);
		homepage=login.clickOnsubmit();
		
		homepage.clickOnAdminlink();
		login =homepage.clickOnLogout();
		
		String expected = "Sign in to start your session";
		String actual = homepage.getAdminText();
		Assert.assertEquals(actual, expected,Messages.LOGOUTSUCCESSERROR);
	}

}
