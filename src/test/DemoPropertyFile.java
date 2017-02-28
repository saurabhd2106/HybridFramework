package test;

import java.util.Properties;

import commonLibs.Utils;

public class DemoPropertyFile {

	public static void main(String[] args) {

		Properties oProperty;
		
		oProperty = Utils.getProperties("C:\\workspace_edureka\\EdurekaFramework\\config\\test.properties");
		
		System.out.println(oProperty.getProperty("firstVariable"));

	}

}
