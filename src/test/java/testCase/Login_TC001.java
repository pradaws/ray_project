package testCase;

import java.time.Duration;

import page_Objects.BaseClass;
import page_Objects.Home_page;

public class Login_TC001 extends BaseClass{
	
	public void LoginTest() throws InterruptedException {
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
		

		String exp_result="Yourstore";
		String act_result=driver.getTitle();

		if(act_result.equals(exp_result)) {
		    log.info("testcase is pass");
		}
		else {
		    log.info("testcase is failed");
		}

		
	    
		
		
	}

}
