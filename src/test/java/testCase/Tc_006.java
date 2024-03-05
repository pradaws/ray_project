package testCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import testBase.Baseclass;

public class Tc_006 extends Baseclass{
	@Test
	public void loginfunctionality() throws IOException, InterruptedException {

	Loginpage loginpage = new Loginpage(driver);
	loginpage.signwthGoggle();
	for(String windowHandle:driver.getWindowHandles()) {
		driver.switchTo().window(windowHandle);
	}
    loginpage.givenemail("vksruthi1@gmail.com");
    loginpage.nxtbtn();
    Thread.sleep(6000);
    System.out.println(driver.getCurrentUrl()); 
    Homepage hp= new Homepage(driver);
    hp.Addcar();
  
	}
  /* @Test
   public void Addcar() throws IOException {
		
		Homepage hp= new Homepage(driver);
		hp.ridesfind();
	}
	*/
	
   
   
}
	//Homepage hp1 = new Homepage(driver);
	//hp1.ridesfind();



