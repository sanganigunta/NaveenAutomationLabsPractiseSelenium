package test;

import org.testng.annotations.Test;

public class TestcasePriority {
	
	
	@Test(priority=5)
	public void aTest()
	{
		System.out.println("test A");
		
	}
	
	@Test(priority=4)
	public void bTest()
	{
		System.out.println("test B");
	}
	
	@Test(priority=-1)
	public void cTest()
	{
		System.out.println("test C");
	}
	@Test(priority= 1)
	public void dTest()
	{
		System.out.println("test D");
	}
	@Test()
	public void eTest()
	{
		System.out.println("test E");
	}
	@Test()
	public void fTest()
	{
		System.out.println("test F");
	}
	

}
