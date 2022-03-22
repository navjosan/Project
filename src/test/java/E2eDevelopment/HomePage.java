package E2eDevelopment;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LoginPage;
import pageObjects.LoginToQaAcademy;
import resources.Base;

public class HomePage extends Base
{
	
	@Test(dataProvider="getData")
	public void HomePage(String email_id, String password) throws IOException
	{
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));
		
		log.info("Driver is getting initialized");
		 
		LoginPage loginPage = new LoginPage(driver);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
	
		loginPage.CheckedAlert().click();
		loginPage.Login().click();
		
		
		LoginToQaAcademy login_qa = new LoginToQaAcademy(driver);
		
		log.info("Successfully moving to the LoginToQaAcademt");

		
		login_qa.Login_Qa_Page().sendKeys(email_id);
		login_qa.Pass_Code().sendKeys(password);
		login_qa.Submit().click();	
		
		log.info("Running");	
	}
	
	@DataProvider
	public Object getData()
	{
		Object[][] data = new Object[2][2];
		
		//Set 1
		data[0][0] = "navjosan123@gmail.com";
		data[0][1] = "navjosan123";
		
		//Set 2
		data[1][0] = "avalnoor123@gmail.com";
		data[1][1] = "avalnoorjosan123";
		
		return data;
	}

//	@Test
//	public void Validations()
//	{
//		Assert.assertEquals(loginPage.getTitle().getText(), "Featured Courses");
//	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
