package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Geolocation {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/geolocation");
		WebElement location = driver.findElement(By.xpath("//button[@onclick='getLocation()']"));
		System.out.println(location.getLocation());
		System.out.println(location.getRect().getHeight());
		System.out.println(location.getRect().getWidth());
		System.out.println(location.getRect().getDimension());
		
	}
}
