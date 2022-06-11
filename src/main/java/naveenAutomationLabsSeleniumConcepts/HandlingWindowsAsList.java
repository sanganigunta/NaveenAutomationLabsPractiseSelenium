package naveenAutomationLabsSeleniumConcepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindowsAsList {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/");
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		Set<String> handler =  driver.getWindowHandles();
		
		
//		String windowId1 = handlerList.get(0);
//		System.out.println(windowId1+":"+driver.getTitle()+":"+driver.getCurrentUrl());
//		
//		String windowId2 = handlerList.get(1);
//		driver.switchTo().window(windowId2);
//		System.out.println(windowId2+":"+driver.getTitle()+":"+driver.getCurrentUrl());
//		driver.close();
//		
//		String windowId3 = handlerList.get(2);
//		driver.switchTo().window(windowId3);
//		System.out.println(windowId3+":"+driver.getTitle()+":"+driver.getCurrentUrl());
//		
//		driver.close();
//		driver.quit();

		
//		for(String window:handlerList)
//		{
//			String windowID = window;
//			System.out.println(windowID);
//			driver.switchTo().window(windowID);
//			System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
//			driver.close();
//		}
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		
		List<String> handlerList = new ArrayList<String>(handler);
		for(int i=0;i<handlerList.size();i++)
		{
			String windowId = handlerList.get(i).toString();
			if(!(parentWindow.equals(windowId)))
					{
			driver.switchTo().window(windowId);
			System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
			driver.close();
			}
		}
		
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.quit();
	}

}
