package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLanch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys("DivyaS").sendKeys(Keys.TAB)
		.sendKeys("Divya@1234").sendKeys(Keys.TAB).build().perform();
		driver.quit();

	}

}
