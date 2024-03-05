package testCase;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import pageObjects.ExcelUtils;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class Tc_003 extends Baseclass{


	@Test
	public void Testloginwithtab() throws IOException, InterruptedException {

//user can access elements by preesing tab
	Loginpage lp=new Loginpage(driver);
	/*String file=System.getProperty("user.dir")+"/test-data/data.xlsx";//+ve cases and -ve cases at a time call
	int rows=ExcelUtils.getRowCount(file, "Sheet1");
	for(int r=1;r<=rows;r++) {
		//read from excel
		String username=ExcelUtils.getCellData(file, "Sheet1", r, 0);//get the values
		String pwd=ExcelUtils.getCellData(file, "Sheet1", r, 1);*/
		Loginpage loginpage = new Loginpage(driver);
	//	loginpage.setuserName(username);
		loginpage.sendKeys();
		Thread.sleep(1000);
		//loginpage.setPassword(pwd);
		loginpage.sendKeys1();
		loginpage.clickContinue();
		
		driver.getCurrentUrl();

}}
