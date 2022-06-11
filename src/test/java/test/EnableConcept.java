package test;

import org.testng.annotations.Test;

public class EnableConcept {
	
	@Test(enabled=false, alwaysRun=true)
	public void homePageTest()
	{
		System.out.println("Test HP");
	}
	
	@Test()
	public void loginPageTest()
	{
		System.out.println("Login page");
	}

}
