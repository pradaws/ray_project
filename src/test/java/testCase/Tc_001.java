package testCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import testBase.Baseclass;

public class Tc_001 extends  Baseclass{
	@Test
	public void Addcar() throws IOException {
		
		Homepage hp= new Homepage(driver);
		hp.ridesfind();
	}
		
}
