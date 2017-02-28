package test;

import org.openqa.selenium.By;

import commonLibs.CommonDriver;

public class BOTStyle {

	public static void main(String[] args) {
		String sUrl = "http://www.amazon.in";
		
		CommonDriver oBrowser = new CommonDriver();
		
		oBrowser.setElementDetectionTimeout(90l);
		oBrowser.setPageLoadTimeout(90l);
		
		oBrowser.openBrowser("chrome", sUrl);
		oBrowser.setText(By.id("twotabsearchtextbox"), "Apple Watches");
	//	oBrowser.setText(By.id("twotabsearchtext"), "Apple Watches");
		
		oBrowser.selectElmentByVisibleText(By.id("searchDropdownBox"), "Watches");
		
		oBrowser.click(By.xpath("//input[@value='Go']"));
		
		String sResult = oBrowser.getText(By.id("s-result-count"));
		
		System.out.println("Result is : "+ sResult);
	}

}
