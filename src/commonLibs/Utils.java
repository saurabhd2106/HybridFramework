package commonLibs;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;

public class Utils {
	
	public static void waitForSeconds(long seconds){
		try {
			
			Thread.sleep(seconds*1000L);
		} catch (Throwable t) {
			
			t.printStackTrace();
		}
	}
	
	
	public static By getLocatorBy(String sLocatorString){
		try{
			
			String[] aLocator;
			
			sLocatorString = sLocatorString.trim();
			if(sLocatorString.isEmpty() || ! sLocatorString.contains(":=")){
				
				throw new Exception("Invalid Locator String");
			} 
			
			aLocator = sLocatorString.split(":=");
			
			if(aLocator[0].equalsIgnoreCase("id")){
				return By.id(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("Class")){
				return By.className(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("xPath")){
				return By.xpath(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("css")){
				return By.cssSelector(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("link")){
				return By.linkText(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("partialLink")){
				return By.partialLinkText(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("name")){
				return By.name(aLocator[1]);
			}
			
			if(aLocator[0].equalsIgnoreCase("tagname")){
				return By.tagName(aLocator[1]);
			}
			
			throw new Exception("Invalid locator String...");
			
		} catch(Throwable t){
			System.err.println(t.getMessage());
			return null;
		}
	}
	//----------------------------------------------------------------
	public static Properties getProperties(String sPropertiesFile){
		
		try {
			InputStream oFileReader;
			Properties oProperty;
			
			oFileReader = new FileInputStream(sPropertiesFile);
			oProperty = new Properties();
			
			oProperty.load(oFileReader);
			
			return oProperty;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			return null;
		}
		
		
	}
	
	//---------------------------------------------------------------
	
	public static String getDateTimeStamp(){

		Date oDate;
		String[] sDatePart;
		String sDateStamp;
		
		
		oDate = new Date();
		System.out.println(oDate.toString());
		//Mon Sep 07 17:28:42 IST 2015

		sDatePart = oDate.toString().split(" ");
		
		sDateStamp = sDatePart[5] + "_" +
				sDatePart[1] + "_" +
				sDatePart[2] + "_" +
				sDatePart[3] ;
		
		sDateStamp = sDateStamp.replace(":",  "_");
		System.out.println(sDateStamp);
		
		//2016_Jan_31_10_47_48
		return sDateStamp;
	}

}
