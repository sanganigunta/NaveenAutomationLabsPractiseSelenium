package naveenAutomationLabsSeleniumConcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		driver.manage().window().maximize();
//		WebElement drpEle = driver.findElement(By.id("Form_submitForm_Country"));
//		Select select = new Select(drpEle);
//		Thread.sleep(3000);
//		select.selectByIndex(6);
//		select.selectByValue("Bhutan");
//		select.selectByVisibleText("Comoros");
//		select.selectByVisibleText("India");
		
		By drplocator = By.id("Form_submitForm_Country");
//		ElementUtil eUtil = new ElementUtil(driver);
//		//eUtil.useSelectByIndex(drplocator,10);
//		//Ireland
//		eUtil.useSelectByVisiableValue(drplocator,"Ireland");
//		//eUtil.useDrpSelectByValue(drplocator,"India");
		
		ElementUtil eUtil = new ElementUtil(driver);
		List<String> listDrpElements = eUtil.selectDrpElementsUsingOptionsList(drplocator);
		System.out.println(listDrpElements);
		eUtil.selectDrpElementsUsingOptions(drplocator,"Macedonia");
		
		
		
	}
	
	
}
