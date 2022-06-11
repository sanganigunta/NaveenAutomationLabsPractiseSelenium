package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept extends BaseTest{

	@Test()
	@DataProvider()
	public Object[][] getLoginData()
	{
//		Object[][] data = new Object[5][2];
//		
//		data[0][0] = "test12345@gmail.com";
//		data[0][1] ="Test@123" ;
//		
//		data[1][0] = "smartdivya234@gmail.com";
//		data[1][1] ="Test@1234" ;
//		data[2][0] = "13333sffdsf";
//		data[2][1] ="dasfsdfsdfsf" ;
//		data[3][0] = "###################";
//		data[3][1] ="EEEEEEEEEEE" ;
//		data[4][0] = "test12345@gmail.com";
//		data[4][1] ="Test@123" ;
//		
//		return data;
				
	
	return new Object[][] {
		{"test12345@gmail.com","Test@123"},
		{"smartdivya234@gmail.com","Test@1234"},
		{"13333sffdsf","dasfsdfsdfsf"},
		{"   ","  "},
		{"test12345@gmail.com","Test@123"}};
		
		
	}
	
	@Test(dataProvider="getLoginData")
	public void loginToOpenCart(String userName, String password)

	{
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys(userName);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		String alertMsg = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
		Assert.assertTrue(alertMsg.contains("Warning: No match for E-Mail Address and/or Password"));
	}
		
	

}
