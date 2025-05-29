package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageCategoryPage {
	
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[text()='Manage Category']")
	private WebElement manageCategory;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Category/add']")
	private WebElement AddNewButton;
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement categoryName;
	@FindBy(xpath="//li[@class=\"ms-elem-selectable\"]")
	private WebElement selectgroup;
	@FindBy(xpath="//input[@id='main_img']")
	private WebElement chooseFile;
	@FindBy(xpath="//input[@value=\"no\" and @name=\"top_menu\"]")
	private WebElement clickRadio;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchCategory;
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement categorySearchform;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	private WebElement SearchButton;
	@FindBy(xpath="//h1[text()='List Categories']")
	private WebElement ListCategory;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement AddNewCategory;
	@FindBy(xpath="//td[text()='New Category Sale']")
	private WebElement AddedCategory;


	
	
	
	public ManageCategoryPage clickAddNewCategory()
	{
		AddNewButton.click();
		return this;
	}
	
	public ManageCategoryPage enterCategoryName(String categoryname)
	{
		categoryName.sendKeys(categoryname);
		return this;
	}
	
	public ManageCategoryPage selectGroup()
	{
		selectgroup.click();
		return this;
	}
	
	public ManageCategoryPage scrollDown()
	{
		
		PageUtility pageutility = new PageUtility();
		pageutility.scrollDownpage(driver);
		return this;

	}
	public ManageCategoryPage uploadFile(String path)
	{
		chooseFile.sendKeys(path);
		return this;
	}
	
	public ManageCategoryPage selectRadioButton()
	{
		clickRadio.click();
		return this;
	}
	
	public ManageCategoryPage saveCategoryclickButton()
	{
		saveButton.click();
		return this;
	}
	// search
	public ManageCategoryPage navigateToManageCategory()
	{
		manageCategory.click();
		return this;
	}
	
	public ManageCategoryPage searchCategoryButton()
	{
		searchCategory.click();
		return this;
	}
	
	public ManageCategoryPage searchCategoryField(String categoryname)
	{
		categorySearchform.sendKeys(categoryname);
		return this;
	}
	public ManageCategoryPage clickSearchButton()
	{
		SearchButton.click();
		return this;
	}
	public String presentListCategories()
	{
		return ListCategory.getText();
		
	}
	public boolean addNewCategorySuccessfully()
	{
		return AddNewCategory.isDisplayed();
		
	}
	public String searchAddedNewCategory()
	{
		return AddedCategory.getText();
		
	}
}
