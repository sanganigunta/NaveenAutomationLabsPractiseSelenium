package test;

import org.testng.annotations.Test;

public class DependsOnMethodConcept {
	
	@Test()
	public void homePgaeTest()
	{
		System.out.println("Home page test");
		
	}
	
	@Test(dependsOnMethods={"homePgaeTest"})
	public void searchPagetTest()
	{
		System.out.println("search page test");
		
	}
	
	@Test(dependsOnMethods={"homePgaeTest"})
	public void addToCartTest()
	{
		System.out.println("ADDTOCART page test");
		
	}

}
