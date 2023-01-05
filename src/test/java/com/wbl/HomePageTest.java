package com.wbl;

import com.aventstack.extentreports.model.Log;
import com.wbl.base.Testbase;
import com.wbl.pages.ContactPage;
import com.wbl.pages.GalleryPage;
import com.wbl.pages.HomePage;
import com.wbl.pages.LoginPage;
import com.wbl.util.Log4j;
import com.wbl.util.TestUtil;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.io.IOException;

import static com.aventstack.extentreports.model.Log.*;
import static com.wbl.base.Testbase.initialiazation;

public class HomePageTest extends Testbase {
    public LoginPage lp;
    public HomePage hp;
    public ContactPage cp;
    public GalleryPage gp;
    public TestUtil ut;
    static String sheetname = "contact";
    private Log4j log;
    public static WebDriver driver;

    public HomePageTest() throws IOException {
        super ();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialiazation ();
        // Log.info ( "initialized the landing page" );
        lp = new LoginPage ();
        cp = new ContactPage ();
        gp = new GalleryPage ();
        hp = lp.login ( prop.getProperty ( "username" ) , prop.getProperty ( "password" ) );
        // Log.info ( "User logged in" );
        ut = new TestUtil ();

    }

     @Test(priority = 1)
    public void verifyHomePageTitleTest() throws IOException {
        String title = hp.verifyHomePageTitle ();
        // HomePage hp = new HomePage(driver);
        hp.verifyHomePageTitle ();
        BasicConfigurator.configure ();
    }

     @Test(priority=2)
    public void verifyContactsLinkTest() {

        cp = hp.clickOnContactLink ();
    }


}


     /*    @DataProvider
         public Object[][] getItemTestData() {

          Object data[][]= TestUtil.getTestData(sheetname);
             return data;
         }
         @Test(priority = 4,dataProvider="getItemTestData")
         public void verifySearchItem( String name , String email , int phone , String message) {
            // Log.debug ( "contact" );
             String TESTDATA_SHEET_PATH = "C:\\User\\BDAdmin\\IdeaProjects\\WhiteBoxQAAutomationFramework\\src\\main\\java\\com\\wbl\\resources\\~$Book1.xlsx";
             String  Testdatapath=  TESTDATA_SHEET_PATH.replace ( "\\","/" );
             hp.contactdeatils(name,email,phone,message);
             BasicConfigurator.configure ();
         }
    }




*/