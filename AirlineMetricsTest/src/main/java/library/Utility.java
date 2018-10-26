package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	
	public static WebElement isElementPresent(WebDriver driver, WebDriverWait driverWait, String xpath, int time) {
		
		WebElement ele = null;
		
		for (int i=0;i<time;i++) {
			
			try {
				
				driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

				ele = driver.findElement(By.xpath(xpath));
				
				System.out.println("Element is available");
				
				break;
				
			}
			
			catch(Exception e) {
				
				System.out.println("xpath=" + xpath);
				
				System.out.println("Element is not yet available, after" + String.valueOf(i + 1) + " times of retry.");
				
				try {
					
					Thread.sleep(3000L);
					
				}
				catch (InterruptedException e1) {
					
					System.out.println("Waiting for element to appear in DOM..");
				}
			}
		}
		
		return ele;
	}
	
	public static boolean isElementStillPresent(WebDriver driver, WebDriverWait driverWait, String xpath, int time) {
		
		boolean isDisplayed = true;
		
		for (int i=0;i<time;i++) {
			
			try {
				
				isDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
				
				if (isDisplayed) {
				
					System.out.println("Element is still displayed");
				
					throw new Exception();
					
				} else {
				
					System.out.println("Element is not displayed");
				
					break;
				}
				
			}
			
			catch(Exception e) {
				
				System.out.println("xpath=" + xpath);
				
				System.out.println("Element is still displayed, after" + String.valueOf(i + 1) + " times of retry.");
				
				try {
					
					Thread.sleep(5000L);
					
				}
				catch (InterruptedException e1) {
					
					System.out.println("Waiting for element to disappear in DOM..");
				}
			}
		}
		
		return isDisplayed;
	}
	
	public static WebElement isElementPresentInCSS(WebDriver driver, String cssSelector, int time) {
		
		WebElement ele = null;
		
		for (int i=0;i<time;i++) {
			try {
				
				ele = driver.findElement(By.cssSelector(cssSelector));
				
				break;
			}
			catch(Exception e) {
				try {
					Thread.sleep(3000L);
				}
				catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear in DOM..");
				}
			}
		}
		
		return ele;
	}
	
	
	public static void elementIsClicked(WebDriver driver, String xpath, WebDriverWait driverWait, int timesCount) throws Exception {
		
		boolean clicked = false;
		
		int i;
		
		for (i = 0;i < timesCount;i++) {
			try {
				
				driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				
				driver.findElement(By.xpath(xpath)).click();
				
				System.out.println("Successfully clicked the element through the Utility elementIsClicked method");
				
				clicked = true;
				
				break;
			}
			catch(Exception e) {
				
				System.out.println("Retrying the element to be click for the " + String.valueOf(i + 1) + " try through the Utility elementIsClicked method");
				try {
					Thread.sleep(5000L);
				}
				catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear in DOM..");
				}
			}
		}
		
		if (!clicked) {
			
			System.out.println("Element is not clickable after " + String.valueOf(i) + " times through the Utility elementIsClicked method" );
			
			throw new Exception();
		}
		
	}
	
	public static void elementIsClickable(WebDriver driver, String xpath, WebDriverWait driverWait, int timesCount) throws Exception {
		
		boolean clickable = false;
		
		int i;
		
		for (i = 0;i < timesCount;i++) {
			try {
				
				driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));;
							
				System.out.println("The element is clickable through the Utility elementIsClickable method");
				
				clickable = true;
				
				break;
			}
			catch(Exception e) {
				
				System.out.println("Retrying the element to be clickable for the " + String.valueOf(i + 1) + " time/s through the Utility elementIsClickable method");
				try {
					Thread.sleep(5000L);
				}
				catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear in DOM..");
				}
			}
		}
		
		if (!clickable) {
			
			System.out.println("Element is not clickable after " + String.valueOf(i) + " times through the Utility elementIsClickable method" );
			
			throw new Exception();
		}
		
	}

	public static void sendKeysToAcceptSuggestion(WebDriver driver, WebDriverWait driverWait, String xpath, String suggestionXpath, String keysSend, int timesCount) throws Exception {
		
		boolean success = false;
		
		String acceptedItem;
		
		int i;
		
		for (i = 0;i < timesCount;i++) {
			
			try {
				
				elementIsClickable(driver, xpath, driverWait, 10);
				
				if (i > 0) {
				
					driver.findElement(By.xpath(xpath)).sendKeys("");
					
				} 
										
				System.out.println("Send the keys " + keysSend + " to the element");
							
				driver.findElement(By.xpath(xpath)).sendKeys(keysSend);
				
				acceptedItem = driver.findElement(By.xpath(suggestionXpath)).getText();
				 																	
				System.out.println("Accept the label " + acceptedItem);
				
				elementIsClicked(driver, suggestionXpath, driverWait, 10);
								
				success = true;
				
				break;
				
			}
			
			catch(Exception e) {
				
				System.out.println("Retrying to send the keys to the element for the " + String.valueOf(i + 1) + " time/s through the Utility sendKeysToAcceptSuggestion method");
				try {
					Thread.sleep(5000L);
				}
				catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear in DOM..");
				}
			}
		}
		
		if (!success) {
			
			System.out.println("Failed to send the keys to the element after " + String.valueOf(i) + " times through the Utility sendKeysToAcceptSuggestion method" );
			
			throw new Exception();
		}
		
	}

}
