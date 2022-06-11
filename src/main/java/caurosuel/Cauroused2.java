package caurosuel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cauroused2 {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.noon.com/uae-en/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,700)");
		
		WebElement arrow=driver.findElement(By.xpath("//div[contains(@class,'swiper-button-next custom-navigation swiper-nav')]"));
		
		String arrowstatus= arrow.getAttribute("class");
		
		while(!(arrowstatus.contains("disabled"))) {
		int caurouselinitialVal=0;
		int caurouselLength=7;
		String text ="(//div[@class='lazyload-wrapper '])[position()='49']//div[@class='sc-1de7b4d8-0 hDYeXg grid']/div[contains(@class,'edaMrp')]//div[contains(@class,'iOSKQc')]/span";
		List<WebElement> titles =driver.findElements(By.xpath(text));
		for(WebElement e:titles)
		{
			System.out.println("-------------------------------------");
			System.out.println(e.getText());
			caurouselinitialVal++;
			if(caurouselinitialVal%caurouselLength==0)
			{
				driver.findElement(By.xpath("//div[contains(@class,'swiper-button-next custom-navigation swiper-nav')]")).click();
				System.out.println("####################################################");
				Thread.sleep(3000);
			}
			}
		arrowstatus= arrow.getAttribute("class");
		}

	}

}
