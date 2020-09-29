package com.spicejet.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spicejet.base.TestBase;
import com.spicejet.pages.HomePage;
import com.spicejet.pages.LoginPage;
import com.spicejet.pages.PassengerlistPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PassengerlistPage passengerlistPage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		passengerlistPage=new PassengerlistPage();
		loginPage= new LoginPage();
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
 	}
	
	@Test(priority=2)
	public void homePageTitleTest(){
		String title= homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "https://book.spicejet.com/SMProfile.aspx", "Home page title not match");
	}

	@Test(priority=3)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@Test(priority=1)
	public void verifyClickOnPassengerlistLink(){
		passengerlistPage= homePage.clickOnPassengerlistLink();
	}
	
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}
  
}
