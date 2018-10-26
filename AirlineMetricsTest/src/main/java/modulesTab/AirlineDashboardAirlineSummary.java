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

@Test(groups = { "airlineDashboard", "airlineSummaryTab" })
public class AirlineDashboardAirlineSummary {

	String properties = "airlineDashboard.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickAirlineSummaryTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the Airline Summary tab");
			String AirlineSummaryXpath = propertiesFile.GetPropValue("AirlineSummaryTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(AirlineSummaryXpath)));
			driver.findElement(By.xpath(AirlineSummaryXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 21, groups = { "checkBoxIATANoTypeFilters","marketedCarrier" })
	public void checkBoxFilterMarketedCarrier() {
		// Test Marketed Carrier filter
		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "AirlineSummary", "MarketedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Marketed Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Marketed Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 22, groups = { "checkBoxIATANoTypeFilters","platedCarrier" })
	public void checkBoxFilterPlatedCarrier() {
		// Test Plated Carrier filter
		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "AirlineSummary", "PlatedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Plated Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 23, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
	    // Test the Year Filter select box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"AirlineSummary","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	
	
	@Test(priority = 24, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"AirlineSummary","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 25, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		//Test Agent Groups filter
		
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "AirlineSummary", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 26, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		//Test IATA No filter
				
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "AirlineSummary", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 27, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		// Test DomInt filter
		
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "AirlineSummary", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}	
	
	@Test(priority = 28, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		// Test the PBNR filter box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "AirlineSummary", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 29, groups = { "checkBoxTypeFilters","transCode" })
	public void checkBoxFilterTransCode() {
		// Test Trans Code Filter
	
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "AirlineSummary", "TransCode", properties);
		
		if (results) {
		
			System.out.println("Testing Trans Code checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Trans Code checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 30, groups = { "checkBoxTypeFilters","noTax" })
	public void checkBoxFilterNoTax() {
		// Test No Tax Filter
	
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "AirlineSummary", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 31, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
        // Test Set Filter check boxes		
		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "AirlineSummary",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 32, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String AirlineSummaryClearFiltersXpath=propertiesFile.GetPropValue("AirlineSummaryClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, AirlineSummaryClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingAirlineSummaryTab() {
		
		System.out.println("Testing of Airline Summary page is complete");
		
	}
	
}
