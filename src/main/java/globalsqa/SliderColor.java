package globalsqa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderColor {

	static WebDriver driver;
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/sliders/");
		WebElement frmaeele = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		driver.switchTo().frame(frmaeele);
		WebElement slider = driver.findElement(By.xpath("//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//div"));
		WebElement slider2 = driver.findElement(By.xpath("(//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//div)[2]"));
		
		WebElement slider3 = driver.findElement(By.xpath("(//div[@class='ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//div)[3]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, -60, 0).perform();
		
		action.dragAndDropBy(slider2, -60, 0).perform();
		
		action.dragAndDropBy(slider3, 100, 0).perform();
		
	}

}
