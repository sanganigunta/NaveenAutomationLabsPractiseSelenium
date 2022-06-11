package toolTips;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrageHRM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		//https://opensource-demo.orangehrmlive.com/index.php/admin/viewSystemUsers
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		WebElement userManagement = driver.findElement(By.id("menu_admin_UserManagement"));
		WebElement user = driver.findElement(By.id("menu_admin_viewSystemUsers"));
		
		
		Actions action = new Actions(driver);
		action.moveToElement(admin).moveToElement(userManagement).moveToElement(user).click().perform();
		
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.cssSelector("input#systemUser_employeeName_empName")).sendKeys("Orange Test");
		driver.findElement(By.cssSelector("input#systemUser_userName")).sendKeys("Test1234");
		driver.findElement(By.cssSelector("input#systemUser_password")).sendKeys("Test@4321@#$1234");
		driver.findElement(By.cssSelector("input#systemUser_confirmPassword")).sendKeys("Test@4321@#$1234");
		driver.findElement(By.name("btnSave")).click();
	
		Thread.sleep(3000);
		String successmsg =driver.findElement(By.cssSelector("div.message.success.fadable")).getText();
		System.out.println(successmsg);
		
		
		
		

	}

}
