package svgConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmiCalculatorBarGraph {

	
	static WebDriver driver;
	static Actions action;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://emicalculator.net/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,1500)");
		action = new Actions(driver);
		String greenbar ="//div[@id='emibarchart']//*[local-name()='svg' and @class='highcharts-root']//*[name()='g' and @class='highcharts-series-group']//*[name()='g' and contains(@class,'highcharts-series-1')]//*[name()='rect']";
		String orangebar="//div[@id='emibarchart']//*[local-name()='svg' and @class='highcharts-root']//*[name()='g' and @class='highcharts-series-group']//*[name()='g' and contains(@class,'highcharts-series-0')]//*[name()='rect']";
		String toolTip="//div[@id='emibarchart']//*[local-name()='svg' and @class='highcharts-root']//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']";
		getToolTipTextOfBarChat("//div[@id='emibarchart']//*[local-name()='svg' and @class='highcharts-root']//*[name()='g' and @class='highcharts-series-group']//*[name()='g' and contains(@class,'highcharts-series-1')]//*[name()='rect']\"");
		
		

//		List<WebElement> graphVal = driver.findElements(By.xpath(orangebar));	
//		for(WebElement e:graphVal)
//		{
//		String height =	e.getAttribute("height");
//		action.moveToElement(e).perform();
//		System.out.println(height);
//		String toolTipText =driver.findElement(By.xpath(toolTip)).getText();
//		
//		System.out.println(toolTipText);
//		}
	}
	
	public static void getToolTipTextOfBarChat(String barVal)
	{
		List<WebElement> graphVal = driver.findElements(By.xpath(barVal));
		System.out.println(graphVal.size());
		
		
	}


}
