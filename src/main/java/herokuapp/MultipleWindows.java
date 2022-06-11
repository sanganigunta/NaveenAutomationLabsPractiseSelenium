package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/windows");
		String parentwindowtxt = driver.findElement(By.tagName("h3")).getText();
		System.out.println(parentwindowtxt);
		driver.findElement(By.xpath("//a[contains(@href,'windows/new')]")).click();
		String childwindowid =driver.getWindowHandle();
		System.out.println("Child window id is "+childwindowid);
		//driver.switchTo().window(childwindowid);
		String childwindowtxt = driver.findElement(By.tagName("h3")).getText();
		System.out.println(childwindowtxt);
		
		
	}

}
