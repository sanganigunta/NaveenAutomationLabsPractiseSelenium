package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	
	@Parameters({"browser","chrome"})
	@BeforeTest()
	public void launchBrowser(String browserName, String url)
	{
		switch(browserName) {
		
		case "chrome":WebDriverManager.chromedriver().setup();
		              driver = new ChromeDriver();
		break;
		case "firefox": WebDriverManager.firefoxdriver().setup();
		                 driver = new FirefoxDriver();
		break;
			
		case "edge": WebDriverManager.edgedriver().setup();
		             driver = new EdgeDriver();
		break;
			
		default: System.out.println("Please pass the correct browser name "+browserName);
		break;
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterTest()
	public void closeBrowser()
	{
		driver.close();
	}

}
