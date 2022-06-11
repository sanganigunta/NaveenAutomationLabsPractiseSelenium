package naveenAutomationLabsSeleniumConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesAssignment {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1200)");
		
		////div[@class='full_width_space']//span
		
//				By iframes = By.tagName("iframe");
//			
//				List<WebElement> frames = driver.findElements(iframes);
//				System.out.println(frames.size());
//				for(WebElement frame:frames)
//				{
//					String frmaeHrefVal = frame.getAttribute("src");
//					System.out.println(frmaeHrefVal);
//				}
		
		driver.switchTo().frame("frame-one748593425");
		By title = By.xpath("//div[@class='full_width_space']//span");
		WebElement tileEle = driver.findElement(title);
		System.out.println(tileEle.getText().trim());
		js.executeScript("arguments[0].click();", tileEle);
		Thread.sleep(8000);
		js.executeScript("arguments[0].setAttribute('style','border:2px solid,red;')", tileEle);
		
		//driver.quit();
		
//		By veid = By.id("RESULT_TextField-2");
//		WebElement veidEle = driver.findElement(veid);
//		veidEle.sendKeys("test");
//		//
//		By veMake = By.id("RESULT_TextField-3");
//		WebElement veMakeELe = driver.findElement(veMake);
//		veMakeELe.sendKeys("test");
		
//		By veModel = By.id("RESULT_TextField-4");
//		WebElement veModelEle = driver.findElement(veModel);
//		veModelEle.sendKeys("test");
//		
//		By color = By.id("RESULT_TextField-5");
//		WebElement colrEle = driver.findElement(color);
//		colrEle.sendKeys("color test");
//		
//		By mileage = By.id("RESULT_TextField-6");
//		WebElement mileageEle = driver.findElement(mileage);
//		mileageEle.sendKeys("test mileageEle");
//		
//		By vin = By.id("RESULT_TextField-7");
//		WebElement vinEle = driver.findElement(vin);
//		vinEle.sendKeys("vin test");
//		
//		By veName = By.id("RESULT_TextField-8");
//		WebElement veNameEle = driver.findElement(veName);
//		veNameEle.sendKeys("veNameEle test");
//		
//		By veAddress = By.id("RESULT_TextField-9");
//		WebElement veAddressEle = driver.findElement(veAddress);
//		veAddressEle.sendKeys("veAddressEle test");
//		
//		By veAddress1 = By.id("RESULT_TextField-10");
//		WebElement veAddress1Ele = driver.findElement(veAddress1);
//		veAddressEle.sendKeys("veAddress1 test");
		
		By veid = By.id("RESULT_TextField-2");
		By veMake = By.id("RESULT_TextField-3");
		By veModel = By.id("RESULT_TextField-4");
		By color = By.id("RESULT_TextField-5");
		By mileage = By.id("RESULT_TextField-6");
		By vin = By.id("RESULT_TextField-7");
		By veName = By.id("RESULT_TextField-8");
		By veAddress = By.id("RESULT_TextField-9");
		By veAddress1 = By.id("RESULT_TextField-10");
		By city = By.id("RESULT_TextField-11");
		By state = By.id("RESULT_RadioButton-12");
		By zip = By.id("RESULT_TextField-13");
		By phone = By.id("RESULT_TextField-14");
		By email = By.id("RESULT_TextField-15");
		
		ElementUtil eUtil = new ElementUtil(driver);
		eUtil.dosendKeys(veid, "veid test");
		eUtil.dosendKeys(veMake, "veMake test");
		eUtil.dosendKeys(veModel, "veModel test");
		eUtil.dosendKeys(color, "color test");
		eUtil.dosendKeys(mileage, "mileage test");
		eUtil.dosendKeys(vin, "vin test");
		eUtil.dosendKeys(veName, "veName test");
		eUtil.dosendKeys(veAddress, "veAddress test");
		eUtil.dosendKeys(veAddress1, "veAddress1 test");
		eUtil.dosendKeys(city, "city test");
		//eUtil.useSelectByVisiableValue(state, "Arkansas");
		eUtil.dosendKeys(zip, "zip test");
		eUtil.dosendKeys(phone, "phone test");
		eUtil.dosendKeys(email, "email test");
		
		driver.switchTo().parentFrame(); //switch to parent frame
		driver.switchTo().defaultContent();//switch to main page or parent frame
		
		

	}

}
