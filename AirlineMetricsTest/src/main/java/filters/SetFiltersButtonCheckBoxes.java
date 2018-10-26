package filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.GetPropertiesValue;
import library.Utility;

public class SetFiltersButtonCheckBoxes {

	
	public static boolean setFiltersResults(WebDriver driver, String tabName, String properties) {
		
		// Set properties file
		GetPropertiesValue propFile = new GetPropertiesValue(properties);

		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		
		boolean results = false;
		
		String xpath;
		
		try {
			
			xpath = propFile.GetPropValue(tabName+"SetFiltersXpath");
			
			System.out.println("Click Set Filters button to show filters checkboxes");
			Utility.isElementPresent(driver, driverWait, xpath, 10).click();
			
			// Delay 3 seconds to complete the display of all filter check boxes.
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String webElementXpath = propFile.GetPropValue(tabName+"SetFiltersWebElementXpath");
			WebElement setFilterElement = driver.findElement(By.xpath(webElementXpath));
			
			int spanCount = setFilterElement.findElements(By.tagName("span")).size();
			System.out.println(spanCount);
			
			String inputXpath = "";
			String labelXpath = "";
			String label = "";
			boolean isDisplayed;
					
			for (int i = 1; i <= spanCount;i++) {
				
				isDisplayed = false;
				
							
				inputXpath = webElementXpath + "/span["+ String.valueOf(i) + "]/input";
				labelXpath = webElementXpath + "/span["+ String.valueOf(i) + "]/label";
				
				isDisplayed = driver.findElement(By.xpath(labelXpath)).isDisplayed();
				
				if (isDisplayed) {
				
					label = driver.findElement(By.xpath(labelXpath)).getText();
					
					System.out.println("Unclick " + label + " Check box");
					
					Utility.elementIsClicked(driver, inputXpath, driverWait, 10);
					
					System.out.println("Click " + label + " Check box");
					
					Utility.elementIsClicked(driver, inputXpath, driverWait, 10);
					
					
				}
			
			}
			
			
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			
			System.out.println("Click Set Filters button to hide filters checkboxes");
			
			Utility.elementIsClicked(driver, xpath, driverWait, 10);
			
			results = true;
		
		}
		
		catch (Exception e) {
			
			return results;
			
		}
		
		return results;
	}

}
