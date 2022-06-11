package naveenAutomationLabsSeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCartSuggestionsSection {

	
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/index.php?route=account/login");
			ElementUtil eUtil = new ElementUtil(driver);
			By links = By.xpath("//aside[@id='column-right']//a");
			eUtil.printAllsugesstionsText(links);
			List<String> linksList = eUtil.printGetTextAsListValue(links);
			System.out.println(linksList);
			eUtil.selectSuggestionsfromSection(links,"Register");

	}

}
