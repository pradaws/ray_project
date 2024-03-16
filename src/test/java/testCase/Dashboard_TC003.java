package testCase;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import page_Objects.Dashboard2;


public class Dashboard_TC003 extends Login_TC001 {
	
    @Test
	public void dashboard_test() throws InterruptedException, AWTException {
		
		
		Dashboard2 db=new Dashboard2(driver);
		//db.dashboard();
	}

}
