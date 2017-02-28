package test;


import commonLibs.AmazonPOM3Style;
import commonLibs.CommonDriver;

public class DemoPOM3Style {

	public static void main(String[] args) {
		
CommonDriver oBrowser = new CommonDriver();
		
		
		oBrowser.setPageLoadTimeout(90l);
		oBrowser.setElementDetectionTimeout(90l);
		
		oBrowser.openBrowser("chrome", "http://www.amazon.in");
		
		AmazonPOM3Style oHomePage = new AmazonPOM3Style(oBrowser.getDriver());
		
		
		oHomePage.searchProduct("Apple Watches", "Watches");

	}

}
