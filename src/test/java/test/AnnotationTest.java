package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationTest {
	@BeforeSuite()
	public void connectToDB()
	{
		System.out.println("BS==========>Connect to DB");
	}
	
	@BeforeTest()
	public void createUser()
	{
		System.out.println("BT================>Create an user");
	}
	
	@BeforeClass()
	public void launchBrowser()
	{
		System.out.println("BC====================>Launch Browser");
	}
	
	@BeforeMethod()
	public void setup()
	{
		System.out.println("BM===========>calling setUp");
	}
	@Test()
	public void getTitle()
	{
		System.out.println("Title of the page");
	}
	
	@Test()
	public void getCurrentUrl()
	{
		System.out.println("Current url of the page");
	}
	
	@Test()
	public void Login()
	{
	System.out.println("User loggedIn");	
	}
	
	@AfterMethod
	public void tearDown()
	{
		System.out.println("AF==============>closing the browser");
	}
	
	@AfterClass
	public void logOut()
	{
		System.out.println("AC============>logOut from app");
	}
	
	@AfterTest
	public void deleteUser()
	{
		System.out.println("AT================>Delete the use");
	}
	
	@AfterSuite
	public void disconnectToDB()
	{
		System.out.println("AS===============>Disconnect to DB");
	}

}
