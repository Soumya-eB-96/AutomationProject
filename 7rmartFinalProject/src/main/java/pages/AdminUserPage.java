package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUserPage {
	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;// global and local variables is same so use concept 'this'
		PageFactory.initElements(driver, this);// initialize elements

	}

	@FindBy(name = "username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement SignIn;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement Adminuserlink;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	private WebElement NewLink;
	@FindBy(xpath = "//input[@id='username']")
	private WebElement UsernameNew;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement PasswordNew;
	@FindBy(xpath = "//select[@name='user_type']")
	private WebElement Usertypedropdown;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	private WebElement saveLink;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	private WebElement searchButton;
	@FindBy(xpath="//input[@class='form-control' and @id='un']")
	private WebElement searchuser;
	@FindBy(xpath="//select[@class='form-control' and @id='ut']")
	private WebElement searchusertype;
	@FindBy(xpath="//button[@type='submit' and @name='Search']")
	private WebElement searchbutton;

	public void enterusernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordonPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnsubmit() {
		SignIn.click();
	}

	public void clickOnAdminuser() {
		Adminuserlink.click();
	}

	public void clickOnNew() {

		NewLink.click();
	}

	public void enternewusernameOnField(String user) {
		UsernameNew.sendKeys(user);
	}

	public void enternewPasswordOntheField(String pass) {
		PasswordNew.sendKeys(pass);
	}

	public void selectUserType(String Admin) {

		Select select = new Select(Usertypedropdown);
		select.selectByVisibleText(Admin);
	}

	public void clickSaveLink() {
		saveLink.click();
	}
	
	public void searchForCreatedUser()
	{
		searchButton.click();
	}
	
	public void searchForUser(String searchusername)
	{
		searchuser.sendKeys(searchusername);	
	}
	
	public void selectUserTypesearch(String Admin)
	{
		Select select = new Select(searchusertype);
		select.selectByVisibleText(Admin);
	}
	
	public void searchUser()
	{
		searchbutton.click();
	}

}
