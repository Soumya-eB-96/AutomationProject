package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import constants.Messages;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class ManageCategoryTest extends Base {
	HomePage homepage;
	ManageCategoryPage category;

	@Test(description = "Verify the user able to Add New category successfully")
	public void verifyuserAbletoAddNewCategory() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		String path = Constant.TESTDATAIMAGE;
		RandomDataUtility randomdata = new RandomDataUtility();
		String categoryname = randomdata.createRandomName();
		//String categoryname = ExcelUtility.getStringData(7, 0, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password);
		homepage = login.clickOnsubmit();
         
		category = homepage.clickOnManageCategory();
		category.clickAddNewCategory().enterCategoryName(categoryname).selectGroup().uploadFile(path).scrollDown()
				.selectRadioButton().saveCategoryclickButton();

		boolean isAlertdisplayed = category.addNewCategorySuccessfully();
		Assert.assertTrue(isAlertdisplayed, Messages.ADDNEWCATEGORYERROR);

	}

	@Test(description = "Verify user able to search category successfully")
	public void searchCategory() throws IOException {
		
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		String categoryname = ExcelUtility.getStringData(7, 0, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterusernameOnUsernameField(username).enterPasswordonPasswordField(password);
		homepage = login.clickOnsubmit();

		category = homepage.clickOnManageCategory();
		category.navigateToManageCategory().searchCategoryButton().searchCategoryField(categoryname).clickSearchButton();

		String expected = categoryname;
		String actual = category.searchAddedNewCategory();
		Assert.assertEquals(actual, expected, Messages.SEARCHCATEGORYERROR);
	}

}
