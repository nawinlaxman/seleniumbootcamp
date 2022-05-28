package testcase;

import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class TC02_CreateLegalEntity extends Base {

	@Test(dataProvider="ProvideData")
	public void testCreateLegalEntity() throws InterruptedException {
		new LoginPage(driver)
		.enterUsername("matschie@testleaf.com")
		.enterPassword("BootcampSel$123")
		.clickLogin()
		.clickAllMenuIcon()
		.clickViewAll()
		.clickLegalEntity()
		.clickNewLegalEntity()
		.createNewLegalEntity("name", "address", "city")
		.checkMessage();
	}

}
