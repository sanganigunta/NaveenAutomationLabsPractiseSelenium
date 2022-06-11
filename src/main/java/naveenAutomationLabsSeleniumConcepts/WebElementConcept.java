package naveenAutomationLabsSeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// WebElement+action(click,sendkeys, gettext())
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/");
//		1. approch
//		driver.findElement(By.id("txtUsername")).sendKeys("Divya");
//		driver.findElement(By.id("txtPassword")).sendKeys("Sanganigunta");

//		2.approch by creating the webelement
//		WebElement userName = driver.findElement(By.id("txtUsername"));
//		userName.sendKeys("Divya");
//		WebElement password = driver.findElement(By.id("txtPassword"));
//		password.sendKeys("Sanganigunta");

//		3.approch using By locator

//		By uName = By.id("txtUsername");
//		By password = By.id("txtPassword");
//		
//		WebElement userN = driver.findElement(uName);
//		userN.sendKeys("Divya");
//		WebElement passwrd = driver.findElement(password);
//		passwrd.sendKeys("Divya@1234");
		
//		4. approch 4 crating a generic method using By locator
//
//		By emialid = By.id("txtUsername");
//		By password = By.id("txtPassword");
//		getLocator(emialid).sendKeys("Divya");
//		getLocator(password).sendKeys("Divya@1234");
		
		//5. approch using generic sendkeys method
//		
//		By emialid = By.id("txtUsername");
//		By password = By.id("txtPassword");
//		dosendKeys(emialid,"Divya");
//		dosendKeys(password,"DIvya@1234");
		
		//6. using String repository 
		
//		String emailId = "txtUsername";
//		String password = "txtPassword";
//		dosendKeys(useStringRepo("id", emailId),"Divya");
//		dosendKeys(useStringRepo("id", password), "Divya@1234");
		
		//7. Using elementUtil generic class
		
//		ElementUtil eUtil = new ElementUtil(driver);
//		By emialid = By.id("txtUsername");
//		By password = By.id("txtPassword");
//		
//		eUtil.dosendKeys(emialid, "Divya");
//		eUtil.dosendKeys(password, "Divya@1234");
		
		ElementUtil eUtil = new ElementUtil(driver);
		String emailid = "txtUsername";
		String password="txtPassword";
//		
//		eUtil.dosendKeys(eUtil.useStringRepo("id", emailid), "Divya");
//		eUtil.dosendKeys(eUtil.useStringRepo("id", password), "Divya@1234");
		
	}

	
}
