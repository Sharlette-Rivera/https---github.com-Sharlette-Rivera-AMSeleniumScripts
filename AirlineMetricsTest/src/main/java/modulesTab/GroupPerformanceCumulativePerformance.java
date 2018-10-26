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

import library.Utility;
import library.GetPropertiesValue;
import base.StartSeleniumTest;
import filters.CheckBoxAgentGroupsTypeFilters;
import filters.CheckBoxIATANoTypeFilters;
import filters.CheckBoxTypeFilters;
import filters.SelectTypeFilters;
import filters.SetFiltersButtonCheckBoxes;

@Test(groups = { "groupPerformance", "cumulativePerformanceTab" } )
public class GroupPerformanceCumulativePerformance extends StartSeleniumTest{

	String properties = "groupPerformance.properties";
	
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
			String cumulativePerformanceXpath = propertiesFile.GetPropValue("CumulativePerformanceTabXpath");
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(cumulativePerformanceXpath)));
			driver.findElement(By.xpath(cumulativePerformanceXpath)).click();
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@Test(priority = 2, groups = { "selectTypeFilters","year" })
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
	
	@Test(priority = 3, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
	
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"CumulativePerformance","Month", properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 4, groups = {"checkBoxAgentGroupsTypeFilters","agentGroups"})
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
	
	@Test(priority = 5, groups = { "checkBoxIATANoTypeFilters","iATANo" })
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
	
	@Test(priority = 6, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		// Test DomInt filter
		System.out.println(CheckBoxTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "DomInt", properties));
		
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "CumulativePerformance", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}	
	
	@Test(priority = 7, groups = { "selectTypeFilters","pBNR" })
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
	
	@Test(priority = 8, groups = { "selectTypeFilters","noTax" })
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
	
	@Test(priority = 9, groups = { "setFiltersButtonCheckBoxes" })
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
	
	@Test(priority = 10, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
		
				System.out.println("Click Clear Filters button");
		
				String agencyPerformanceClearFiltersXpath=propertiesFile.GetPropValue("CumulativePerformanceClearFiltersXpath");
		
				Utility.isElementPresent(driver, driverWait, agencyPerformanceClearFiltersXpath, 10).click();
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
