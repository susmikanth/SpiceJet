package com.spicejet.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.spicejet.base.TestBase;

public class SignUpPage extends TestBase{

	@FindBy(xpath="//a[@class='signup-link buttonN']")
	WebElement signUpLink;
	
	@FindBy(xpath="//select[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle']")
	WebElement Title;
	
	public SignUpPage(){
	PageFactory.initElements(driver,this);	
	}


	public void clikOnSignUpLink(){
		signUpLink.click();
	}
	
	public void title(String title){
		Title.sendKeys(title);
	}
}
