package com.eprocbiling.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.eprocbiling.qa.base.TestBase;
import com.eprocbiling.qa.pages.HomePage;
import com.eprocbiling.qa.pages.LoginPage;
import com.eprocbiling.qa.pages.SourceForgePage;
import com.eprocbiling.qa.utils.TestListner;
import com.eprocbiling.qa.utils.TestUtils;


public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	SourceForgePage sourceforgepage;
	HomePage homepage;
	
	public static final String SHEET_NAME="InvalidLoginData";
	
	@BeforeMethod
	public void setUpEnvironment() {
		initialization();
		loginpage= new LoginPage();
	}
	
	@Test(priority=1)
	public void  titleOfLoginPageTest() {
		
		String title= loginpage.validateTitleOfLoginPage();
		Assert.assertEquals("webERP Login screen", title);
	}
	
	
	@Test(priority=2)
	public void  loginLogoDisplayTest() {
		
		boolean flag= loginpage.validateLoginLogoDisplay();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void  sourceforgeImageDisplayTest() {
		
		boolean flag= loginpage.validateSourceforgeImageDisplay();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=4)
	public void  sourceForgeLinkTest() {
		
		sourceforgepage= loginpage.validateSourceForgeLink();
		
	}
	
	@Test(priority=5)
	public void  loginCredentialsTest() {
		
		 loginpage.validateLoginCredentials();
		
	}
	
	@Test(priority=6)
	public void loginsuccessTest() {
		String mainmenulabel=loginpage.validateLoginIsSuccessful(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals("Main Menu123", mainmenulabel );
	}
	
	
	@DataProvider
	public Object[][] getTestData() {
		Object [][] data= TestUtils.getTestDataFromExcel(SHEET_NAME);
		return data;
	}
	
	@Test(priority=7,dataProvider="getTestData")
	public void combinationOfLoginTestData(String uname,String upass) {
		
		String errorMessage=loginpage.validateCombinationOfLoginTestData(uname, upass);
		System.out.println(errorMessage);
		Assert.assertEquals("incorrect password\n" + 
				"The user/password combination\n" + 
				"is not a valid user of the system", errorMessage);
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
