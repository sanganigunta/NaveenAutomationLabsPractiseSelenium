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


public class EmiCalculatorPieChart {

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
		js.executeScript("window.scrollTo(0,900)");
		
		String piechart="//*[local-name()='svg' and @class='highcharts-root']//*[name()='g' and @class='highcharts-series-group']//*[name()='g' and contains(@class,'highcharts-pie-series')]//*[name()='path']";
		String toolTip="//*[name()='g' and contains(@class,'highcharts-tooltip')]//*[name()='text']";
		
		List<WebElement> piechartVal =driver.findElements(By.xpath(piechart));
		
		 action = new Actions(driver);
		
		for(WebElement pie:piechartVal)
		{
			action.moveToElement(pie).perform();
			String toolTipText =driver.findElement(By.xpath(toolTip)).getText();
			System.out.println(toolTipText);
		}

	}

}
