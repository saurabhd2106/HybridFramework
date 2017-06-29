package test;

import utility.ExcelDriver;

public class DemoExcelDrievr {

	public static void main(String[] args) {
		try {
			String filename = "Test.xlsx";
			
			String sheetName= "demoSheet";
			
			ExcelDriver excel = new ExcelDriver();
			
			excel.createExcelWorkbook(filename);
			
			excel.openExcelWorkbook(filename);
			
			excel.createSheet(sheetName);
			
			excel.setCellData(sheetName, 1, 1, "Saurabh");
			
			excel.setCellData(sheetName, 1, 2, "Dhingra");
			
			excel.setCellData(sheetName, 2, 1, "Rishab");
			
			excel.setCellData(sheetName, 2, 2, "Jain");
			
			excel.save();
			
			excel.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
