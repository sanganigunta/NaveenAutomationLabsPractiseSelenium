package calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	driver.get("https://jqueryui.com/datepicker/");
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");

		//driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

		driver.findElement(By.cssSelector("#datepicker")).click();
		String expectedDate = "25";

		String expectedMonthVal = "December";
		
	//	selectFutureDate(expectedMonthVal,expectedDate);
		selectpreviousDate(expectedMonthVal,expectedDate);
	   	
		

	}

	public static void selectDay(String expectedDay) {
		List<WebElement> dateElement = driver.findElements(By.xpath("//td[@data-handler='selectDay']/a"));
		int maxDateVal = dateElement.size();
		if (Integer.parseInt(expectedDay) > maxDateVal) {
			System.out.println("Please pass the correct date/Day value for the given month " + expectedDay);
		} else {
			for (WebElement e : dateElement) {
				if ((e.getText().equals(expectedDay))) {
					e.click();
					break;
				}
			}
		}
	}
	
	
	public static void selectFutureDate(String expectedMonth, String ExpectedDayValue)

	{
		String currentMonth_Year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().trim();
	    while (!currentMonth_Year.contains(expectedMonth)) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			currentMonth_Year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().trim();
		}

	    selectDay(ExpectedDayValue);
	}
	
	public static void selectpreviousDate(String expectedMonth, String ExpectedDayValue)

	{
		String currentMonth_Year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().trim();
	    while (!currentMonth_Year.contains(expectedMonth)) {
			driver.findElement(By.xpath("//span[text()='Prev']")).click();
			currentMonth_Year = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().trim();
		}

	    selectDay(ExpectedDayValue);
	}
}
