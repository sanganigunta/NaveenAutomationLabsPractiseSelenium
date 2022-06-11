package naveenAutomationLabsSeleniumConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAllWindows {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentwindowInd = driver.getWindowHandle();
		System.out.println(parentwindowInd);
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> itr = handler.iterator();
		while(itr.hasNext())
		{
			String windowId = itr.next();
			if(!windowId.equals(parentwindowInd)) {
			System.out.println(windowId);
			driver.switchTo().window(windowId);
			System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
			driver.close();
			}
			else
			{
				System.out.println("Currently in a parent window");
			}
		}
		System.out.println("Closing parent window");
		driver.quit();

	}

}
