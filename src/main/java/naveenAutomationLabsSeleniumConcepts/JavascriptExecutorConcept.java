package naveenAutomationLabsSeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavascriptExecutorConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
//		String title=js.executeScript("return document.title").toString();
//		System.out.println(title);
		
//		String title=getTitleByJs();
//		System.out.println(title);
		
//		js.executeScript("history.go(0)");
//		
//		driver.get("https://www.amazon.com/");
//		js.executeScript("history.go(-1)");
//		js.executeScript("history.go(1)");
		
		
//		refreshPageByJs();
//		driver.get("https://www.amazon.com/");
//		backToPageByJs();
//		forwordPageByJs();
		
//		String message="Hello i am testing alert message of JS";
//		js.executeScript("alert('"+message+"')");
		
//		getAlertMessageByJs("Hello i am testing alert message of JS");
		
//		
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
//		
//		js.executeScript("window.scrollTo(document.body.scrollToHeight,0);");
//		
//		js.executeScript("window.scrollTo(0,400)");
//		
//		
//		scrollToEndOfPage();
//		scrollToTopOfOfPage();
//		scrollToSpecificHeight("250");
		
		WebElement email = driver.findElement(By.id("input-email"));
//		js.executeScript("arguments[0].setAttribute('style' , 'background:yellow; border: 3px solid red');",email);
//    	highlightAnElement(email);
//     	highlightBackgroud(email);
		
//		String color = email.getCssValue("background");
//		System.out.println(color);
//		String arr[] = color.split("none");
//		System.out.println(arr[0]);
	
//		String emailId ="input-email";
//		String value="test@gmail.com";
//
//		js.executeScript("document.getElementById('"+emailId+"').value='"+value+"'");
		
//		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
//		js.executeScript("arguments[0].click();",loginBtn );
		
//		
//		String emailId ="input-email";
//		String value="test@gmail.com";
//		senKeysByJs(emailId,value);
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
		clickByJs(loginBtn);
	}

	
	public static String getTitleByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return js.executeScript("return document.title").toString();
	}
	
	public static void refreshPageByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	
	public static void backToPageByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(-1)");
	}
	
	
	public static void forwordPageByJs()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(1)");
	}
	
	public static void getAlertMessageByJs(String message)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void scrollToEndOfPage()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
	
	public static void scrollToTopOfOfPage()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}
	
	public static void scrollToSpecificHeight(String height)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,'"+height+"')");
	}
	
	
	public static void highlightAnElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style','border:3px solid green;');", element);
		
		
	}
	
	
	public static void highlightBackgroud(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].setAttribute('style','background:yellow;');",element); 
	}
	
	
	public static void senKeysByJs(String id, String value)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('"+id+"').value='"+value+"'");
		
	}
	
	public static void clickByJs(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
}
