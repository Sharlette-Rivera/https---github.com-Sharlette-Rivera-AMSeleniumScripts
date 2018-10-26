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

@Test(groups = { "ticketedRevenueReport", "currentYearVsLastYearTab" })
public class TicketedRevenueMetricsCurrentYearVsLastYear {

	String properties = "ticketedRevenueReport.properties";
	
	// Create an instance of Explicit wait driver
	WebDriverWait driverWait;
	
	WebDriver driver;
	
	// Set properties file
	GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
	
	@BeforeClass
	@Test(groups = { "clickTab" })
	public void clickCurrentYearVsLastYearTab() throws IOException {
		
		driver = StartSeleniumTest.getDriver();
		driverWait =  new WebDriverWait(driver, 20);
		
		try {
			
			System.out.println("Click the Current Year Vs Last Year tab");
			String currentYearVsLastYearTabXpath = propertiesFile.GetPropValue("CurrentYearVsLastYearTabXpath");
			
			// Apply Explicit wait.
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(currentYearVsLastYearTabXpath)));
			driver.findElement(By.xpath(currentYearVsLastYearTabXpath)).click();
		
		} catch (Exception e) {
		
			Assert.assertTrue(false);
		}
	
		Assert.assertTrue(true);

	}
	
	@Test(priority = 2, groups = { "checkBoxIATANoTypeFilters","carrier" })
	public void checkBoxFilterCarrier() {
		// Test Marketed Carrier filter
		
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "CurrentYearVsLastYear", "Carrier", 
				properties, false);
		
		if (results) {
		
			System.out.println("Testing Carrier checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Carrier checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	
	@Test(priority = 3, groups = { "selectTypeFilters","year" })
	public void selectFilterYear() throws IOException {
	    // Test the Year Filter select box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"CurrentYearVsLastYear","Year",properties);
		
		if (results) {
		
			System.out.println("Testing Year select filter is successful");
			
		} else {
			
			System.out.println("Testing Year select filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	
	
	@Test(priority = 4, groups = { "selectTypeFilters","month" })
	public void selectFilterMonth() throws IOException {
		
		// Test the month filter box
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"CurrentYearVsLastYear","Month",properties);
		
		if (results) {
		
			System.out.println("Testing Month select filter is successful");
			
		} else {
			
			System.out.println("Testing Month select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 5, groups = { "checkBoxAgentGroupsTypeFilters","agentGroups" })
	public void checkBoxFilterAgentGroups() throws IOException {
		//Test Agent Groups filter
		
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "CurrentYearVsLastYear", "AgentGroups", properties);
		
		if (results) {
		
			System.out.println("Testing Agent Groups checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Agent Groups checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
		
	}
	
	@Test(priority = 6, groups = { "checkBoxIATANoTypeFilters","iATANo" })
	public void checkBoxFilterIATANo() {
		//Test IATA No filter
				
		boolean results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "CurrentYearVsLastYear", "IATANo", 
				properties, true);
		
		if (results) {
		
			System.out.println("Testing IATA No checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing IATA No checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);

	}
	
	@Test(priority = 7, groups = { "checkBoxTypeFilters","domInt" })
	public void checkBoxFilterDomInt() {
		// Test DomInt filter
		
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "CurrentYearVsLastYear", "DomInt", properties);
		
		if (results) {
		
			System.out.println("Testing DomInt checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing DomInt checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}	
	
	@Test(priority = 8, groups = { "selectTypeFilters","pBNR" })
	public void selectFilterPBNR() throws IOException {
		// Test the PBNR filter box
		
		boolean results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "CurrentYearVsLastYear", "PBNR", properties);
		
		if (results) {
		
			System.out.println("Testing PBNR select filter is successful");
			
		} else {
			
			System.out.println("Testing PBNR select filter is failed");
			
		}
		
		Assert.assertTrue(results);	
	}
	
	@Test(priority = 9, groups = { "checkBoxTypeFilters","transCode" })
	public void checkBoxFilterTransCode() {
		// Test Trans Code Filter
	
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "CurrentYearVsLastYear", "TransCode", properties);
		
		if (results) {
		
			System.out.println("Testing Trans Code checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing Trans Code checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 10, groups = { "checkBoxTypeFilters","noTax" })
	public void checkBoxFilterNoTax() {
		// Test No Tax Filter
	
		boolean results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "CurrentYearVsLastYear", "NoTax", properties);
		
		if (results) {
		
			System.out.println("Testing No Tax checkbox filter is successful");
			
		} else {
			
			System.out.println("Testing No Tax checkbox filter is failed");
			
		}
		
		Assert.assertTrue(results);
	}
	
	@Test(priority = 11, groups = { "setFiltersButtonCheckBoxes" })
	public void clickSetFilters()  {
        // Test Set Filter check boxes		
		
		boolean results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "CurrentYearVsLastYear",properties);
		
		if (results) {
				
			System.out.println("Testing SetFilters checkboxes is successful");
					
		} else {
					
			System.out.println("Testing SetFilters checkboxesr is failed");
					
		}
				
		Assert.assertTrue(results);

	}
	
	@Test(priority = 12, groups = { "clearFiltersButton" })
	public void clickClearFilters() throws IOException  {
		
		try {
			
			System.out.println("Click Clear Filters button");
		
			String currentYearVsLastYearClearFiltersXpath=propertiesFile.GetPropValue("CurrentYearVsLastYearClearFiltersXpath");
		
			Utility.isElementPresent(driver, driverWait, currentYearVsLastYearClearFiltersXpath, 10).click();
			System.out.println("Set filters are cleared");
			
		
		} catch (Exception e) {
			
			Assert.assertTrue(false);
		}
		
		Assert.assertTrue(true);

	}
	
	@AfterClass
	@Test
	public void endOfTestingCurrentYearVsLastYearTab() {
		
		System.out.println("Testing of Current Year Vs Last Year page is complete");
		
	}

}
