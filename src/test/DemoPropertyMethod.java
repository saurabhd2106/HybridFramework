package test;

import java.util.Properties;

import commonLibs.Utils;

public class DemoPropertyMethod {

	public static void main(String[] args) {
		
		Properties oProperty;
		oProperty = Utils.getProperties("C:\\Users\\computer\\workspace\\EdurekaFramework\\config\\config.properties");
		
		System.out.println(oProperty.getProperty("InputFileFolder"));
		System.out.println(oProperty.getProperty("DriverInputFile"));
		System.out.println(oProperty.getProperty("ResultFolder"));

	}

}
