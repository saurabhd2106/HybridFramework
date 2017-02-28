package commonLibs;


import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDriver {
	
	private WebDriver oDriver;
	private long pageLoadTimeout;
	private long elementDetectionTimeout;
	
	public CommonDriver(){
		pageLoadTimeout = 60l;
		elementDetectionTimeout = 60l;
	}

	public void setPageLoadTimeout(long pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementDetectionTimeout(long elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	
	public void openBrowser(String sBrowserType, String sUrl){
		
		try {
			
			sBrowserType = sBrowserType.trim();
			
			if(sBrowserType.equalsIgnoreCase("ff") || sBrowserType.equalsIgnoreCase("firefox")
					|| sBrowserType.equalsIgnoreCase("mozilla firefox") || sBrowserType.equalsIgnoreCase("mozilla")) {
				
				oDriver = new FirefoxDriver();
			} else if(sBrowserType.equalsIgnoreCase("chrome") || sBrowserType.equalsIgnoreCase("google")
					|| sBrowserType.equalsIgnoreCase("google chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "C:\\workspace\\libs\\chromedriver.exe");
				oDriver = new ChromeDriver();
			} else if(sBrowserType.equalsIgnoreCase("ie") || sBrowserType.equalsIgnoreCase("internet")
					|| sBrowserType.equalsIgnoreCase("internet explorer") || sBrowserType.equalsIgnoreCase("explorer")) {
				
				System.setProperty("webdriver.ie.driver", "C:\\workspace\\libs\\IEDriverServer.exe");
				oDriver = new InternetExplorerDriver();
			} 
			
			else {
				throw new Exception("Invalid Browser Type");
			}
			
			sUrl = sUrl.trim();
			
			if(sUrl.isEmpty() || sUrl == null ){
				oDriver.get("about:blank");
			}
			
		
			oDriver.manage().window().maximize();
			
			oDriver.manage().deleteAllCookies();
			
			oDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
			oDriver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
			
			oDriver.get(sUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public void closeBrowser(){
		try {
			
			if(oDriver != null){
				oDriver.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public void closeAllBrowser(){
		try {
			
			if(oDriver != null){
				oDriver.quit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------------
	
	public void takeSnapshot(String sImageFilename){
		try {
			TakesScreenshot oCamera;
			File tmpFile, oImageFile;
			
			oImageFile = new File(sImageFilename);
			
			if( new File(sImageFilename).exists()){
				throw new Exception("File already exists..");
							}
			
			oCamera= (TakesScreenshot) oDriver;
			
			tmpFile = oCamera.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(tmpFile, oImageFile);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//----------------------------------------------------------------------------------------
	
	public void waitTillElementVisible(By oBy, long timeoutInSeconds){
		
		try {
			
			WebDriverWait oWait = new WebDriverWait(oDriver, timeoutInSeconds);
			oWait.until(ExpectedConditions.visibilityOfElementLocated(oBy));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public WebDriver getDriver(){
		try {
			return oDriver;
		} catch (Exception e) {
			return null;
		}
	}
	//--------------------------------------------------------------------------------------------
	
	public void click(By oBy){
		
		try {
			
			oDriver.findElement(oBy).click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//--------------------------------------------------------------------------------------------
	
	public void setText(By oBy, String sText){
		
		try {
			
			oDriver.findElement(oBy).sendKeys(sText);
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
	}
	//--------------------------------------------------------------------------------------------
	
	public void navigateTo(String sUrl){
		try {
			oDriver.navigate().to(sUrl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public void navigateBack(){
		try {
			oDriver.navigate().back();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public void refreshPage(){
		try {
			oDriver.navigate().refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public void navigateForward(){
		try {
			oDriver.navigate().forward();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//--------------------------------------------------------------------------------------------
	public void selectElmentByVisibleText(By oBy, String sText){
		try {
			Select oDropdown = new Select(oDriver.findElement(oBy));
			
			oDropdown.selectByVisibleText(sText);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//--------------------------------------------------------------------------------------------
	public void selectElmentByValue(By oBy, String sValue){
		try {
			Select oDropdown = new Select(oDriver.findElement(oBy));
			
			oDropdown.selectByValue(sValue);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	//--------------------------------------------------------------------------------------------
	public void selectElmentByIndex(By oBy, int index){
		try {
			Select oDropdown = new Select(oDriver.findElement(oBy));
			
			oDropdown.selectByIndex(index);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	
	public String getText(By oBy){
		try {
		return	oDriver.findElement(oBy).getText();
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	//--------------------------------------------------------------------------------------------
	
	public String getTitle(){
		try {
		return	oDriver.getTitle();
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	//--------------------------------------------------------------------------------------------
	
	public String getCurrentUrl(){
		try {
		return	oDriver.getCurrentUrl();
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	//--------------------------------------------------------------------------------------------
	
	public String getAttribute(By oBy, String sAttribute){
		try {
		return	oDriver.findElement(oBy).getAttribute(sAttribute);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public boolean isMultiple(By oBy){
		try {
		Select oDropdown = new Select(oDriver.findElement(oBy));
			
		return	oDropdown.isMultiple();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//--------------------------------------------------------------------------------------------
	public boolean isVisible(By oBy){
		try {
		
			
		return	oDriver.findElement(oBy).isDisplayed();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//--------------------------------------------------------------------------------------------
	
	public boolean isSelected(By oBy){
		try {
		
			
		return	oDriver.findElement(oBy).isSelected();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//----------------------------------------------------------------------------------
	public boolean isEnabled(By oBy){
		try {
		
			
		return	oDriver.findElement(oBy).isEnabled();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	//----------------------------------------------------------------------------------
	
	public void acceptAlert(){
		try {
			oDriver.switchTo().alert().accept();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------
	
	public void rejectAlert(){
		try {
			oDriver.switchTo().alert().dismiss();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------
	
	public void switchToFrame(String sId){
		
		try {
			oDriver.switchTo().frame(sId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//----------------------------------------------------------------------------------
	
	
	public void switchToFrame(int index){
		
		try {
			oDriver.switchTo().frame(index);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//----------------------------------------------------------------------------------
	
	public void switchToFrame(By oBy){
		
		try {
			oDriver.switchTo().frame(oDriver.findElement(oBy));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	//----------------------------------------------------------------------------------
	
	public String getSessionId(){
		try {
			return oDriver.getWindowHandle();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	//----------------------------------------------------------------------------------
	
	public void switchToChildWindow(){
		try {
			String sChildWindow;
			sChildWindow = oDriver.getWindowHandles().toArray()[1].toString();
			
			oDriver.switchTo().window(sChildWindow);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------
}
