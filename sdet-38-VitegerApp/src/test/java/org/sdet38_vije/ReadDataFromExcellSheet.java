package org.sdet38_vije;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcellSheet {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//step 1:read the file using File Input Stream
	FileInputStream fis = new FileInputStream(".\\data\\Datadriven.xlsx");
	//step 2:create workbook
	Workbook workbook = WorkbookFactory.create(fis);
	//step 3:load sheet
	Sheet sh = workbook.getSheet("Sheet1");
	int rows = sh.getLastRowNum();
	 int cols = sh.getRow(1).getLastCellNum();
	 for(int r=0;r<=rows;r++) {
			//step 4: navigate to the row
			Row row = sh.getRow(r); 
	 
	for(int c=0;c<=cols;c++) {
		//Step 5: navigate to the cell
		Cell cell = row.getCell(c);
	switch (cell.getCellType()) {
	case STRING:System.out.println(cell.getStringCellValue());	
	break;
	case NUMERIC:System.out.println(cell.getNumericCellValue());
	break;
	case BOOLEAN:System.out.println(cell.getBooleanCellValue());
	break;


	}
	  System.out.println("  ");
	}
    System.out.println();
		
	 }}
}
