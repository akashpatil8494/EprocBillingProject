package com.eprocbiling.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.eprocbiling.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory:OR
	
	@FindBy(name="CompanyNameField")
	WebElement companyName;
	
	@FindBy(name="UserNameEntryField")
	WebElement userNameEntry;
	
	@FindBy(name="Password")
	WebElement passwordEntry;
	
	@FindBy(name="SubmitUser")
	WebElement loginButton;
	
	@FindBy(id="login_logo")
	WebElement loginLogo;

	@FindBy(xpath="//a[@href=\"https://sourceforge.net/projects/web-erp\"]")
	WebElement sourceforgeImage;
	
	@FindBy(xpath="//*[@id=\"container\"]/div[3]/a")
	WebElement sourceforgeLink;
	
	@FindBy(xpath="//div[@id='demo_text']")
	WebElement errorMassage;
	
	@FindBy(xpath="//div[@id='AppInfoModuleDiv']")
	WebElement mainMenuLebal;
	
	//Initializing Page Object
	
	public LoginPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions:
	
	public String validateTitleOfLoginPage() {
		return driver.getTitle();
		
	}
	
	public boolean validateLoginLogoDisplay() {
		return loginLogo.isDisplayed();
	}
	
	public boolean validateSourceforgeImageDisplay() {
		return sourceforgeImage.isDisplayed();
	}
	
	
	public SourceForgePage validateSourceForgeLink() {
		sourceforgeLink.click();
		return new SourceForgePage();
	}
	
	public HomePage validateLoginCredentials() {
		
		userNameEntry.clear();
		userNameEntry.sendKeys(prop.getProperty("username"));
		passwordEntry.clear();
		passwordEntry.sendKeys(prop.getProperty("password"));
		loginButton.click();
		
		return new HomePage();
		
		
	}
	
	
	public String validateLoginIsSuccessful(String uname,String upass) {
		
		userNameEntry.clear();
		userNameEntry.sendKeys(uname);
		passwordEntry.clear();
		passwordEntry.sendKeys(upass);
		loginButton.click();
		
		return mainMenuLebal.getText();
		
		
		
	}
	
	public String validateCombinationOfLoginTestData(String uname,String upass) {
		userNameEntry.clear();
		userNameEntry.sendKeys(uname);
		passwordEntry.clear();
		passwordEntry.sendKeys(upass);
		loginButton.click();
		
		return errorMassage.getText();
	}
	
	

}
