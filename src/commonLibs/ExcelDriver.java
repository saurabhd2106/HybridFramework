package commonLibs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {
	
	private InputStream oFileReader;
	private OutputStream oFileWriter;
	private Workbook oExcelWorkbook;
	private String sExcelFileName;
	
	public void createExcelWorkbook(String sFilename){
		
		try {
			
			sFilename = sFilename.trim();
			
			if(sFilename.isEmpty()){
				throw new Exception("Invalid file name..");
			}
			
			if(new File(sFilename).exists()){
				throw new Exception("File already exists");
			}
			
			if(sFilename.endsWith("xlsx")) {
				oExcelWorkbook = new XSSFWorkbook();
			} else if(sFilename.endsWith("xls")){
				oExcelWorkbook = new HSSFWorkbook();
			} else {
				throw new Exception("Invalid File Extension...");
			}
			
			oFileWriter = new FileOutputStream(sFilename);
			oExcelWorkbook.write(oFileWriter);
			oFileWriter.close();
			oExcelWorkbook.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//----------------------------------------------------------------------------
	
	public void openExcelSheet(String sFileName){
		try {
			
			sFileName = sFileName.trim();
			
			if(sFileName.isEmpty()){
				System.out.println("File Name not specified");
			}
			
			if(! (new File(sFileName)).exists()){
				throw new Exception("File doesnot exist.. ");
			}
			
			oFileReader = new FileInputStream(sFileName);
			sExcelFileName = sFileName;
			
			oExcelWorkbook = WorkbookFactory.create(oFileReader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//----------------------------------------------------------------------------
	
	public void save(){
		try {
			
			oFileWriter = new FileOutputStream(sExcelFileName);
			oExcelWorkbook.write(oFileWriter);
			
			oFileWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//----------------------------------------------------------------------------
	
	
	public void saveAs(String sFileNewName){
		try {
			
			if(sFileNewName.isEmpty()){
				throw new Exception("File name does not exists");
			}
			
			if((new File(sFileNewName)).exists()){
				throw new Exception("File already exists");
			}
			
			oFileWriter = new FileOutputStream(sFileNewName);
			oExcelWorkbook.write(oFileWriter);
			
			oFileWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------
	
	public void close(){
		try {
			
			oExcelWorkbook.close();
			oFileReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------
	
	public void createSheet(String sSheetName){
		try {
			
			sSheetName = sSheetName.trim();
			
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified..");
			}
			
			Sheet oSheet;
			
			oSheet = oExcelWorkbook.getSheet(sSheetName);
			
			if(oSheet != null){
				throw new Exception("Sheet Already exist...");
			}
			
			oExcelWorkbook.createSheet(sSheetName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//----------------------------------------------------------------------------
	
	public int getRowCountoFSheet(String sSheetName){
		try {
			
			sSheetName = sSheetName.trim();
			
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified..");
			}
			
			Sheet oSheet;
			
			oSheet = oExcelWorkbook.getSheet(sSheetName);
			
			if(oSheet == null){
				throw new Exception("Sheet doesnot exist...");
			}
			
			return oSheet.getLastRowNum();
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//----------------------------------------------------------------------------
	
	public int getCellCount(String sSheetName, int iRow){
		try {
			
			sSheetName = sSheetName.trim();
			
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified..");
			}
			
			Sheet oSheet;
			
			oSheet = oExcelWorkbook.getSheet(sSheetName);
			
			if(oSheet == null){
				throw new Exception("Sheet doesnot exist...");
			}
			
			if(iRow < 1){
				throw new Exception("Row Index start from 1");
			}
			
			Row oRow;
			
			oRow = oSheet.getRow(iRow);
			if(oRow == null ){
				return 0;
			} else {
				return oRow.getLastCellNum();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//----------------------------------------------------------------------------
	
	@SuppressWarnings("deprecation")
	public String getCellData(String sSheetName, int iRow, int iCell){
try {
			
			sSheetName = sSheetName.trim();
			
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified..");
			}
			
			Sheet oSheet;
			
			oSheet = oExcelWorkbook.getSheet(sSheetName);
			
			if(oSheet == null){
				throw new Exception("Sheet doesnot exist...");
			}
			
			if(iRow < 1 || iCell < 1){
				throw new Exception("Row and cell Index start from 1");
			}
			
			Row oRow;
			
			oRow = oSheet.getRow(iRow-1);
			if(oRow == null ){
				return "";
			} 
			
			Cell oCell;
			
			oCell = oRow.getCell(iCell-1);
			
			if(oCell == null ){
				return "";
			} else {
				
				
				if(oCell.getCellType() == Cell.CELL_TYPE_NUMERIC){
					return String.valueOf((int) oCell.getNumericCellValue());
			} else {
				return oCell.getStringCellValue();
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	//----------------------------------------------------------------------------
	
	public void setCellData(String sSheetName, int iRow, int iCell, String sValue){
try {
			
			sSheetName = sSheetName.trim();
			
			if(sSheetName.isEmpty()){
				throw new Exception("Sheet name not specified..");
			}
			
			Sheet oSheet;
			
			oSheet = oExcelWorkbook.getSheet(sSheetName);
			
			if(oSheet == null){
				throw new Exception("Sheet doesnot exist...");
			}
			
			if(iRow < 1 || iCell < 1){
				throw new Exception("Row and cell Index start from 1");
			}
			
			Row oRow;
			
			oRow = oSheet.getRow(iRow-1);
			if(oRow == null ){
				oSheet.createRow(iRow-1);
				oRow = oSheet.getRow(iRow-1);
			} 
			
			Cell oCell;
			
			oCell = oRow.getCell(iCell-1);
			
			if(oCell == null ){
				oRow.createCell(iCell-1);
				oCell = oRow.getCell(iCell-1);
			} 
			oCell.setCellValue(sValue);
}
			
			
		 catch (Exception e) {
			e.printStackTrace();
		
		}
	
	}
	
//----------------------------------------------------------------------------
}
