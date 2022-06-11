package herokuapp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://the-internet.herokuapp.com/checkboxes");
		checkboxSelection();

	}

	public static void checkboxSelection() {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

		for (WebElement checkbox : checkboxes) {
			boolean checkboxSelection = checkbox.isSelected();
			if (checkboxSelection == true) {
				System.out.println("Checkbox is selected for " +checkbox.getText());

			} else {
				checkbox.click();
			}
		}
	}

}
