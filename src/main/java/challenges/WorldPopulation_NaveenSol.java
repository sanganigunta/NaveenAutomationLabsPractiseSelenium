package challenges;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldPopulation_NaveenSol {
	
		static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			driver.get("https://www.worldometers.info/world-population/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			String pupulationCount ="//div[@id='maincounter-wrap']//span[@class='rts-counter']";
            String todayPopulationCount ="//div[text()='Today']/parent::div//span[@class='rts-counter']";
            String thisYearPopulationCount="//div[text()='This year']/parent::div//span[@class='rts-counter']";
			String today_thisYearCount="//div[text()=\"Today\" or text()='This year']/parent::div//span[@class='rts-counter']";
            
//			System.out.println("============================ World poupulation count is=================================");
//			printWorldPopulation(pupulationCount);
//			System.out.println("============================ Today's poupulation count is=================================");
//			printWorldPopulation(todayPopulationCount);
//			System.out.println("============================ This year poupulation count is=================================");
//			printWorldPopulation(thisYearPopulationCount);
			
			int count =1;
			while(count<=20){
				System.out.println("===============Timer value=================");
				System.out.println(count+" second");
				if(count>20) break;
			System.out.println("============================ World poupulation count is=================================");
			printWorldPopulation(pupulationCount);
			System.out.println("============================ Today's and this year poupulation count is=================================");
			printWorldPopulation(today_thisYearCount);
			Thread.sleep(1000);
			count++;
			
			}		
				
	}

		public static void printWorldPopulation(String locator) throws InterruptedException
		{			
			List<WebElement> poppulation = driver.findElements(By.xpath(locator));
			for(WebElement e:poppulation)
			{
				System.out.println(e.getText());
			}
	
		}
		
}
