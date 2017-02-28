package test;

import commonLibs.AmazonPOM1Style;
import commonLibs.CommonDriver;

public class DemoAmazomPOM1Style {

	public static void main(String[] args) {
		
			CommonDriver oBrowser = new CommonDriver();
			
			
			oBrowser.setPageLoadTimeout(90l);
			oBrowser.setElementDetectionTimeout(90l);
			
			oBrowser.openBrowser("chrome", "http://www.amazon.in");
			
			AmazonPOM1Style oHomePage = new AmazonPOM1Style(oBrowser.getDriver());
			
			oHomePage.oSearchEdit.sendKeys("Apple Watche");
			oHomePage.oSearchList.selectByVisibleText("Watches");
			
			oHomePage.oSearchButton.click();
			
	}

}
