package globalsqa;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling1 {


	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/accordion-and-tabs/");
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame.lazyload")));
//		By accordian = By.xpath("//h3[@id='ui-id-1']");
//				driver.findElement(accordian).click();
//		
		String text = driver.findElement(By.xpath("//h3[@id='ui-id-1']/following-sibling::div[@id='ui-id-2']/p")).getText();
		System.out.println(text);
	}
}
