package com.learnframework.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		File src=new File("./TestData/data.xlsx");
		 
		try {
		 FileInputStream fis = new FileInputStream(src);
		 wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unabe to read excel file: "+e.getMessage());
			
		}
	
	}
	
	public String getStringData(String sheetName, int rowNo, int colNo){
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int rowNo, int colNo){
		return wb.getSheet(sheetName).getRow(rowNo).getCell(colNo).getNumericCellValue();
	}

}
