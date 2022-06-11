package naveenAutomationLabsSeleniumConcepts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		driver.manage().window().maximize();

		By name = By.id("Form_submitForm_Name");
		By email = By.id("Form_submitForm_Email");
		By contact = By.id("Form_submitForm_Contact");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement fullName = wait.until(ExpectedConditions.presenceOfElementLocated(name));
//
//		fullName.sendKeys("Divya Sanganigunta");
//		driver.findElement(email).sendKeys("Divya1234@gmail.com");
//		driver.findElement(contact).sendKeys("99999999");

//		WebElement fullName = wait.until(ExpectedConditions.visibilityOfElementLocated(name));
//		
//		fullName.sendKeys("Divya Sanganigunta");
//		driver.findElement(email).sendKeys("Divya1234@gmail.com");
//		driver.findElement(contact).sendKeys("99999999");

//		driver.findElement(By.linkText("CONTACT SALES")).click();
//		
//		wait.until((ExpectedConditions.titleContains("contact"));
//		
//		WebElement fullName = getWebElementOfExplictWait(name, 5);
//		fullName.sendKeys("Divya Sanganigunta");
//		driver.findElement(email).sendKeys("Divya1234@gmail.com");
//		driver.findElement(contact).sendKeys("99999999");

//		driver.findElement(By.linkText("CONTACT SALES")).click();
//		
//		 wait.until(ExpectedConditions.titleContains("Contact"));
//		 String title = driver.getTitle();
//		System.out.println(title);
//		
//		driver.findElement(By.linkText("BOOK A FREE DEMO")).click();
//		 wait.until(ExpectedConditions.titleContains("Sign Up"));
//		 String title1 = driver.getTitle();
//		System.out.println(title1);

//		driver.findElement(By.linkText("CONTACT SALES")).click();
//		String title1 ="Contact OrangeHRM";
//		wait.until(ExpectedConditions.titleIs(title1));
//		System.out.println(driver.getTitle());
//		driver.findElement(By.linkText("BOOK A FREE DEMO")).click();
//		wait.until(ExpectedConditions.titleIs("Sign Up for a Free HR Software Demo | OrangeHRM"));
//		System.out.println(driver.getTitle());
//		
		By contackLink = By.linkText("CONTACT SALES");
		By BAFD = By.linkText("BOOK A FREE DEMO");

		driver.findElement(contackLink).click();
		String title = getTitleFractionByWait(contackLink, 10, "Contact");
		String url1 = getCurrentUrlFractionFromWait(contackLink,10,"contact-sales");
		System.out.println(title+":"+url1);
		driver.findElement(BAFD).click();
		String tile1 = getTitleUsingWait(BAFD, "Sign Up for a Free HR Software Demo | OrangeHRM", 5);
		String url2 =  getCurrentUrlFromWait(BAFD,5,"https://www.orangehrm.com/hris-hr-software-demo/");
		System.out.println(tile1+" "+url2);

		
	

	}

	public static WebElement getWebElementOfExplictWait(By locator, int timeOutVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutVal));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public static String getTitleFractionByWait(By locator, int timeOut, String titleVal) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleContains(titleVal)))
			return driver.getTitle();
		return null;
	}

	public static String getTitleUsingWait(By locator, String TitleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(TitleVal)))
			return driver.getTitle();

		return null;
	}
	
	public static String getCurrentUrlFractionFromWait(By locator, int timeOut, String urlVal)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlContains(urlVal)))
			return driver.getCurrentUrl();
		return null;
	}
	
	public static String getCurrentUrlFromWait(By locator, int timeOut, String urlVal)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if(wait.until(ExpectedConditions.urlToBe(urlVal)))
			return driver.getCurrentUrl();
		return null;
	}

}
