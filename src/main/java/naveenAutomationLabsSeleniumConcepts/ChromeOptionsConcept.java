package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		//option.setHeadless(true);
		//option.addArguments("--headless");
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
        driver.get("https://www.flipkart.com/");
        System.out.println(driver.getTitle());
		
	}

}
