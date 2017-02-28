package test;

import commonLibs.ExcelDriver;

public class DemoExcelDriver1 {

	public static void main(String[] args) {
		
		ExcelDriver oExcel = new ExcelDriver();
		
		String sFileName = "C:\\Users\\computer\\workspace\\EdurekaFramework\\output\\demo.xlsx";
		String sSheetName = "Test";
		
		oExcel.createExcelWorkbook(sFileName);
		oExcel.openExcelSheet(sFileName);
		
		oExcel.createSheet(sSheetName);
		
		oExcel.setCellData(sSheetName, 1, 1, "Saurabh");
		oExcel.setCellData(sSheetName, 1, 2, "Dhingra");
		oExcel.setCellData(sSheetName, 2, 1, "Anuj");
		oExcel.setCellData(sSheetName, 2, 2, "Yadav");
		oExcel.setCellData(sSheetName, 3, 1, "Vishal");
		oExcel.setCellData(sSheetName, 3, 2, "Singh");
		oExcel.setCellData(sSheetName, 4, 1, "Sunil");
		oExcel.setCellData(sSheetName, 4, 2, "Dewan");
		
		oExcel.save();
		
		oExcel.close();
	}

}
