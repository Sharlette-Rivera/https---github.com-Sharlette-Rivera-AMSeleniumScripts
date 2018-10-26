package Entity;

import java.io.IOException;

import library.GetPropertiesValue;

public class OriginDestinationFilter {

	private boolean testCheckBoxes;
	
	private int zoneTestCheckBoxesCount;
	
	private int countryTestCheckBoxesCount;
	

	public void retrieveSettingsFromConfig(String FilterBoxName) throws IOException {
		
		String properties = "config.properties";
		
		// Set properties file
		GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
		
		// Set value of public variables;
		
		testCheckBoxes = Boolean.parseBoolean(propertiesFile.GetPropValue(FilterBoxName + "TestCheckBoxes"));
		
		zoneTestCheckBoxesCount = Integer.parseInt(propertiesFile.GetPropValue(FilterBoxName + "ZoneTestCheckBoxesCount"));
		
		countryTestCheckBoxesCount = Integer.parseInt(propertiesFile.GetPropValue(FilterBoxName + "CountryTestCheckBoxesCount"));
			
	}
	
	public boolean getTestCheckBoxes() {
		return testCheckBoxes;
	}

	public void setTestCheckBoxes(boolean testCheckBoxes) {
		this.testCheckBoxes = testCheckBoxes;
	}

	public int getZoneTestCheckBoxesCount() {
		return zoneTestCheckBoxesCount;
	}

	public void setZoneTestCheckBoxesCount(int zoneTestCheckBoxesCount) {
		this.zoneTestCheckBoxesCount = zoneTestCheckBoxesCount;
	}

	public int getCountryTestCheckBoxesCount() {
		return countryTestCheckBoxesCount;
	}

	public void setCountryTestCheckBoxesCount(int countryTestCheckBoxesCount) {
		this.countryTestCheckBoxesCount = countryTestCheckBoxesCount;
	}

}
