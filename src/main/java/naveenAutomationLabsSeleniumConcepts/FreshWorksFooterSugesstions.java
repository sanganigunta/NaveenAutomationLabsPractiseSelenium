package naveenAutomationLabsSeleniumConcepts;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FreshWorksFooterSugesstions {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.freshworks.com/");
		
		Thread.sleep(3000);
		WebElement cookies =driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"));
		Boolean cookiesVal = cookies.isDisplayed();
		System.out.println(cookiesVal);
		if(cookiesVal)
		{
			cookies.click();
		}
		else {
			System.out.println("Cookes is not present");
		}
		Thread.sleep(10000);
		
		By foolterlink = By.xpath("//div[@class='footer-main']//div[contains(@class,'footer-left-section')]//li//a");
		
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.printAllsugesstionsText(foolterlink);
		List<String> elementsList = eUtil.printGetTextAsListValue(foolterlink);
		System.out.println(elementsList);
		eUtil.selectSuggestionsfromSection(foolterlink,"Customers");
	}

	
}
