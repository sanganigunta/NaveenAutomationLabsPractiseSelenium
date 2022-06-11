package relativeLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.with;
import io.github.bonigarcia.wdm.WebDriverManager;
public class RelativeLocatorsConcepts {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.aqi.in/dashboard/canada");
		WebElement element = driver.findElement(By.linkText("Langley, Canada"));
		System.out.println(element.getText());
		
//		String right = driver.findElement(RelativeLocator.with(By.tagName("p")).toRightOf(element)).getText();
//		System.out.println(right);
		
		String right = driver.findElement(with(By.tagName("p")).toRightOf(element)).getText();
		System.out.println(right);
		String left = driver.findElement(with(By.tagName("p")).toLeftOf(element)).getText();
		System.out.println(left);
		String above = driver.findElement(with(By.tagName("a")).above(element)).getText();
		System.out.println(above);
		
		String below = driver.findElement(with(By.tagName("p")).below(element)).getText();
		System.out.println(below);
		
		String nearEle =driver.findElement(with(By.tagName("p")).near(element)).getText();
		System.out.println(nearEle);

	}
	

}
