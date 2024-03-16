package page_Objects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_page extends BaseClass{

	WebDriver driver;
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

	@FindBy(xpath="//i[@id='closeModal']")
	WebElement ClosePopup;

	@FindBy(xpath="//button[@class='btn btn-wide black-outline-btn']")
	WebElement ClickYesbtn;

	@FindBy(xpath="//span[text()='Products']")
	WebElement ClickProduct;

	@FindBy(xpath="/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-products/div/div[3]/div[1]/div/div[1]/div[3]/label/span[2]")
	WebElement selectAll;

	@FindBy(xpath="//*[text()='add']")
	WebElement Addproductbtn;

	@FindBy(xpath="//i[@class='material-icons add-img ng-tns-c105-2']")
	WebElement AddImage;

	@FindBy(xpath="//input[@name='name']")
	WebElement productname;

	@FindBy(name="unit")
	WebElement unitdropdown;

	@FindBy(name="stock_type")
	WebElement Stockype;

	@FindBy(name="selling_price")
	WebElement sellingprice;

	@FindBy(name="min_qty")
	WebElement min_qty;

	@FindBy(xpath="//div[@class='ql-editor ql-blank']")
	WebElement Desc;

	@FindBy(xpath="//input[@placeholder='Search']")
	WebElement search;

	@FindBy(xpath="//span[normalize-space()='Test']")
	WebElement testbox;

	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement img_save_btn;

	@FindBy(xpath="//span[normalize-space()='Add']")
	WebElement Addbtn;

	@FindBy(xpath="//a[normalize-space()='Catalogs']")
	WebElement catalogs;

	@FindBy(xpath="//span[normalize-space()='sort']")
	WebElement sort;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/form/div/div[3]/button[2]")
	WebElement Applysort;
	
	@FindBy(xpath="//body//app-root//button[3]")
	WebElement filter;
	
	@FindBy(xpath="/html/body/ngb-modal-window/div/div/form/div/div[3]/button[2]")
	WebElement Applyfilter;
	
	@FindBy(xpath="//button[@routerlink='/product-sections/products/import']")
	WebElement importprod;
	
	@FindBy(xpath="/html/body/app-root/app-store-layout/div[1]/div[3]/app-product-sections/app-import-product/div/div[2]/form/div/div/div/div[1]/div/div/label/div[2]/i")
	WebElement clickimportprod;
	
	
	




	public void ClickLogin() {
		Login.click();
		String parentWindowHandle = driver.getWindowHandle();


		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/div[2]/div[1]/ul/li[4]/a")).click();

		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String handle:allWindowHandles) {
			if(!handle.equals(parentWindowHandle)) 
			{
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));



			}
		}
	}

	public void emailid(String email) {

		emailid.sendKeys(email);

	}

	public void password(String password ) {


		pwd.sendKeys(password);

	}

	public void submit() throws InterruptedException, IOException {


		submitbtn.click();
		Thread.sleep(1000);
		String current_url="https://yourstore.io/login/session/signin";
		String exp_url=driver.getCurrentUrl();
		if(current_url.equals(exp_url)) {
			File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(f, new File("C:/Users/white/git/Orbit/capturesscreenshot02.png"));

			//screenshot copied from buffer is saved at the mentioned path.

			System.out.println("The Screenshot is captured.");

		}
	}
	public void ClosePopup() throws InterruptedException {


		//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		//		wait.until(ExpectedConditions.elementToBeClickable(ClickYesbtn)).click();
		Set<String> allWindowHandles = driver.getWindowHandles();

		// Print the number of open windows
		System.out.println("Number of open windows: " + allWindowHandles.size());

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", ClickYesbtn);






	}

	public void ClickProduct() {

		ClickProduct.click();
	}

	public void Checkbox() {

		System.out.println("Entered");

		selectAll.click();

	}

	public void AddProduct() throws InterruptedException, AWTException {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", Addproductbtn);

		//		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
		//		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//*[text()='add']")));
		//

		AddImage.click();
		String img="Ride.png";


		StringSelection selection = new StringSelection(img);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot =new Robot();

		robot.delay(2000);


		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);




		Thread.sleep(1000);
		img_save_btn.click();




		//AddImage.sendKeys("‪C:\\Users\\white\\OneDrive\\Pictures\\Ride.png");
		//System.out.println("File is Uploaded Successfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		productname.sendKeys("White Mastery");
		Thread.sleep(2000);		

		Select  unit=new Select(unitdropdown);
		unit.selectByValue("Mts");
		Thread.sleep(2000);	



		Select limit= new Select(Stockype);
		limit.selectByValue("unlim");
		Thread.sleep(2000);	

		min_qty.sendKeys("100");
		Thread.sleep(2000);	
		sellingprice.sendKeys("50000");
		Thread.sleep(2000);	

		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");

		Desc.sendKeys("HELLO WORLD");
		Thread.sleep(2000);	

		search.sendKeys("test");
		Thread.sleep(2000);	

		testbox.click();
		Thread.sleep(2000);	


		JavascriptExecutor js1 = (JavascriptExecutor) driver;	
		js1.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");

		WebDriverWait wait1 =new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.elementToBeClickable(Addbtn)).click();

		Thread.sleep(1000);

		catalogs.click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Products')]")).click();
		
		
		sort.click();
		Thread.sleep(1000);
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		
		js2.executeScript("window,scrollBy(0,500)", "");
		
		
		List<WebElement> radio= driver.findElements(By.tagName("input"));
		
		for(WebElement radios:radio) {
			
			
			
			String id= radios.getAttribute("id");
			
			
			if(!id.isEmpty()) {
			
			System.out.println("ID:" + id);
			
			radios.click();
			Thread.sleep(1000);
			
			
			if(id.equals("created_desc")) {
				
				break;
			}			
			
			
			
			}
			
			
			
		}

		Applysort.click();
		Thread.sleep(1000);
		
	
		JavascriptExecutor jsExecutor1 = (JavascriptExecutor) driver;
		jsExecutor1.executeScript("arguments[0].click();", filter);
		Thread.sleep(1000);
		
		List<WebElement> filterbtn= driver.findElements(By.name("product_type"));
		
		for(WebElement filterradiobtn:filterbtn) {
			
			String prod_type= filterradiobtn.getAttribute("id");
			
			System.out.println("Product_Type:" + prod_type	);
			
			filterradiobtn.click();
			Thread.sleep(1000);
			
			
		}
		
		Applyfilter.click();
		Thread.sleep(1000);
		
		importprod.click();
		Thread.sleep(1000);
		
		clickimportprod.click();
		
		String img2="bulk.csv";


		StringSelection selection1 = new StringSelection(img2);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection1, null);

		//Robot robot =new Robot();

		robot.delay(2000);


		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}








}





