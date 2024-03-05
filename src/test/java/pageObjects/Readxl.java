package pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Readxl {

	@Test
	public void excel() throws IOException{
		FileInputStream file= new FileInputStream(System.getProperty("user.dir")+"\\test-data\\data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int totalrows=sheet.getLastRowNum();
		int totalcells=sheet.getRow(1).getLastCellNum();
		System.out.println("NO of rows:"+totalrows);
		System.out.println("NO of cells:"+totalcells);
		for(int r=0;r<=totalrows;r++) {
			XSSFRow currentrow=sheet.getRow(r);
			for(int c=0;c<=totalcells;c++) {
				XSSFCell cell=currentrow.getCell(c);
				String value=cell.toString();
				System.out.println(value+" ");
				
			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}}