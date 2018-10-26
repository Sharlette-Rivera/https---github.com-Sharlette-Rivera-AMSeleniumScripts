package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups = { "groupPerformance" })
public class GroupPerformance extends StartSeleniumTest{
	
	String properties = "groupPerformance.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 1)
	public void clickGroupPerformanceLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Group Performance option");
		// Apply Explicit wait.
		String groupPerformanceXpath = propertiesFile.GetPropValue("GroupPerformanceXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(groupPerformanceXpath)));
		driver.findElement(By.xpath(groupPerformanceXpath)).click();
	}
	
}
