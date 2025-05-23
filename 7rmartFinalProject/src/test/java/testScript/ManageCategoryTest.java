package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	
	@BeforeMethod(description="Verify the user able to navigate successfully to manage category")
	public void verifyManageCategory() throws IOException
	{
		String username = ExcelUtility.getStringData(0, 0, "LoginPage");
		String password = ExcelUtility.getStringData(0, 1, "LoginPage");
		
		ManageCategoryPage category = new ManageCategoryPage(driver);
		category.enterusernameOnUsernameField(username);
		category.enterPasswordonPasswordField(password);
		category.clickOnsubmit();
		category.clickOnManageCategory();
		
		String expected = "List Categories";
		String Actual = category.presentListCategories();
		Assert.assertEquals(Actual,expected, "User failed to navigate to the Manage category");
	}
	@Test(description="Verify the user able to Add New category")
	public void addNewCategory() throws IOException
	{
		String path = Constant.TESTDATAIMAGE;
		String categoryname = ExcelUtility.getStringData(7, 0, "LoginPage");
		
		ManageCategoryPage category = new ManageCategoryPage(driver);
		category.clickAddNewCategory();
		category.enterCategoryName(categoryname);
		category.selectGroup();
		category.scrollDown();
		category.uploadFile(path);
		category.selectRadioButton();
		category.saveCategoryclickButton();
		category.scrollDown();
		
		boolean isAlertdisplayed = category.addNewCategorySuccessfully();
		Assert.assertTrue(isAlertdisplayed,"The Category is failed to create");
	 }
	
	@AfterMethod(description ="Verify user able to search category successfully")
	public void searchCategory() throws IOException
	{
		String categoryname = ExcelUtility.getStringData(7, 0, "LoginPage");
		
		ManageCategoryPage category = new ManageCategoryPage(driver);
		category.navigateToManageCategory();
		category.searchCategoryButton();
		category.searchCategoryField(categoryname);
		category.clickSearchButton();
		//Ask except gettext any other ways
		
		String expected = categoryname;
		String actual = category.searchAddedNewCategory();
		Assert.assertEquals(actual, expected,"Unable to find the searched category");
	}

}
