package base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

import library.GetPropertiesValue;

public class StartSeleniumTest {
	
	// Create a global driver
	public static WebDriver driver;
	
	public static GetPropertiesValue propertiesFile;
	
	@BeforeTest
	public static void openBrowser() throws IOException {
		
		// Set properties file
		propertiesFile = new GetPropertiesValue("config.properties");

		String webBrowser = propertiesFile.GetPropValue("browser");
		
	
		if (webBrowser.equalsIgnoreCase("chrome")) {
			
			// Create an instance of Web driver for Chrome browser
			System.setProperty("webdriver.chrome.driver", "C://work//chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (webBrowser.equalsIgnoreCase("firefox")) {
			
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize(); // Maximize the Browser Window.
		
		System.out.println("Open Airline Metrics web Application");
		String url = propertiesFile.GetPropValue("url");
		driver.get(url);
		
		System.out.println("Enter user login address");
		String user = propertiesFile.GetPropValue("user");
		driver.findElement(By.id("identity")).sendKeys(user);
		
		System.out.println("Enter user login password");
		String password = propertiesFile.GetPropValue("password");
		driver.findElement(By.id("password")).sendKeys(password);
		
		// Click the login button
		String strLoginButton = propertiesFile.GetPropValue("loginButton");
		WebElement loginButton = driver.findElement(By.xpath(strLoginButton));
		loginButton.click();
		
		System.out.println("Login successfully");
		
		// Delay 10 seconds to complete the display of the filter check boxes.
		try {
			Thread.sleep(10000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static GetPropertiesValue getPropertiesFile() {
		return propertiesFile;
	}

	public static void setPropertiesFile(GetPropertiesValue propertiesFile) {
		StartSeleniumTest.propertiesFile = propertiesFile;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		StartSeleniumTest.driver = driver;
	}
	

}
