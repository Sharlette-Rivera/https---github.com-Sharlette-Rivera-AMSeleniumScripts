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

@Test(groups = { "segmentsDashboard", "topSegmentsByPassengersTab" })
public class SegmentsDashboardTopSegmentsByPassengers {

	String properties = "segmentsDashboard.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickTopSegmentsByPassengersTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the Top Segments By Revenue tab");
			String topSegmentsByPassengersXpath = propertiesFile.GetPropValue("TopSegmentsByPassengersTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(topSegmentsByPassengersXpath)));
			driver.findElement(By.xpath(topSegmentsByPassengersXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 63, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		
		//Test Agent Groups filter
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 64, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		
		//Test IATA No filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 65, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
		
	    // Test the Year Filter select box		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"TopSegmentsByPassengers","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 66, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"TopSegmentsByPassengers","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 67, groups = { "checkBoxIATANoTypeFilters","marketedCarrier" })
	public void checkBoxFilterMarketedCarrier() {
		
		// Test Marketed Carrier filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "MarketedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Marketed Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Marketed Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 68, groups = { "checkBoxTypeFilters","classes" })
	public void checkBoxFilterClasses() {
		
		// Test Classes filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "Classes", properties);
		
		if (results) {
		
			System.out.println("Testing Classes checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Classes checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 69, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		
		// Test DomInt filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 70, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		
		// Test the PBNR filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "TopSegmentsByPassengers", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 71, groups = { "checkBoxIATANoTypeFilters","platedCarrier" })
	public void checkBoxFilterPlatedCarrier() {
		
		// Test Plated Carrier filter		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "PlatedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Plated Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
		
	@Test(priority = 72, groups = { "checkBoxTypeFilters","platedYear" })
	public void checkBoxFilterPlatedYear() {
		
		// Test Plated Year Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "PlatedYear", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Year checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Year checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 73, groups = { "checkBoxTypeFilters","platedMonth" })
	public void checkBoxFilterPlatedMonth() {
		
		// Test Plated Month Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "PlatedMonth", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Month checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Month checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 74, groups = { "checkBoxTypeFilters","origin" })
	public void dialogBoxFilterOrigin() throws IOException {
		
		OriginDestinationFilter originDestinationFilter = new OriginDestinationFilter();
		
		originDestinationFilter.retrieveSettingsFromConfig("Origin");
		
		// Test Origin Dialog box Filter
		boolean results = InputBoxOriginDestination.inputOriginDestinationFilters(driver, "TopSegmentsByPassengers", "Origin", properties, originDestinationFilter);
	
		if (results) {
		
			System.out.println("Testing Origin dialog box filter is successful");
			
		} else {
			
			System.out.println("Testing Origin dialog box filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}	
	
	@Test(priority = 75, groups = { "checkBoxTypeFilters","destination" })
	public void dialogBoxFilterDestination() throws IOException {
			
		OriginDestinationFilter originDestinationFilter = new OriginDestinationFilter();
		
		originDestinationFilter.retrieveSettingsFromConfig("Destination");
		
		// Test Destination Dialog box Filter
		boolean results = InputBoxOriginDestination.inputOriginDestinationFilters(driver, "TopSegmentsByPassengers", "Destination", properties, originDestinationFilter);
	
		if (results) {
		
			System.out.println("Testing Plated Month checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Month checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 76, groups = { "selectTypeFilters","limit" })
	public void selectFilterLimit() throws IOException {

	    // Test the Limit Filter select box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"TopSegmentsByPassengers","Limit",properties);
		
		if (results) {
		
			System.out.println("Testing Limit select filter is successful");
			
		} else {
			
			System.out.println("Testing Limit select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 77, groups = { "checkBoxTypeFilters","noTax" })
	public void checkBoxFilterNoTax() {
		
		// Test No Tax Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByPassengers", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 78, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
		
        // Test Set Filter check boxes		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "TopSegmentsByPassengers",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 79, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String topSegmentsByPassengersClearFiltersXpath=propertiesFile.GetPropValue("TopSegmentsByPassengersClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, topSegmentsByPassengersClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingTopSegmentsByPassengersTab() {
		
		System.out.println("Testing of Top Segments By Revenue page is complete");
		
	}
}
