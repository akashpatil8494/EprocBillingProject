package com.eprocbiling.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eprocbiling.qa.base.TestBase;

public class PurchasesPage extends TestBase {
	
	@FindBy(xpath="//img[@title='Transactions' and @alt='Transactions']")
	WebElement transactionImage;
	
	@FindBy(xpath="//a[text()=\"New Purchase Order\"]")
	WebElement newPurchaseOrderLink;
	
	@FindBy(xpath="//a[text()='Purchase Orders']")
	WebElement purchaseOrdersLink;
	
	@FindBy(xpath="//a[text()='Purchase Order Inquiry']")
	WebElement purchaseOrderInquiryLink;

	
	
	public PurchasesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePurchasesPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateTransactionImage() {
		return transactionImage.isDisplayed();
	}
	
	public NewPurchaseOrderPage validateNewPurchaseLink() {
		newPurchaseOrderLink.click();
		return new NewPurchaseOrderPage();
	}
	
	public PurchaseOrdersPage validatePurchaseOrderLink() {
		purchaseOrdersLink.click();
		return new PurchaseOrdersPage();
	}
	
	public PurchaseOrderInquiryPage validatePurchaseOrderInquiryLink() {
		purchaseOrderInquiryLink.click();
		return new PurchaseOrderInquiryPage();
	}
	
	
	/*public SearchOutstandingPurchaseOrders validatePurchaseOrderLink() {
		purchaseOrdersLink.click();
		return new SearchOutstandingPurchaseOrders()
	}
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
