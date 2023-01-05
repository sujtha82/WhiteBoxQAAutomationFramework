package com.wbl;

import com.wbl.base.Testbase;
import com.wbl.pages.HomePage;
import com.wbl.pages.LoginPage;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest  extends Testbase {
    LoginPage loginPage;
    HomePage homePage;


    public LoginPageTest() throws IOException {
        super ();
    }

     //WebDriver driver = new ChromeDriver ();
    @BeforeMethod
    public void setUp() throws IOException {
        initialiazation ();
        loginPage = new LoginPage ();
    }
    @Test(priority = 1)
    public void loginPageTitleTest() throws IOException{
        String title = loginPage.verifySigninPageTitle ();
        Assert.assertTrue ( Boolean.parseBoolean ( "QA/QE/SDET Training." ) ,"QA/QE/SDET Training." );

    }
    @Test
    public void HomePageloginTest() throws IOException {
        BasicConfigurator.configure();
        homePage = loginPage.login ( prop.getProperty ( "username" ) , prop.getProperty ( "password" ) );
    }
    @AfterMethod
    public void tearDown() {
        driver.quit ();
    }





}



