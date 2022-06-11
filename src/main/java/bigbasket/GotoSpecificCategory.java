package bigbasket;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GotoSpecificCategory {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	 WebDriverManager.chromedriver().setup();	
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
     driver.get("https://www.bigbasket.com/");
     
     Actions action = new Actions(driver);
     WebElement sbyBtn = driver.findElement(By.xpath("//li[@class='dropdown full-wid hvr-drop']"));
     action.moveToElement(sbyBtn).perform();
     
     List<WebElement> l1Categories =driver.findElements(By.xpath("//ul[@id='navBarMegaNav']//a"));
     
    int l1Size= l1Categories.size();
    System.out.println(l1Size);
    int ExecutionCount =0;
     for(WebElement e:l1Categories)
     {
    	 action.moveToElement(e).perform();
    	 String l1CatText = e.getText().trim();
    	 System.out.println(l1CatText);
    	 
    	 List<WebElement> l2Categories = driver.findElements(By.xpath("(//ul[contains(@class,'nav-stacked')])[last()]//a"));
    	 for(WebElement l2cat:l2Categories)
    	 {
    		 action.moveToElement(l2cat).perform();
    		 String l2CatText = l2cat.getText();
    		 System.out.println(l2CatText);
    	 
    	 
    	 List<WebElement> l3Category = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[last()-1]//a"));
    	 for(WebElement l3cat:l3Category)
    	 {
    		 action.moveToElement(l3cat).perform();
    		 String l3CatText = l3cat.getText().trim();
    	     System.out.println(l3CatText);
    	     List<WebElement> l4Category = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[last()]//a"));
        	 for(WebElement l4cat:l4Category)
        	 {
        		 action.moveToElement(l4cat).perform();
        		 String l4CatText = l4cat.getText().trim();
        	     System.out.println(l4CatText);
        	     ExecutionCount++;
            	 if(ExecutionCount==12)
            	 {
            		 break;
            	 }
    	 }
    	
    	 
    	 }

    	 }
    	
    	 
     }
     
     //System.out.println(ExecutionCount);
	}

}
