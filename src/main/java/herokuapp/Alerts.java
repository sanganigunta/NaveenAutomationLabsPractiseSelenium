package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//		simpleAlert();
//		alertsHandling();
		enterinputAlert();
	}
	
	public static void simpleAlert()
	{
		driver.findElement(By.cssSelector("button[onclick='jsAlert()']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		String alertsucessmesg = driver.findElement(By.cssSelector("p#result")).getText().trim();
		
		if(alertsucessmesg.equals("You successfully clicked an alert"))
		{
			System.out.println("Alret is handled sucessfully!!!!!!!!!!!");
		}
		else
		{
			System.out.println("Failed to handled alert");
		}
	}
	
	public static void alertsHandling()
	{
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		driver.switchTo().alert().accept();
		String alertacceptText = driver.findElement(By.cssSelector("p#result")).getText().trim();
		if(alertacceptText.equals("You clicked: Ok"))
		{
			System.out.println("Alert accepted");
		}
		else
		{
			System.out.println("dismissed the alert");
		}
		
		driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
		driver.switchTo().alert().dismiss();
		String alertcancelText = driver.findElement(By.cssSelector("p#result")).getText().trim();
		System.out.println(alertcancelText);
	}
	
	public static void enterinputAlert()
	{
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		 driver.switchTo().alert().sendKeys("test alert input");
		 driver.switchTo().alert().accept();
		
		
	
	}

}
