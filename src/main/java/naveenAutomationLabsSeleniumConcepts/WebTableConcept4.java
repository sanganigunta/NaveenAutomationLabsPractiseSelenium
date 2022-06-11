package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept4 {


	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		String name="Amazon";
		
		List<WebElement> eles = driver.findElements(By.xpath("//td[text()='"+name+"']/parent::tr/td"));
		for(WebElement e:eles)
		{
			System.out.println(e.getText().trim());
		}
	}

}
