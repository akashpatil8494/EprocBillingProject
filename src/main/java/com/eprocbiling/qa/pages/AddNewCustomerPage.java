package com.eprocbiling.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.eprocbiling.qa.base.TestBase;

public class AddNewCustomerPage extends TestBase {
	
	@FindBy(xpath="//p[@class='page_title_text']")
	WebElement customerMaintainceLabel;
	
	@FindBy(xpath="//input[@name='DebtorNo']")
	WebElement customerCode;
	
	@FindBy(name="CustName")
	WebElement customerName;
	
	@FindBy(name="Address1")
	WebElement customerstreet;
	
	@FindBy(name="Address3")
	WebElement customercity;
	
	@FindBy(name="Address4")
	WebElement customerstate;
	
	@FindBy(xpath="//select[@name='Address6']")
	WebElement countryDropDown;
	
	@FindBy(xpath="//input[@name='ClientSince']")
	WebElement customerdate;
	
	@FindBy(xpath="//input[@type='submit' and @value='Add New Customer']")
	WebElement submitButton;
	
	@FindBy(xpath="//input[@name='ContactName']")
	WebElement addBranch;
	
	@FindBy(xpath="//input[@value='Enter Or Update Branch']")
	WebElement enterBranch;
	
	
	
	public AddNewCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddCustomerPageTitle() {
		return driver.getTitle();
	}
	
	public String validateCustomerMaintainceLabel() {
		return customerMaintainceLabel.getText();
	}
	
	public void validateAddNewCustomer(String code, String name, String street,String city, String state, String country, String branchName) {
		customerCode.clear();
		customerCode.sendKeys(code);
		customerName.clear();
		customerName.sendKeys(name);
		customerstreet.clear();
		customerstreet.sendKeys(street);
		customercity.clear();
		customercity.sendKeys(city);
		customerstate.clear();
		customerstate.sendKeys(state);
		
		Select select = new Select(countryDropDown);
		select.selectByVisibleText("India");
	
		submitButton.click();
		addBranch.sendKeys(branchName);
		enterBranch.click();
		
		
		
	}
	
	
	
	

}
