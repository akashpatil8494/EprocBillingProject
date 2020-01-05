package com.eprocbiling.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eprocbiling.qa.base.TestBase;

public class CustomerPage extends TestBase {

	@FindBy(xpath="//img[@title='Customer']")
	WebElement customerImage;
	
	@FindBy(xpath="//p[text()=' Customers']")
	WebElement customerLabel;
	
	@FindBy(xpath="//p[text()=' Search for Customers']")
	WebElement searchForCustomerLabel;
	
	@FindBy(xpath="//input[@name='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//a[@href=\"/projects/eprocbiling/Customers.php\"]")
	WebElement addNewCustomerLink;
	
	//table[@cellpadding="4"]//tbody//tr//td[1]
	String before_xpath="//table[@cellpadding=\"4\"]//tbody//tr//td[";
	String after_xpath="]";
	
	public CustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateCustomerLabel() {
		return customerLabel.getText();
	}
	
	public boolean validateCustomerImage() {
		return customerImage.isDisplayed();
	}
	
	public String validateSearchCustomerLabel() {
		return searchForCustomerLabel.getText();
	}
	
	public AddNewCustomerPage validateAddNewCustomerLink() {
		for(int i=1; i<=3;i++) {
			
		String table=driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
		System.out.println(table);
		if(table.contains("Add a New Customer")) {
			driver.findElement(By.xpath(before_xpath+i+after_xpath)).click();	
		}	
	}
	return new AddNewCustomerPage();
	}
	
	
	public void validateSearchCustomerFromTable() {
		searchButton.click();
		
		List<WebElement> list = driver.findElements(By.xpath("//table[@cellpadding='2']//tbody//tr//td"));
	
		for (int i = 1; i < list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("123ABC 123ABC")) {
				list.get(i).click();
				break;
				
			}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}