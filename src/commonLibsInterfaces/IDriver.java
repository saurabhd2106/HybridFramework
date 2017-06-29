package commonLibsInterfaces;

public interface IDriver {
	
	public void openBrowser(String url) throws Exception;
	
	public void closeBrowser() throws Exception;
	
	public void closeAllBrowser() throws Exception;
	
	public void setPageLoadTimeout(long pageLoadTimeout) throws Exception;
	
	public void setElementDetectionTimeout(long elementDetectionTimeout) throws Exception;
	
	public String getTitle() throws Exception;
	
	public String getPageSource() throws Exception;
	
	public String getCurrentUrl() throws Exception;
	
	public void navigateTo(String url) throws Exception;
	
	public void navigateRefresh() throws Exception;
	
	public void navigateForward() throws Exception;
	
	public void navigateBack() throws Exception;
	

}
