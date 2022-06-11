package naveenAutomationLabsSeleniumConcepts;

import java.net.MalformedURLException;
import java.net.URL;

public class UtilTest {
	
	public static void main(String args[]) throws MalformedURLException {
	
	BrowserUtil test = new BrowserUtil();
	
	test.initializeBrowser("chrome");
	test.navigateToUrl("https://www.flipkart.com/");
	System.out.println(test.getTitle());
	System.out.println(test.getCurrentUrl());
	//System.out.println(test.getSourceCode().contains("Registered Office Address"));
	//test.quit();
	//test.close();
	
    test.navigateToUrl(new URL("https://www.amazon.com/"));
    System.out.println(test.getTitle());
    
    test.navigateBackword();
    System.out.println(test.getTitle());
    
    test.navigateForword();
    System.out.println(test.getTitle());
    
    test.performRefresh();
	
	
	
	
	}
	

}
