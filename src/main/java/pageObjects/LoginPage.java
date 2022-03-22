package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
//	@FindBy(xpath="//div[@class='listbuilder-popup-content']//*[text()='NO THANKS']")
//	WebElement checked;
	
	By checked=By.xpath("//div[@class='listbuilder-popup-content']//*[text()='NO THANKS']");
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement login;
	
	@FindBy(xpath="//div/h2[text()='Featured Courses']")
	WebElement title;
	
	
	public LoginPage(WebDriver driver)   //Constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement Login()
	{
		return login;
	}
	
	public WebElement CheckedAlert()
	{
		return driver.findElement(checked);
	}
	
	
	public List<WebElement> CheckedAlertSize()
	{
		return driver.findElements(checked);
	}
	
	public WebElement getTitle()
	{
		return title;
	}

	
}
