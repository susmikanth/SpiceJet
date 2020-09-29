package com.spicejet.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spicejet.base.TestBase;
import com.spicejet.pages.HomePage;
import com.spicejet.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage= new LoginPage();
 	}
	
	
	@Test(priority=3)
	public void loginPageTitleTest(){
		String title= loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines");
	}
	
	@Test(priority=2)
	public void spicejetLogoTest(){
		boolean flag=loginPage.validateSpicejectLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=1)
	public void loginTest(){
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}
	
}
