package naveenAutomationLabsSeleniumConcepts;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil implements Util {

	WebDriver driver;

	public WebDriver initializeBrowser(String browserName) {
		
//		switch (browserName) {
//		case CHROME_BROWSER:
//			WebDriverManager.chromedriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case FIREFOX_BROWSER:
//			WebDriverManager.firefoxdriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case EDGE_BROWSER:
//			WebDriverManager.edgedriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case InternetExplorer_BROWSER:
//			WebDriverManager.iedriver().setup();
//			driver = new ChromeDriver();
//			break;
//		case SAFARI_BROWSER:
//			driver = new ChromeDriver();
//			break;
//		default:
//			System.out.println("please pass the correct browser name " + browserName);
//
//		}

		System.out.println("The name of the browser is " + browserName);
		if (browserName.equals(CHROME_BROWSER)) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equals(FIREFOX_BROWSER)) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase(EDGE_BROWSER)) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equals(InternetExplorer_BROWSER)) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase(SAFARI_BROWSER)) {
			driver = new SafariDriver();
		}

		else {
			System.out.println("Please pass correct browser name " + browserName);
		}
    	return driver;
	}

	//@Override
	public void navigateToUrl(String url) {
		if(url==null)
		{
			return;
		}
		else if(url.isEmpty())
		{
			return;
		}
		else if(url.indexOf("http")==-1 || url.indexOf("https")==-1)
		{
			System.out.println("http(s) is missing in the given url");
			return;
		}
		else {
			driver.get(url);
		}
		
		
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public String getSourceCode() {
		return driver.getPageSource();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public void navigateToUrl(URL url)
	{
		driver.navigate().to(url);
	}
		
	@Override
	public void performRefresh()
	{
		driver.navigate().refresh();
	}

	@Override
	public void navigateForword() {
		driver.navigate().forward();
	}

	@Override
	public void navigateBackword() {
		driver.navigate().back();
		
	}
}
