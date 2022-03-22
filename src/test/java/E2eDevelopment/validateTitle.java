package E2eDevelopment;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LoginPage;
import pageObjects.LoginToQaAcademy;
import resources.Base;

public class validateTitle extends Base
{
	
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =InitializeDriver();
		 log.info("Driver is initialized");
			
		driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");
	}
	
	@Test
	public void validateTitle() throws IOException
	{		 
	
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
	
		
		
		//one is inheritance
				// creating object to that class and invoke methods of it
			LoginPage loginPage = new LoginPage(driver);
				//compare the text from the browser with actual text.- Error..
				Assert.assertEquals(loginPage.getTitle().getText(), "FEATURED CO123URSES");
				 log.info("Successfully validated Text message");
				 System.out.println("Test completed");
				 
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}

}
