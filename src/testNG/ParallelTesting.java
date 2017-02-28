package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;

public class ParallelTesting {
	CommonDriver oBrowser = new CommonDriver();
	String sUrl = "http://www.demo.guru99.com/v4";
	
	@BeforeMethod
	public void setup(){
		
		oBrowser.setPageLoadTimeout(40l);
		oBrowser.setElementDetectionTimeout(30l);
	}

	@Parameters ({"browser"})
	@Test 
	public void loginToGuru99(String sBrowserType){
		oBrowser.openBrowser(sBrowserType , sUrl);
		
		oBrowser.setText(By.name("uid"), "mngr37581");
		oBrowser.setText(By.name("password"), "AgEtuty");
		
		oBrowser.click(By.name("btnLogin"));
		String sTitle = oBrowser.getTitle();
		Assert.assertTrue(sTitle.equals("Guru99 Bank Manager HomePage"));
	}
	
	
	@AfterMethod
	public void teardown(){
		oBrowser.closeBrowser();
	}
	

}
