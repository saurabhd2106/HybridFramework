package test;

import java.util.Properties;

import utility.Utils;

public class DemoConfigFile {

	public static void main(String[] args) {
		
		try {
			Properties property = Utils.getProperty("C:\\Users\\Saurabh Dhingra\\workspace_qa\\ModularFramework\\connfig\\config.properties");
			
			System.out.println(property.get("browserType"));
			System.out.println(property.get("loginPageTitle"));
			System.out.println(property.get("emailId"));
			System.out.println(property.get("defaultUsername"));
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
