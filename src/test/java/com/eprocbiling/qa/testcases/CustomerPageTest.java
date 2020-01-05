package com.eprocbiling.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eprocbiling.qa.base.TestBase;
import com.eprocbiling.qa.pages.CustomerPage;
import com.eprocbiling.qa.pages.HomePage;
import com.eprocbiling.qa.pages.LoginPage;

public class CustomerPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerpage;

	public CustomerPageTest() {
		
		super();
	}

	@BeforeMethod
	public void setUp() {
		
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.validateLoginCredentials();
		customerpage = homepage.validateCustomerPageLInk();
		// customerpage= new CustomerPage();

	}

	@Test(priority=1)
	public void customerLabelTest() {
		String label = customerpage.validateCustomerLabel();
		Assert.assertEquals(label, "Customers");
	}
	
	@Test(priority=2)
	public void addNewCustomerLinkTest() {
		customerpage.validateAddNewCustomerLink();
	}
	
	@Test(priority=3)
	public void searchCustomerLabelTest() {
		String label=customerpage.validateSearchCustomerLabel();
		Assert.assertEquals(label, "Search for Customers");
	}
	
	@Test(priority=4)
	public void AddNewCustomerTest() {
		customerpage.validateAddNewCustomerLink();
	}
	
	@Test(priority=5)
	public void searchCustomerFromTableTest() {
		customerpage.validateSearchCustomerFromTable();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
