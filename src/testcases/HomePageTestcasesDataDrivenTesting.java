package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import commonLibs.CommonDriver;
import utility.ReadDataFromExcelFromDataProvider;



public class HomePageTestcasesDataDrivenTesting extends BaseScenarios {
	
	
	
	@Test (priority=1)
	public void verifyTitleOfHomePage(){
		try {
			Assert.assertEquals(cmnDriver.getTitle(), 
					configProperty.getProperty("homePageTitle"));
			
		} catch (Exception e) {
			
			
			
			CommonDriver.log.error(e.getStackTrace());
		}
	}
	
	@Test (priority=10, dataProvider="getData", dataProviderClass=utility.ReadDataFromExcelFromDataProvider.class)
	public void verifyUserLogin(String emailId,String password ){
		
		try {
			
			String excelFileName = "C:\\Users\\Saurabh Dhingra\\workspace_qa\\ModularFramework\\input\\TestData.xlsx";
			String sheetName = "SignInData";
			
			ReadDataFromExcelFromDataProvider dataReader
			= new ReadDataFromExcelFromDataProvider(excelFileName, sheetName);
			
			
			homePage.userLogin(emailId, password);
			String welcomeText = String.format("Welcome, %s",
					configProperty.getProperty("usernameFirstname"));
			
			Assert.assertEquals(homePage.getWelcomeText(), welcomeText);
		} catch (Exception e) {
			
			CommonDriver.log.error("Verify USer Login Failed with reason :: "+ e.getMessage());
		}
	}
	
}
