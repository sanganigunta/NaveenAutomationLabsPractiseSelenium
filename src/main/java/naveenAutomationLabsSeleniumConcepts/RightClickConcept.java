package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://jqueryui.com/droppable/");
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(rightClickBtn).perform();
		
		List<WebElement> rightclickOptions =driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li[contains(@class,'context-menu-item context-menu-icon')]/span"));
			for(WebElement e: rightclickOptions)
			{
			  String rightClickText = e.getText().trim();
			  System.out.println(rightClickText);
			  if(rightClickText.equals("Edit"))
			  {
				  e.click();
				  break;
			  }
			}
			
			Alert alert = driver.switchTo().alert();
			alert.accept();

	}

}
