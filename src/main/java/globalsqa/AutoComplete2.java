package globalsqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoComplete2 {

	static WebDriver driver;
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/auto-complete/#Categories");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");
		
		driver.findElement(By.id("ComboBox")).click();
		
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded' and contains(@data-src,'combobox')]"));
		
		driver.switchTo().frame(iframe);
		
		//driver.findElement(null)

		
		
		//ComboBox
	}

}
