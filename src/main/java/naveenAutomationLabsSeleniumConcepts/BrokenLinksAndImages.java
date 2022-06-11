package naveenAutomationLabsSeleniumConcepts;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinksAndImages {

		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException, IOException {
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.get("https://www.amazon.com/");
			driver.get("https://the-internet.herokuapp.com/broken_images");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			
//			By link = By.tagName("a");
//			printBrokenLinksOrImages(link,"href");
			
			
			By image = By.tagName("img");
			printBrokenLinksOrImages(image,"src");
			
			

	}
		
		public static void printBrokenLinksOrImages(By locator, String arttributeValue) throws IOException
		{
			int countBrokenthingsCount=0;
			List<WebElement> list = driver.findElements(locator);
			System.out.println("Number of links or images availabe are "+list.size());
			
			for(WebElement e:list)
			{
				String urlVal = e.getAttribute(arttributeValue);
				
			if(urlVal!=null && (!urlVal.isEmpty()) && (!urlVal.contains("javascript"))){
				//System.out.println(urlVal);
			
				URL url = new URL(urlVal);
			//	System.out.println(url);
			
				HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
				httpUrlConnection.connect();
				int responsecode =httpUrlConnection.getResponseCode();
				String responseMsg = httpUrlConnection.getResponseMessage();
				httpUrlConnection.disconnect();
				if(responsecode>=400) {
				System.out.println(urlVal+"------>"+responsecode+"--------->"+responseMsg);
				countBrokenthingsCount++;
				}
				}
				
			}
			
			System.out.println("Broken images or links count are "+countBrokenthingsCount);
		}

}
