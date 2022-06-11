package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesExp {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		nestedFramesTop("left");
		nestedFramesTop("midle");
		nestedFramesTop("right");
		nestedFramesbottom("bottom");
		
	}
	
	
	public static void nestedFramesbottom(String framename) {
		
		driver.switchTo().frame("frame-bottom");
		String bttomtxt = driver.findElement(By.tagName("body")).getText().trim();
		System.out.println(bttomtxt);
		
	}
	
	public static void nestedFramesTop(String framename)
	{
		System.out.println("Framename is "+framename);
	  driver.switchTo().frame("frame-top");
	  {
		  if(framename.equals("left"))
		  {
			  driver.switchTo().frame("frame-left");
			  String leftframetext= driver.findElement(By.tagName("body")).getText().trim();
			  System.out.println(leftframetext);
			  driver.switchTo().defaultContent();
			 
		  }
		  else if(framename.equals("midle"))
		  {
			  //frame-middle  frame-right
			  driver.switchTo().frame("frame-middle");
			  String leftframetext= driver.findElement(By.tagName("body")).getText().trim();
			  System.out.println(leftframetext);
			  driver.switchTo().defaultContent();
		  }
		  else if(framename.equals("right"))
		  {
			  driver.switchTo().frame("frame-right");
			  String leftframetext= driver.findElement(By.tagName("body")).getText().trim();
			  System.out.println(leftframetext);
			  driver.switchTo().defaultContent();
		  }
		  
		  else
		  {
			  System.out.println("Please enter the correct inner frame "+framename);
		  }
		  
		  driver.switchTo().parentFrame();
	  }

	  
	}

}
