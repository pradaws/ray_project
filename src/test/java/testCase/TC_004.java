package testCase;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.ExcelUtils;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class TC_004 extends Baseclass{
	@Test
public void Testenter() throws IOException {
	Loginpage lp=new Loginpage(driver);
	

String file=System.getProperty("user.dir")+"/test-data/data.xlsx";//+ve cases and -ve cases at a time call
int rows=ExcelUtils.getRowCount(file, "Sheet1");
for(int r=1;r<=rows;r++) {
	//read from excel
	String username=ExcelUtils.getCellData(file, "Sheet1", r, 0);//get the values
	String pwd=ExcelUtils.getCellData(file, "Sheet1", r, 1);
	
	
	//pass to application
 
	Loginpage loginpage = new Loginpage(driver);
	loginpage.setuserName(username);
	loginpage.setPassword(pwd);
	loginpage.enter();

}
}}