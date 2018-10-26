package filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.GetPropertiesValue;

public class CheckBoxAgentGroupsTypeFilters {

	
	public static boolean filterCheckBoxResults(WebDriver driver, String tabName, String filterBoxName, String properties) {
		
		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		
		// Set properties file
		GetPropertiesValue propFile = new GetPropertiesValue(properties);
		
		System.out.println("Test " + filterBoxName + " box");
		
		boolean results = false;

		
		try {
			
			String webElementXpath=propFile.GetPropValue(tabName+filterBoxName+"WebElementXpath");
			
			// Set the web element
			WebElement setFilterElement = driver.findElement(By.xpath(webElementXpath));
			
			int optionCount = setFilterElement.findElements(By.tagName("li")).size();
			
			System.out.println("Number of elements for " + filterBoxName + " is " + String.valueOf(optionCount));

            String filterBoxXpath =	propFile.GetPropValue(tabName+filterBoxName+"Xpath");
            
			System.out.println("Click the " + filterBoxName + " filter box");
			driver.findElement(By.xpath(filterBoxXpath)).click();

			// Delay 3 seconds to complete the display of all filter check boxes.
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			String xpath;
			String labelXpath;
			String label;
			boolean isSelected;
			
			String optionXpath = propFile.GetPropValue(tabName+filterBoxName+"OptionXpath");
					
			for (int i = 1; i <= optionCount;i++) {

				isSelected = false;
				xpath="";
				labelXpath="";
				
				switch (filterBoxName) {
				
					case "AgentGroups":

						xpath = optionXpath + "[" + String.valueOf(i) + "]/span[2]";
						labelXpath = optionXpath + "[" + String.valueOf(i) +"]/a/span[2]";
			
				}
				
				isSelected = driver.findElement(By.xpath(xpath)).isSelected();
				
				if (!isSelected) {
					
					driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
					
					label = driver.findElement(By.xpath(labelXpath)).getText();
					
					System.out.println("Click " + label + " Check box");
					
					driver.findElement(By.xpath(xpath)).click();
					
					// Delay 3 seconds to complete the display of all filter check boxes.
					try {
						Thread.sleep(3000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
					
					System.out.println("Unclick " + label + " Check box");
					
					driver.findElement(By.xpath(xpath)).click();
					
					
				}

			}
			
			results = true;

		}
		
		catch (Exception e) {
			
			return results;
			
		}
		
		return results;
	}
}
