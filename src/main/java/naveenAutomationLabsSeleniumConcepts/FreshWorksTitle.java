package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreshWorksTitle {

	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		ElementUtil eutil = new ElementUtil(driver);
		By title = By.tagName("h1");
		String tileTxt  =eutil.performGetText(title);
		System.out.println(tileTxt);
		
		

	}

}
