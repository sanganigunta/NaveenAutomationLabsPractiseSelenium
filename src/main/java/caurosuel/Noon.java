package caurosuel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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
		List<WebElement> caurosel1 =driver.findElements(By.xpath("(//div[@class='lazyload-wrapper '])[position()=6]//div[@class='bannerContainer']//div[@class='sc-gKclnd jPRnVP']//img"));
		
		printCaurouselElementsData(caurosel1,12);
		
		
		}
	
	public static void printCaurouselElementsData(List<WebElement> cauroselEle, int caurouselcut )
	{
		WebElement nextBtn = driver.findElement(By.xpath("//div[@class='swiper-button-next custom-navigation']"));
		String nxtBtnStatus = nextBtn.getAttribute("class");
		System.out.println(nxtBtnStatus);

		int couroselLeength =0;
		
		//swiper-button-disabled
		while(!(nxtBtnStatus.contains("swiper-button-disabled")))
		{
		
			for(WebElement e:cauroselEle)
			{
				String altText =e.getAttribute("alt");
				String[] arr=altText.split("/");
			    System.out.println(arr[1]);
			    couroselLeength++;
				if(couroselLeength%caurouselcut==0)
	            {
			    System.out.println("################################");
	      	    driver.findElement(By.xpath("//div[@class='swiper-button-next custom-navigation']")).click();
	            }
				}
			nxtBtnStatus = nextBtn.getAttribute("class");
			System.out.println("End of caurousel");
		}
	}
	

}
