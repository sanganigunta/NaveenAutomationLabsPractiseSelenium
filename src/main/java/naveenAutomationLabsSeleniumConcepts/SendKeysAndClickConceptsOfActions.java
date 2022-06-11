package naveenAutomationLabsSeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysAndClickConceptsOfActions {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://jqueryui.com/droppable/");
		//driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("email")).sendKeys("trest");
		driver.findElement(By.id("passwd")).sendKeys("test");
		driver.findElement(By.id("passwd")).submit();
//		WebElement fName = driver.findElement(By.cssSelector("#Form_submitForm_FirstName"));
//		WebElement lName = driver.findElement(By.cssSelector("#Form_submitForm_LastName"));
//		fName.sendKeys("test");
//		lName.sendKeys("Divya");
//		lName.submit();
		
//		Actions action = new Actions(driver);
//		action.sendKeys(fName,"Divya Sanganigunta").perform();
//		action.sendKeys(lName, "Krushna").perform();
//		
//		action.click(driver.findElement(By.id("Form_submitForm_action_request"))).perform();
//		action.click(driver.findElement(By.xpath("(//a[contains(text(),'OrangeHRM')])[9]"))).perform();
//		action.doubleClick();
//		action.doubleClick(lName);
//		action.pause(1000);
//
	}

}
