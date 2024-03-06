package page_Objects;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_page extends BaseClass{

	public static WebDriver driver;
	public Home_page(WebDriver ldriver) {

		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath="/html/body/header/div/div/div/div[2]/div[2]/div[1]/ul/li[4]/a")	
	WebElement Login;


	@FindBy(xpath="//input[@placeholder='EMAIL']")
	WebElement emailid;

	@FindBy(name="password")
	WebElement pwd;

	@FindBy(xpath="//button[@type='submit']")
	WebElement submitbtn;

	public void ClickLogin() {
		Login.click();
		String parentWindowHandle = driver.getWindowHandle();


		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div[2]/div[1]/ul/li[4]/a")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle:allWindowHandles) {
			if(!handle.equals(parentWindowHandle)) 
			{
				driver.switchTo().window(handle);

			}
		}
	}

	public void emailid(String email) {

		emailid.sendKeys(email);

	}

	public void password(String password ) {

		pwd.sendKeys(password);

	}

	public void submit() {

		submitbtn.click();

	}


}




