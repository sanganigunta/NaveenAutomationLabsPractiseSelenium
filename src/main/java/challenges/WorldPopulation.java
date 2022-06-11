package challenges;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorldPopulation {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement currentWP = driver.findElement(By.xpath("//div[@id='maincounter-wrap']/h1/../div[@class='maincounter-number']/span"));
		System.out.println(currentWP.getText());
		
//		String populationGrowthToday ="//div[@class='content-inner']//div[contains(@class,'col')]/div[text()='Today']/../div[contains(@class,'sec-box')]/div[@class='sec-text' and contains(text(),'Population Growth today')]/parent::div/div[@class='sec-counter']/span"; 
//		String birthsToday="//div[@class='content-inner']//div[contains(@class,'col')]/div[text()='Today']/../div[contains(@class,'sec-box')]/div[@class='sec-text' and contains(text(),'Births today')]/parent::div/div[@class='sec-counter']/span";
//		String deathsToday="//div[@class='content-inner']//div[contains(@class,'col')]/div[text()='Today']/../div[contains(@class,'sec-box')]/div[@class='sec-text' and contains(text(),'Deaths today')]/parent::div/div[@class='sec-counter']/span";
//		WebElement bT= driver.findElement(By.xpath(birthsToday));
//		WebElement DT= driver.findElement(By.xpath(populationGrowthToday));
//		WebElement pGT= driver.findElement(By.xpath(deathsToday));
//		
//		while(true) {
//		System.out.println("Todays birth count is: "+bT.getText());
//		System.out.println("Todays Death count is: "+DT.getText());
//		System.out.println("Todays Population Growth count is: "+pGT.getText());
//		
//		String birthsThisYear = "//div[@class='content-inner']//div[contains(@class,'col')]/div[text()='This year']/../div[contains(@class,'sec-box')]/div[contains(text(),'Births this year')]/../div[@class='sec-counter']/span";
//		String deathsThisYear ="//div[@class='content-inner']//div[contains(@class,'col')]/div[text()='This year']/../div[contains(@class,'sec-box')]/div[contains(text(),'Deaths this year')]/../div[@class='sec-counter']/span";
//		String populationGrowthThisYear ="//div[@class='content-inner']//div[contains(@class,'col')]/div[text()='This year']/../div[contains(@class,'sec-box')]/div[contains(text(),'Population Growth this year')]/../div[@class='sec-counter']/span";
//
//		
//		WebElement bTTY= driver.findElement(By.xpath(birthsThisYear));
//		WebElement DTTY= driver.findElement(By.xpath(deathsThisYear));
//		WebElement pGTTY= driver.findElement(By.xpath(populationGrowthThisYear));
//		
//		System.out.println("This year Births count is: "+(bTTY.getText()));
//		System.out.println("This year Deaths count is: "+DTTY.getText());
//		System.out.println("This yaer Population Growth count is: "+pGTTY.getText());
		
			
		
	}
}
