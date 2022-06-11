package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementConcept {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		By headers = By.xpath("//div[@id='header-navbar']//li[@class='main-list']//a[@class='link']");
//		List<WebElement> headerEle = driver.findElements(headers);
//		for(WebElement e: headerEle)
//		{
//			Actions action = new Actions(driver);
//			action.moveToElement(e).perform();
//			
//		}
		
		
		
//		By resouces = By.xpath("//div[@id='header-navbar']//li[@class='main-list']//a[contains(text(),'Resources')]");
//		WebElement resourcesEle = driver.findElement(resouces);
//		Actions action = new Actions(driver);
//		action.moveToElement(resourcesEle).perform();
//		
//		By subheaders = By.xpath("//div[@class='sub-menu']//div[1]//p/a");
//		List<WebElement> subheaderEle = driver.findElements(subheaders);
//		for(WebElement e:subheaderEle)
//		{
//			if(!(e.getText().isEmpty())){
//				String subElementsText = e.getText();
//			System.out.println(subElementsText);
//			if(subElementsText.contains("can an HRIS help retain the best talent?"))
//			{
//				e.click();
//				break;
//			}
//			}
//		}
//
		
		String headerVal ="Company";
		By L1Header = By.xpath("//div[@id='header-navbar']//li[@class='main-list']//a[contains(text(),'"+headerVal+"')]");
		GoToL1Category(L1Header);
		By subElement =By.xpath("//div[@class='sub-menu']//div[1]//p/a");
		getSubListValues(subElement,"News Articles");
		
		
	}

		
	public static void GoToL1Category(By locator)
	{
		
		WebElement LiElement = driver.findElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(LiElement).perform();
	}
	
	public static void getSubListValues(By locator, String subElementVal)
	{ List<WebElement> subELements = driver.findElements(locator);
		for(WebElement e:subELements)
			{
				if(!(e.getText().isEmpty())){
				String subElementsText = e.getText();
				System.out.println(subElementsText);
				if(subElementsText.contains(subElementVal))
				{
					e.click();
					break;
				}
				}
			}
	}
}
