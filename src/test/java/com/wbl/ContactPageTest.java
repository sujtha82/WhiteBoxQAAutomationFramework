package com.wbl;

import com.wbl.base.Testbase;
import com.wbl.pages.ContactPage;
import com.wbl.pages.HomePage;
import com.wbl.pages.LoginPage;
import com.wbl.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ContactPageTest extends Testbase{


         LoginPage loginPage;
	      HomePage hp;
            TestUtil testUtil;
            ContactPage contactPage;

            String sheetName = "contact";


public ContactPageTest() throws IOException {
        super();

        }




    @BeforeMethod
public void setUp() throws IOException{

        initialization();
        testUtil = new TestUtil();
        contactPage= new ContactPage();
        loginPage = new LoginPage();
        hp = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

        contactPage = hp.clickOnContactLink();
        }

    private void initialization() {
    }

    @Test(priority=1)
public void verifyContactsPageLabel(){
        Assert.assertTrue(contactPage.verifyContactsLabel(), "contacts label is missing on the page");
        }

//@Test(priority=2)
public void verifyContactsTest(){
        
        }
/*
//@Test(priority=3)
public void selectMultipleContactsTest(){
        contactPage.selectContactsByName("test2 test2");
        contactPage.selectContactsByName("ui uiii");

        }*/

@DataProvider
public Object[][] getcontactTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
        }


@Test(priority=4, dataProvider="getcontactTestData")
public void validatecreateContacttest( String Fname, String email,int phone,String message) throws IOException {

      hp.clickContactlink();
    contactPage.createNewContact(Fname,email,phone,message);
    }



@AfterMethod
public void tearDown(){
        driver.quit();
        }

}
