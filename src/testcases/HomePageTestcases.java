package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;



public class HomePageTestcases extends BaseScenarios {
	
	
	
	@Test (priority=1)
	public void verifyTitleOfHomePage(){
		try {
			Assert.assertEquals(cmnDriver.getTitle(), 
					configProperty.getProperty("homePageTitle"));
			
		} catch (Exception e) {
			
			
			
			CommonDriver.log.error(e.getStackTrace());
		}
	}
	
	@Test (priority=10)
	public void verifyUserLogin(){
		
		try {
			String emailId = configProperty.getProperty("emailId");
			String password = configProperty.getProperty("password");
			homePage.userLogin(emailId, password);
			String welcomeText = String.format("Welcome, %s",
					configProperty.getProperty("usernameFirstname"));
			
			Assert.assertEquals(homePage.getWelcomeText(), welcomeText);
		} catch (Exception e) {
			
			CommonDriver.log.error("Verify USer Login Failed with reason :: "+ e.getMessage());
		}
	}
	
}
