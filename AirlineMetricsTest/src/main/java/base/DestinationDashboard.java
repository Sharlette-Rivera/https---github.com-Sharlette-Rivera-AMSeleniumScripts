package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups= { "destinationDashboard" })
public class DestinationDashboard {

	String properties = "destinationDashboard.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 20)
	public void clickDestinationDashboardLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Destination Dashboard option");
		// Apply Explicit wait.
		String destinationDashboardXpath = propertiesFile.GetPropValue("DestinationDashboardXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(destinationDashboardXpath)));
		driver.findElement(By.xpath(destinationDashboardXpath)).click();
	}
}
