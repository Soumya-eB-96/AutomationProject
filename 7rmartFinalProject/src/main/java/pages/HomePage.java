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

	@FindBy(name = "username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement SignIn;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement Admin;
	@FindBy(xpath = "//div[@class='dropdown-menu dropdown-menu-lg dropdown-menu-right text_black show']/a[2]")
	private WebElement Logout;
	

	public void enterusernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordonPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnsubmit() {
		SignIn.click();
	}

	public void clickOnAdminlink() {
		Admin.click();
	}

	public void clickOnLogout() {
		Logout.click();
	}
	
}
