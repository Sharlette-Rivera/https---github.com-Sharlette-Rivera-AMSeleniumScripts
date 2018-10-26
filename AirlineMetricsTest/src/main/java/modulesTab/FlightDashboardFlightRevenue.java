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

import Entity.OriginDestinationFilter;
import base.StartSeleniumTest;
import filters.CheckBoxAgentGroupsTypeFilters;
import filters.CheckBoxIATANoTypeFilters;
import filters.CheckBoxTypeFilters;
import filters.InputBoxOriginDestination;
import filters.SelectTypeFilters;
import filters.SetFiltersButtonCheckBoxes;
import library.GetPropertiesValue;
import library.Utility;

@Test(groups = { "flightDashboard", "flightRevenueTab" })
public class FlightDashboardFlightRevenue {
	
	String properties = "flightDashboard.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickFlightRevenueTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the Flight Revenue tab");
			String flightRevenueXpath = propertiesFile.GetPropValue("FlightRevenueTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(flightRevenueXpath)));
			driver.findElement(By.xpath(flightRevenueXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 120, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		
		//Test Agent Groups filter
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 121, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		
		//Test IATA No filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 122, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
		
	    // Test the Year Filter select box		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"FlightRevenue","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 123, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"FlightRevenue","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 124, groups = { "checkBoxIATANoTypeFilters","marketedCarrier" })
	public void checkBoxFilterMarketedCarrier() {
		
		// Test Marketed Carrier filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "MarketedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Marketed Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Marketed Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 125, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		
		// Test DomInt filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 126, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		
		// Test the PBNR filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "FlightRevenue", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 127, groups = { "checkBoxIATANoTypeFilters","platedCarrier" })
	public void checkBoxFilterPlatedCarrier() {
		
		// Test Plated Carrier filter		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "PlatedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Plated Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
		
	@Test(priority = 128, groups = { "checkBoxTypeFilters","platedYear" })
	public void checkBoxFilterPlatedYear() {
		
		// Test Plated Year Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "PlatedYear", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Year checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Year checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 129, groups = { "checkBoxTypeFilters","platedMonth" })
	public void checkBoxFilterPlatedMonth() {
		
		// Test Plated Month Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "PlatedMonth", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Month checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Month checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 130, groups = { "selectTypeFilters","limit" })
	public void selectFilterLimit() throws IOException {

	    // Test the Limit Filter select box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"FlightRevenue","Limit",properties);
		
		if (results) {
		
			System.out.println("Testing Limit select filter is successful");
			
		} else {
			
			System.out.println("Testing Limit select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 131, groups = { "checkBoxTypeFilters","noTax" })
	public void checkBoxFilterNoTax() {
		
		// Test No Tax Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FlightRevenue", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 132, groups = { "checkBoxTypeFilters","origin" })
	public void dialogBoxFilterOrigin() throws IOException {
		
		OriginDestinationFilter originDestinationFilter = new OriginDestinationFilter();
		
		originDestinationFilter.retrieveSettingsFromConfig("Origin");
		
		// Test Origin Dialog box Filter
		boolean results = InputBoxOriginDestination.inputOriginDestinationFilters(driver, "FlightRevenue", "Origin", properties, originDestinationFilter);
	
		if (results) {
		
			System.out.println("Testing Origin dialog box filter is successful");
			
		} else {
			
			System.out.println("Testing Origin dialog box filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}	
	
	@Test(priority = 133, groups = { "checkBoxTypeFilters","destination" })
	public void dialogBoxFilterDestination() throws IOException {
			
		OriginDestinationFilter originDestinationFilter = new OriginDestinationFilter();
		
		originDestinationFilter.retrieveSettingsFromConfig("Destination");
		
		// Test Destination Dialog box Filter
		boolean results = InputBoxOriginDestination.inputOriginDestinationFilters(driver, "FlightRevenue", "Destination", properties, originDestinationFilter);
	
		if (results) {
		
			System.out.println("Testing Plated Month checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Month checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 134, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
		
        // Test Set Filter check boxes		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "FlightRevenue",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 135, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String flightRevenueClearFiltersXpath=propertiesFile.GetPropValue("FlightRevenueClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, flightRevenueClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingFlightRevenueTab() {
		
		System.out.println("Testing of Flight Revenue page is complete");
		
	}
}
