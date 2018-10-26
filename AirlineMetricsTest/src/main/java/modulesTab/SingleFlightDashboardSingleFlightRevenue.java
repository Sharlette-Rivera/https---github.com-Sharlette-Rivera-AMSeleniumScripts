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
import filters.InputBoxTypeFilters;
import filters.SelectTypeFilters;
import filters.SetFiltersButtonCheckBoxes;
import library.GetPropertiesValue;
import library.Utility;

@Test(groups = { "singleFlightDashboard", "singleFlightRevenueTab" })
public class SingleFlightDashboardSingleFlightRevenue {

	String properties = "singleFlightDashboard.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickSingleFlightRevenueTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the SingleFlight Revenue tab");
			String singleFlightRevenueXpath = propertiesFile.GetPropValue("SingleFlightRevenueTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(singleFlightRevenueXpath)));
			driver.findElement(By.xpath(singleFlightRevenueXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 119, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		
		//Test Agent Groups filter
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 120, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		
		//Test IATA No filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
		

	@Test(priority = 121, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
		
	    // Test the Year Filter select box		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"SingleFlightRevenue","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 122, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"SingleFlightRevenue","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 123, groups = { "checkBoxIATANoTypeFilters","marketedCarrier" })
	public void checkBoxFilterMarketedCarrier() {
		
		// Test Marketed Carrier filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "MarketedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Marketed Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Marketed Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 124, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		
		// Test DomInt filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	
	
	@Test(priority = 125, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		
		// Test the PBNR filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "SingleFlightRevenue", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 126, groups = { "checkBoxIATANoTypeFilters","platedCarrier" })
	public void checkBoxFilterPlatedCarrier() {
		
		// Test Plated Carrier filter		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "PlatedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Plated Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
		
	@Test(priority = 127, groups = { "checkBoxTypeFilters","platedYear" })
	public void checkBoxFilterPlatedYear() {
		
		// Test Plated Year Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "PlatedYear", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Year checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Year checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 128, groups = { "checkBoxTypeFilters","platedMonth" })
	public void checkBoxFilterPlatedMonth() {
		
		// Test Plated Month Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "PlatedMonth", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Month checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Month checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 129, groups = { "inputBoxTypeFilters","flightNo" })
	public void inputBoxFilterFlightNo() {
		
		// Test Flighr No Filter
		boolean results = InputBoxTypeFilters.filterInputBoxResults(driver, "SingleFlightRevenue", "FlightNo", properties);
		
		if (results) {
		
			System.out.println("Testing Flight No inputbox filter is successful");
			
		} else {
			
			System.out.println("Testing Flight No inputbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	

	@Test(priority = 130, groups = { "selectTypeFilters","limit" })
	public void selectFilterLimit() throws IOException {

	    // Test the Limit Filter select box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"SingleFlightRevenue","Limit",properties);
		
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
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "SingleFlightRevenue", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 132, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
		
        // Test Set Filter check boxes		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "SingleFlightRevenue",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 133, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String singleFlightRevenueClearFiltersXpath=propertiesFile.GetPropValue("SingleFlightRevenueClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, singleFlightRevenueClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingSingleFlightRevenueTab() {
		
		System.out.println("Testing of Single Flight Revenue page is complete");
		
	}
	
}
