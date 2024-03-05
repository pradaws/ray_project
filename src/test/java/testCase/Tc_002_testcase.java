package testCase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
public class Tc_002_testcase {


	    public static void main(String[] args) throws IOException {
	       
	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

            // Open the login page
            driver.get("https://products.ncryptedprojects.com/sharecaar/login");

	        // Open Excel file
	        FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\test-data\\data.xlsx");
			XSSFWorkbook workbook=new XSSFWorkbook(file);
			XSSFSheet sheet=workbook.getSheet("Sheet1");//workbook.getSheetAt(0);
			    // Iterate through rows

	        // Iterate through rows
	        for (int i = 2; i <= sheet.getLastRowNum(); i++) {
	            Row row = sheet.getRow(i);

	            // Read data from Excel
	            String username = row.getCell(0).getStringCellValue();
	           String password = row.getCell(1).getStringCellValue();

	            // Open the login page
	           // driver.get("https://products.ncryptedprojects.com/sharecaar/login");

	            // Locate username and password fields and submit button using appropriate Selenium locators
	            WebElement usernameInput = driver.findElement(By.xpath("//input[@id='email']"));
	            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
	            WebElement loginButton = driver.findElement(By.id("//button[@id='sbtLogin']"));

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
	       // driver.quit();
	        workbook.close();
	       ;
	    }
	}
