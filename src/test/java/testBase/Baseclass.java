package testBase;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.Loginpage;

public class Baseclass {

	public static WebDriver driver;
	public Logger logger;// for logging
	 public ResourceBundle rb;
	
	//@Parameters({"browser"})
	@BeforeClass
		public void setup() throws FileNotFoundException {

			rb=ResourceBundle.getBundle("Config");
			logger=LogManager.getLogger(this.getClass());
			driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(rb.getString("BaseUrl"));
			
		}
		
		@AfterClass
		public void close() {
			driver.quit();
			
		}

		}
