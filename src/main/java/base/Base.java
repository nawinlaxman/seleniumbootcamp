package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class Base {

	public RemoteWebDriver driver;
	String excelFileName;
	
	@BeforeMethod
	public void launchBrowser() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();

	}
	
	@DataProvider(name="ProvideData")
	public String[][] getExcelData() throws IOException {
	
		String [][] readData = ReadExcel.getExcelData(excelFileName); 
		return readData;
	}


}
