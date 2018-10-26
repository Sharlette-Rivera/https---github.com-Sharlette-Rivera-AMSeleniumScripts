package TestModules;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Entity.OriginDestinationFilter;
import filters.CheckBoxAgentGroupsTypeFilters;
import filters.CheckBoxIATANoTypeFilters;
import filters.CheckBoxTypeFilters;
import filters.InputBoxOriginDestination;
import filters.SelectTypeFilters;
import filters.SetFiltersButtonCheckBoxes;
import base.StartSeleniumTest;
import library.GetPropertiesValue;
import library.Utility;

public class DebugFilterBox extends StartSeleniumTest{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String properties = "segmentsDashboard.properties";
		
		// Set properties file
		GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
		
		openBrowser();
		
		WebDriver driver = getDriver();
		
		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);

		// Set properties file
		propertiesFile = new GetPropertiesValue(properties);
		

		System.out.println("Click the Segments Dashboard option");
		
		// Apply Explicit wait.
		String segmentsDashboardXpath = propertiesFile.GetPropValue("SegmentsDashboardXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(segmentsDashboardXpath)));
		driver.findElement(By.xpath(segmentsDashboardXpath)).click();
		
		System.out.println("Click the Top Segements By Revenue tab");
		String topSegmentsByRevenueXpath = propertiesFile.GetPropValue("TopSegmentsByRevenueTabXpath");
		// Apply Explicit wait.
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(topSegmentsByRevenueXpath)));
		driver.findElement(By.xpath(topSegmentsByRevenueXpath)).click();	

		
		//Test Agent Groups filter	
		boolean results = CheckBoxAgentGroupsTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "AgentGroups", properties);

		//Test IATA No filter	
		results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "IATANo", 
				properties, true);
		
	    // Test the Year Filter select box
		results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"TopSegmentsByRevenue","Year",properties);

		// Test the month filter box
		results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"TopSegmentsByRevenue","Month",properties);

		// Test Marketed Carrier filter
		results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "MarketedCarrier", 
				properties, false);

		// Test Classes filter
		results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "Classes", properties);

		// Test DomInt filter
		results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "DomInt", properties);

		// Test the PBNR filter box
		results = SelectTypeFilters.isTestSelectFilterSuccess(driver, "TopSegmentsByRevenue", "PBNR", properties);

		// Test Plated Carrier filter		
		results = CheckBoxIATANoTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "PlatedCarrier", 
				properties, false);

		// Test Plated Year Filter
		results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "PlatedYear", properties);

		// Test Plated Month Filter
		results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "PlatedMonth", properties);

		// Test Origin Filter
		OriginDestinationFilter originDestinationFilter = new OriginDestinationFilter();
		
		originDestinationFilter.retrieveSettingsFromConfig("Origin");
		
		// Test Origin Dialog box Filter
		results = InputBoxOriginDestination.inputOriginDestinationFilters(driver, "TopSegmentsByRevenue", "Origin", properties, originDestinationFilter);

		originDestinationFilter.retrieveSettingsFromConfig("Destination");
		
		// Test Destination Dialog box Filter
		results = InputBoxOriginDestination.inputOriginDestinationFilters(driver, "TopSegmentsByRevenue", "Destination", properties, originDestinationFilter);
		
	    // Test the Limit Filter select box
		results = SelectTypeFilters.isTestSelectFilterSuccess(driver,"TopSegmentsByRevenue","Limit",properties);

		// Test No Tax Filter
		results = CheckBoxTypeFilters.filterCheckBoxResults(driver, "TopSegmentsByRevenue", "NoTax", properties);

	     // Test Set Filter check boxes		
		results = SetFiltersButtonCheckBoxes.setFiltersResults(driver, "TopSegmentsByRevenue",properties);

		System.out.println("Click Clear Filters button");
		
		String topSegmentsByRevenueClearFiltersXpath=propertiesFile.GetPropValue("TopSegmentsByRevenueClearFiltersXpath");
	
		Utility.isElementPresent(driver, driverWait, topSegmentsByRevenueClearFiltersXpath, 10).click();
		System.out.println("Set filters are cleared");
		
		System.out.println(results);
/*		String mainWindowHandle=driver.getWindowHandle();
		
		System.out.println("Click the Origin filter box");
		String topSegmentsByRevenueOriginXpath = propertiesFile.GetPropValue("TopSegmentsByRevenueOriginXpath");
		// Apply Explicit wait.
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(topSegmentsByRevenueOriginXpath)));
		driver.findElement(By.xpath(topSegmentsByRevenueOriginXpath)).click();	
		
		Set s = driver.getWindowHandles();
		
		Iterator ite = s.iterator();
        while(ite.hasNext())
        {
             String popupHandle=ite.next().toString();
             if(!popupHandle.contains(mainWindowHandle))
             {
                   driver.switchTo().window(popupHandle);
             }
        }
        
        driver.switchTo().window( mainWindowHandle );*/
		

	}
}
