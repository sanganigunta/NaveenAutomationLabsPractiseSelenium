package azurewebsites;

import java.util.List;
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
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		 //selectDropdown("Norway");
		getAllDropdownElements("Turkey");
		

	}

	
	public static void getAllDropdownElements(String drpselele)
	{

		WebElement drpEle = driver.findElement(By.xpath("//select[@class='custom-select']"));
		Select selDrp = new Select(drpEle);
		List<WebElement> drpeles=selDrp.getOptions();
//		for(WebElement drpele: drpeles)
//		{
//			System.out.println(drpele.getText());
//			if(drpele.getText().trim().equals(drpselele))
//			{
//				drpele.click();
//				break;
//			}
//		}
		
		for(int i=0;i<drpeles.size();i++)
		{
			System.out.println(drpeles.get(i).getText());
			if(drpeles.get(i).getText().trim().equals(drpselele))
			{
				drpeles.get(i).click();
				break;
			}
		}
		
	}
	
	public static void selectDropdown(String country)
	{
		WebElement drpEle = driver.findElement(By.xpath("//select[@class='custom-select']"));
		Select selDrp = new Select(drpEle);
		//selDrp.selectByVisibleText(country);
		//selDrp.selectByValue("1");
		selDrp.selectByIndex(1);
		
	}
	
}
