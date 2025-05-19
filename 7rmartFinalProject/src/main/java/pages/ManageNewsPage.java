package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement usernamefield;
	@FindBy(name = "password")
	private WebElement passwordfield;
	@FindBy(xpath = "//button[text()='Sign In']")////a[@onclick='click_button(2)']
	private WebElement SignIn;
	@FindBy(xpath = "//p[text()='Manage News']")
	private WebElement manageNews;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")//"//a[@class='btn btn-rounded btn-danger']"
	private WebElement addnews;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enternews;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savenewsButton;

	public void enterusernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
	}

	public void enterPasswordonPasswordField(String password) {
		passwordfield.sendKeys(password);
	}

	public void clickOnsubmit() {
		SignIn.click();
	}

	public void navigateOnManageNews() {
		manageNews.click();
	}

	public void clickAddNewsButton() {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", addnews);
		
		
	}

	public void enterNewsontheField(String newscontent) {
		
		enternews.clear();
		enternews.sendKeys(newscontent);
	}

	public void clickOnSaveNewsButton() {
		savenewsButton.click();
	}

}
