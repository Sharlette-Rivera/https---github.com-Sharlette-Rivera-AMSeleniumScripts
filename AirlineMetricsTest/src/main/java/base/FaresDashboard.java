package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups= { "faresDashboard" })
public class FaresDashboard {
	
	String properties = "faresDashboard.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 151)
	public void clickFaresDashboardLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Fares Dashboard option");
		// Apply Explicit wait.
		String faresDashboardXpath = propertiesFile.GetPropValue("FaresDashboardXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(faresDashboardXpath)));
		driver.findElement(By.xpath(faresDashboardXpath)).click();
		
	}
}
