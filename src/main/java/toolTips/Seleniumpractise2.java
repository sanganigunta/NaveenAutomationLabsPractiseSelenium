package toolTips;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Seleniumpractise2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://seleniumpractise.blogspot.com/2019/08/tooltip-in-selenium-or-help-text-example.html");
		WebElement tooltip = driver.findElement(By.xpath("//div[@class='tooltip']"));
		Actions act = new Actions(driver);
		act.moveToElement(tooltip).perform();
		String tooltiptext = driver.findElement(By.xpath("//span[@class='tooltiptext']")).getText().trim();
		System.out.println(tooltiptext);
		if(tooltiptext.equalsIgnoreCase("Tooltip text"))
		{
			System.out.println("tool tip text is captured");
		}
		else
		{
			System.out.println("tool tip text is not captured");

		}


	}

}
