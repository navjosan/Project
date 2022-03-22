package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginToQaAcademy 
{

	WebDriver driver;
	
	By login = By.xpath("//input[@type='email']");
	By pass_code = By.xpath("//input[@type='password']");
	By submit = By.xpath("//input[@type='submit']");
	
	
	public LoginToQaAcademy(WebDriver driver) 
	{
		this.driver = driver;
	}


	public WebElement Login_Qa_Page()
	{
		return driver.findElement(login);
	}
	
	public WebElement Pass_Code()
	{
		return driver.findElement(pass_code);
	}
	
	public WebElement Submit()
	{
		return driver.findElement(submit);
	}
	
}
