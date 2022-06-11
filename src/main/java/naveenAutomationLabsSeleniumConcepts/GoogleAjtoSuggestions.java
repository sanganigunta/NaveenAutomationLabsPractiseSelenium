package naveenAutomationLabsSeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAjtoSuggestions {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("naveen Automation labs");
		Thread.sleep(3000);
		List<WebElement> suggestionsList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[contains(@class,'wM6W7d')]/span"));
		
//		for(WebElement e: suggestionsList)
//		{
//			String sugesstionsText = e.getText().trim();
//			System.out.println(sugesstionsText);
//			if(sugesstionsText.contains("naveen automationlabs github"))
//			{
//				e.click();
//				break;
//			}
//		}
		
		//driver.findElement(By.xpath("//div[contains(@class,'wM6W7d')]//span[text()='naveen ']/b[text()='automationlabs']//following::b[text()=' github']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'wM6W7d')]//span[text()='naveen automation labs']/b[contains(text(),'selenium')]")).click();
		
		
		

	}

}
