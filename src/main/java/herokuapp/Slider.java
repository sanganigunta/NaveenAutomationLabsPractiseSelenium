package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	static WebDriver driver;
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/horizontal_slider");
		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		System.out.println(slider.getLocation());
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 30, 0).perform();
		System.out.println(slider.getLocation());
		action.dragAndDropBy(slider, -20, 0).perform();
		

	}

}
