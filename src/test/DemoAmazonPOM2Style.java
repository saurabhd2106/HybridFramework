package test;

import commonLibs.AmazonPOM2Style;
import commonLibs.CommonDriver;

public class DemoAmazonPOM2Style {

	public static void main(String[] args) {
		
		CommonDriver oBrowser = new CommonDriver();
		
		
		oBrowser.setPageLoadTimeout(90l);
		oBrowser.setElementDetectionTimeout(90l);
		
		oBrowser.openBrowser("chrome", "http://www.amazon.in");
		
		AmazonPOM2Style oHomePage = new AmazonPOM2Style(oBrowser.getDriver());
		
		
		oHomePage.searchProduct("Apple Watches", "Watches");

	}

}
