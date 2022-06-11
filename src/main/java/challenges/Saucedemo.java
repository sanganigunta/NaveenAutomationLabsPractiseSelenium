package challenges;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Saucedemo {

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
		
		
		List<Float> pI = new ArrayList<Float>();
		
		for(WebElement price: prices)
		{
			String priceText = price.getText().trim();
			//System.out.println(priceText);
			String sub = priceText.substring(1, priceText.length());
			System.out.println(sub);
			
			
			Float PIText= Float.parseFloat(sub);
			
			pI.add(PIText);
		}
		
		System.out.println(pI);
		
		//String []dsf = new String[al.size()];
	//	al.toArray(dsf);
		
		Float[] price = new Float[pI.size()];
		pI.toArray(price);
		
		System.out.println(Arrays.toString(price));
		Float min=price[0];
		
		for(int i=0;i<price.length;i++)
		{
			if(price[i]<min)
			{
				min = price[i];
			}
		
		}
		
		System.out.println("Minimum price value is "+min);
		
		
		driver.findElement(By.xpath("//div[@class='inventory_item_price' and text()='"+min+"']/following-sibling::button[text()='Add to cart']")).click();

	}

}
