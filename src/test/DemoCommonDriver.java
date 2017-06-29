package test;

import commonLibs.CommonDriver;

public class DemoCommonDriver {

	public static void main(String[] args) {
		
		try {
			CommonDriver Driver = new CommonDriver("chrome");
			
			Driver.setPageLoadTimeout(40l);
			
			Driver.setElementDetectionTimeout(20l);
			
			Driver.openBrowser("http://qatechhub.com");
			
			System.out.println(Driver.getTitle());
			
			Driver.closeAllBrowser();
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
