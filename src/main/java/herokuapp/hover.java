package herokuapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class hover {

	
	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/hovers");
		WebElement img1 = driver.findElement(By.cssSelector("img[src*='avatar-blank']"));
		WebElement img2 = driver.findElement(By.xpath("(//img[contains(@src,'avatar-blank')])[2]"));
		WebElement img3 = driver.findElement(By.xpath("(//img[contains(@src,'avatar-blank')])[3]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(img1).perform();
		String userinfo =driver.findElement(By.xpath("//div[@class='figure']//div//h5")).getText().trim();
		System.out.println(userinfo);
		
		action.moveToElement(img2).perform();
		String userinfo2 =driver.findElement(By.xpath("(//div[@class='figure']//div//h5)[2]")).getText().trim();
		System.out.println(userinfo2);
		
		
		action.moveToElement(img3).perform();
		String userinfo3 =driver.findElement(By.xpath("(//div[@class='figure']//div//h5)[3]")).getText().trim();
		System.out.println(userinfo3);
		
		
		
	}

}
