package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.Base;
import utils.ReadProperties;

public class LoginPage extends Base {
	
	public RemoteWebDriver driver;
	
	public LoginPage (RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage enterUsername(String value) {
		driver.findElement(By.id(ReadProperties.getElementValue("LoginPage","username"))).sendKeys(value);
		return this;
	}
	
	public LoginPage enterPassword(String value) {
		driver.findElement(By.id(ReadProperties.getElementValue("LoginPage","password"))).sendKeys(value);
		return this;
	}
	
	public HomePage clickLogin() throws InterruptedException {
	driver.findElement(By.id(ReadProperties.getElementValue("LoginPage","clicklgn"))).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Thread.sleep(6000); //Add Webdriver wait
	return new HomePage(driver);
	}
	
	

}
