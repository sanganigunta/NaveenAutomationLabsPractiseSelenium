package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {
	WebDriver driver;
	
	@BeforeTest()
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test()
	public void getTitle()
	{
		String title =driver.getTitle();
		Assert.assertEquals(title, "Account Login");
	}
	
	@Test()
	public void getCurrentPageUrl()
	{
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("demo.opencart.com"));
	}
	
	@Test()
	public void getPageHeader()
	{
		WebElement pageheader =driver.findElement(By.linkText("Your Store"));
		Assert.assertTrue(pageheader.isDisplayed(),"Page header is not displayed");
		
	}
	
	@Test()
	public void newCustomer()
	{
		WebElement newCustomer =driver.findElement(By.xpath("//h2[text()='New Customer']"));
		String nc = newCustomer.getText();
		Assert.assertEquals(nc, "New Customer","Customer type is not displayed");
	}
	
	@Test()
	public void printExistingCustomer()
	{
		WebElement existingCustomer = driver.findElement(By.xpath("//h2[text()='Returning Customer']"));
		Assert.assertTrue(existingCustomer.isDisplayed(),"existing customer is not displayed");
	}
	
	@Test()
	public void printRegistrationLinkVisibility()
	{
		WebElement register = driver.findElement(By.linkText("Register"));
		Assert.assertFalse(!(register.isDisplayed()),"Registrtaion link not visisable");
	}
	
	
	@Test()
	public void printLoginLinkVisibility()
	{
		WebElement Login = driver.findElement(By.linkText("Login"));
		Assert.assertTrue(Login.isDisplayed(), "Login link not visiable");
	}
	
	@Test()
	public void addToCartBtn()
	{
		boolean addToCartBtn =driver.findElement(By.id("cart")).isDisplayed();
		Assert.assertTrue(addToCartBtn);
	}
	
	@AfterTest()
	public void tearDown()
	{
		driver.close();
	}

}
