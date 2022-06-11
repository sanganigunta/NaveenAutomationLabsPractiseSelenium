package naveenAutomationLabsSeleniumConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindowsOneByOne {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parentWindowId = driver.getWindowHandle();
		System.out.println(parentWindowId+":"+driver.getTitle()+":"+driver.getCurrentUrl());
		
		
//		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
//		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
//		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();		
//		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
//		Set<String> handles =driver.getWindowHandles();
//		Iterator<String> itr = handles.iterator();
//		
//			String windowId1 = itr.next();
//			driver.switchTo().window(windowId1);
//			System.out.println(windowId1+":"+driver.getTitle()+":"+driver.getCurrentUrl());
//			driver.close();
//		
//		
//			String windowId2 = itr.next();
//			driver.switchTo().window(windowId2);
//			System.out.println(windowId2+":"+driver.getTitle()+":"+driver.getCurrentUrl());
//			driver.close();
//			
//			String windowId3 = itr.next();
//			driver.switchTo().window(windowId3);
//			System.out.println(windowId3+":"+driver.getTitle()+":"+driver.getCurrentUrl());
//			driver.close();
//			
//			driver.quit();
		
		By linkedIn = By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
		By faceBook = By.xpath("//img[@alt='OrangeHRM on Facebook']");
		By twiter =   By.xpath("//img[@alt='OrangeHRM on twitter']");
		By youtube = By.xpath("//img[@alt='OrangeHRM on youtube']");
	//	handleWindows(linkedIn,"parentWindowId");
		
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.linkedin.com/signup/cold-join?session_redirect=https%3A%2F%2Fwww%2Elinkedin%2Ecom%2Fgroups%3Fhome%3D%26gid%3D891077&trk=login_reg_redirect");
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.facebook.com/OrangeHRM");
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://twitter.com/orangehrms");
		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://www.youtube.com/watch?v=QD_cIT-kRf4");
		
		driver.quit();
		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://twitter.com/orangehrm");
//		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
//		driver.close();
//		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://www.youtube.com/c/OrangeHRMInc");
//		System.out.println(driver.getTitle()+":"+driver.getCurrentUrl());
//		driver.close();
//		
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.get("https://opensource-demo.orangehrmlive.com/index.php/");
//		driver.quit();
//		
//	
		
		

	}

	public static void doClick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	public static void handleWindows(By locator, String parentWindowId)
	{
		doClick(locator);
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> itr = handler.iterator();
		while(itr.hasNext())
		{
			String windowId = itr.next();
			if((windowId.equals(parentWindowId))) {
				System.out.println("Child and parent windows are equal");
				continue;
			}
			else {
			driver.switchTo().window(windowId);
			System.out.println(windowId+":"+driver.getTitle()+":"+driver.getCurrentUrl());
			driver.close();
			}
		}
		driver.switchTo().window(parentWindowId);
		driver.quit();

	}
	}
