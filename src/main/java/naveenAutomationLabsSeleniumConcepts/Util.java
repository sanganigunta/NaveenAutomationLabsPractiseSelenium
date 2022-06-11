package naveenAutomationLabsSeleniumConcepts;

import java.net.URL;

public interface Util {
	
	String CHROME_BROWSER ="chrome";
	String FIREFOX_BROWSER ="firefox";
	String EDGE_BROWSER ="edge";
	String SAFARI_BROWSER ="safari";
	String InternetExplorer_BROWSER ="ie";
	String Opera_BROWSER ="opera";

	
	public void navigateToUrl(String url);
	
	public String getTitle();
	public String getCurrentUrl();
	public String getSourceCode();
	public void quit();
	public void close();
	
	public void navigateToUrl(URL url);
	public void navigateForword();
	public void navigateBackword();
	public void performRefresh();
	
	
	
	

}
