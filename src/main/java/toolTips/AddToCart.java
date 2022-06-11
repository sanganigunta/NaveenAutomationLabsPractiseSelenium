package toolTips;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {

	static WebDriver driver;
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		AddToCart();
	}
	
	public static void AddToCart()
	{
		String[] vegs = {"Brocolli","Cauliflower","Cucumber","Tomato"};
		List<WebElement> vegNames = driver.findElements(By.xpath("//h4[@class='product-name']"));
		for(WebElement vegName: vegNames) {
			String[] vegitables = vegName.getText().split("-");
			String vegitableValues = vegitables[0].trim();
			System.out.println(vegitableValues);
			List<String> al = new ArrayList<String>();
			al= Arrays.asList(vegs);
		//	if(vegitableValues.equalsIgnoreCase(al)) {
			driver.findElement(By.xpath("//div[@class='product-action']//button")).click();
			
		//	}
		
		}
	}

}
