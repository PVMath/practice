package org.sdet38_vije;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





public class WriteDataInExcellSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(".\\data\\datadriven1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet("Sheet1");
		Object empdata[][]= {{"EmpId", "Name", "Job"},
				            {101,"David","Enginner"},
				            {102,"Smith","Manager"},
				            {103,"Cott","Doctor"}
		};
		int rows = empdata.length;
		int cols = empdata[0].length;
		System.out.println( rows);
		System.out.println( cols);
		for(int r=0;r<=rows;r++) {
		Row row = sh.createRow(r);
		for(int c=0;c<=cols;c++) {
	  Cell cell = row.createCell(c);
	  Object value = empdata[r][c];
	  if(value instanceof String)
		  cell.setCellValue((String)value);
	  if(value instanceof Number)
		  cell.setCellValue((Double)value);
	  if(value instanceof Boolean)
		  cell.setCellValue((Boolean)value);
	  
	  
	  
		}
	

	}
		FileOutputStream fo = new FileOutputStream(".\\data\\datadriven1.xlsx");
		workbook.write(fo);
		fo.close();
	}

	}


