package azurewebsites;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioAndCheckbox {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.findElement(By.xpath("//label[@for= '2years']")).click(); 
		driver.findElement(By.xpath("//label[@for= 'selenium']")).click();
	    driver.findElement(By.xpath("//label[@for= 'testng']")).click();
		//selectRadioBtn("4years");
	}

	public static void selectRadioBtn(String radioBtn) {
		System.out.println("Given radio button is " + radioBtn);
		List<WebElement> allradioBtn = driver.findElements(
				By.xpath("//div[@class='custom-control custom-radio']//label[@class='custom-control-label']"));

		// css==input[name='customRadio']

		for (WebElement radioBtnVal : allradioBtn) {
			String raadioVal = radioBtnVal.getAttribute("id").trim();
			if (radioBtn.equals(raadioVal)) {
				radioBtnVal.click();
			}
		}
	}

}
