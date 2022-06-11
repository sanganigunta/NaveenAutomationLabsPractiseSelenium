package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertConcept {

		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
		
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
//			driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
//			By signInBtn = By.name("proceed");
//			driver.findElement(signInBtn).click();
//			Thread.sleep(3000);
//			Alert alert = driver.switchTo().alert();
//			alert.accept();
			
			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			By alertBtn = By.id("alertbtn");
			By confirmBtn = By.id("confirmbtn");
			
			//driver.findElement(alertBtn).click();
			driver.findElement(confirmBtn).click();
			Alert alert = driver.switchTo().alert();
			//alert.sendKeys("this is my alert");
			String alertText = alert.getText();
			System.out.println(alertText);
			//alert.accept();
			alert.dismiss();
			
			
			
	}

}
