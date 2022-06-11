package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{
	

	
	
		@Test(priority=1)
		public void getTitle()
		{
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Google");
		}
	
		@Test()
		public void getCurrentUrl()
		{
			System.out.println(driver.getCurrentUrl());
			Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");
		}
		@Test()
		public void getPageSource()
		{
			
			Assert.assertTrue(driver.getPageSource().contains("Google"));
		}
		
	
	

}
