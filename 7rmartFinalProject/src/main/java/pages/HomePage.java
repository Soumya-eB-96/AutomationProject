package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;// global and local variables is same so use concept 'this'
		PageFactory.initElements(driver, this);// initialize elements

	}

	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement manageNews;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement Admin;
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']/a[2]")
	private WebElement Logout;
	@FindBy(xpath="//p[@class='login-box-msg']")
	private WebElement startSession;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement Adminuserlink;
	@FindBy(xpath="//p[text()='Manage Category']")
	private WebElement manageCategory;
	

	

	public HomePage clickOnAdminlink() {
		Admin.click();
		return this;
	}

	public LoginPage clickOnLogout() {
		Logout.click();
		return new LoginPage(driver) ;
	}
	public String getAdminText()
	{
		return startSession.getText();
		
	}
	
	public AdminUserPage clickOnAdminuser() {
		Adminuserlink.click();
		return new AdminUserPage(driver);
	}
	
	public ManageNewsPage navigateOnManageNews() {
		manageNews.click();
		return new ManageNewsPage(driver);
	}
	
	public ManageCategoryPage clickOnManageCategory()
	{
		manageCategory.click();
		return new ManageCategoryPage(driver);
	}
	
	
}
