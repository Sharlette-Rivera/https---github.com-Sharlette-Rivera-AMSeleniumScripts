package TestModules;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import hibernate.configuration.AppConfig;

import base.StartSeleniumTest;
import hibernate.model.TicketedRevenue;
import hibernate.service.TicketedRevenueService;
import library.GetPropertiesValue;

public class DebugTableReport extends StartSeleniumTest {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String properties = "ticketedRevenueReport.properties";
		
		// Set properties file
		GetPropertiesValue propertiesFile = new GetPropertiesValue(properties);
		
		openBrowser();
		
		WebDriver driver = getDriver();
		
		// Create an instance of Explicit wait driver
		WebDriverWait driverWait = new WebDriverWait(driver, 20);

		// Set properties file
		propertiesFile = new GetPropertiesValue(properties);
		

		System.out.println("Click the Ticketed Revenue Report option");
		
		// Click Revenue Metrics Module
		String revenueMetricsXpath = propertiesFile.GetPropValue("RevenueMetricsXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(revenueMetricsXpath)));
		driver.findElement(By.xpath(revenueMetricsXpath)).click();
		String ticketedRevenueReportXpath = propertiesFile.GetPropValue("TicketedRevenueReportXpath");
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(ticketedRevenueReportXpath)));
		driver.findElement(By.xpath(ticketedRevenueReportXpath)).click();
		
		System.out.println("Click the Current Year Vs Last Year tab");
		String currentYearVsLastYearTabXpath = propertiesFile.GetPropValue("CurrentYearVsLastYearTabXpath");
		
		// Apply Explicit wait.
		driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(currentYearVsLastYearTabXpath)));
		driver.findElement(By.xpath(currentYearVsLastYearTabXpath)).click();
		
		// Delay 3 seconds to complete the display of all filter check boxes.
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		String currentYearVsLastYearTableHeaderXpath = propertiesFile.GetPropValue("CurrentYearVsLastYearTableHeaderXpath");
		WebElement tableHeader = driver.findElement(By.xpath(currentYearVsLastYearTableHeaderXpath));
		
		int headerCount = tableHeader.findElements(By.tagName("td")).size();

		String columnHeaderXpath = "";
		String headerName = "";
		
		HashMap<String,String> headerColumns = new HashMap<String, String>();
		
		for (int i = 1; i <= headerCount; i++) {
			
			columnHeaderXpath = currentYearVsLastYearTableHeaderXpath + "/td[" + String.valueOf(i) + "]";
			headerName = driver.findElement(By.xpath(columnHeaderXpath)).getText();
			
			headerColumns.put("Header" + String.valueOf(i),headerName);
				
		}
		
		for (Map.Entry<String, String> m:headerColumns.entrySet()) {
			System.out.println("Key is " + m.getKey() + " with value of " + m.getValue() );
		}
		
		String currentYearVsLastYearTableElementXpath = propertiesFile.GetPropValue("CurrentYearVsLastYearTableElementXpath");

		WebElement tableBody = driver.findElement(By.xpath(currentYearVsLastYearTableElementXpath));
		
		int rowCount = tableBody.findElements(By.tagName("tr")).size();
		
		String columnElementXpath = "";
		String columnElementValue = "";
		String columnKey = "";
		String columnValue = "";
		
		List <TicketedRevenue> listTicketedRevenue = new ArrayList<TicketedRevenue>();
		
		for (int r = 1; r <= rowCount; r++) {
			
		
			TicketedRevenue ticketedRevenue = new TicketedRevenue();
			
			
			for (int i = 1; i <= headerCount; i++) {
				
				columnElementXpath = currentYearVsLastYearTableElementXpath + "/tr/td[" + String.valueOf(i) + "]";
				columnElementValue = driver.findElement(By.xpath(columnElementXpath)).getText();
				
				columnKey = "Header" + String.valueOf(i);
				
				columnValue = headerColumns.get(columnKey);
				
				switch (columnValue) {
				
				case "Year":
					ticketedRevenue.setYear(Integer.valueOf(columnElementValue));
					break;
	
				case "Jan":
					ticketedRevenue.setJanuary(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Feb":
					ticketedRevenue.setFebruary(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Mar":
					ticketedRevenue.setMarch(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Apr":
					ticketedRevenue.setApril(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "May":
					ticketedRevenue.setMay(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Jun":
					ticketedRevenue.setJune(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Jul":
					ticketedRevenue.setJuly(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Aug":
					ticketedRevenue.setAugust(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Sep":
					ticketedRevenue.setSeptember(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Oct":
					ticketedRevenue.setOctober(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Nov":
					ticketedRevenue.setNovember(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Dec":
					ticketedRevenue.setDecember(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
				case "Grand Total":
					ticketedRevenue.setTotal(BigDecimal.valueOf(Double.parseDouble(columnElementValue.replace(",", ""))));
					break;
	
				}
				
				ticketedRevenue.setTabName("CurrentYearVsLastYear");
				
				listTicketedRevenue.add(ticketedRevenue);
			}
		}
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		TicketedRevenueService service = (TicketedRevenueService) context.getBean("ticketedRevenueService");
		
		for (TicketedRevenue eachTicketedRevenue: listTicketedRevenue) {
			
			service.saveTicketedRevenue(eachTicketedRevenue);
			
		}
		
		context.close();
	}
}
