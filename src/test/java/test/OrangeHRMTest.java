package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRMTest extends BaseTest {



	@Test(priority=1)
	public void getTitle()
	{
		driver.get("https://www.orangehrm.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "OrangeHRM HR Software | Free &amp; Open Source HR Software | HRMS | HRIS");
	}

	@Test()
	public void getCurrentUrl()
	{
		System.out.println(driver.getCurrentUrl());
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.orangehrm.com/");
	}
	@Test()
	public void getPageSource()
	{
		
		Assert.assertTrue(driver.getPageSource().contains("Orange"));
	}
	
	
}
