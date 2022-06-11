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

public class ToolTipVideoBased {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/tooltip/");
		
		By video = By.id("Video Based");
		
		WebElement videoBasedTab = waitForElement(video,10);
		videoBasedTab.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,400)");
		
		 driver.switchTo().frame(driver.findElement(By.xpath("//div[@rel-title='Video Based']//iframe")));
	
	 
		WebElement ele =driver.findElement(By.xpath("//button[@data-icon='ui-icon-circle-plus']"));
		 
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		 
//	
//		Thread.sleep(5000);
//		String text =driver.findElement(tooltipVal).getText();
//		System.out.println(text);
		
		
	
		
		
	
		
		
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement()));
//		
//		System.out.println(ele.getText());
//		
//		

		
		
		
	}
	
	public static WebElement waitForElement(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}

}
