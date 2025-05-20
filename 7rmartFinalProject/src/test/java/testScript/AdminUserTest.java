package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminUserPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {

	@BeforeMethod(description = "Verify the admin able to create new admin user")
	public void verifyUserabletoCreateNewAdminuser() throws IOException {

		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");

		// random user name and password using faker class
		RandomDataUtility randomdata = new RandomDataUtility();

		String user = randomdata.createRandomUsername();

		String pass = randomdata.createRandomPassword();

		String Admin = ExcelUtility.getStringData(5, 0, "LoginPage");// ask

		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.enterusernameOnUsernameField(username);
		adminuser.enterPasswordonPasswordField(password);
		adminuser.clickOnsubmit();
		adminuser.clickOnAdminuser();
		adminuser.clickOnNew();
		adminuser.enternewusernameOnField(user);
		adminuser.enternewPasswordOntheField(pass);
		adminuser.selectUserType(Admin);
		adminuser.clickSaveLink();

		boolean isdisplayedAlert = adminuser.alertSuccessCreateUser();
		Assert.assertTrue(isdisplayedAlert, "User not created successfully");

	}

	@Test(description = "Verify the admin able to search the new user added")
	public void verifytheSearchofAddedUser() throws IOException {

		String searchusername = ExcelUtility.getStringData(4, 0, "LoginPage");
		String Admin = ExcelUtility.getStringData(5, 0, "LoginPage");

		AdminUserPage adminuser = new AdminUserPage(driver);
		adminuser.searchForCreatedUser();
		adminuser.searchForUser(searchusername);
		adminuser.selectUserTypesearch(Admin);
		adminuser.searchUser();

		boolean isDisplayedUser = adminuser.searchReceivedUser();
		Assert.assertTrue(isDisplayedUser, "User Failed to create not found under search");
	}
}
