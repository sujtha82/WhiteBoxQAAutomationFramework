package com.wbl;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TempClass {
    @Test
    public void test() {

        System.out.println ( "hello" );
        String TESTDATA_SHEET_PATH = "C:\\User\\BDAdmin\\IdeaProjects\\WhiteBoxQAAutomationFramework\\src\\main\\java\\com\\wbl\\resources\\~$Book1.xlsx";
        String Testdatapath = TESTDATA_SHEET_PATH.replace ( "\\" , "/" );
        System.out.println ( Testdatapath );
        String Testadata1 = "C:/User/BDAdmin/IdeaProjects/WhiteBoxQAAutomationFramework/src/main/java/com/wbl/resources/~$Book1.xlsx";
        System.out.println ( Testadata1 );
    }



    public void TestUtil() throws IOException {
        }

@Test
        public static Object[][] getTestData(String sheetName) {
            String TESTDATA_SHEET_PATH = "C:\\User\\BDAdmin\\IdeaProjects\\WhiteBoxQAAutomationFramework\\src\\main\\java\\com\\wbl\\resources\\~$Book1.xlsx";
            String  Testdatapath=  TESTDATA_SHEET_PATH.replace ( "\\","/" );
            FileInputStream file = null;
            try {
                file = new FileInputStream (Testdatapath);
            } catch (FileNotFoundException e) {
                e.printStackTrace ();
            }
            Workbook book = null;
            try {
                assert file != null;
                book = WorkbookFactory.create ( file );
            } catch (IOException e) {
                e.printStackTrace ();
            }
            Sheet sheet = book.getSheet ( sheetName );
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

    }

