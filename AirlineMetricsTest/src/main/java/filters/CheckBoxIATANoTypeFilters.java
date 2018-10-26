package filters;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.GetPropertiesSelectedValue;
import library.GetPropertiesValue;
import library.Utility;


public class CheckBoxIATANoTypeFilters {

	public static boolean filterCheckBoxResults(WebDriver driver, String tabName, String filterBoxName, 
			String properties, boolean testAll) {
		
		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		
		// Set properties file
		GetPropertiesValue propFile = new GetPropertiesValue(properties);
		
		// Set properties file
		GetPropertiesSelectedValue propFileSelectedValue = new GetPropertiesSelectedValue("selectedItems.properties");
		
		System.out.println("Test " + filterBoxName + " box");

		boolean results = false;
		
		try {
			
			String webElementXpath=propFile.GetPropValue(tabName+filterBoxName+"WebElementXpath");
			
			// Set the web element
			WebElement setFilterElement = driver.findElement(By.xpath(webElementXpath));

			String checkAllXpath = "";
			String uncheckAllXpath = "";
			String closeButtonXpath="";

			// Set check all xpath
			checkAllXpath=propFile.GetPropValue(tabName+filterBoxName+"CheckAllXpath");
			
			// Set uncheck all xpath
			uncheckAllXpath=propFile.GetPropValue(tabName+filterBoxName+"UncheckAllXpath");

		
			// Set close button xpath
			closeButtonXpath=propFile.GetPropValue(tabName+filterBoxName+"CloseButtonXpath");
			
			int tagCount = setFilterElement.findElements(By.tagName("li")).size();
			
			System.out.println("Number of elements for " + filterBoxName + " is " + String.valueOf(tagCount));

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
			
			// if test all items
			if (testAll) 
				{
					
				for (int i = 1; i <= tagCount;i++) {
	
					isSelected = false;
					xpath = optionXpath + "[" + String.valueOf(i) + "]/label/input";
					labelXpath = optionXpath + "[" + String.valueOf(i) +"]/label/span";
			
					isSelected = driver.findElement(By.xpath(xpath)).isSelected();
					
					if (!isSelected) {
						
						driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
						
						label = driver.findElement(By.xpath(labelXpath)).getText();
						
						System.out.println("Click " + label + " Check box");
						
						driver.findElement(By.xpath(xpath)).click();
						
						driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
						
						System.out.println("Unclick " + label + " Check box");
						
						driver.findElement(By.xpath(xpath)).click();
						
						
					}
	
				}

			}
			
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkAllXpath)));
			boolean checkAllIsdisplayed = Utility.isElementPresent(driver, driverWait, checkAllXpath, 10).isDisplayed();
			
			// If the filter box check all is displayed
			if (checkAllIsdisplayed) {
				
				System.out.println("Click the " + filterBoxName + " Check all");
				driver.findElement(By.xpath(checkAllXpath)).click();
				
			}
			
			
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(uncheckAllXpath)));
			boolean uncheckAllIsdisplayed = Utility.isElementPresent(driver, driverWait, uncheckAllXpath, 10).isDisplayed();
			
			// If the filter box uncheck all is displayed
			if (uncheckAllIsdisplayed) {
				
				System.out.println("Click the " + filterBoxName + " Uncheck all");
				driver.findElement(By.xpath(uncheckAllXpath)).click();
				
			}
			
			List<String> selectedCheckBoxes =  new ArrayList<String>();
			
			selectedCheckBoxes = propFileSelectedValue.GetPropSelectedValue(filterBoxName);
			
			if (selectedCheckBoxes.isEmpty()) {
			
				System.out.println("Select all check boxes in " + filterBoxName);
				
			} else {
				
				System.out.println("Select only selected check boxes in " + filterBoxName);
			}
			
			for (int i = 1; i <= tagCount;i++) {

				isSelected = false;
		
				xpath = optionXpath + "[" + String.valueOf(i) + "]/label/input";
				labelXpath = optionXpath + "["  + String.valueOf(i) +"]/label/span";

				if (selectedCheckBoxes.isEmpty()) {
					
					if (testAll) {
					
						isSelected = driver.findElement(By.xpath(xpath)).isSelected();
					
						if (!isSelected) {
							
							driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
							
							label = driver.findElement(By.xpath(labelXpath)).getText();
							
							System.out.println("Click " + label + " Check box");
							
							driver.findElement(By.xpath(xpath)).click();
							
						}
					} else {
						
						driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(checkAllXpath)));
						checkAllIsdisplayed = Utility.isElementPresent(driver, driverWait, checkAllXpath, 10).isDisplayed();
						
						// If the filter box check all is displayed
						if (checkAllIsdisplayed) {
							
							System.out.println("Click the " + filterBoxName + " Check all");
							driver.findElement(By.xpath(checkAllXpath)).click();
							
						}
						
						break;

					}
					
				} else {
					
					label = driver.findElement(By.xpath(labelXpath)).getText();
					
					if (selectedCheckBoxes.contains(label)) {
					
						isSelected = driver.findElement(By.xpath(xpath)).isSelected();
						
						if (!isSelected) {
							
							driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
							
							System.out.println("Click " + label + " Check box");
							
							driver.findElement(By.xpath(xpath)).click();
							
						}
							
						
					}
					
				}

			}

			// Delay 3 seconds to complete the display of all filter check boxes.
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(closeButtonXpath)));
			boolean closeButtonIsdisplayed = Utility.isElementPresent(driver, driverWait, closeButtonXpath, 10).isDisplayed();
			
			// If the filter box close button is displayed
			if (closeButtonIsdisplayed) {
				
				System.out.println("Click the " + filterBoxName + " close button");
				driver.findElement(By.xpath(closeButtonXpath)).click();
				
			}
			
			results = true;		
		
		}
		
		catch (Exception e) {
			
			return results;
			
		}
		
		return results;
	}

}
