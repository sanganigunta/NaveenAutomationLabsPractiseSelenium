package globalsqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTipImageBased {

	static WebDriver driver;
	static Actions action ;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/tooltip/#Image%20Based");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='attention closable']"))));
		
//		String text =ele.getText();
//		System.out.println(text);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame.lazyloaded")));
	//	WebElement countryName1 = driver.findElement(By.linkText("Vienna, Austria"));
		
//		action = new Actions(driver);
//		action.moveToElement(countryName1).perform();
//		String toolTip1 =driver.findElement(By.xpath("//div[@class='ui-tooltip-content']/img")).getAttribute("alt");
//		System.out.println(toolTip1);
		
		action = new Actions(driver);
//		By Austria = By.linkText("Vienna, Austria");
//		By toolTip = By.xpath("//div[@class='ui-tooltip-content']/img");
//		
//		getTootlTipText(Austria,toolTip,"alt");
		
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,400)");
//		By landon = By.linkText("London, England");
//		getTootlTipText(landon, toolTip,"alt");
		
		By image1 = By.cssSelector("img[src*='stephens']");
		
//		String text = getTootlTipTextforImages(image1,"alt");
//		System.out.println(text);
		
		
		By image2 = By.cssSelector("img[src*='tower']");
		String text = getTootlTipTextforImages(image2,"alt");
		System.out.println(text);
		
	}
	
	public static void getTootlTipText(By locator, String AttributeValue)
	{
		action.moveToElement(driver.findElement(locator)).perform();
		String toolTip1 =driver.findElement(By.xpath("//div[@class='ui-tooltip-content']/img")).getAttribute(AttributeValue);
		System.out.println(toolTip1);
		
	}
	
	public static String getTootlTipTextforImages(By locator, String AttributeValue)
	{
		action.moveToElement(driver.findElement(locator)).perform();
		return driver.findElement(By.xpath("//div[@class='ui-tooltip-content']")).getText();		
	}

}
