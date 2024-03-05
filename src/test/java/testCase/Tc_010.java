package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.ExcelUtils;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class Tc_010 extends Baseclass{
	@Test
	public void loginfunctionality() throws IOException, InterruptedException {



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
	loginpage.clickContinue();
	driver.navigate().back();
	Thread.sleep(3000);
	driver.navigate().refresh();
	Thread.sleep(1000);
	//driver.navigate().to("https://products.ncryptedprojects.com/sharecaar/");

}
}}