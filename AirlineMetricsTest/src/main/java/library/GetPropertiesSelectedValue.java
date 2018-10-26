package library;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class GetPropertiesSelectedValue {
	
	String propertiesFileName;
	
	public GetPropertiesSelectedValue(String propertiesFleName) {
		
		propertiesFileName = propertiesFleName;
		
	}
	
	String keyValue;
	

	public List<String> GetPropSelectedValue(String propertyKey) throws IOException {

		InputStream inputStream = null;
		
		try {
			
			Properties prop = new Properties();
			String propFileName = propertiesFileName;
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				
				prop.load(inputStream);
				
			} else {
				
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				
			}
 
			// get the property value and print it out
			keyValue = prop.getProperty(propertyKey);
			
			if (keyValue == null || keyValue.isEmpty()) {
				
				System.out.println("Property Key to search is " + propertyKey + ", value is All" );
				
			} else {
				
				System.out.println("Property Key to search is " + propertyKey + ", values are " + keyValue );
			
			}
		} catch (Exception e) {
			
			System.out.println("Exception: " + e);
			
		} finally {
			
			inputStream.close();
			
		}
		
		ArrayList<String> results = new ArrayList<>();
		
		if (keyValue != null && !keyValue.isEmpty()) {
	
			results =  new ArrayList<String>(Arrays.asList(keyValue.split(",")));
		}
		
		return results;
		
	}

}
