package com.wbl.util;

import com.wbl.base.Testbase;
import com.wbl.pages.HomePage;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtil extends Testbase {
    public static long PAGE_LOAD_TIMEOUT = 120;

    public static long IMPLICIT_WAIT = 60;
   String TESTDATA_SHEET_PATH = "C:\\User\\BDAdmin\\IdeaProjects\\WhiteBoxQAAutomationFramework\\src\\main\\java\\com\\wbl\\resources\\~$Book1.xlsx";
   String  Testdatapath=  TESTDATA_SHEET_PATH.replace ( "\\","/" );
    static Workbook book;
    static Sheet sheet;

    public TestUtil() throws IOException {
    }


    public static Object[][] getTestData(String sheetName) {
        String TESTDATA_SHEET_PATH = "C:\\User\\BDAdmin\\IdeaProjects\\WhiteBoxQAAutomationFramework\\src\\main\\java\\com\\wbl\\resources\\~$Book1.xlsx";
        String  Testdatapath=  TESTDATA_SHEET_PATH.replace ( "\\","/" );
        FileInputStream file = null;
        try {
            file = new FileInputStream (Testdatapath);
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        }
        try {
            assert file != null;
            book = WorkbookFactory.create ( file );
        } catch (IOException e) {
            e.printStackTrace ();
        }
        sheet = book.getSheet ( sheetName );
        Object[][] data = new Object[sheet.getLastRowNum ()][sheet.getRow ( 0 ).getLastCellNum ()];
        for (int i = 0; i < sheet.getLastRowNum (); i++) {
            for (int k = 0; k < sheet.getRow ( 0 ).getLastCellNum (); k++) {
                data[i][k] = sheet.getRow ( i + 1 ).getCell ( k ).toString ();
                // System.out.println(data[i][k]);
                // System.out.println(sheet.getLastRowNum() + "--------" +
                // sheet.getRow(0).getLastCellNum());
            }
        }
        return data;
    }


    public static String getScreenshot(WebDriver driver , String screenshotName) throws Exception {
        //below line is just to append the date format with the screenshot name to avoid duplicate names
        String dateName = new SimpleDateFormat ( "yyyyMMddhhmmss" ).format ( new Date () );
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs ( OutputType.FILE );
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty ( "user.dir" ) + "/FailedTestsScreenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File ( destination );
        FileUtils.copyFile ( source , finalDestination );
        //Returns the captured file path
        return destination;



    }
}
