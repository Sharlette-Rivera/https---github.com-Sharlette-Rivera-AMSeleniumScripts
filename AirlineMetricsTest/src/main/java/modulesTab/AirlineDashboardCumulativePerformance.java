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

@Test(groups = { "airlineDashboard", "cumulativePerformanceTab" })
public class AirlineDashboardCumulativePerformance {

	String properties = "airlineDashboard.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickCumulativePerformanceTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the Cumulative Performance tab");
			String CumulativePerformanceXpath = propertiesFile.GetPropValue("CumulativePerformanceTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(CumulativePerformanceXpath)));
			driver.findElement(By.xpath(CumulativePerformanceXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 33, groups = { "checkBoxIATANoTypeFilters","marketedCarrier" })
	public void checkBoxFilterMarketedCarrier() {
		// Test Marketed Carrier filter
		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "MarketedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Marketed Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Marketed Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 34, groups = { "checkBoxIATANoTypeFilters","platedCarrier" })
	public void checkBoxFilterPlatedCarrier() {
		// Test Plated Carrier filter
		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "PlatedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Plated Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 35, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
	    // Test the Year Filter select box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"CumulativePerformance","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	
	
	@Test(priority = 36, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"CumulativePerformance","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 37, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		//Test Agent Groups filter
		
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 38, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		//Test IATA No filter
				
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 39, groups = { "checkBoxTypeFilters","domInt" }, alwaysRun = true)
	public void checkBoxFilterDomInt() {
		// Test DomInt filter
		
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}	
	
	@Test(priority = 40, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		// Test the PBNR filter box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "CumulativePerformance", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 41, groups = { "checkBoxTypeFilters","transCode" })
	public void checkBoxFilterTransCode() {
		// Test Trans Code Filter
	
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "TransCode", properties);
		
		if (results) {
		
			System.out.println("Testing Trans Code checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Trans Code checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 42, groups = { "checkBoxTypeFilters", "noTax" })
	public void checkBoxFilterNoTax() {
		// Test No Tax Filter
	
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 43, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
        // Test Set Filter check boxes		
		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "CumulativePerformance",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 44, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String CumulativePerformanceClearFiltersXpath=propertiesFile.GetPropValue("CumulativePerformanceClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, CumulativePerformanceClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingCumulativePerformanceTab() {
		
		System.out.println("Testing of Cumulative Performance page is complete");
		
	}
	
}
