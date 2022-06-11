package globalsqa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectElement {

	static WebDriver driver;

	static Actions action;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.globalsqa.com/demo-site/select-elements/");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200)");

		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));

		driver.switchTo().frame(frame);
		Thread.sleep(2000);

		action = new Actions(driver);
//		action.moveToElement(item1).clickAndHold(item1).moveToElement(item2).clickAndHold(item2).moveToElement(item3)
//				.clickAndHold(item3).moveToElement(item4).clickAndHold(item4).moveToElement(item5).clickAndHold(item5)
//				.moveToElement(item6).clickAndHold(item6).moveToElement(item7).click().build().perform();

//		By iteam1 = By.xpath("//ol[@id='selectable']//li[text()='Item 1']");
//		
//		
//		

		int n=1;
		while(n>0 && n<=7) {
		selectAllElements(n);
		n++;
		}

		// selectAllElements(1);

//		By text = By.xpath("//ol[@id='selectable']//li[text()='Item 1']");
//
//		WebElement ele = driver.findElement(text);
//		action.moveToElement(ele).click().build().perform();

		// ===========Grid=============

	}

	public static void selectAllElements(int num) {
		WebElement element = driver.findElement(By.xpath("//ol[@id='selectable']//li[text()='Item " + num + "']"));
		action.moveToElement(element).clickAndHold(element).build().perform();

	}

}
