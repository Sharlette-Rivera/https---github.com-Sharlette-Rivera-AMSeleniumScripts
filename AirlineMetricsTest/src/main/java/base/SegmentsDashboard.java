package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups= { "segmentsDashboard" })
public class SegmentsDashboard {
	
	String properties = "segmentsDashboard.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 45)
	public void clickSegmentsDashboardLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Segments Dashboard option");
		// Apply Explicit wait.
		String segmentsDashboardXpath = propertiesFile.GetPropValue("SegmentsDashboardXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(segmentsDashboardXpath)));
		driver.findElement(By.xpath(segmentsDashboardXpath)).click();
		
	}
}
