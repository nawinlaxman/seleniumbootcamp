package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AccountsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.ReadProperties;

public class CreateAccount {
	
	RemoteWebDriver driver;
	
	public void openBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		
	}
	
	public void loadURL() {
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(driver.getTitle());
	}
	
	public void enterUsername(String value) {
		driver.findElement(By.id(ReadProperties.getElementValue("LoginPage","username"))).sendKeys(value);
		
	}
	
	public void enterPassword(String value) {
		driver.findElement(By.id(ReadProperties.getElementValue("LoginPage","password"))).sendKeys(value);
	}
	
	public void clickLogin() throws InterruptedException {
	driver.findElement(By.id(ReadProperties.getElementValue("LoginPage","clicklgn"))).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	Thread.sleep(6000); //Add Webdriver wait

	}
	
	public void clickAllMenuIcon() throws InterruptedException {
		driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "allMenu"))).click();
		Thread.sleep(2000);
		}

	public void clickViewAll() throws InterruptedException {
		driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "viewAll"))).click();
		Thread.sleep(2000);
		}
	
	public void clickAccounts() throws InterruptedException {
		driver.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "clickAccount"))));
		Thread.sleep(2000);
		driver.findElement(By.xpath(ReadProperties.getElementValue("HomePage", "clickAccount"))).click();
		Thread.sleep(3000);
	}
	
	public void clickNewAccounts() throws InterruptedException {
		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage","newAccount"))).click();
		Thread.sleep(2000);
		
	}
	
	public void provideNewAccountDetails(String name) throws InterruptedException{
		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "accountName"))).sendKeys(name);

		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "accountOwnership"))).click();
		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "ownership_public"))).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "saveAccount"))).click();
		Thread.sleep(2000);
		
	}
	
	public void checkmessage() {
		boolean displayed = driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "message"))).isDisplayed();
		String successmsg = driver.findElement(By.xpath(ReadProperties.getElementValue("AccountsPage", "message"))).getText();
		System.out.println(successmsg);
		//Hard Assert
		//Assert.assertTrue(displayed);

		//Soft Assert
		SoftAssert sa = new SoftAssert();
		sa.assertFalse(displayed);
		System.out.println(displayed);
		
	}

}
