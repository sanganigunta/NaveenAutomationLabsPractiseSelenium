package test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoCartTest extends BaseTest{

	
	
	@Test(priority=1)
	public void getTitleTest()
	{
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Your Store"));
	}

	@Test()
	public void getCurrentUrlTest()
	{
		//System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("opencart"));
	}
	@Test()
	public void getPageSourceTest()
	{
		Assert.assertTrue(driver.getPageSource().contains("Your Store"));
	}
	
	
	
}
