package test;

import org.testng.annotations.Test;

public class ExceptionConcept {
	
	
	String name="test";
	@Test(expectedExceptions ={ArithmeticException.class,NullPointerException.class})
	public void AEText()
	{
		System.out.println("AE test ");
		int a = 9/0;
		System.out.println(a);
		ExceptionConcept ac = new ExceptionConcept();
		ac=null;
		System.out.println(ac.name);
		
	}

}
