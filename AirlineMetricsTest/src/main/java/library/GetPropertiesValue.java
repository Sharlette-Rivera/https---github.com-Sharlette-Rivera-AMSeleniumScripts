package library;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetPropertiesValue {
	
	String propertiesFileName;
	
	public GetPropertiesValue(String propertiesFleName) {
		
		propertiesFileName = propertiesFleName;
		
	}
	
	String keyValue;
	

	public String GetPropValue(String propertyKey) throws IOException {

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
			
 
			System.out.println("Property Key to search is " + propertyKey + ", value = " + keyValue );
		} catch (Exception e) {
			
			System.out.println("Exception: " + e);
			
		} finally {
			
			inputStream.close();
			
		}
		
		return keyValue;
		
	}
	
}
