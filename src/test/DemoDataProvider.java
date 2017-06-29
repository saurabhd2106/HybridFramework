package test;

import org.testng.annotations.Test;

import utility.ReadDataFromExcelFromDataProvider;
import utility.Utils;

public class DemoDataProvider {
	String excelFileName = "C:\\Users\\Saurabh Dhingra\\workspace_qa\\ModularFramework\\input\\TestData.xlsx";
	String sheetName = "SignInData";
	ReadDataFromExcelFromDataProvider dataReader
	= new ReadDataFromExcelFromDataProvider(excelFileName, sheetName);
	
	@Test(dataProvider="getData", dataProviderClass=utility.ReadDataFromExcelFromDataProvider.class)
	public void printData(String emaild, String password){
		System.out.println("emaild : "+ emaild );
	}
	
}
