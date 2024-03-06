package pageObjects;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;


	import org.apache.poi.xssf.usermodel.XSSFCell;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.testng.annotations.Test;


	public class Excel2 {
		@Test
		void excelread() throws IOException   {
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\test-data\\LoginData.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");//workbook.getSheetAt(0);
			
			int totalrows=sheet.getLastRowNum();// no of rows
			int totalcells=sheet.getRow(1).getLastCellNum();// no of cells in a row
			
			System.out.println("No of rows:"+totalrows); 
			System.out.println("No of cells in a row:"+totalcells);
			
			for(int r=0;r<=totalrows;r++) {
				XSSFRow currentrow=sheet.getRow(r);
				for(int c=0;c<totalcells;c++) {
					XSSFCell cell=currentrow.getCell(c);// goto cell
					String value=cell.toString();// read value from cell
					// String value=currentrow.getCell(c).toString();
					System.out.print(value+"   ");
				}
				System.out.println();
			}
			workbook.close();
			file.close();	
		}
	}



	
	/*public class Excel2 {
		@Test
		void Excelwrite() throws IOException {
			FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\myfile.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook();//create new workbook
			XSSFSheet sheet=workbook.createSheet();//create new sheet
			XSSFRow row1=sheet.createRow(0);//create new row
			row1.createCell(0).setCellValue("vamshi");// write data into the 1st row 1st cell
			row1.createCell(1).setCellValue("Tester");
			row1.createCell(2).setCellValue("Manual");
			row1.createCell(3).setCellValue("Selenium");
			workbook.write(file);
			workbook.close();
			file.close();
			System.out.println("writing completed");
		}
	}
*/



