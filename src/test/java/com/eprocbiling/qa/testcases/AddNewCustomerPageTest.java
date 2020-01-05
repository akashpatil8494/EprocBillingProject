package com.eprocbiling.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eprocbiling.qa.base.TestBase;
import com.eprocbiling.qa.pages.AddNewCustomerPage;
import com.eprocbiling.qa.pages.CustomerPage;
import com.eprocbiling.qa.pages.HomePage;
import com.eprocbiling.qa.pages.LoginPage;
import com.eprocbiling.qa.utils.TestUtils;

public class AddNewCustomerPageTest extends TestBase {

	public AddNewCustomerPageTest() {
		super();
	}
	
	LoginPage loginpage;
	HomePage homepage;
	CustomerPage customerpage;
	AddNewCustomerPage addnewcustomer;
	String sheet_name="AddNewCustomerData";
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.validateLoginCredentials();
		customerpage=homepage.validateCustomerPageLInk();
		addnewcustomer=customerpage.validateAddNewCustomerLink();
	}
	
	@Test(priority=1)
	public void customerPageTitleTest() {
		String title=addnewcustomer.validateAddCustomerPageTitle();
		Assert.assertEquals(title, "Customer Maintenance");
	}
	
	@Test(priority=2)
	public void customerMaintanceLabel() {
		String label=addnewcustomer.validateCustomerMaintainceLabel();
		Assert.assertEquals(label, "Customer Maintenance");
	}
	

	@DataProvider
	public Object[][] getTestData() {
		Object [][] data= TestUtils.getTestDataFromExcel(sheet_name);
		return data;
	}
	
	
	@Test(priority=3,dataProvider="getTestData", enabled=false)	
	public void addNewCustomerTest(String code, String name, String street, String city, String state, String country, String branchName) {
		addnewcustomer.validateAddNewCustomer(code, name, street, city, state, country, branchName);
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
