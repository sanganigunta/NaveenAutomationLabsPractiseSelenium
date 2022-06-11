package azurewebsites;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckBox {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		//selectGender("female");
		//driver.quit();
		
		//selectCheckBox();
		//selectAllCheckBox();
		selectNCheckBox();
		
		
		
		
		
	}
	
	public static void selectNCheckBox()
	{
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for(int i=checkboxes.size()-2;i<checkboxes.size();i++)
		{
			
				checkboxes.get(i).click();
		}
	}
	
	public static void selectAllCheckBox()
	{
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for(int i=0;i<checkboxes.size();i++)
		{
			
				checkboxes.get(i).click();
		}
	}
	
	public static void selectCheckBox()
	{
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		for(int i=0;i<checkboxes.size();i++)
		{
		
			String checkbox =checkboxes.get(i).getAttribute("id").trim();
			System.out.println(checkbox);
		
			if(checkbox.equals("thursday") || checkbox.equals("friday"))
			{
				checkboxes.get(i).click();
				
			}
		}
	}
	
	public static void selectGender(String genderVal)
	{
	
		//System.out.println("Entered gender value is "+genderVal);
		
		List<WebElement> radioBtn = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='radio']"));
		Boolean radioSelection = false ;
		System.out.println(radioSelection);
		int count =0;
		for(int i=0;i<radioBtn.size();i++)
		{
			 radioSelection =radioBtn.get(i).isSelected();
			 
			}
		System.out.println(radioSelection);
		
		if(radioSelection==false) {
//		switch(genderVal)
//		{
//		case "female":
//			driver.findElement(By.xpath("//input[@class='form-check-input' and @id='female']")).click();
//			
//			break;
//
//		case "male":
//			driver.findElement(By.xpath("//input[@class='form-check-input' and @id='male']")).click();
//			
//			break;
//		case "other":
//			System.out.println("Others is disabled at this movement..");
//			break;
//		default:
//			System.out.println("Please pass correct gender value....." + genderVal);
//			break;
//		}
		}
		else
		{
			System.out.println("Radio button is slected already...");
		}
		
		
//		if(radioSelection==true)
//		{
//			System.out.println("Some radio button is selected");
//			}
//		else
//		{
//			if(genderVal.equals("female"))
//			{
//				driver.findElement(By.xpath("//input[@class='form-check-input' and @id='female']")).click();
//			}
//			
//			else if(genderVal.equals("male"))
//			{
//				driver.findElement(By.xpath("//input[@class='form-check-input' and @id='male']")).click();
//			}
//			else if(genderVal.equals("other"))
//			{
//				System.out.println("Others is disabled at this movement..");
//			}
//			else
//			{
//				System.out.println("Please pass correct gender value....."+genderVal);
//			}
//		}
//		

	}
}
