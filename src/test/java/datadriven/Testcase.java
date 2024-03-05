package datadriven;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import pageObjects.ExcelUtils;

public class Testcase {
	
		WebDriver driver;
		@BeforeClass
		void setup() {
		 driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		@Test
		void login() throws IOException {
		String file=System.getProperty("user.dir")+"/testdata/LoginData.xlsx";//+ve cases and -ve cases at a time call
		int rows=ExcelUtils.getRowCount(file, "Sheet1");
		for(int r=1;r<=rows;r++) {
			//read from excel
			String username=ExcelUtils.getCellData(file, "Sheet1", r, 0);//get the values
			String pwd=ExcelUtils.getCellData(file, "Sheet1", r, 1);
			
			//pass to application
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(pwd);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			//validation
			
			String exp_title="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
			String Act_title=driver.getCurrentUrl();
			
			if(Act_title.equals(exp_title)) {
				System.out.println("Test is passed");
				ExcelUtils.setCellData(file, "Sheet1", r, 2, "Pass");
				ExcelUtils.fillGreenColor(file, "Sheet1", r, 2);
				driver.findElement(By.className("oxd-userdropdown-name")).click();
				driver.findElement(By.xpath("//a[text()='Logout']")).click();
				
			}else {
				System.out.println("Test is failed");
				ExcelUtils.setCellData(file, "Sheet1", r, 2, "fail");
				ExcelUtils.fillRedColor(file, "Sheet1", r, 2);
			}
}
		}

@AfterClass
void close() {
	driver.quit();
}

}
