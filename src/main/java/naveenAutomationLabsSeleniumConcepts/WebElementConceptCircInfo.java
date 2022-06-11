package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementConceptCircInfo {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/indian-premier-league-2022-1298423/royal-challengers-bangalore-vs-rajasthan-royals-39th-match-1304085/full-scorecard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		
		String name="Trent Boult";
//		WebElement wicketKeeperName =driver.findElement(By.xpath("//span[text()='"+name+"']/parent::span/parent::a/parent::span/parent::td/following-sibling::td/span/span"));
//
//		action.moveToElement(wicketKeeperName).perform();
//		String nameText = wicketKeeperName.getText();
//		System.out.println(nameText);
//		
//		
//		List<WebElement> score =driver.findElements(By.xpath("//span[text()='"+name+"']/parent::span/parent::a/parent::span/parent::td/following-sibling::td[contains(@class,'ds-text-right')]"));
//		
//		for(WebElement e:score)
//		{
//			System.out.println(e.getText().trim());
//		}
		
		getPlayerDetails(name);
		

	}
	
	public static void getPlayerDetails(String nameVal)
	{
		System.out.println("Player name is "+nameVal);
		List<WebElement> eles =	driver.findElements(By.xpath("//span[text()='"+nameVal+"']/parent::span/parent::a/parent::span/parent::td/following-sibling::td"));
		
		for(WebElement e: eles)
		{
			System.out.println(e.getText().trim());
		}
	}
	

}
