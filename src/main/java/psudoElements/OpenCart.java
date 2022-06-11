package psudoElements;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {

	static JavascriptExecutor js;
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		
		js = (JavascriptExecutor)driver;
		
		String value="input-lastname";
		
		getMandatoryValue(value);
	}
	
	public static void getMandatoryValue(String value)
	{
      String mandatoryVal =js.executeScript("return window.getComputedStyle(document.querySelector(\"label[for='"+value+"']\"),'::before').getPropertyValue('content')").toString();
		
		System.out.println(mandatoryVal);
	}

}
