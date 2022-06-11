package bigbasket;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextOfAllCategories {

	static WebDriver driver;
	static Actions action ;
	public static void main(String[] args) throws InterruptedException {
		
	 WebDriverManager.chromedriver().setup();	
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("https://www.bigbasket.com/");
     
     action = new Actions(driver);
     MoveToCategoryLinks("Bakery, Cakes & Dairy","Cookies, Rusk & Khari","Bakery Biscuits, Cookies","Khari");
     
	}
	
	public static void MoveToCategoryLinks(String l1, String l2, String l3, String l4)
	{
		action.moveToElement(driver.findElement(By.xpath("//li[@class='dropdown full-wid hvr-drop']"))).perform();
	     
	     WebElement l1Link = driver.findElement(By.linkText(l1));
	     action.moveToElement(l1Link).perform();
	     
	     WebElement l2Link = driver.findElement(By.linkText(l2));
	     action.moveToElement(l2Link).perform();
	     
	     WebElement l3Link = driver.findElement(By.linkText(l3));
	     action.moveToElement(l3Link).perform();
	     
	     WebElement l4Link =driver.findElement(By.linkText(l4));
	     action.moveToElement(l4Link).click(l4Link).build().perform();
	}

}
