package testCase;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.Loginpage;
import testBase.Baseclass;


			public class TC_001_testcase extends Baseclass{
				@Test
				public void loginfunctionality() throws IOException {
		
			Loginpage lp=new Loginpage(driver);
		
					FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\test-data\\data.xlsx");
					XSSFWorkbook workbook=new XSSFWorkbook(file);
					XSSFSheet sheet=workbook.getSheet("Sheet1");//workbook.getSheetAt(0);
					    // Iterate through rows
			        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			            Row row = sheet.getRow(i);

			            // Read data from Excel
			            String username = row.getCell(0).getStringCellValue();
			            String password = row.getCell(1).getStringCellValue();

			            // Open the login page
			            driver.get("your_application_login_page_url");

			            // Locate username and password fields and submit button using appropriate Selenium locators
			            WebElement usernameInput = driver.findElement(By.id("username"));
			            WebElement passwordInput = driver.findElement(By.id("password"));
			            WebElement loginButton = driver.findElement(By.id("loginButton"));

			            // Enter data into the login fields
			            usernameInput.sendKeys(username);
			            passwordInput.sendKeys(password);

			            // Perform login
			            loginButton.click();

			            // You can add further validation or assertions based on your application's behavior

			            // Optional: Wait for a while to observe the result before moving to the next iteration
			            try {
			                Thread.sleep(2000);
			            } catch (InterruptedException e) {
			                e.printStackTrace();
			            }
			        }

			        // Close the browser and workbook
			        driver.quit();
			        workbook.close();
			        
			    }
			}
