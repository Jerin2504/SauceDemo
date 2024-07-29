package com.saucedemo.PageTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.saucedemo.Pages.AccountLoginPage;
import com.saucedemo.Pages.SwagLabsPage;
import com.saucedemo.TestBase.TestBase;



public class AccountLoginPageTest extends TestBase {
	
	AccountLoginPage accountLoginPage;
	SwagLabsPage swagLabsPage;
	SoftAssert softAssert;
	
	@BeforeMethod
	public void setup() {
		initailise();
		accountLoginPage = new AccountLoginPage();
		swagLabsPage = new SwagLabsPage();
		
		softAssert = new SoftAssert();
	}

	@Test
	public void validateAccountLogin() {
		accountLoginPage.enterUsername();
		accountLoginPage.enterPassword();
		accountLoginPage.clickSubmitBtn();
		
		softAssert.assertEquals(swagLabsPage.getTitle(), "Swag Labs");
	}
	
	@AfterMethod
	public void closeBrowser() {
		tearDown();
	}
}
