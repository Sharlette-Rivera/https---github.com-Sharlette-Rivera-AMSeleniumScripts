package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups= { "singleFlightDashboard" })
public class SingleFlightDashboard {
	
	String properties = "singleFlightDashboard.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 103)
	public void clickSingleFlightDashboardLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Single Flight Dashboard option");
		// Apply Explicit wait.
		String singleFlightDashboardXpath = propertiesFile.GetPropValue("SingleFlightDashboardXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(singleFlightDashboardXpath)));
		driver.findElement(By.xpath(singleFlightDashboardXpath)).click();
	}

}
