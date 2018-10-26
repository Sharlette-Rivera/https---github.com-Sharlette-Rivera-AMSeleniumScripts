package modulesTab;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.StartSeleniumTest;
import filters.CheckBoxAgentGroupsTypeFilters;
import filters.CheckBoxIATANoTypeFilters;
import filters.CheckBoxTypeFilters;
import filters.SelectTypeFilters;
import filters.SetFiltersButtonCheckBoxes;
import library.GetPropertiesValue;
import library.Utility;

@Test(groups = { "destinationDashboard", "destinationRevenueTab" })
public class DestinationDashboardDestinationRevenue {

	String properties = "destinationDashboard.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickDestinationRevenueTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the Destination Revenue tab");
			String destinationRevenueXpath = propertiesFile.GetPropValue("DestinationRevenueTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(destinationRevenueXpath)));
			driver.findElement(By.xpath(destinationRevenueXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 80, groups = { "checkBoxIATANoTypeFilters","carrier" })
	public void checkBoxFilterCarrier() {
		
		// Test Carrier filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "DestinationRevenue", "Carrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 81, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
		
	    // Test the Year Filter select box		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"DestinationRevenue","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 82, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"DestinationRevenue","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 83, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		
		//Test Agent Groups filter
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "DestinationRevenue", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 84, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		
		//Test IATA No filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "DestinationRevenue", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 85, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		
		// Test DomInt filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "DestinationRevenue", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 86, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		
		// Test the PBNR filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "DestinationRevenue", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 87, groups = { "clickCheckBox", "includeTax" })
	public void clickCheckBoxIncludeTax() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
	try {
			
			System.out.println("Click the Include Tax check box");
			String includeTaxCheckBoxXpath = propertiesFile.GetPropValue("DestinationRevenueIncludeTaxXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(includeTaxCheckBoxXpath)));
			driver.findElement(By.xpath(includeTaxCheckBoxXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 88, groups = { "selectTypeFilters","limit" })
	public void selectFilterLimit() throws IOException {

	    // Test the Limit Filter select box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"DestinationRevenue","Limit",properties);
		
		if (results) {
		
			System.out.println("Testing Limit select filter is successful");
			
		} else {
			
			System.out.println("Testing Limit select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 89, groups = { "checkBoxTypeFilters","noTax" })
	public void checkBoxFilterNoTax() {
		
		// Test No Tax Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "DestinationRevenue", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 90, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
		
        // Test Set Filter check boxes		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "DestinationRevenue",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 91, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String destinationRevenueClearFiltersXpath=propertiesFile.GetPropValue("DestinationRevenueClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, destinationRevenueClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingDestinationRevenueTab() {
		
		System.out.println("Testing of Destination Revenue page is complete");
		
	}
	
}
