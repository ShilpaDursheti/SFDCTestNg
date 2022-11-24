package com.training.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook ExcelWbook;
	static XSSFSheet ExcelWSheet;
	static XSSFRow Row;
	static XSSFCell Cell;
	
	public static Object[][]getTableArray(String filePath, String SheetName) throws IOException{
		
		String[][]tabArray = null;
		
		FileInputStream ExcelFile = new FileInputStream(filePath);
		
		ExcelWbook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWbook.getSheet(SheetName);
		int totalRows = ExcelWSheet.getLastRowNum();
		int totalCols = 2;
		tabArray = new String[totalRows][totalCols];
 		int ci = 0;
		
		for(int i = 1; i<=totalRows; i++, ci++) {
			int cj = 0;
			for(int j = 1; j<=totalCols; j++, cj++) {
				
				tabArray[ci][cj]= getCellData(i,j);
				System.out.println(tabArray[ci][cj]);				
			}
		}
		return tabArray;	
	}
	
	public static String getCellData(int RowNum, int ColNum) {
		
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
		String CellData = Cell.getStringCellValue();
		return CellData;
		
	}
public static Object[][]getTableArray1(String filePath, String SheetName, int TestCase) throws IOException{
		
		String[][]tabArray = null;
		
		FileInputStream ExcelFile = new FileInputStream(filePath);
		
		ExcelWbook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWbook.getSheet(SheetName);
		int totalRows =1;
		int totalCols = 2;
		tabArray = new String[totalRows][totalCols];
		int ci = 0;
	
			int cj = 0;
			for(int j = 1; j<=totalCols; j++, cj++) {
				
				tabArray[ci][cj]= getCellData(TestCase,j);
				System.out.println(tabArray[ci][cj]);				
			}
		
		return tabArray;	
	}
	

	
}
	
	


