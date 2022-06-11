package toolTips;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Seleniumpractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://seleniumpractise.blogspot.com/2019/09/bootstrap-tooltip-in-selenium.html");
		WebElement tooltopele = driver.findElement(By.xpath("//a[@data-toggle='tooltip']"));
		Actions action = new Actions(driver);
		action.moveToElement(tooltopele).perform();
		String text = driver.findElement(By.xpath("//a[@data-original-title='Hooray!']")).getAttribute("data-original-title");
		System.out.println(text);
		if(text.contains("Hooray!"))
		{
			System.out.println("Captured tool tip text");
		}
		else
		{
			System.out.println("not captured tool tip text");
		}
		

	}

}
