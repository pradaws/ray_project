package testCase;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import page_Objects.BaseClass;
import page_Objects.Dashboard2;
import page_Objects.Home_page;

public class Login_TC001 extends BaseClass{

	@Test(priority=1)
	public void LoginTest() throws InterruptedException, AWTException, IOException {
		Home_page hp= new Home_page(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		hp.ClickLogin();
		hp.emailid(emailid);
		log.info("Email-id is entered");
		Thread.sleep(2000);
		hp.password(password);
		log.info("Password is entered");
		Thread.sleep(2000);
		hp.submit();
		log.info("User is Successfully logged into the account");
		File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File("C:/Users/white/git/Orbit/capturesscreenshot02.png"));

		//screenshot copied from buffer is saved at the mentioned path.

		System.out.println("The Screenshot is captured.");

		hp.ClosePopup();
		
		log.info("MouseHover Action to close the Tab");


		String exp_result="Yourstore";
		String act_result=driver.getTitle();

		if(act_result.equals(exp_result)) {
			log.info("testcase is pass");
		}
		else {
			log.info("testcase is failed");
			
			
			
		}
		
		

	}
	
    //@Test(priority=2)
	public void produt_test() throws InterruptedException, AWTException {
		Home_page hp= new Home_page(driver);
		
		
		log.info("MouseHover Action to close the Tab");
		hp.ClickProduct();
		log.info("Product is clicked");
		hp.Checkbox();
		log.info("Select all check box is enabled");
		hp.AddProduct();
		log.info("Add product is selected:");
	}
	
	@Test(priority=3)
	public void dashboard_test() throws InterruptedException, AWTException, IOException {

		// TODO Auto-generated method stub
		Dashboard2 db=new Dashboard2(driver);
		db.dashboard();

	}

}
