package herokuapp;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	static WebDriver driver;
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/drag_and_drop");
		WebElement src = driver.findElement(By.cssSelector("div#column-a"));
		WebElement dest = driver.findElement(By.cssSelector("div#column-b"));
		
		Actions act = new Actions(driver);
	//	act.clickAndHold(src).moveToElement(dest).release().build().perform();
		
		act.dragAndDrop(src, dest);
	}

}
