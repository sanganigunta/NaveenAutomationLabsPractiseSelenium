package naveenAutomationLabsSeleniumConcepts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlingConcepts {


	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/");
		//OrangeHRM on Facebook
		//driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		//driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		////img[@alt='OrangeHRM on twitter']
		//driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		//OrangeHRM on youtube
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> itr = handles.iterator();
		String parentwindowid = itr.next();
		System.out.println(parentwindowid);
		String childWindowId = itr.next();
		System.out.println(childWindowId);
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(parentwindowid);
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.close();

	}

}
