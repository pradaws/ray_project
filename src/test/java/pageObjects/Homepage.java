package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{

	
public Homepage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//*[@id='ride-section']")
    WebElement find_ride ;
	
	@FindBy(xpath="//i[@class='fa fa-plus']")
	WebElement Add_car;
	
	@FindBy(xpath="//*[text()='You have no upcoming rides.Click hear to offer ride']")
	WebElement offer_ride;
	
   public void ridesfind() {
	   
	find_ride.click();
   }
  
	public void Addcar() {
		
		Add_car.click();
	}

	public void offerrides() {
		
	}
	}

