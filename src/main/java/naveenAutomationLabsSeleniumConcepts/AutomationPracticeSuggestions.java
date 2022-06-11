package naveenAutomationLabsSeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationPracticeSuggestions {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		Thread.sleep(10000);
		//List<WebElement> suggestionsList = driver.findElements(By.xpath("//div[@class='ac_results']//li"));
//		for(WebElement e: suggestionsList)
//		{
//			String sugesstionsListText = e.getText();
//			System.out.println(sugesstionsListText);
//			if(sugesstionsListText.contains("T-shirts > Faded Short Sleeve T-shirts"))
//			{
//				e.click();
//				break;
//			}
//		}
		
		WebElement suggestion = driver.findElement(By.xpath("//div[@class='ac_results']//li[@class='ac_even' and contains(text(),'Casual Dresses > Printed ')]"));
		System.out.println(suggestion.getText());
		suggestion.click();

	}

}
