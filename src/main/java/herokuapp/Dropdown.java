package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/dropdown");
		selectDropdownelements("Option 2");
		
	}
	
	public static void selectDropdownelements(String drpVal)
	{
		WebElement drpEle = driver.findElement(By.xpath("//select[@id ='dropdown']"));
		Select selDrpEle = new Select(drpEle);
		selDrpEle.selectByVisibleText(drpVal);
		
	}
}
