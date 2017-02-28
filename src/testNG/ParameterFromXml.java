package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;

public class ParameterFromXml {
	
	CommonDriver oBrowser = new CommonDriver();
	String sUrl = "http://www.demo.guru99.com/v4";
	
	@BeforeMethod
	public void setup(){
		
		oBrowser.setPageLoadTimeout(40l);
		oBrowser.setElementDetectionTimeout(30l);
	}
	
	@Parameters ({ "browser", "username", "password"})
	@Test 
	public void login(String sBrowser, String sUsername, String sPassword){
		oBrowser.openBrowser(sBrowser , sUrl);
		
		oBrowser.setText(By.name("uid"), sUsername);
		oBrowser.setText(By.name("password"), sPassword);
		
		oBrowser.click(By.name("btnLogin"));
		String sTitle = oBrowser.getTitle();
		Assert.assertTrue(sTitle.equals("Guru99 Bank Manager HomePage"));
	}
	
	@Parameters ({  "username", "password"})
	@Test 
	public void loginToGuru99( String sUsername, String sPassword){
		oBrowser.openBrowser("chrome" , sUrl);
		
		oBrowser.setText(By.name("uid"), sUsername);
		oBrowser.setText(By.name("password"), sPassword);
		
		oBrowser.click(By.name("btnLogin"));
		String sTitle = oBrowser.getTitle();
		Assert.assertTrue(sTitle.equals("Guru99 Bank Manager HomePage"));
	}
	
	
	@AfterMethod
	public void teardown(){
		oBrowser.closeBrowser();
	}
	
	

}
