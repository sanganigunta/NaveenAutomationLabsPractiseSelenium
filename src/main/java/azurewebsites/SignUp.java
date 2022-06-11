package azurewebsites;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://itera-qa.azurewebsites.net/");
		driver.findElement(By.xpath("//a[@href='/UserRegister/NewUser']")).click();
		WebElement regform = driver.findElement(By.cssSelector("div.container.body-content>h2"));
		String reg_title = regform.getText();
		System.out.println(reg_title);
		validateErrorMessages();

		formRegistration("Divya","San","Punganur","76890654331","DivyaS1","Divya@1234","Divya@1234");
		driver.quit();


	}

	public static void validateErrorMessages() {
		driver.findElement(By.cssSelector("input#submit")).click();

		ArrayList<String> errorMesg = new ArrayList<String>();
		ArrayList<String> exp_ErrorMesg = new ArrayList<String>();

		errorMesg.add("Please enter first name");
		errorMesg.add("Please enter surname");
		errorMesg.add("Please enter username");
		errorMesg.add("Please enter password");
		System.out.println(errorMesg);
		System.out.println("Original list before sorting......" + errorMesg);
		Collections.sort(errorMesg);
		System.out.println("Original list After sorting......" + errorMesg);

		String firstNameErrorMesg = driver.findElement(By.cssSelector("span#FirstName-error")).getText();
		exp_ErrorMesg.add(firstNameErrorMesg);
		String lastNameErrorMesg = driver.findElement(By.cssSelector("span#Surname-error")).getText();
		exp_ErrorMesg.add(lastNameErrorMesg);
		String userNameErrorMesg = driver.findElement(By.cssSelector("span#Username-error")).getText();
		exp_ErrorMesg.add(userNameErrorMesg);
		String passwordNameErrorMesg = driver.findElement(By.cssSelector("span#Password-error")).getText();
		exp_ErrorMesg.add(passwordNameErrorMesg);

		System.out.println("Expected list before sorting......" + exp_ErrorMesg);

		Collections.sort(exp_ErrorMesg);
		System.out.println("Expected list after sorting......" + exp_ErrorMesg);

		if (errorMesg.equals(exp_ErrorMesg)) {
			System.out.println("All Error messages are displayed");
		}

		else {
			System.out.println("All error messages are not displayed");
		}
	}

	public static void formRegistration(String fName, String lName,String epost, String phNum, String uname, String passwrd, String confirmPassword)
	{

		driver.findElement(By.cssSelector("input#FirstName")).sendKeys(fName);
		driver.findElement(By.cssSelector("input#Surname")).sendKeys(lName);
		driver.findElement(By.cssSelector("input#E_post")).sendKeys(epost);
		driver.findElement(By.cssSelector("input#Mobile")).sendKeys(phNum);
		driver.findElement(By.cssSelector("input#Username")).sendKeys(uname);
		driver.findElement(By.cssSelector("input#Password")).sendKeys(passwrd);
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(confirmPassword);
		driver.findElement(By.cssSelector("input#submit")).click();
		String regSucessMesg = driver.findElement(By.cssSelector("label.label-success")).getText().trim();
		if (regSucessMesg.equals("Registration Successful")) {
			System.out.println("Registration is successful");
		} else {
			System.out.println("Registration is not successful");
		}
	}
	
	
}
