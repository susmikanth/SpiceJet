package com.spicejet.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.spicejet.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGELOAD_TIMEOUT=50;
	public static long IMPLICITELY_WAIT=50;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static Object[][] getTestData(String sheetName){
		FileInputStream file=null;
		try{
				file=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/spicejet/testdata/SpiceJet_TestData.xlsx");
			}
			catch(FileNotFoundException e){ 
				e.printStackTrace();
			} 
			try{
		        workbook = new XSSFWorkbook(file);
			}
			catch(InvalidFormatException e){
			e.printStackTrace();
			}
			catch(IOException e){
				e.printStackTrace();
			}
			sheet = workbook.getSheet(sheetName);
			Object[][] data=new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for(int i=0;i<sheet.getLastRowNum();i++){
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++){
					data[i][j]=sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
			
		}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}