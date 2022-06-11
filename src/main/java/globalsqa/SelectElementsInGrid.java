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

public class SelectElementsInGrid {

	static WebDriver driver;

	static Actions action;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/select-elements/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");
		
		
		By grid = By.xpath("//li[@id='Grid Selection']");
		By seialize = By.xpath("//li[@id='Serialize']");
		
		clickOnTab(seialize);
		
		By frameVal = By.xpath("//iframe[@class='demo-frame lazyloaded' and contains(@data-src,'serialize') ]");
		WebElement frameEle = driver.findElement(frameVal);
		switchToFrame(frameEle);
		
//		WebElement frameVal = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded' and contains(@data-src,'display-grid')]"));
//     	driver.switchTo().frame(frameVal);
//		
//     	By test1 = By.xpath("//ol[@id='selectable']//li[text()='2']");
//		
//		waitForElement(test1,10);
//		
    	action = new Actions(driver);
////		driver.findElement(test1).click();
//		
//		int n=1;
//		while(n>0 && n<=12) {
//		selectGrid(n);
//		n++;
//		}

     	
     	By iteam = By.xpath("//ol[@id='selectable']//li[text()='Item 1']");
     	waitForElement(iteam,5);
     	int n=1;
     	while(n>0 && n<=6) {
     	selectSerialize(n);
     	n++;
     	}
     	//driver.findElement(iteam).click();

	}
	
	public static WebElement waitForElement(By locator, int timeOut)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		
	}
	
	
	public static void selectGrid(int num)
	{
		WebElement ele = driver.findElement(By.xpath("//ol[@id='selectable']//li[text()='"+num+"']"));
		action.moveToElement(ele).clickAndHold(ele).build().perform();
		}
	
	public static void clickOnTab(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public static void switchToFrame(WebElement ele)
	{
		driver.switchTo().frame(ele);
		
	}
	
	public static void selectSerialize(int num)
	{
		WebElement ele = driver.findElement(By.xpath("//ol[@id='selectable']//li[text()='Item "+num+"']"));
		action.moveToElement(ele).clickAndHold(ele).build().perform();
		}

}
