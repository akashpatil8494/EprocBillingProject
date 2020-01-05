package com.eprocbiling.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eprocbiling.qa.base.TestBase;

public class NewPurchaseOrderPage extends TestBase {

	@FindBy(xpath="//img[@title=\"Purchase Order\"]")
	WebElement image;
	
	@FindBy(xpath="//input[@type='text' and @name='Keywords']")
	WebElement supplierName;
	
	@FindBy(xpath="//input[@type='text' and @name='SuppCode']")
	WebElement supplierCode;
	
	@FindBy(xpath="//input[@type='submit' and @name='SearchSuppliers']")
	WebElement searchButton;
	
	@FindBy(xpath="//input[@type='submit' and @value='Reset']")
	WebElement resetButton;
	
	@FindBy(xpath="//table[2]//tbody//tr")
	WebElement table;
	
	public NewPurchaseOrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateNewPurchaseOrderPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateImage() {
		return image.isDisplayed();
	}
	
	public NewPurchaseOrderPage validateEnterSupplierName() {
		supplierName.sendKeys("Akash");
		resetButton.click();
		return new NewPurchaseOrderPage();
	}
	
	public NewPurchaseOrderPage validateSupplierCode() {
		supplierCode.sendKeys("Ak101");
		resetButton.click();
		return new NewPurchaseOrderPage();
	}
	
	public NewPurchaseOrderPage validateResetButton() {
		supplierName.sendKeys("Akash");
		supplierCode.sendKeys("Ak101");
		resetButton.click();
		return new NewPurchaseOrderPage();
	}
	
	public void validateTableData() {
		searchButton.click();
		List<WebElement> list = driver.findElements(By.xpath("//table[2]//tbody//tr"));
		
	for (int i = 0; i < list.size(); i++) {
		String text = list.get(i).getText();
		System.out.println(text);
		}
	driver.findElement(By.xpath("//input[@value='ABHISUPPLY']")).click();
	}
	
	public String validateTableDataClickingSuccessful() {
		validateTableData();
		return driver.getTitle();
	}


}
	
	
		

