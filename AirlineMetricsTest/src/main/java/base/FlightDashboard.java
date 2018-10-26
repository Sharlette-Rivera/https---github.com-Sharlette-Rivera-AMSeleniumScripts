package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups= { "flightDashboard" })
public class FlightDashboard {
	String properties = "flightDashboard.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 119)
	public void clickFlightDashboardLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Flight Dashboard option");
		// Apply Explicit wait.
		String flightDashboardXpath = propertiesFile.GetPropValue("FlightDashboardXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(flightDashboardXpath)));
		driver.findElement(By.xpath(flightDashboardXpath)).click();
		
	}
}
