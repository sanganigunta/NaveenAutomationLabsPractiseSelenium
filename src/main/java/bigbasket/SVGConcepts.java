package bigbasket;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SVGConcepts {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	 WebDriverManager.chromedriver().setup();	
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("https://petdiseasealerts.org/forecast-map#/");
     
//     List<WebElement> iframes =driver.findElements(By.tagName("iframe"));
//     for(WebElement e:iframes)
//     {
//    	 System.out.println(e.getAttribute("src"));
//    	 System.out.println(e.getAttribute("name"));
//     }
     
     WebElement frameEle = driver.findElement(By.xpath("//iframe[contains(@name,'__privateStripeMetricsController')]"));
    // driver.switchTo().frame("__privateStripeMetricsController0260");
     
     List<WebElement> states =driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='g']//*[name()='path']"));
     Actions action = new Actions(driver);
     for(WebElement e:states)
     {
    	 action.moveToElement(e).perform();
    	String stateName = e.getAttribute("name").trim();
    	if(stateName.equals("North Dakota"))
    	{
    		e.click();
    		break;
    	}
     }
     
     WebElement frameEle1= driver.findElement(By.xpath("//iframe[contains(@name,'__privateStripeMetricsController')]"));
     driver.switchTo().frame(frameEle1);
     
    List<WebElement> countries =  driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='counties']//*[name()='path']"));
     for(WebElement e1:countries)
     {
    	 action.moveToElement(e1).perform();
     }
	}

}
