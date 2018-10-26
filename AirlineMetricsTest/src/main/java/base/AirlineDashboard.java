package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups= { "airlineDashboard" })
public class AirlineDashboard {

	String properties = "airlineDashboard.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 20)
	public void clickAirlineDashboardLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Airline Dashboard option");
		// Apply Explicit wait.
		String airlineDashboardXpath = propertiesFile.GetPropValue("AirlineDashboardXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(airlineDashboardXpath)));
		driver.findElement(By.xpath(airlineDashboardXpath)).click();
	}
}
