package com.eprocbiling.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.eprocbiling.qa.base.TestBase;
import com.eprocbiling.qa.pages.HomePage;
import com.eprocbiling.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage= new LoginPage();
		homepage=loginpage.validateLoginCredentials();
		//homepage= new HomePage();
	}
	
	@Test(priority=1)
	public void homePageTitle() {
		String title=homepage.validateHomePageTitle();	
		Assert.assertEquals("Main Menu", title);
	}
	
	@Test(priority=2)
	public void customerPageLinkTest() {
		homepage.validateCustomerPageLInk();
	}

	
	@Test(priority=4)
	public void logOutLinkTest() {
		homepage.validateLogOutLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
