package naveenAutomationLabsSeleniumConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleFileUpload {


	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://ps.uci.edu/~franklin/doc/file_upload.html");
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//input[@name ='userfile']")).sendKeys("C:\\Users\\smart\\Downloads\\LibraryAPI.docx");
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\smart\\Downloads\\LibraryAPI.docx");
		
		

	}

}
