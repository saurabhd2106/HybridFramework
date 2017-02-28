package testNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;

public class ParameterizeExample {
	
	CommonDriver oBrowser = new CommonDriver();
	String sUrl = "http://www.demo.guru99.com/v4";
	
	@BeforeMethod
	public void setup(){
		
		oBrowser.setPageLoadTimeout(40l);
		oBrowser.setElementDetectionTimeout(30l);
	}
	
	@Test (dataProvider = "getValue")
	public void login(String sUsername, String sPassword){
		oBrowser.openBrowser("chrome", sUrl);
		
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
	
	@DataProvider
	public Object[][] getValue(){
		
		Object[][] data = new Object[4][2];
		
		data[0][0] = "mngr37581";
		data[0][1] = "AgEtuty";
		data[1][0] = "mngr37580";
		data[1][1] = "somepassword";
		data[2][0] = "mngr37581";
		data[2][1] = "AgEtuty";
		data[3][0] = "mngr37581";
		data[3][1] = "ghghgh";
		
		return data;
		
	}

}
