package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	
	
    static WebDriver driver;
	public static void main(String[] args) {
		LunchMakeMyTrip();
		selectTrip("Round Trip");

	}
	
	public static void LunchMakeMyTrip()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
	}

	
	public static void selectTrip(String trpval)
	{
		List<WebElement> trips =driver.findElements(By.cssSelector("li>span.tabsCircle.appendRight5"));
		for(WebElement trip: trips)
		{
			String triptext = trip.getText();
			System.out.println(triptext);
		}
	}
}
