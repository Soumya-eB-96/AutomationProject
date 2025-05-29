package testScript;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import automationcore.Base;
import constants.Messages;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {

	HomePage homepage;
	AdminUserPage adminuser;

	@Test(description = "Verify the admin able to create new admin user")
	public void verifyUserabletoCreateNewAdminuser() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		String Admin = ExcelUtility.getStringData(5, 0, "LoginPage");
		// random user name and password using faker class
		RandomDataUtility randomdata = new RandomDataUtility();
        String user = randomdata.createRandomUsername();
		String pass = randomdata.createRandomPassword();
        LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password);
		homepage = login.clickOnsubmit();
		
        adminuser = homepage.clickOnAdminuser();
        adminuser.clickOnNew().enternewusernameOnField(user)
				.enternewPasswordOntheField(pass).selectUserType(Admin).clickSaveLink();

		boolean isdisplayedAlert = adminuser.alertSuccessCreateUser();
		Assert.assertTrue(isdisplayedAlert, Messages.CREATEUSERSUCCESSERROR);

	}

	@Test(description = "Verify the admin able to search the new user added")
	public void verifytheSearchofAddedUser() throws IOException {

		
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password);
		homepage = login.clickOnsubmit();
		
		String searchusername = ExcelUtility.getStringData(4, 0, "LoginPage");
		String Admin = ExcelUtility.getStringData(5, 0, "LoginPage");

		//AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser = homepage.clickOnAdminuser();
		adminuser.searchForCreatedUser().searchForUser(searchusername).selectUserTypesearch(Admin).searchUser();

		boolean isDisplayedUser = adminuser.searchReceivedUser();
		Assert.assertTrue(isDisplayedUser, Messages.SEARCHSUCCESSERROR);
	}
}
