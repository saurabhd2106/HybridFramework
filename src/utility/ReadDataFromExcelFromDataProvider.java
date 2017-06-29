package utility;

import org.testng.annotations.DataProvider;

public class ReadDataFromExcelFromDataProvider {
	
	private static ExcelDriver excelDriver;
	private static String excelFileName;
	private static String sheetName;
	
	public ReadDataFromExcelFromDataProvider(String _excelFileName, String _sheetName){
		excelFileName = _excelFileName;
		sheetName = _sheetName;
	}
	@DataProvider
	public static Object[][] getData() throws Exception{
		Object[][] data;
		
		excelDriver = new ExcelDriver();
		
		excelDriver.openExcelWorkbook(excelFileName);
		
		int numberOfRows = excelDriver.getRowCountOfSheet(sheetName);
		int numberOfCellsInFirstRow = excelDriver.getCellCountFromARow(sheetName, 1); 
		int numberOfCellsInARow;
		
		data = new Object[numberOfRows][numberOfCellsInFirstRow];
		for (int iRow = 1; iRow<= numberOfRows; iRow++){
			
			numberOfCellsInARow = excelDriver.getCellCountFromARow(sheetName, iRow);
			
			for(int iCell = 1; iCell <= numberOfCellsInARow; iCell++ ){
				
				data[iRow-1][iCell-1] = excelDriver.getCellData(sheetName, iRow, iCell);
			}
			
		}
		
		return data;
	}
 
}
