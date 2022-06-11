package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OrangehrmReg {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		//driver.get("https://www.orangehrm.com/contact-sales/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// fillRegUsingBy();
		// fillRegUsingStringLocatorRepo();

		//contactformBy();
		//contactformusingString();
		//noOfEmployee();
		
		countryDrpElement();
	}
	
	public static void countryDrpElement()
	{
		WebElement drpEle = driver.findElement(By.id("Form_submitForm_Country"));
		Select countryDrp = new Select(drpEle);
		List<WebElement> countries = countryDrp.getOptions();
		for(WebElement country:countries )
		{
			String countryVal = country.getText().trim();
			if(countryVal.contains("St Pierre and Miquelon"))
			{
				country.click();
				break;
			}
		}
	}
	
	public static void noOfEmployee()
	{
		WebElement drpEle = driver.findElement(By.id("Form_submitForm_NoOfEmployees"));
		Select drpVal = new Select(drpEle);
		drpVal.selectByVisibleText("16 - 20");
	}

	public static void contactformusingString() {
		
		String fullname= "input#Form_submitForm_FullName";
		String companyName="CompanyName";
		String jobTitle="//input[@name='JobTitle']";
		String phoneNumber="Form_submitForm_Contact";
		String email="//input[@type='email']";
		String comment="Comment";
		
		ElementUtil eutil = new ElementUtil(driver);
		eutil.dosendKeys(eutil.useStringRepo("cssselector", fullname), "Divya san");
		eutil.dosendKeys(eutil.useStringRepo("name", companyName), "wipro");
		eutil.dosendKeys(eutil.useStringRepo("xpath", jobTitle), "software");
		eutil.dosendKeys(eutil.useStringRepo("id", phoneNumber), "1234567890");
		eutil.dosendKeys(eutil.useStringRepo("xpath", email), "Divya.san@gmail.com");
		eutil.dosendKeys(eutil.useStringRepo("name", comment), "Divya.san@gmail.com sis working with wipro");
	}

	public static void contactformBy() {
		By fullname = By.cssSelector("input#Form_submitForm_FullName");
		By companyName = By.name("CompanyName");
		By jobTitle = By.xpath("//input[@name='JobTitle']");
		By phoneNumber = By.id("Form_submitForm_Contact");
		By email = By.xpath("//input[@type='email']");
		By comment = By.name("Comment");
		ElementUtil eutil = new ElementUtil(driver);
		eutil.dosendKeys(fullname, "Divya san");
		eutil.dosendKeys(companyName, "wipro");
		eutil.dosendKeys(jobTitle, "software");
		eutil.dosendKeys(phoneNumber, "1234567890");
		eutil.dosendKeys(email, "Divya.san@gmail.com");
		eutil.dosendKeys(comment, "Divya.san@gmail.com sis working with wipro");

	}

	public static void fillRegUsingStringLocatorRepo() {
		String fname = "Form_submitForm_FirstName";
		String lname = "LastName";
		String email = "//input[@type='email']";
		String phNum = "input#Form_submitForm_Contact";
		ElementUtil eutil = new ElementUtil(driver);
		eutil.dosendKeys(eutil.useStringRepo("id", fname), "Divya");
		eutil.dosendKeys(eutil.useStringRepo("name", lname), "Divya San");
		eutil.dosendKeys(eutil.useStringRepo("xpath", email), "Divya.san@gmail.com");
		eutil.dosendKeys(eutil.useStringRepo("cssselector", phNum), "9876543210");

	}

	public static void fillRegUsingBy() {
		By fname = By.id("Form_submitForm_FirstName");
		By lname = By.name("LastName");
		By emial = By.xpath("//input[@type='email']");
		By phNum = By.cssSelector("input#Form_submitForm_Contact");
		By contact = By.linkText("Contact Sales");
		// By bookBtn = By.id("Form_submitForm_action_request");

		ElementUtil eutil = new ElementUtil(driver);
		eutil.dosendKeys(fname, "Divya");
		eutil.dosendKeys(lname, "San");
		eutil.dosendKeys(emial, "divya1.sanganigunta@gmail.com");
		eutil.dosendKeys(phNum, "987654123");

		// eutil.doClick(bookBtn);

	}

}
