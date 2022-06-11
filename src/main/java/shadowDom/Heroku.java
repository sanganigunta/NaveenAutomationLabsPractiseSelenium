package shadowDom;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Heroku {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, IOException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/shadowdom");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement test =(WebElement) js.executeScript("return document.querySelector(\"#content > my-paragraph:nth-child(4)\")");
		String textValue =test.getText();
		System.out.println(textValue);
		
		WebElement second =(WebElement)js.executeScript("return document.querySelector(\"#content > my-paragraph:nth-child(5) > ul\")");

		System.out.println(second.getText());
	}

}
