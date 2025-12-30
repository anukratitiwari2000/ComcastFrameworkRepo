package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int CellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./testData/VtigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(CellNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./testData/VtigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataBackToExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./testData/VtigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos=new FileOutputStream("./testData/VtigerData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
