package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyPress {
	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/key_presses?");
		WebElement inputbox = driver.findElement(By.xpath("//input[@id='target']"));
				             inputbox.sendKeys(Keys.F5);
		String enteredKettxt = driver.findElement(By.xpath("//p[@id='result']")).getText();
		System.out.println(enteredKettxt);

	}

}
