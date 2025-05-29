package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenews;

	@Test(description = "Verify the user able to add the new news successfully")
	public void verifyNavigationToManageNews() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password);
		homepage =login.clickOnsubmit();
		
		String newscontent = ExcelUtility.getStringData(6, 0, "LoginPage");

		
		managenews = homepage.navigateOnManageNews();
		managenews.clickAddNewsButton().enterNewsontheField(newscontent).clickOnSaveNewsButton();
		
		boolean isDisplayedAlert = managenews.alertVisible();
		Assert.assertTrue(isDisplayedAlert, Messages.ADDNEWSERROR);
		
		
	}

}
