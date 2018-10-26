package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import library.GetPropertiesValue;

@Test(groups = { "ticketedRevenueReport" })
public class TicketedRevenueReport extends StartSeleniumTest{

	String properties = "ticketedRevenueReport.properties";
	
	WebDriver driver;

	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;	
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@Test(priority = 1)
	public void clickTicketedRevenueReportLink() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		
		driverWait = new WebDriverWait(driver, 20);
		System.out.println("Click the Ticketed Revenue Report option");
		// Apply Explicit wait.
		// Click Revenue Metrics Module
		String revenueMetricsXpath = propertiesFile.GetPropValue("RevenueMetricsXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(revenueMetricsXpath)));
		driver.findElement(By.xpath(revenueMetricsXpath)).click();
		String ticketedRevenueReportXpath = propertiesFile.GetPropValue("TicketedRevenueReportXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ticketedRevenueReportXpath)));
		driver.findElement(By.xpath(ticketedRevenueReportXpath)).click();
	}
	

}
