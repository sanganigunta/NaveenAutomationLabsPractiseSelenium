package relativeLocators;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AQICanada {


	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.aqi.in/dashboard/canada");
		
		String stateName = "Quebec";

		getRightSideElements(stateName);
		

	}
	
	public static void getRightSideElements(String stateVal)
	{
		WebElement state = driver.findElement(By.linkText(stateVal));
		List<WebElement> rightElements = driver.findElements(
				with(By.xpath("//th[@class='sorting_1']/a[text()='" + stateVal + "']/../following-sibling::td"))
						.toRightOf(state));

		for (WebElement right : rightElements) {
			String rightText = right.getText();
			System.out.println(rightText);
		}
	}

}
