package calender;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		
		 WebElement DateValue=driver.findElement(By.xpath("//div[@class='sc-jJoQJp iPfLQ'] //span[text()='Departure']/parent::div/p"));
//		 String currentDate = currentDateElement.getText();
//         System.out.println(currentDate);
		  DateValue.click();
//		WebElement currentDate = driver.findElement(By.xpath("(//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption'])[last()]"));
//		String currentDateText = currentDate.getText();
//		System.out.println("Current moth and year is "+currentDateText);
//		
//		String expectedMonth="September 2022";
//		
//		while(!(currentDateText.contains(expectedMonth)))
//		{
//			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//			currentDate = driver.findElement(By.xpath("(//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption'])[last()]"));
//			currentDateText = currentDate.getText();
//		}
//       
		 
		 String expectedDay="30";
		 
		
		  
		String currentMonthYear=  driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
         System.out.println(currentMonthYear);
         
         String expectedMonth="September 2022";
 		
 		while(!(currentMonthYear.contains(expectedMonth)))
 		{
 			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
 			currentMonthYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption'])[last()]")).getText();
 			
 		}
 		 selectDateValue(expectedDay);
		  
	}

	public static void selectDateValue(String expectedDay)
	{
	
		driver.findElement(By.xpath("//p[text()='"+expectedDay+"']")).click();
		
	}
	
}
