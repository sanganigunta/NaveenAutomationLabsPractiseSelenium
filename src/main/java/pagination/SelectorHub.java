package pagination;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectorHub {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,3200)");
		
//		String text =driver.findElement(By.xpath("//td[text()='Ranchi']")).getText();
//
//		System.out.println(text);
//		selectCity("Visakhapatnam");
		
		String cityName="Divya";
		
		while(true)
		{
			if(driver.findElements(By.xpath("//td[text()='"+cityName+"']")).size()>0) {
				selectCity(cityName);
				break;
			}
			
			else
			{
			 WebElement next =driver.findElement(By.linkText("Next"));
			 if(next.getAttribute("class").contains("disabled"))
			 {
				 System.out.println("No city is avaialbe with the in the table with the provided city name "+cityName);
				 break;
			 }
					 next.click();	
			}
		}
	}
	
	public static void selectCity(String cityName)
	{
		driver.findElement(By.xpath("//td[text()='"+cityName+"']//preceding-sibling::td/input[@type='checkbox']")).click();
	}

}
