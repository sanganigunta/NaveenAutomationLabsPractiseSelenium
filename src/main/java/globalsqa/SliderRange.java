package globalsqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderRange {

	static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/sliders/#Range");
		WebElement frameele = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frameele);
		WebElement minSlider = driver.findElement(By.xpath("(//div[@id='slider-range']//span)[1]"));
		WebElement maxSlider = driver.findElement(By.xpath("(//div[@id='slider-range']//span)[2]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(minSlider, 200, 0).perform();
		
		action.dragAndDropBy(maxSlider, 200, 0).perform();

	}

}
