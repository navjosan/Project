package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.io.File;


public class Base
{
	public WebDriver driver;
	public Properties prop;
	
	public static Logger log =  LogManager.getLogger(Base.class.getName());
	
	public WebDriver InitializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\kaurn\\eclipse-workspace\\E2eDevelopment\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		log.info("Successfully passing the parameters ");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kaurn\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\kaurn\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		else if(browserName.equals("Internet Explorer"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\kaurn\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		return driver;
		
			}
	
	public String getScreenshots(String testCaseName , WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		   File source =ts.getScreenshotAs(OutputType.FILE);
//		File source=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+".png";
		System.out.println(destinationFile);
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
}
