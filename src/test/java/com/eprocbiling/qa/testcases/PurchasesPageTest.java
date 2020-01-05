package com.eprocbiling.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eprocbiling.qa.base.TestBase;
import com.eprocbiling.qa.pages.HomePage;
import com.eprocbiling.qa.pages.LoginPage;
import com.eprocbiling.qa.pages.PurchasesPage;

public class PurchasesPageTest extends TestBase {
	
	public PurchasesPageTest() {
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	PurchasesPage purchasespage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.validateLoginCredentials();
		purchasespage=homepage.validatePurchasesPageLink();
	}
	
	@Test(priority=1)
	public void purchasesPageTitleTest() {
		String title=purchasespage.validatePurchasesPageTitle();
		Assert.assertEquals(title, "Main Menu");
	}
	
	@Test(priority=2)
	public void transactionImageTest() {
		Assert.assertTrue(purchasespage.validateTransactionImage());
	}
	
	@Test(priority=3)
	public void newPurchaseLinkTest() {
		purchasespage.validateNewPurchaseLink();
	}
	
	@Test(priority=4)
	public void purchaseOrderInquiryLinkTest() {
		purchasespage.validatePurchaseOrderInquiryLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
