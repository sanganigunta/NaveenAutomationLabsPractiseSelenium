package globalsqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormsBasedToolTip {

static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/tooltip/");
		
		By video = By.id("Forms Based");
		
		WebElement videoBasedTab = waitForElement(video,10);
		videoBasedTab.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@rel-title='Forms Based']//iframe")));
		
		Thread.sleep(2000);
		
//		firstName.sendKeys("test");
//		Actions action = new Actions(driver);
//		action.moveToElement(firstName).perform();
		
		By firstName = By.id("firstname");
		By lastName = By.name("lastname");
		
		By toolTip = By.cssSelector(".ui-tooltip-content");
		

		String text = getToolTipValue(lastName,toolTip,"test");
		System.out.println(text);
	}
	
	public static WebElement waitForElement(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	public static String getToolTipValue(By locator, By toolTipLocator, String sendKeysValue)
	{
		driver.findElement(locator).sendKeys("test");

		return driver.findElement(toolTipLocator).getText();
		
	}

}


