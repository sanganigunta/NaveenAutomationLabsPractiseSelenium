package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
	
		 BrowserUtil br = new BrowserUtil();
		 driver = br.initializeBrowser("firefox");
				 
		 br.navigateToUrl("https://opensource-demo.orangehrmlive.com/index.php/");
		 System.out.println(br.getTitle());
		 System.out.println(br.getCurrentUrl());
		 
		 ElementUtil eu = new ElementUtil(driver);
		 String emailId = "txtUsername";
		 String password ="txtPassword";
		 eu.dosendKeys(eu.useStringRepo("id", emailId), "Divya");
		 eu.dosendKeys(eu.useStringRepo("id", password), "Divya@1234");
		

	}

}
