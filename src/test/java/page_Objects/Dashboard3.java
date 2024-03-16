package page_Objects;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Dashboard3 extends BaseClass {

	WebDriver driver;
	public Dashboard3(WebDriver ldriver) {

		driver=ldriver;
		PageFactory.initElements(ldriver, this);
	}
	@FindBy(xpath="//span[normalize-space()='Dashboard']")
	WebElement Dashboard;

	@FindBy(xpath="(//button[@type='button'])[1]")
	WebElement creataccountview;

	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement Addlogoview;

	@FindBy(xpath="//body[1]/app-root[1]/app-store-layout[1]/div[2]/div[3]/app-dashboard[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/button[2]/span[1]")
	WebElement SetupB2BConfigurationview;


	@FindBy(xpath="(//span[contains(text(),'View')])[4]")
	WebElement Listyourproductsview;

	@FindBy(xpath="//body/app-root/app-store-layout[@class='ng-star-inserted']/div[@class='app-admin-wrap layout-sidebar-large']/div[@class='main-content-wrap d-flex flex-column sidenav-open mt-115']/app-dashboard[@class='ng-star-inserted']/div[@class='row ml-0 mr-0 mt-4 mb-4 ng-star-inserted']/div[@class='col-md-12 p-0']/div[@class='data-list-card-wrapper']/div[@class='data-list-card-inner']/div[1]/div[2]/div[1]/button[2]")
	WebElement Setupshippingmethodsview;

	@FindBy(xpath="((//span[contains(text(),'Start')])[3]")
	WebElement Configurepaymentcollectionview;

	@FindBy(xpath="(//button[@type='button'])[7]")
	WebElement Chooseplanview;

	@FindBy(name="sub_type")
	WebElement b2btypedropdown;

	@FindBy(xpath="//span[normalize-space()='Update']")
	WebElement Update;

	@FindBy(xpath="/html/body/app-root/app-store-layout/div[1]/div[3]/app-payment-methods/div/div[2]/div/div[2]/button/span")
	WebElement Addnew;

	@FindBy(name="name")
	WebElement Paymentdropdown;

	@FindBy(name="btn_name")
	WebElement payname;

	@FindBy(xpath="//span[normalize-space()='Add']")
	WebElement Addbtn;

	@FindBy(xpath="(//button[@type='button'])[5]")
	WebElement startconfig;

	@FindBy(xpath="//*[text()='I Agree']")
	WebElement Iagree;

	@FindBy(xpath="//input[@name='key']")
	WebElement MerchantKey;
	
	@FindBy(xpath="//input[@name='token']")
	WebElement MerchantToken;
	
	@FindBy(xpath="//select[@name='mode']")
	WebElement paymode;
	

	public void dashboard() throws InterruptedException, AWTException 
	{

		//Addbtn.click();

		Dashboard.click();
		Thread.sleep(1000);

		creataccountview.click();

		driver.findElement(By.xpath("//span[normalize-space()='edit']")).click();

		WebElement input_CompanyName=driver.findElement(By.name("company_name"));
		input_CompanyName.clear();
		input_CompanyName.sendKeys("TEST WHITEMASTERY");
		Thread.sleep(1000);


		driver.findElement(By.xpath("//span[normalize-space()='Update']")).click();
		Thread.sleep(1000);

		driver.navigate().back();
		Thread.sleep(1000);

		
		driver.findElement(By.xpath("//body[1]/app-root[1]/app-store-layout[1]/div[1]/div[3]/app-dashboard[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/button[2]")).click();

		Select b2b =new Select(b2btypedropdown);
		b2b.selectByVisibleText("Quote Based");
		Thread.sleep(2000);

		Update.click();

		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);


		startconfig.click();

		Addnew.click();

		if(Iagree.isDisplayed()) {
			Iagree.click();
			Thread.sleep(1000);
		}


		Select paymethod=new Select(Paymentdropdown);
		Thread.sleep(1000);

		paymethod.selectByValue("PayU");

		payname.sendKeys("PayU");
		Thread.sleep(1000);

		
		MerchantKey.sendKeys("007");
		Thread.sleep(1000);
		
		MerchantToken.sendKeys("Hello World");
		Thread.sleep(1000);
		
		Select paymod=new Select(paymode);
		paymod.selectByVisibleText("Production");
		
		
		
		Addbtn.click();
		
		driver.navigate().back();
		Thread.sleep(1000);
		
		

		

	}
}
