package challenges;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucedemo_Naveen {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.saucedemo.com/inventory.html");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
//		Double max =prices.stream()
//		.mapToDouble(e->Double.parseDouble(e.getText().replace("$", "")))
//		.max().getAsDouble();
//		
//		driver.findElement(By.xpath("//div[normalize-space()='$"+max+"']/following-sibling::button[text()='Add to cart']")).click();
//		
//		
//		Double min = prices.stream().mapToDouble(e->Double.parseDouble(e.getText().replace("$", ""))).min().getAsDouble();
//		
//		driver.findElement(By.xpath("//div[normalize-space()='$"+min+"']/following-sibling::button[text()='Add to cart']")).click();
	
		Double largest=0.0;
	
		
		for(WebElement e:prices)
		{
			Double d = Double.parseDouble(e.getText().trim().replace("$", ""));
			if(d>largest)
			{
				largest=d;
			}
			
		}
		
		System.out.println(largest);
		driver.findElement(By.xpath("//div[normalize-space()='$"+largest+"']/following-sibling::button[text()='Add to cart']")).click();
		
		
		
	}

}
