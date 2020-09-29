package com.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spicejet.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//div[@class='UserWelcome']")
	WebElement userNameLabel;
	
	@FindBy(xpath="(//a[contains(text(),'Passenger List')])[2]")
	WebElement passengerListLink;
	
	@FindBy (xpath="//li[@id='header-book']/a")
	WebElement searchPageLink;
	
	public HomePage(){
		PageFactory.initElements(driver,this);	
		}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public PassengerlistPage clickOnPassengerlistLink(){
		passengerListLink.click();
		return new PassengerlistPage();
	}
	
	public SearchPage clcikOnSearchPageLink(){
		searchPageLink.click();
		return new SearchPage();
	}
	
	public boolean verifyUserName(){
		return userNameLabel.isDisplayed();
	}
	
}
