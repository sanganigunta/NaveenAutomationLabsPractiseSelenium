package relativeLocators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WhenWise {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://whenwise.com/sign-in");
		
		driver.findElement(By.id("email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Test@12345");
		driver.findElement(By.id("login-btn")).click();
		driver.findElement(By.cssSelector("span.avatar-status>img")).click();
		driver.findElement(By.linkText("Edit Profile")).click();
		
		WebElement emailConfirm = driver.findElement(By.xpath("//span[text()='Email on booking confirmation?']"));
		WebElement smsConfirm = driver.findElement(By.xpath("//span[text()='Accept SMS appointment reminder?']"));
		
		driver.findElement(with(By.className("lever")).toRightOf(emailConfirm)).click();
		driver.findElement(with(By.className("lever")).toRightOf(smsConfirm)).click();
		

	}
	
}
