package pagination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Noon {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.noon.com/uae-en/");
		
		
		List<WebElement> caurosoul = driver.findElements(By.xpath("//div[@data-qa='widget_bannerModuleScroller']//div[contains(@class,'swiper-slide')]//div[@class='lazyload-wrapper ']//img"));
		
		for(WebElement e:caurosoul)
		{
			System.out.println(e.getAttribute("alt"));
		}

	}

}
