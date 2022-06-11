package relativeLocators;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		WebElement radio = driver.findElement(By.xpath("//label[normalize-space()='Yes']"));
		radio.click();
		System.out.println(radio.getText());
		driver.findElement(with(By.tagName("label")).toRightOf(radio)).click();
		//driver.findElement(with(By.tagName("label")).toLeftOf(radio)).click();
		



		WebElement pp = driver.findElement(By.xpath("//b[text()='Privacy Policy']"));
		driver.findElement(with(By.name("agree")).toRightOf(pp)).click();
		
		driver.findElement(with(By.cssSelector("input[value='Continue']")).toRightOf(pp)).click();
		
	}

}
