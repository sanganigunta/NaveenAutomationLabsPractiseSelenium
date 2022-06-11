package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenCartRegistration {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
		//useDoSendKeys();
		useStringrepo();

	}
	
	public static void useStringrepo()
	{
		String fname = "input-firstname";
		String lname = "lastname";
		String email = "//input[@type='email']";
		String phnumber = "input#input-telephone";
		String password = "password";
		String confirmpwd = "input#input-confirm";
		String checkBox = "agree";
		String continueBtn = "//input[@value='Continue']";
		ElementUtil eutil = new ElementUtil(driver);
		eutil.dosendKeys(eutil.useStringRepo("id", fname),"Divya");
		eutil.dosendKeys(eutil.useStringRepo("name", lname),"San");
		eutil.dosendKeys(eutil.useStringRepo("xpath", email),"Divya1.san@gmail.com");
		eutil.dosendKeys(eutil.useStringRepo("cssselector", phnumber),"1234567890");
		eutil.dosendKeys(eutil.useStringRepo("name", password),"Divya@1234");
		eutil.dosendKeys(eutil.useStringRepo("cssselector", confirmpwd),"Divya@1234");
		eutil.doClick(eutil.useStringRepo("name", checkBox));
		eutil.doClick(eutil.useStringRepo("xpath", continueBtn));
		
	}
	

	
	public static void useDoSendKeys()
	{
		ElementUtil eutil = new ElementUtil(driver);
		By fname = By.id("input-firstname");
		By lname = By.name("lastname");
		By email = By.xpath("//input[@type='email']");
		By phnumber = By.cssSelector("input#input-telephone");
		By password = By.name("password");
		By confirmpwd = By.cssSelector("input#input-confirm");
		By checkBox = By.name("agree");
		By continueBtn = By.xpath("//input[@value='Continue']");
		eutil.dosendKeys(fname, "Divya");
		eutil.dosendKeys(lname, "San");
		eutil.dosendKeys(email, "San.divya1@gmail.com");
		eutil.dosendKeys(phnumber, "1234567890");
		eutil.dosendKeys(password, "Divya@12345");
		eutil.dosendKeys(confirmpwd, "Divya@12345");
		eutil.doClick(checkBox);
		eutil.doClick(continueBtn);
	}
}
