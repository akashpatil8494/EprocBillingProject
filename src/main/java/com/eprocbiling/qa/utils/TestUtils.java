package com.eprocbiling.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eprocbiling.qa.base.TestBase;

public class TestUtils extends TestBase {

	// Wait utility
	public static final long PAGE_LOAD_WAIT = 40;
	public static final long IMPLECIT_WAIT = 40;

	// Reading TestData from Excel file
	public static FileInputStream fis;
	public static Workbook book;
	public static Sheet sheet;
	public static Object[][] data;
	public static final String PATH_OF_EXCEL_FILE = "D:\\Eprocbiling\\src\\main\\java\\com\\eprocbiling\\qa\\testData\\EprocBilingTestData.xlsx";
	
	public static Object[][] getTestDataFromExcel(String sheetName) {
		try {
			fis = new FileInputStream(PATH_OF_EXCEL_FILE);

			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);
			
			int rows= sheet.getLastRowNum();
			int cols= sheet.getRow(0).getLastCellNum();
			
			data= new Object[rows][cols];
			
			for(int i=0;i<rows;i++) {
				
				for(int j=0;j<cols;j++) {
				
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
	
	public static void getScreenShot(String methodname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(src, new File("D:\\Eprocbiling\\ScreenShot\\"+methodname+"_"+System.currentTimeMillis()+".jpg"));
		}
		
	
	//Click utility 
	public static void clickOn(WebDriver driver,WebElement element,Timeouts waittime ) {
		
		WebDriverWait wait= new WebDriverWait(driver, 4000);
		wait.until(ExpectedConditions.elementToBeSelected(element));
		//wait.until(ExpectedConditions.elementToBeClickable(element);
		
		
	}
	

}
