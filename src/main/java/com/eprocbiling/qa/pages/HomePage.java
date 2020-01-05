package com.eprocbiling.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eprocbiling.qa.base.TestBase;

public class HomePage extends TestBase{
	
		@FindBy(linkText="Customers")
		WebElement customerPageLink;
		
		@FindBy(linkText="Items")
		WebElement itemsPageLink;
		
		@FindBy(linkText="Logout")
		WebElement logoutLink;
		
		@FindBy(linkText="Receivables")
		WebElement receivablesPageLink;
		
		@FindBy(linkText="Purchases")
		WebElement purchasesPageLink;
		
		@FindBy(linkText="Payables")
		WebElement payablesPageLink;
		
		@FindBy(linkText="Inventory")
		WebElement inventoryPageLink;
		
		@FindBy(linkText="Manufacturing")
		WebElement manufacturingPageLink;
		
		
		public HomePage() {
			
			PageFactory.initElements(driver, this);
		}
		
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		public CustomerPage validateCustomerPageLInk() {
			customerPageLink.click();
			return new CustomerPage();
		}
		
		public LoginPage validateLogOutLink() {
			logoutLink.click();
			return new LoginPage();
		}
		
		public PurchasesPage validatePurchasesPageLink() {
			purchasesPageLink.click();
			return new PurchasesPage();
		}
		
		/*public ReceivablesPage validateReceivablesPageLink() {
			receivablesPageLink.click();
			return new ReceivablesPage();
		}
		
		public PayablesPage validatePayablesPageLink() {
			payablesPageLink.click();
			return new PayablesPage();
		}
		
		public InventoryPage validateInventoryPageLink() {
			inventoryPageLink.click();
			return new InventoryPage();
		}
		
		public ManufacturingPage validateManufacturingPageLink() {
			manufacturingPageLink.click();
			return new ManufacturingPage();
		}
		*/
	}
















