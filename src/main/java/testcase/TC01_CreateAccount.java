package testcase;

import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class TC01_CreateAccount extends Base {
	
	
	@Test
	public void testCreateAccount() throws InterruptedException
	{
		new LoginPage(driver)
		.enterUsername("matschie@testleaf.com")
		.enterPassword("BootcampSel$123")
		.clickLogin()
		.clickAllMenuIcon()
		.clickViewAll()
		.clickAccounts()
		.clickNewAccounts()
		.provideNewAccountDetails("testname")
		.checkmessage();
	}
}
