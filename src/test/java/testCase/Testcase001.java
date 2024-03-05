 package testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.ExcelUtils;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class Testcase001 extends Baseclass{
	@Test
	public void loginfunctionality() throws IOException {



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
	driver.getCurrentUrl();

	
	//validation
	
	String exp_title="https://products.ncryptedprojects.com/sharecaar/login";
	String Act_title=driver.getCurrentUrl();
	
	if(Act_title.equals(exp_title)) {
		System.out.println("Test is passed");
		ExcelUtils.setCellData(file, "Sheet1", r, 2, "Pass");
		ExcelUtils.fillGreenColor(file, "Sheet1", r, 2);
		//driver.findElement(By.className("oxd-userdropdown-name")).click();
		//driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
	}else {
		System.out.println("Test is failed");
		ExcelUtils.setCellData(file, "Sheet1", r, 2, "fail");
		ExcelUtils.fillRedColor(file, "Sheet1", r, 2);
	}
}
}
	 

}
