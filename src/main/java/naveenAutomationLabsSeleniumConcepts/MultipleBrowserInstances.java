package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleBrowserInstances {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver1 = new ChromeDriver();
//		driver = new ChromeDriver();
//		driver = new ChromeDriver();
		driver1.get("https://www.google.com/");
		
		WebDriver driver2 = new ChromeDriver();
		driver2.get("https://www.amazon.com/");
		
		WebDriver driver3 = new ChromeDriver();
		driver3.get("https://www.flipkart.com/");

	}

}
