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


	
	
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	private WebElement addnews;
	@FindBy(xpath = "//textarea[@id='news']")
	private WebElement enternews;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement savenewsButton;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	private WebElement manageNewstext;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement createNews;


	

	public ManageNewsPage clickAddNewsButton() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addnews);
		return this;

	}

	public ManageNewsPage enterNewsontheField(String newscontent) {

		enternews.clear();
		enternews.sendKeys(newscontent);
		return this;
	}

	public ManageNewsPage clickOnSaveNewsButton() {
		savenewsButton.click();
		return this;
	}

	public  String getNewsText()
	{
		return manageNewstext.getText();
		
	}
	
	public boolean alertVisible()
	{
		return createNews.isDisplayed();
		
	}

}
