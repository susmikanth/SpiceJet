package com.spicejet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.spicejet.base.TestBase;

public class PassengerlistPage extends TestBase{

	@FindBy(xpath="//input[@value='Add Passenger']")
	WebElement AddPassengerLink;
	
	@FindBy(id="ControlGroupGuestListView_TxtFirstName")
	WebElement firstName;
	
	@FindBy(id="ControlGroupGuestListView_TxtLastName")
	WebElement lastName;
	
	@FindBy(id="ControlGroupGuestListView_ButtonSubmit")
	WebElement submitBtn;
	
	public PassengerlistPage(){
		PageFactory.initElements(driver,this);	
		}
	
	public String verifyPassengerlistPageTitle(){
		return driver.getTitle();
	}

	public void clickOnAddPassenger(){
		AddPassengerLink.click();
	}
	
	public void addPassenger(String title, String fname, String lname, String Year, String Month, String Date, String Nationality) throws InterruptedException{
		//driver.findElement(By.xpath("//select[@id='ControlGroupGuestListView_DdlTitle']")).click();
		Select select=new Select(driver.findElement(By.xpath("//select[@name='ControlGroupGuestListView$DdlTitle']")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		
		driver.findElement(By.xpath("//input[@id='guestListCalDob']")).click();
       // WebElement ele = driver.findElement(By.xpath("//span[text()='"+ Year +"']"));
        WebElement ele = driver.findElement(By.xpath("//tbody[@class='datepickerYears']/tr/td/a/span[text()='"+ Year +"']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", ele);
        Thread.sleep(10000);
        WebElement ele1 = driver.findElement(By.xpath("(//span[text()='"+Month+"'])[1]"));
        JavascriptExecutor js1 = (JavascriptExecutor)driver;
        js1.executeScript("arguments[0].click();", ele1);                
        Thread.sleep(10000);

		//driver.findElement(By.xpath("//span[text()='"+ Year +"']")).click();
		//driver.findElement(By.xpath("(//span[text()='"+Month+"'])[2]")).click();
		driver.findElement(By.xpath("//tbody[@class='datepickerDays']/tr/td/a/span[text()='"+Date+"']")).click();
        Thread.sleep(10000);

		Select select1=new Select(driver.findElement(By.xpath("//select[@id='ControlGroupGuestListView_DdlNationality']")));
		select1.selectByVisibleText(Nationality);
		submitBtn.click();
	}
	
}
