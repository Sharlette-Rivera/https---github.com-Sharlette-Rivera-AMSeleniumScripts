package filters;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import library.GetPropertiesSelectedValue;
import library.GetPropertiesValue;

public class SelectTypeFilters {

	
	public static boolean isTestSelectFilterSuccess(WebDriver driver, String tabName, String filterBoxName, String properties) throws IOException {
		
		boolean results = false;
		
		// Set properties file
		GetPropertiesValue propFile = new GetPropertiesValue(properties);
		
		// Set properties file
		GetPropertiesSelectedValue propFileSelectedValue = new GetPropertiesSelectedValue("selectedItems.properties");
		
		String strXpath = propFile.GetPropValue(tabName+filterBoxName+"Xpath");
		
		System.out.println("Test " + filterBoxName + " box");
		
		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		
		try {
			
			WebElement filterBox = driver.findElement(By.xpath(strXpath));
			
			int optionSize = filterBox.findElements(By.tagName("option")).size();
			
			System.out.println("Iterate on each select " + filterBoxName + " box");
			
			for (int i = 0; i < optionSize;i++) {
				
				driverWait.until(ExpectedConditions.elementToBeClickable(filterBox.findElements(By.tagName("option")).get(i)));
				
				System.out.println("select " + filterBox.findElements(By.tagName("option")).get(i).getText());
				
				filterBox.findElements(By.tagName("option")).get(i).click();
			}
			
			System.out.println("Click the " + filterBoxName + " filter");	
			
			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(strXpath)));
			
			Select selectFilter = new Select(driver.findElement(By.xpath(strXpath)));
			
			List<String> selectedValue = propFileSelectedValue.GetPropSelectedValue(filterBoxName);
			
			Iterator<String> iterator = selectedValue.iterator();
			
			while (iterator.hasNext()) {
				
				String selectValue = iterator.next();
				System.out.println("select " + filterBoxName + " " + selectValue);
				
				selectFilter.selectByVisibleText(selectValue);

			}
			
			results = true;
			
		} 
		
		catch (Exception e) {
			
			return results;
			
		}
		
		return results;
	}
	
}
