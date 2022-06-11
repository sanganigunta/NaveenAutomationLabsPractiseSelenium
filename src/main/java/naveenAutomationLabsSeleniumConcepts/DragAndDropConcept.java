package naveenAutomationLabsSeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropConcept {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://jqueryui.com/droppable/");
		driver.get("https://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement src = driver.findElement(By.cssSelector("div#draggable"));
	//	WebElement target = driver.findElement(By.cssSelector("div#droppable"));
		Actions action = new Actions(driver);
		//action.dragAndDrop(src, target).perform();
		
		//action.moveToElement(src).clickAndHold().moveToElement(target).release().build().perform();
		action.moveToElement(src).clickAndHold().moveByOffset(100, 100).release().perform();

	}

}
