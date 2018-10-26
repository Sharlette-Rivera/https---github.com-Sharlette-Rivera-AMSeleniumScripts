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

@Test(groups = { "faresDashboard", "faresDashboardTab" })
public class FaresDashboardFaresDashboard {
	
	String properties = "faresDashboard.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickFaresDashboardTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the  Fares Dashboard tab");
			String faresDashboardXpath = propertiesFile.GetPropValue("FaresDashboardTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(faresDashboardXpath)));
			driver.findElement(By.xpath(faresDashboardXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 152, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		
		//Test Agent Groups filter
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 153, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		
		//Test IATA No filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 154, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
		
	    // Test the Year Filter select box		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"FaresDashboard","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 155, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"FaresDashboard","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 156, groups = { "checkBoxIATANoTypeFilters","marketedCarrier" })
	public void checkBoxFilterMarketedCarrier() {
		
		// Test Marketed Carrier filter
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "MarketedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Marketed Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Marketed Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 157, groups = { "checkBoxTypeFilters","classes" })
	public void checkBoxFilterClasses() {
		
		// Test Classes filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "Classes", properties);
		
		if (results) {
		
			System.out.println("Testing Classes checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Classes checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 158, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		
		// Test DomInt filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 159, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		
		// Test the PBNR filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "FaresDashboard", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 160, groups = { "checkBoxIATANoTypeFilters","platedCarrier" })
	public void checkBoxFilterPlatedCarrier() {
		
		// Test Plated Carrier filter		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "PlatedCarrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Plated Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
		
	@Test(priority = 161, groups = { "checkBoxTypeFilters","platedYear" })
	public void checkBoxFilterPlatedYear() {
		
		// Test Plated Year Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "PlatedYear", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Year checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Year checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 162, groups = { "checkBoxTypeFilters","platedMonth" })
	public void checkBoxFilterPlatedMonth() {
		
		// Test Plated Month Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "PlatedMonth", properties);
		
		if (results) {
		
			System.out.println("Testing Plated Month checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Plated Month checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 163, groups = { "selectTypeFilters","limit" })
	public void selectFilterLimit() throws IOException {

	    // Test the Limit Filter select box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"FaresDashboard","Limit",properties);
		
		if (results) {
		
			System.out.println("Testing Limit select filter is successful");
			
		} else {
			
			System.out.println("Testing Limit select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 164, groups = { "checkBoxTypeFilters","noTax" })
	public void checkBoxFilterNoTax() {
		
		// Test No Tax Filter
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "FaresDashboard", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 165, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
		
        // Test Set Filter check boxes		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "FaresDashboard",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 166, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String faresDashboardClearFiltersXpath=propertiesFile.GetPropValue("FaresDashboardClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, faresDashboardClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingFaresDashboardTab() {
		
		System.out.println("Testing of Fares Dashboard page is complete");
		
	}
}
