package naveenAutomationLabsSeleniumConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextConcept {

	static WebDriver driver;
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/hris-hr-software-demo/");
		driver.manage().window().maximize();
//		String placeholderVal = driver.findElement(By.cssSelector("#Form_submitForm_FirstName")).getAttribute("placeholder");
//		System.out.println(placeholderVal);
//		 By placeholderVal = By.cssSelector("#Form_submitForm_FirstName");
//		 String text = getAttributeValuefrominputField(placeholderVal,"placeholder");
//		 System.out.println(text);
//		 doSendKeys(placeholderVal,"Divya S");
//		 String textVal = getAttributeValuefrominputField(placeholderVal,"value");
//		 System.out.println(textVal);
		
		By placeholderVal = By.cssSelector("#Form_submitForm_FirstName");

		ElementUtil eUtil = new ElementUtil(driver);
//		String text = eUtil.getAttributeValuefrominputField(placeholderVal, "placeholder");
//		System.out.println(text);
//		eUtil.dosendKeys(placeholderVal, "divya s");
//		String textVal = eUtil.getAttributeValuefrominputField(placeholderVal, "value");
//		System.out.println(textVal);
		boolean val = eUtil.isDisplayed(placeholderVal);
		System.out.println(val);
		
		}
	
//	public static boolean isDisplayed(By locator)
//	{
//		return getElement(locator).isDisplayed();
//	}
//	
//	public static WebElement getElement(By locator)
//	{
//		return driver.findElement(locator);
//		
//	}
//	
//	public static void doSendKeys(By locator, String locatorValue)
//	{
//		getElement(locator).sendKeys(locatorValue);
//	}
//	
//	public static String getAttributeValuefrominputField(By locator, String attributeVal)
//	{
//		return getElement(locator).getAttribute(attributeVal);
//	}
	}


