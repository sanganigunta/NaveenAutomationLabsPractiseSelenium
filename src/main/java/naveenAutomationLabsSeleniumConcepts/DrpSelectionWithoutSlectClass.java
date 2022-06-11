package naveenAutomationLabsSeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DrpSelectionWithoutSlectClass {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		driver.manage().window().maximize();
		
		By drpEle = By.xpath("//div[@class='middleColumn']/select/option");
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.selectDrpElementsWithoutUsingSelect(drpEle,"United Arab Emirates");
		
	}
	
	
}
