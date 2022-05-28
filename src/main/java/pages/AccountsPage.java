package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import utils.ReadProperties;

public class AccountsPage {

	public RemoteWebDriver driver;

	
	
	public AccountsPage(RemoteWebDriver driver) {
		this.driver=driver;
	}
	
	public AccountsPage clickNewAccounts() throws InterruptedException {
		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage","newAccount"))).click();
		Thread.sleep(2000);
		return this;
	}
	
	public AccountsPage provideNewAccountDetails(String name) throws InterruptedException{
		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "accountName"))).sendKeys(name);

		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "accountOwnership"))).click();
		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "ownership_public"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "saveAccount"))).click();
		Thread.sleep(2000);
		return this;
	}
	
	public AccountsPage checkmessage() {
		boolean displayed = driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "message"))).isDisplayed();
		String successmsg = driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "message"))).getText();
		System.out.println(successmsg);
		//Hard Assert
		//Assert.assertTrue(displayed);

		//Soft Assert
		SoftAssert sa = new SoftAssert();
		sa.assertFalse(displayed);
		System.out.println(displayed);
		return this;
	}
	
	
}
