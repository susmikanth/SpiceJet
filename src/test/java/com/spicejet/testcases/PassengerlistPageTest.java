package com.spicejet.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.spicejet.base.TestBase;
import com.spicejet.pages.HomePage;
import com.spicejet.pages.LoginPage;
import com.spicejet.pages.PassengerlistPage;
import com.spicejet.util.TestUtil;

public class PassengerlistPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PassengerlistPage passengerlistPage;
	String sheetName="passengers";
	
	public PassengerlistPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage= new LoginPage();
		homePage= loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		passengerlistPage=new PassengerlistPage();
		homePage.clickOnPassengerlistLink();
		}
	
	@Test(priority=2)
	public void clickOnAddPasserlistLink(){
		passengerlistPage.clickOnAddPassenger();
	}


	@Test(priority=3)
	public void PassengerlistPageTestTitleTest(){
		String title= passengerlistPage.verifyPassengerlistPageTitle();
		Assert.assertEquals(title, "Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines", "Home page title not match");
	}
	

	@DataProvider
	public Object[][] getTestData(){
		Object data[][]= TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider="getTestData")
	public void validateCrateNewPassenger(String title, String fname, String lname, String Year, String Month, String Date, String Nationality) throws InterruptedException{
		passengerlistPage.clickOnAddPassenger();
		//passengerlistPage.addPassenger("MISS", "Tom", "Peter", 1988, "Feb", 6, "India");
		passengerlistPage.addPassenger(title, fname, lname, Year, Month, Date, Nationality);
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
	}
}
