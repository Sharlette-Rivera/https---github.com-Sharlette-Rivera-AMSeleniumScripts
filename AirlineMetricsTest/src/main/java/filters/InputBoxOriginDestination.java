package filters;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Entity.OriginDestinationFilter;
import library.GetPropertiesSelectedValue;
import library.GetPropertiesValue;
import library.Utility;

public class InputBoxOriginDestination {

	public static boolean inputOriginDestinationFilters(WebDriver driver, String tabName, String filterBoxName, 
			String properties, OriginDestinationFilter originDestinationFilter) {
		
		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);
		
		// Set properties file
		GetPropertiesValue propFile = new GetPropertiesValue(properties);
		
		// Set properties file
		GetPropertiesSelectedValue propFileSelectedValue = new GetPropertiesSelectedValue("selectedItems.properties");
		
		System.out.println("Test " + filterBoxName + " box");

		boolean results = false;
		
		try {
			
			String zoneInputDialogBoxXpath=propFile.GetPropValue(tabName+filterBoxName+"ZoneInputDialogBoxXpath");
			
			String countryInputDialogBoxXpath = propFile.GetPropValue(tabName+filterBoxName+"CountryInputDialogBoxXpath");
			
			String airportsInputDialogBoxXpath = propFile.GetPropValue(tabName+filterBoxName+"AirportsInputDialogBoxXpath");
			
			String closeButtonXpath = propFile.GetPropValue(tabName+filterBoxName+"CloseButtonXpath");
			
            String filterBoxXpath =	propFile.GetPropValue(tabName+filterBoxName+"Xpath");
            
			System.out.println("Click the " + filterBoxName + " filter box");
			driver.findElement(By.xpath(filterBoxXpath)).click();

			// Delay 3 seconds to complete the display of the country Show/Hide button.
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
			boolean isDisplayed;
			
			if (originDestinationFilter.getTestCheckBoxes()) {

				String optionXpath = propFile.GetPropValue(tabName+filterBoxName+"ZoneCheckBoxOptionXpath");

				System.out.println("Testing zone check boxes");
				
				// Validate if zone check boxes are displayed by validating if it is in Show or Hide List label
				String zoneShowHideListXpath = propFile.GetPropValue(tabName+filterBoxName+"ZoneShowHideListXpath");
				
				isDisplayed = driver.findElement(By.xpath(zoneShowHideListXpath)).isDisplayed();
				
				if (isDisplayed) {
					
					String zoneShowHideListLabel = driver.findElement(By.xpath(zoneShowHideListXpath)).getText();
					
					boolean zoneCheckBoxesShown = true;
					
					if (zoneShowHideListLabel.equalsIgnoreCase("Show List")) {
						
						zoneCheckBoxesShown = false;
						
						try {
						
							System.out.println("The Zone Show/Hide List button is set to Hide List");

							Utility.elementIsClicked(driver, zoneShowHideListXpath, driverWait, 10);
							
							System.out.println("Click the Zone Show/Hide List button to Show List");
							
							zoneCheckBoxesShown = true;
						
						} catch (Exception e) {
							
							System.out.println("Maximum waiting time reached");
							
						}
					}
					
					// If zone check boxes are shown
					if(zoneCheckBoxesShown) {
					
						String zoneCheckBoxWebElement = propFile.GetPropValue(tabName+filterBoxName+"ZoneCheckBoxWebElementXpath");
						
						WebElement zoneCheckBox = driver.findElement(By.xpath(zoneCheckBoxWebElement));
						
						int intZoneCount = zoneCheckBox.findElements(By.tagName("div")).size();
						
						System.out.println("Number of elements for " + filterBoxName + " Zone check boxes is " + String.valueOf(intZoneCount));
				
						System.out.println("Check all zone check boxes");
								
						int zoneCheckBoxSelected = 0;
						
						for (int i = 2; i <= intZoneCount; i++) {
							
							isSelected = false;
							xpath = optionXpath + "[" + String.valueOf(i) + "]/input";
							labelXpath = optionXpath + "[" + String.valueOf(i) +"]/span";
							
							// Delay 5 seconds to complete the display of the filter check boxes.
							try {
								Thread.sleep(5000L);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
						
							isSelected = driver.findElement(By.xpath(xpath)).isSelected();
						
							if (!isSelected) {
								
								try {
									
										
										label = Utility.isElementPresent(driver, driverWait, labelXpath, 10).getText();
								
										System.out.println("Click " + label + " Check box");
								
										Utility.elementIsClicked(driver, xpath, driverWait, 10);
										
										zoneCheckBoxSelected++;
	
										if (zoneCheckBoxSelected > originDestinationFilter.getZoneTestCheckBoxesCount()) {
											
											break;
										}
										
								} catch (Exception e) {
									
									System.out.println("Maximum waiting time reached");
									
								}
							}
								
						}
					}
				}
				
			
				optionXpath = propFile.GetPropValue(tabName+filterBoxName+"CountryCheckBoxOptionXpath");
				
				// Delay 3 seconds to complete the display of the country Show/Hide button.
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Testing country check boxes");
			
				// Validate if country check boxes are displayed by validating if it is in Show or Hide List label
				String countryShowHideListXpath = propFile.GetPropValue(tabName+filterBoxName+"CountryShowHideListXpath");
			
				isDisplayed = driver.findElement(By.xpath(countryShowHideListXpath)).isDisplayed();
			
				if (isDisplayed) {
				
					String countryShowHideListLabel = driver.findElement(By.xpath(countryShowHideListXpath)).getText();
					
					boolean countryCheckBoxesShown = true;
				
					if (countryShowHideListLabel.equalsIgnoreCase("Show List")) {
						
						countryCheckBoxesShown = false;
						
						try {
					
							System.out.println("The Country Show/Hide List button is set to Hide List");
													
							Utility.elementIsClicked(driver, countryShowHideListXpath, driverWait, 10);
						
							System.out.println("Click the Country Show/Hide List button to Show List");
							
							countryCheckBoxesShown = true;
						
						} catch (Exception e) {
							
							System.out.println("Maximum waiting time reached");
					
						}
					}
					
					// If country check boxes are shown
					if(countryCheckBoxesShown) {
						
						String countryCheckBoxWebElement = propFile.GetPropValue(tabName+filterBoxName+"CountryCheckBoxWebElementXpath");
					
						WebElement countryCheckBox = driver.findElement(By.xpath(countryCheckBoxWebElement));
					
						int intCountryCount = countryCheckBox.findElements(By.tagName("div")).size();
					
						System.out.println("Number of elements for " + filterBoxName + " Country check boxes is " + String.valueOf(intCountryCount));
					
						int countryCheckBoxSelected  = 0;
					
						System.out.println("Check all countries check boxes");
					
						for (int i = 6; i <= intCountryCount; i++) {
						
							isSelected = false;
							xpath = optionXpath + "[" + String.valueOf(i) + "]/input";
							labelXpath = optionXpath + "[" + String.valueOf(i) +"]/span";
						
							// Delay 5 seconds to complete the display of the filter check boxes.
							try {
								Thread.sleep(5000L);
							} catch (InterruptedException e) {
							// TODO Auto-generated catch block
								e.printStackTrace();
							}
				
							isSelected = driver.findElement(By.xpath(xpath)).isSelected();
					
							if (!isSelected) {
							
								try {
													
									label = Utility.isElementPresent(driver, driverWait, labelXpath, 10).getText();
							
									System.out.println("Click " + label + " Check box");
								
									Utility.elementIsClicked(driver, xpath, driverWait, 10);
									
									countryCheckBoxSelected++;
									
									if (countryCheckBoxSelected > originDestinationFilter.getCountryTestCheckBoxesCount()) {
										
										break;
									}
									
									i= i + 4;
									
								} catch (Exception e) {
									
									System.out.println("Maximum waiting time reached");
							
								}
								
							}
		
						}
					}
				}
				
				optionXpath = propFile.GetPropValue(tabName+filterBoxName+"CountryDialogBoxOptionXpath");
				
				// Delay 3 seconds to complete the display of the filter check boxes.
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Testing remove selected country in the dialog box");
							
				String countryDialogBoxWebElement = propFile.GetPropValue(tabName+filterBoxName+"CountryDialogBoxWebElementXpath");
				
				WebElement countryDialogBox = driver.findElement(By.xpath(countryDialogBoxWebElement));
				
				int intCountryCount = countryDialogBox.findElements(By.tagName("span")).size();
				
				intCountryCount = (intCountryCount -  1)/2;
				
				System.out.println("Number of elements for " + filterBoxName + " Country dialog box is " + String.valueOf(intCountryCount));
							
				System.out.println("Remove all selected countries in the dialog boxes");
				
				for (int i = intCountryCount; i > 0; i--) {
					
					isDisplayed = false;
					xpath = optionXpath + "[" + String.valueOf(i) + "]/span";
					labelXpath = optionXpath + "[" + String.valueOf(i) +"]";
					
					// Delay 5 seconds to complete the display of the filter check boxes.
					try {
						Thread.sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
					isDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
				
					if (isDisplayed) {
						
						try {
						
							label = driver.findElement(By.xpath(labelXpath)).getText();
						
							System.out.println("Remove " + label + " country");
						
							Utility.elementIsClicked(driver, xpath, driverWait, 10);

						
						} catch (Exception e) {
							
							System.out.println("Maximum waiting time reached");
					
						}
					}
				}		
				
				// Delay 3 seconds to complete the display of the filter check boxes.
				try {
					Thread.sleep(3000L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Testing remove selected zones in the dialog box");
				
				String zoneDialogBoxWebElement = propFile.GetPropValue(tabName+filterBoxName+"ZoneDialogBoxWebElementXpath");
					
				WebElement zoneDialogBox = driver.findElement(By.xpath(zoneDialogBoxWebElement));
					
				int intZoneCount = zoneDialogBox.findElements(By.tagName("span")).size();
				
				intZoneCount = (intZoneCount -1)/2;
					
				System.out.println("Number of elements for " + filterBoxName + " Zone dialog boxes is " + String.valueOf(intZoneCount));
			
				System.out.println("Remove all selected zones in the dialog box");
				
				optionXpath = propFile.GetPropValue(tabName+filterBoxName+"ZoneDialogBoxOptionXpath");
							
				for (int i = intZoneCount; i > 0; i--) {
						
					isDisplayed = false;
					xpath = optionXpath + "[" + String.valueOf(i) + "]/span";
					labelXpath = optionXpath + "[" + String.valueOf(i) +"]";
						
					// Delay 10 seconds to complete the display of the filter check boxes.
					try {
						Thread.sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					isDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
				
					if (isDisplayed) {
						
						try {
							
								label = driver.findElement(By.xpath(labelXpath)).getText();
						
								System.out.println("Remove " + label + " zone");
						
								Utility.elementIsClicked(driver, xpath, driverWait, 10);
								

						} catch (Exception e) {
							
							System.out.println("Maximum waiting time reached");
							
						}
					}
				}
			}
			

			// Delay 5 seconds to complete the display of the zone dialog box.
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<String> selectedItems =  new ArrayList<String>();
			
			selectedItems = propFileSelectedValue.GetPropSelectedValue(filterBoxName+"Zone");
			
			String suggestionXpath;
			
			if (!selectedItems.isEmpty()) {
		
				System.out.println("Select only selected zones in " + filterBoxName + " dialog box");

				for (int i = 1; i <= selectedItems.size();i++) {
					
					isDisplayed = false;

					xpath = zoneInputDialogBoxXpath + "[" + String.valueOf(i) + "]/input[2]";
					suggestionXpath = zoneInputDialogBoxXpath + "[" + String.valueOf(i) +"]/div/div/div";
					
					// Delay 5 seconds to complete the display of the selected zone.
					try {
						Thread.sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
									
					isDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
					
					if (isDisplayed) {
						
						try {
							
							label = selectedItems.get(i - 1).toString();
							
							Utility.sendKeysToAcceptSuggestion(driver, driverWait, xpath, suggestionXpath, label, 10);							
					
						} catch (Exception e) {
							
							System.out.println("Maximum waiting time reached");
						}
					}
				}
			}

			// Delay 5 seconds to complete the display of the country dialog box.
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			selectedItems =  new ArrayList<String>();
			
			selectedItems = propFileSelectedValue.GetPropSelectedValue(filterBoxName+"Country");
			
			if (!selectedItems.isEmpty()) {
		
				System.out.println("Select only selected countries in " + filterBoxName + " dialog box");

				for (int i = 1; i <= selectedItems.size();i++) {
					
					isDisplayed = false;

					xpath = countryInputDialogBoxXpath + "[" + String.valueOf(i) + "]/input[2]";
					suggestionXpath = countryInputDialogBoxXpath + "[" + String.valueOf(i) +"]/div/div/div";
					
					// Delay 5 seconds to complete the display of the selected country.
					try {
						Thread.sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
									
					isDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
					
					if (isDisplayed) {
						
						try {
												
							label = selectedItems.get(i - 1).toString();
										
							Utility.sendKeysToAcceptSuggestion(driver, driverWait, xpath, suggestionXpath, label, 10);
						
						} catch (Exception e) {
							
							System.out.println("Maximum waiting time reached");
						}
					}
				}
			}

			// Delay 5 seconds to complete the display of the airports dialog box.
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			selectedItems =  new ArrayList<String>();
			
			selectedItems = propFileSelectedValue.GetPropSelectedValue(filterBoxName+"Airports");
			
			if (!selectedItems.isEmpty()) {
		
				System.out.println("Select only selected airports in " + filterBoxName + " dialog box");

				for (int i = 1; i <= selectedItems.size();i++) {
					
					isDisplayed = false;

					xpath = airportsInputDialogBoxXpath + "[" + String.valueOf(i) + "]/input[2]";
					suggestionXpath = airportsInputDialogBoxXpath + "[" + String.valueOf(i) +"]/div/div/div";
					
					// Delay 5 seconds to complete the display of the selected airport.
					try {
						Thread.sleep(5000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
									
					isDisplayed = driver.findElement(By.xpath(xpath)).isDisplayed();
					
					if (isDisplayed) {
						
						try {
												
							label = selectedItems.get(i - 1).toString();
													
							Utility.sendKeysToAcceptSuggestion(driver, driverWait, xpath, suggestionXpath, label, 10);
							
						} catch (Exception e) {
							
							System.out.println("Maximum waiting time reached");
						}
					}
				}
			}

			// Delay 5 seconds to complete the display of the close button.
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(closeButtonXpath)));
			boolean closeButtonIsdisplayed = Utility.isElementPresent(driver, driverWait, closeButtonXpath, 10).isDisplayed();
			
			// If the filter box close button is displayed
			if (closeButtonIsdisplayed) {
				
				System.out.println("Click the " + filterBoxName + " close button");
				
				Utility.elementIsClicked(driver, closeButtonXpath, driverWait, 10);
				
			}
			
			results = true;	
		
		}
		
		catch (Exception e) {
			
			return results;
			
		}
		
		return results;
	}
}
