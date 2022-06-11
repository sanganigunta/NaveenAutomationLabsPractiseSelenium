package herokuapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redirect {
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/redirector");
		
		driver.findElement(By.xpath("//a[@id='redirect']")).click();
		List<WebElement> statuscodes =driver.findElements(By.xpath("//div[@class='example']//li//a"));
		for(WebElement statuscode:statuscodes)
		{
			System.out.println(statuscode.getText());
		}
		
		driver.navigate().back();
		driver.navigate().refresh();
		driver.navigate().forward();
		
	}

}
