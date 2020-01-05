package com.eprocbiling.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eprocbiling.qa.base.TestBase;
import com.eprocbiling.qa.pages.HomePage;
import com.eprocbiling.qa.pages.LoginPage;
import com.eprocbiling.qa.pages.NewPurchaseOrderPage;
import com.eprocbiling.qa.pages.PurchasesPage;

public class NewPurchaseOrderPageTest extends TestBase {

	public NewPurchaseOrderPageTest() {
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	PurchasesPage purchasespage;
	NewPurchaseOrderPage newpurchaseOrderPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.validateLoginCredentials();
		purchasespage=homepage.validatePurchasesPageLink();
		newpurchaseOrderPage=purchasespage.validateNewPurchaseLink();
	}
	
	@Test(priority=1)
	public void newPurchaseOrderPageTitleTest() {
		String title=newpurchaseOrderPage.validateNewPurchaseOrderPageTitle();
		Assert.assertEquals(title, "Purchase Order Entry");
	}
	
	@Test(priority=2)
	public void imageTitle() {
		Assert.assertTrue(newpurchaseOrderPage.validateImage());
	}
	
	@Test(priority=3)
	public void enterSuppliersNameTest() {
		newpurchaseOrderPage.validateEnterSupplierName();
	}
	
	@Test(priority=4)
	public void supplierCodeTest() {
		newpurchaseOrderPage.validateSupplierCode();
	}
	
	@Test(priority=5)
	public void resetButtonTest() {
		newpurchaseOrderPage.validateResetButton();
	}
	
	@Test(priority=6)
	public void tableDataTest() {
		newpurchaseOrderPage.validateTableData();
	}
	
	@Test(priority=7)
	public void tableDataClickSuccessfulTest() {
		String title= newpurchaseOrderPage.validateTableDataClickingSuccessful();
		Assert.assertEquals(title, "Purchase Order Entry");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
