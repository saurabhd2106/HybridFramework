package testcases;

import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import commonLibs.CommonDriver;
import mercuryTravel.MercuryTravelHomePage;
import mercuryTravel.SignIn;
import utility.Utils;

public class BaseScenarios {
	CommonDriver cmnDriver;
	MercuryTravelHomePage homePage;
	SignIn signInPage;
	Properties configProperty;
	private String configFilename;
	
	public BaseScenarios() {
		try {
			configFilename = "C:\\Users\\Saurabh Dhingra\\workspace_qa\\ModularFramework\\connfig\\config.properties";
			configProperty = Utils.getProperty(configFilename);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeClass (alwaysRun=true)
	public void setup(){
		try {
			cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));
			
			cmnDriver.setPageLoadTimeout(90l);
			
			cmnDriver.setElementDetectionTimeout(20l);
			
			homePage = new MercuryTravelHomePage(cmnDriver.getDriver());
			
			signInPage = new SignIn(cmnDriver.getDriver());
			
			cmnDriver.openBrowser(configProperty.getProperty("baseUrl"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		try {
			cmnDriver.closeAllBrowser();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
