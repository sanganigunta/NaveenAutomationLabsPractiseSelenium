package naveenAutomationLabsSeleniumConcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {

	private static WebDriver driver = null;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement getLocator(By locator) {
		return driver.findElement(locator);
	}

	public static void dosendKeys(By locator, String value) {
		getLocator(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getLocator(locator).click();
	}

	public String performGetText(By locator) {
		return getLocator(locator).getText();
	}

	public static By useStringRepo(String locatorType, String locatorValue)

	{
		By locator = null;
		switch (locatorType) {

		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;

		default:
			System.out.println("Please pass the correct locator");
			break;

		}
		return locator;
	}

	public boolean isDisplayed(By locator) {
		return getLocator(locator).isDisplayed();
	}

	public String getAttributeValuefrominputField(By locator, String attributeVal) {
		return getLocator(locator).getAttribute(attributeVal);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getCountofWebElements(By locator) {
		return getElements(locator).size();
	}

	public void selectSuggestionsfromSection(By locator, String linkvalue) {
		List<WebElement> SugesstionsList = getElements(locator);
		for (WebElement e : SugesstionsList) {
			String footerlinkstext = e.getText().trim();
			if (footerlinkstext.contains(linkvalue)) {
				e.click();
				break;
			}
		}
	}

	public List<String> printGetTextAsListValue(By locator) {
		List<String> elementsList = new ArrayList<String>();
		List<WebElement> SugesstionsList = getElements(locator);
		for (WebElement e : SugesstionsList) {
			String footerlinkstext = e.getText().trim();

			elementsList.add(footerlinkstext);

		}
		return elementsList;

	}

	public void printAllsugesstionsText(By locator) {
		List<WebElement> SugesstionsList = getElements(locator);
		for (WebElement e : SugesstionsList) {
			String footerlinkstext = e.getText().trim();
			System.out.println(footerlinkstext.trim());

		}
	}

	// ########################################Dropdown utils################################################

	public void useSelectByIndex(By locator, int indexVal) {
		WebElement drpelement = getLocator(locator);
		Select select = new Select(drpelement);
		select.selectByIndex(indexVal);
	}

	public void useSelectByVisiableValue(By locator, String visiableVal) {
		WebElement drpelement = getLocator(locator);
		Select select = new Select(drpelement);
		select.selectByValue(visiableVal);
	}

	public void useDrpSelectByValue(By locator, String value) {
		WebElement drpelement = getLocator(locator);
		Select select = new Select(drpelement);
		select.selectByValue(value);
	}
	public void selectDrpElementsUsingOptions(By locator, String optionVal)
	{
		WebElement drpElement = getLocator(locator);
		Select select = new Select(drpElement);
		List<WebElement> countryDrpEles = select.getOptions();
		for(WebElement e:countryDrpEles)
		{
			String drpEleText = e.getText().trim();
			System.out.println(drpEleText);
			if(drpEleText.contains(optionVal))
			{
				e.click();
				break;
			}
		}
		
		}
	public List<String> selectDrpElementsUsingOptionsList(By locator)
	{
		List<String> listDrpElements = new ArrayList<String>();
		WebElement drpElement = getLocator(locator);
		Select select = new Select(drpElement);
		List<WebElement> countryDrpEles = select.getOptions();
		for(WebElement e:countryDrpEles)
		{
			String drpEleText = e.getText().trim();
			listDrpElements.add(drpEleText);
		}
		
		return listDrpElements;
	}
	
	public void selectDrpElementsWithoutUsingSelect(By locator, String value)
	{
		List<WebElement> drpElementsList = getElements(locator);
		for(WebElement e:drpElementsList)
		{
			String drpElementsText = e.getText().trim();
			System.out.println(drpElementsText);
			if(drpElementsText.contains(value))
			{
				e.click();
				break;
			}
		}
	}


	
}
