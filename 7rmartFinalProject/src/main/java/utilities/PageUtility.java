package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {

	WebDriver driver;
	//select dropdown value
	public void selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}
	//select by index
	public void selectDropdowithIndex(WebElement element, int index)
	{
		Select object = new Select(element);
		object.selectByIndex(index);
		
	}
	//select by visibletext
	public void selectDropdownwithVisibleText(WebElement element, String text)
	{
		Select object = new Select(element);
		object.selectByVisibleText(text);
	}
	// mousehover the element
	public void mouseHoverElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	//right click/context click
	public void rightClickElement(WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	//checkbox selection
	public void selectCheckboxHandle(WebElement element)
	{
		if(!element.isSelected())
		{
			element.click();
		}
	}
	//enable button select
	public void selectRadiobuttonHandle(WebElement element)
	{
		if(!element.isSelected())
		{
			element.click();
		}
	}
	// click element using java script executor
	public void clickOnElementByjs(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("argument[0].click();", element);
	}
	
	//scroll down
	public void scrollDownpage(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	//scroll up
	public void scrollUppage()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBTo(0,0)");
	}
	
}
