package Libraries;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	private XSSFWorkbook xlWorkBook;
	private XSSFSheet xlsSheet;
	private XSSFCell xlsCell;
	private XSSFRow xlsRow;
	public  int RowCount;
	
	private String xlFileName;
	
	public ExcelUtil(String xlFileName, String SheetName) throws IOException {		
		try {			
			FileInputStream ExcelFile = new FileInputStream (xlFileName);
			xlWorkBook = new XSSFWorkbook(ExcelFile);
			xlsSheet =  xlWorkBook.getSheet(SheetName);			
		}catch (Exception e) {			
			throw(e);			
		}
	}
	
	public int RowCount() throws IOException {
		try {			
			RowCount = xlsSheet.getLastRowNum();
			return RowCount;
		}catch (Exception e) {			
			throw(e);			
		}		
	}
	
	public String GetCellData(int RowNumber, int ColNumber) throws IOException{
		try {
			xlsCell = xlsSheet.getRow(RowNumber).getCell(ColNumber);			
			String CellData = xlsCell.getStringCellValue();
			return CellData;
		}catch(Exception e) {			
			throw(e);
		}	
	}
			
	public void SetCellData(int RowNumber, int ColNumber, String CellValue) throws IOException{
		try {
			xlsRow = xlsSheet.getRow(RowNumber);
			
			xlsCell = xlsRow.getCell(ColNumber);
			
			if(xlsCell == null) {				
				xlsCell = xlsRow.createCell(ColNumber);
				xlsCell.setCellValue(CellValue);
			}else {
				xlsCell.setCellValue(CellValue);				
			}			
			
			FileOutputStream fileout = new FileOutputStream(xlFileName);
			xlWorkBook.write(fileout);
			fileout.flush();
			fileout.close();		
			
		}catch(Exception e) {
			throw(e);			
		}		
	}
	
	
	
}
