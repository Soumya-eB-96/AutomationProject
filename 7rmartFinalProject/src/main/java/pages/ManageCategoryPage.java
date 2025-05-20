package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
	
	public WebDriver driver;

	public ManageCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement SignIn;
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

	public void enterusernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordonPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnsubmit() {
		SignIn.click();
	}
	
	public void clickOnManageCategory()
	{
		manageCategory.click();
	}
	
	public void clickAddNewCategory()
	{
		AddNewButton.click();
	}
	
	public void enterCategoryName(String categoryname)
	{
		categoryName.sendKeys(categoryname);
	}
	
	public void selectGroup()
	{
		selectgroup.click();
	}
	
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500);"); 

	}
	public void uploadFile(String path)
	{
		chooseFile.sendKeys(path);
	}
	
	public void selectRadioButton()
	{
		clickRadio.click();
	}
	
	public void saveCategoryclickButton()
	{
		saveButton.click();
	}
	
	public void navigateToManageCategory()
	{
		manageCategory.click();
	}
	
	public void searchCategoryButton()
	{
		searchCategory.click();
	}
	
	public void searchCategoryField(String categoryname)
	{
		categorySearchform.sendKeys(categoryname);
	}
	public void clickSearchButton()
	{
		SearchButton.click();
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
