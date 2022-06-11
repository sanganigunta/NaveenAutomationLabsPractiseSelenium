package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept3 {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.espncricinfo.com/series/indian-premier-league-2022-1298423/royal-challengers-bangalore-vs-rajasthan-royals-39th-match-1304085/full-scorecard");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		String name="Wanindu Hasaranga de Silva";
		
		List<WebElement> table2 =driver.findElements(By.xpath("//span[text()='"+name+"']/../../../parent::tr[@class='ds-border-b ds-border-line ds-text-tight-s']/td"));
		
		for(WebElement e: table2)
		{
			System.out.println(e.getText().trim());
		}
	}

}
