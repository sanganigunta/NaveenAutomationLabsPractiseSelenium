package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptExecutorUtil {

	public static WebDriver driver = null;
		
		public JavascriptExecutorUtil(WebDriver driver) {
			this.driver = driver;
		}
	
	
	public String getTitleByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.title").toString();
	}
	
	public void refreshPageByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	
	public void backToPageByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(-1)");
	}
	
	
	public void forwordPageByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(1)");
	}
	
	public void getAlertMessageByJs(String message)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public void scrollToEndOfPage()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	public void scrollToTopOfOfPage()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}
	
	public void scrollToSpecificHeight(String height)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,'"+height+"')");
	}
	
	
	public void highlightAnElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','border:3px solid green;');", element);
		
		
	}
	
	
	public void highlightBackgroud(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].setAttribute('style','background:yellow;');",element); 
	}
	
	
	public void senKeysByJs(String id, String value)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+id+"').value='"+value+"'");
		
	}
	
	public void clickByJs(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
}
