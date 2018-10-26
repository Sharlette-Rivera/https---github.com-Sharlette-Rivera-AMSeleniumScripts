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

@Test(groups = { "groupPerformance", "agencyPerformanceTab" } )
public class GroupPerformanceAgencyPerformance {

	String properties = "groupPerformance.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickAgencyPerformanceTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the Agency Performance tab");
			
			String agencyPerformanceXpath = propertiesFile.GetPropValue("AgencyPerformanceTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(agencyPerformanceXpath)));
			driver.findElement(By.xpath(agencyPerformanceXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 11, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
	    // Test the Year Filter select box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"AgencyPerformance","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 12, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"AgencyPerformance","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 13, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		//Test Agent Groups filter
		
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "AgencyPerformance", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 14, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		//Test IATA No filter
				
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "AgencyPerformance", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 15, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		// Test DomInt filter
		
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "AgencyPerformance", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}	
	
	@Test(priority = 16, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		// Test the PBNR filter box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "AgencyPerformance", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 17, groups = { "selectTypeFilters","noTax" })
	public void checkBoxFilterNoTax() {
		// Test No Tax Filter
		
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "AgencyPerformance", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 18, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
        // Test Set Filter check boxes		
		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "AgencyPerformance",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 19, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String agencyPerformanceClearFiltersXpath=propertiesFile.GetPropValue("AgencyPerformanceClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, agencyPerformanceClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingAgencyPerformanceTab() {
		
		System.out.println("Testing of Agency Performance page is complete");
		
	}
	
}
