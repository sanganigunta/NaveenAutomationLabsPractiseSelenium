package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketAssignment {

	static WebDriver driver;
	static Actions action;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		action = new Actions(driver);
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		By L1Value = By.xpath("//a[@qa='categoryDD']");
		WebElement L1Element = driver.findElement(L1Value);
        Actions action = new Actions(driver);
        action.moveToElement(L1Element).perform();
//		
//        List<WebElement> l1List = driver.findElements(By.xpath("(//li[@class='dropdown full-wid hvr-drop']//ul)[2]//li/a"));
//        for(WebElement e: l1List)
//        {
//        	String l1Text = e.getText().trim();
//        	if(l1Text.contains("Bakery, Cakes & Dairy"))
//        	{
//        		action.moveToElement(e).perform();
//        		break;
//        	}
//        }
//        
//		By L2category = By.xpath("//div[@class='mm-content']//ul/li/a[@qa='catL2']");
//		List<WebElement> L2CatEle = driver.findElements(L2category);
//		for (WebElement e : L2CatEle) {
//			String l2Text = e.getText().trim();
//			if (!l2Text.isEmpty()) {
//				System.out.println(l2Text);
//				if (l2Text.contains("Dairy")) {
//					action.moveToElement(e).perform();
//					break;
//				}
//
//			}
//		}
//		
//		//l3  //div[@class='box']//ul/li/a[@qa='catL3']
//		
//		By L3category = By.xpath("//div[@class='box']//ul/li/a[@qa='catL3']");
//		List<WebElement> L3CatEle = driver.findElements(L3category);
//		for (WebElement e : L3CatEle) {
//			String l3Text = e.getText().trim();
//			if (!l3Text.isEmpty()) {
//				System.out.println(l3Text);
//				if(l3Text.contains("Milk"))
//				{
//					action.moveToElement(e).perform();
//					break;
//				}
//			}
//		}
//		
//		
//		//(//div[@class='box'])[4]//li/a
//		
//
//		By L4category = By.xpath("(//div[@class='box'])[4]//li/a");
//		List<WebElement> L4CatEle = driver.findElements(L4category);
//		for (WebElement e : L4CatEle) {
//			String l4Text = e.getText().trim();
//			if (!l4Text.isEmpty()) {
//				System.out.println(l4Text);
//				if(l4Text.contains("Butter"))
//				{
//					action.moveToElement(e).click().build().perform();
//					break;
//				}
//			}
//		}
        
        
        
        By l1Category = By.xpath("(//li[@class='dropdown full-wid hvr-drop']//ul)[2]//li/a");
		String l1text = "Bakery, Cakes & Dairy";
		categoryLinks(l1Category,l1text);
		
		By l2Category = By.xpath("//div[@class='mm-content']//ul/li/a[@qa='catL2']");
		String l2Text = "Cakes & Pastries";
		categoryLinks(l2Category,l2Text);
		
		By l3Category = By.xpath("//div[@class='box']//ul/li/a[@qa='catL3']");
		String l3Text ="DOUGHNUTS & MOUSSES";
		categoryLinks(l3Category,l3Text);
		
		By L4Category = By.xpath("(//div[@class='box'])[4]//li/a");
		String l4Text ="Bread";
		categoryLinks(L4Category,l4Text);
		
	}
	
	public static void categoryLinks(By locator, String categoryVal)
	{
		List<WebElement> L4CatEle = driver.findElements(locator);
		for (WebElement e : L4CatEle) {
			String l4Text = e.getText().trim();
			if (!l4Text.isEmpty()) {
				System.out.println(l4Text);
				if(l4Text.contains(categoryVal))
				{
					action.moveToElement(e).perform();
					break;
				}
			}
		}
		
	}

}
