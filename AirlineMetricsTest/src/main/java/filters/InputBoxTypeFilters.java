package filters;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.GetPropertiesSelectedValue;
import library.GetPropertiesValue;

public class InputBoxTypeFilters {

	public static boolean filterInputBoxResults(WebDriver driver, String tabName, String filterBoxName, String properties) {
		
		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		
		// Set properties file
		GetPropertiesValue propFile = new GetPropertiesValue(properties);
		
		// Set properties file
		GetPropertiesSelectedValue propFileSelectedValue = new GetPropertiesSelectedValue("selectedItems.properties");
		
		System.out.println("Test " + filterBoxName + " box");
		
		boolean results = false;

		
		try {
			
            String filterBoxXpath =	propFile.GetPropValue(tabName+filterBoxName+"Xpath");
            
			System.out.println("Click the " + filterBoxName + " filter box");

			List<String> selectedItems =  new ArrayList<String>();
			
			selectedItems = propFileSelectedValue.GetPropSelectedValue(filterBoxName);
			
			if (selectedItems.isEmpty()) {
				
				System.out.println("No items to be entered in " + filterBoxName);
				
			} else {
				
				System.out.println("Enter " + String.valueOf(selectedItems.size()) + " items in the " + filterBoxName + " input box");
			}
			
			for (int i = 0; i < selectedItems.size();i++) {

				if (i > 0) {
				
					// Delay 10 seconds to complete the display of the page.
					try {
						Thread.sleep(10000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(filterBoxXpath)));

				driver.findElement(By.xpath(filterBoxXpath)).click();

				driver.findElement(By.xpath(filterBoxXpath)).clear();

				driver.findElement(By.xpath(filterBoxXpath)).sendKeys(selectedItems.get(i).toString());

				driver.findElement(By.xpath(filterBoxXpath)).sendKeys(Keys.ENTER);
			}
			
			results = true;
		}
		
		catch (Exception e) {
			
			return results;
			
		}
		
		return results;
		
	}

}
