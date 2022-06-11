package naveenAutomationLabsSeleniumConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableConcept {

	static WebDriver driver ;
	public static void main(String[] args)  {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String name="Garry.White";
		selectCheckBox(name);
		getTableValues(name);
		
	}
	
	public static void selectCheckBox(String name)
	{
		WebElement checkbox = driver.findElement(By.xpath("//a[text()='"+name+"']/parent::td/preceding-sibling::td/input"));
		checkbox.click();

	}

	public static void getTableValues(String name)
	{
		List<WebElement> userDetials = driver.findElements(By.xpath("//a[text()='"+name+"']/parent::td/following-sibling::td"));
		for(WebElement e:userDetials)
		{
			System.out.println(e.getText().trim());
		}
	}
}
