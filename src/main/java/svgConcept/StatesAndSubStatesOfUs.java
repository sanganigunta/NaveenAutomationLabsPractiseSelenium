package svgConcept;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatesAndSubStatesOfUs {
	static Actions action;
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	 WebDriverManager.chromedriver().setup();	
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.get("https://petdiseasealerts.org/forecast-map#/");
     
    
     
     action = new Actions(driver);
     
    String  stateName="Nevada";
    String subState="nevada";
     
    getShadowElement(stateName,subState);
	  
	}
	
	
	public static void getShadowElement(String stateName, String subState) 
	{
		 
		   List<WebElement> states =driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='states']//*[name()='path']"));
			 for(WebElement state:states)
		     {
		    	action.moveToElement(state).perform(); 
		    	String stateText= state.getAttribute("name");
		    	System.out.println(stateText.trim());
		    	
		    	if(stateText.equals(stateName))
		    	{
		    		state.click();

		   		 List<WebElement> substates =driver.findElements(By.xpath("//*[name()='g' and @id='"+subState+"']//*[name()='g' and @class='counties']//*[name()='path']"));
		   		 
		   			for(WebElement substate:substates)
		   			{
		   				
		   				action.moveToElement(substate).perform();
		   				String toolTipText = driver.findElement(By.className("tooltip")).getText();
		   				System.out.println(toolTipText);
		   			}
		    		break;
		    	}
		     }
	     
	}

}
