package challenges;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Noon {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.noon.com/uae-en/");
		
//		List<String> arr =getCaurouselElementsDataAsList("Trending deals in laptops",7);
//
//		Collections.sort(arr);
//		System.out.println(arr);
		
	//	scrolltoSection("Trending deals in mobiles");
		
		List<String> arr =getCaurouselElementsDataAsList("Trending deals in mobiles",7);
		
				Collections.sort(arr);
				System.out.println(arr);
	     
	}
	
	public static void scrolltoSection(String sectionName) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		switch(sectionName)
		{
		case "Recommended for you":js.executeScript("window.scrollTo(0,700)");
		break;
		
		case "More clearance deals":js.executeScript("window.scrollTo(0,2500)");
		break;
		
		case "Trending deals in electronics":
		js.executeScript("window.scrollTo(0,2981)");
		WebElement electronic =driver.findElement(By.xpath("//h3[text()='Trending deals in electronics']"));
		js.executeScript("arguments[0].scrollIntoView(true);", electronic);
		break;
		
		case "Trending deals in laptops":js.executeScript("window.scrollTo(0,3500)");
//		WebElement laptops = driver.findElement(By.xpath("//h3[text()='Trending deals in laptops']"));
//		js.executeScript("arguments[0].scrollIntoView(true);", laptops);
		break;
		
		
		default: System.out.println("Please send the correct section name: "+sectionName);
		break;
		}
	}
	
	public static List<String> getCaurouselElementsDataAsList(String caurouselName, int caurouselLength) throws InterruptedException
	{
		int caurouselCount=0;
		
		scrolltoSection(caurouselName);
		Thread.sleep(2000);
		List<String> caurouselList = new ArrayList<String>();
		List<WebElement> caurouselEle= driver.findElements(By.xpath("//h3[text()='"+caurouselName+"']/../..//div[@class='sc-htJRVC iiiJFW']//div[@class='sc-1de7b4d8-0 hDYeXg grid']/div[contains(@class,'edaMrp')]//div[contains(@class,'iOSKQc')]/span"));
		WebElement arrow =driver.findElement(By.xpath("//h3[text()='"+caurouselName+"']/../..//div[@class='sc-htJRVC edHlQZ']//div[contains(@class,'swiper-button-next custom-navigation swiper-nav')]"));	
		
		String arrowstatus = arrow.getAttribute("class");
		
		while(!(arrowstatus.contains("disabled"))) {
		for(WebElement e:caurouselEle)
		{
			String caurouselText = e.getText().trim();
			if(!(caurouselText.isEmpty()))
			{
				System.out.println(caurouselText);
				caurouselList.add(caurouselText);
				caurouselCount++;
			}
			if(caurouselCount%caurouselLength==0)
			{
				arrow.click();
				Thread.sleep(2000);
			}
			
		}
		arrowstatus = arrow.getAttribute("class");
		System.out.println(arrowstatus);
		}
		return caurouselList;
	}

}
