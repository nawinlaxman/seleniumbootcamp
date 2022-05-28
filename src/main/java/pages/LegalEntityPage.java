package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.asserts.SoftAssert;

public class LegalEntityPage {

	public RemoteWebDriver driver;

	public LegalEntityPage(RemoteWebDriver driver)
	{
		this.driver=driver;
	}

	public LegalEntityPage clickNewLegalEntity() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']//a[@role='button']//lightning-primitive-icon")).click();
				Thread.sleep(3000);
				// driver.findElement(By.xpath("//span[contains(text(),'New LegalEntity')]")).click();
				driver.executeScript("arguments[0].click()",driver.findElement(By.xpath("//span[contains(text(),'New Legal Entity')]")));
				// driver.findElement(By.xpath("//span[@class='slds-truncate']//span")).click();
				// driver.findElement(By.xpath("//span[text()='New Legal Entity']")).click();
				Thread.sleep(4000);
				return this;
	}
	
	public LegalEntityPage createNewLegalEntity(String name, String address, String city) throws InterruptedException
	{
		driver.findElement(By.xpath("(//input[@class=' input'])[1]")).sendKeys(name);
		driver.findElement(By.xpath("//textarea[contains(@class,'street compoundTLRadius')]")).sendKeys(address);
		driver.findElement(By.xpath("//input[contains(@class,'city compoundBorderBottom')]")).sendKeys(city);
		driver.findElement(By.xpath("//input[contains(@class,'state compoundBorderBottom')]")).sendKeys("Tamil Nadu");
		driver.findElement(By.xpath("//input[contains(@class,'postalCode compoundBLRadius')]")).sendKeys("600053");
		driver.findElement(By.xpath("//input[contains(@class,'country compoundBRRadius')]")).sendKeys("India");
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Wanye Enterprise");
		driver.findElement(By.xpath("(//textarea[@cols='20'])[2]")).sendKeys("Description area");
		driver.findElement(By.linkText("--None--")).click();
		driver.findElement(By.xpath("(//a[@role='menuitemradio'])[2]")).click();

		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(1000);
		return this;
	}

	public LegalEntityPage checkMessage() {
		// Sweet Alert
		boolean displayed = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).isDisplayed();
		String legalEntitytest = driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText();
		System.out.println(legalEntitytest);
		
		SoftAssert sa = new SoftAssert();
		sa.assertFalse(displayed);
		System.out.println(displayed);
		return this;
	}
}
