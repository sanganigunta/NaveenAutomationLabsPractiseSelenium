package svgConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {

	static WebDriver driver;
	static Actions action;
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//div[@class='_2QfC02']/button")).click();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("tshirt");
		WebElement searchIcon =driver.findElement(By.xpath("//*[local-name()='svg']//*[name()='g' and @fill-rule='evenodd']"));
		action = new Actions(driver);
		Thread.sleep(1000);
		action.click(searchIcon).perform();
	}

}
