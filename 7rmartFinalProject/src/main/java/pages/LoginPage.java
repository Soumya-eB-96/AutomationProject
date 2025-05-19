package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;// global and local variables is same so use concept 'this'
		PageFactory.initElements(driver, this);// initialize elements

	}

	@FindBy(name = "username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement SignIn;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement visibleAlert;
	@FindBy(xpath="//p[text()='Dashboard']")
	private WebElement dashBoard;

	public void enterusernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordonPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnsubmit() {
		SignIn.click();
	}
	
	public boolean alertVisibility()
	{
		return visibleAlert.isDisplayed();
	}
	
	public String getDashboardText()
	{
		return dashBoard.getText();
		
	}
}
