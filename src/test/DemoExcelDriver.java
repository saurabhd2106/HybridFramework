package test;

import commonLibs.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) {
		String sWorkbook = "C:\\workspace_edureka\\EdurekaFramework\\output\\text2.xlsx";
		
		String sSheetName = "Testsuite";
		ExcelDriver oExcel = new ExcelDriver();
		
		oExcel.createExcelWorkbook(sWorkbook);
		
		oExcel.openExcelSheet(sWorkbook);
		
		oExcel.createSheet(sSheetName);
	
		oExcel.setCellData(sSheetName, 1, 1, "Saurabh");
		oExcel.setCellData(sSheetName, 1, 2, "Dhingra");
		oExcel.setCellData(sSheetName, 2, 1, "MOhit");
		oExcel.setCellData(sSheetName, 2, 2, "Sharma");
		oExcel.setCellData(sSheetName, 3, 1, "Saurabh");
		oExcel.setCellData(sSheetName, 3, 2, "Dhingra");
		
		oExcel.save();
		
		oExcel.close();
	}

}
