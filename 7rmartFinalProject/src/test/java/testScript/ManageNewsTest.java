package testScript;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	@BeforeMethod(description = "Verify the user able to navigate Manage News Successfully")
	public void verifyNavigationToManageNews() throws IOException {
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		ManageNewsPage news = new ManageNewsPage(driver);
		news.enterusernameOnUsernameField(username);
		news.enterPasswordonPasswordField(password);
		news.clickOnsubmit();
		news.navigateOnManageNews();
	}

	@Test(description = "Verify the user able to add the new news successfully")
	public void verifyAddNewnews() throws IOException {
		String newscontent = ExcelUtility.getStringData(6, 0, "LoginPage");

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickAddNewsButton();
		news.enterNewsontheField(newscontent);
		news.clickOnSaveNewsButton();
	}

}
