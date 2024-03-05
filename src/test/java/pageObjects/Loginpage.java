package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage {

	public Loginpage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//button[@id='sbtLogin']")
	WebElement submit_btn;
	
	@FindBy(xpath="//a[@title='Login with Google']")
	WebElement sign_google;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement gvn_email;
	
	@FindBy(xpath="//*[text()='Next']")
	WebElement Nxt_btn;

	public void setuserName(String user) {
		
			txt_username.sendKeys(user);
		}
		
		public void setPassword(String pwd) {
			txt_password.sendKeys(pwd);
		}
		public void clickContinue() {
			submit_btn.submit();
		}

		public void sendKeys() {
			// TODO Auto-generated method stub
			txt_username.sendKeys(Keys.TAB);
		}
	
		public void sendKeys1() {
			// TODO Auto-generated method stub
			txt_password.sendKeys(Keys.TAB);
		}
	
	public void enter() {
		txt_password.sendKeys(Keys.ENTER);
	}
	public void signwthGoggle() {
		sign_google.click();
	}
	
	public void givenemail(String email) {
		
		gvn_email.sendKeys(email);
	}
	public void nxtbtn() {
		Nxt_btn.click();
	}
}
