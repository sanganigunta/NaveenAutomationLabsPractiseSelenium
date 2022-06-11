package naveenAutomationLabsSeleniumConcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsConcepts {

	static WebDriver driver;
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smart\\OneDrive\\Documents\\code\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/register");
//		List<WebElement> links = driver.findElements(By.tagName("a"));
//		int size = links.size();
//		System.out.println(size);
//		
//		for(int i = 0;i<size;i++)
//		{
//			String linkText = links.get(i).getText();
//			String hrefVal =links.get(i).getAttribute("href");
//			if(!linkText.isEmpty()) {
//			System.out.println(linkText+" : "+hrefVal);
//			}
//		}
		
//		for(WebElement link: links)
//		{
//			String linkText = link.getText();
//			String linkhrefVal = link.getAttribute("href");
//			if(!linkText.isEmpty()) {
//			System.out.println(linkText+" : "+linkhrefVal);
//			}
//		}
				
		
		//links.stream().forEach(ele ->System.out.println(ele.getText()));
		//links.stream().filter(ele->!ele.getText().isEmpty()).forEach(e->System.out.println(e.getText()));
		
		//links.parallelStream().filter(e->!e.getText().isEmpty()).forEach(e->System.out.println(e.getText()+":"+e.getAttribute("href")));
		
		ElementUtil eUtil = new ElementUtil(driver);
		By amazonlinks = By.className("form-control");
		
		List<WebElement> links = eUtil.getElements(amazonlinks);
		int linksCount = eUtil.getCountofWebElements(amazonlinks);
		System.out.println(linksCount);
		
		for(WebElement e: links)
			
		{
			//String altText = e.getAttribute("alt");
			//String hrefVal = e.getAttribute("src");
			
			
//			if(!(altText.isEmpty()&&hrefVal.isEmpty())) {
//				
//				System.out.println(e.getAttribute("alt")+":"+e.getAttribute("src"));		
//				
//			}
			
			String placeholderVal = e.getAttribute("placeholder");
			if(!placeholderVal.isEmpty())
			{
				System.out.println(placeholderVal);
			}
//			
			
		}

	}
	
//	public static List<WebElement> getElements(By locator)
//	{
//		return driver.findElements(locator);
//	}
//	
//	public static int getCountofWebElements(By locator)
//	{
//		return getElements(locator).size();
//	}

}
