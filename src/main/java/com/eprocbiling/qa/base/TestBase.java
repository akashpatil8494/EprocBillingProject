package com.eprocbiling.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Listeners;

import com.eprocbiling.qa.utils.TestListner;
import com.eprocbiling.qa.utils.TestUtils;
import com.eprocbiling.qa.utils.WebEvetListener;

@Listeners(TestListner.class)
public class TestBase {
	
	public static final String PATH_OF_CHROME_DRIVER="D:\\Eprocbiling\\src\\main\\java\\com\\eprocbiling\\qa\\browserDrivers\\chromedriver.exe";
	public static final String PATH_OF_IE_DRIVER="D:\\Eprocbiling\\src\\main\\java\\com\\eprocbiling\\qa\\browserDrivers\\IEDriverServer.exe";
	public static final String PATH_OF_PROPERTIES_FILE= "D:\\Eprocbiling\\src\\main\\java\\com\\eprocbiling\\qa\\config\\config.properties";
	public static final String PATH_OF_LOG_FILE = "D:\\Eprocbiling\\src\\main\\resources\\log4j.properties";
	
	public static Properties prop;
	public static FileInputStream fis;
	public static WebDriver driver;
	public static Logger log;
	public static EventFiringWebDriver edriver;
	public static WebDriverEventListener listener;
	
	public TestBase() {	
		try {
			fis= new FileInputStream(PATH_OF_PROPERTIES_FILE);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public static void initialization() {
		log = Logger.getLogger(TestBase.class); 
		PropertyConfigurator.configure(PATH_OF_LOG_FILE);
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", PATH_OF_CHROME_DRIVER);
			log.info("===>Launching chrome browser");
			driver= new ChromeDriver();
			
		}else if(prop.getProperty("browser").equalsIgnoreCase("InternetExplorer")) {
			System.setProperty("webdriver.ie.driver", PATH_OF_IE_DRIVER);
			log.info("Launching InternetExplorer browser");
			driver= new InternetExplorerDriver();
		}else if(prop.getProperty("browser").equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", PATH_OF_IE_DRIVER);
			driver= new FirefoxDriver();
		}
		
		edriver= new EventFiringWebDriver(driver);
		listener= new WebEvetListener();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLECIT_WAIT, TimeUnit.SECONDS);
		
		log.info("===>Opening url");
		driver.get(prop.getProperty("url"));
		
		
		
	}
	
	
	
	

}
