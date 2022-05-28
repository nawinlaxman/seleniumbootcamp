package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;


import utils.ReadProperties;

public class HomePage {

public RemoteWebDriver driver;

	public HomePage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage clickAllMenuIcon() throws InterruptedException {
		driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "allMenu"))).click();
		Thread.sleep(2000);
		return this;
		}

	public HomePage clickViewAll() throws InterruptedException {
		driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "viewAll"))).click();
		Thread.sleep(2000);
		return this;
		}
	
	public AccountsPage clickAccounts() throws InterruptedException {
		driver.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "clickAccount"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "clickAccount"))).click();
		Thread.sleep(3000);
		return new AccountsPage(driver);
	}
	
	public LegalEntityPage clickLegalEntity() throws InterruptedException {
		driver.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "clickLegalEntity"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[text()='Legal Entities']")).click();
		Thread.sleep(3000);
		return new LegalEntityPage(driver);
	}
	
	
	
}
