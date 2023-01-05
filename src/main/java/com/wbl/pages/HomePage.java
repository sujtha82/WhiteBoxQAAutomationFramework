package com.wbl.pages;

import com.wbl.base.Testbase;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import static com.wbl.util.Log4j.Log;
public class HomePage extends Testbase {
    WebDriver driver;


    @FindBy(xpath = "//*[@id='logo']")
    WebElement logo;
    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[6]/")
    WebElement info;
    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[6]/ul/li[1]/a")
    WebElement gallerylink;
    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[6]/ul/li[2]/a")
    WebElement contactlink;


    public HomePage() throws IOException {
        super ();
        PageFactory.initElements ( driver , this );
        // Logger.info ( "******HomePage has Started***" );

        // logger.info ( "******HomePage has Started***" );
    }




    public String verifyHomePageTitle() {
        //Log.info ( "check the homepageurl" );
        return driver.getTitle ();
    }


    public ContactPage clickonContactPage() throws IOException {
        ContactPage.click ();
        return new ContactPage ();
    }


    public void selectSearchItem(String item) {
        WebElement searchtextbox = driver.findElement ( By.id ( "twotabsearchtextbox" ) );
        searchtextbox.sendKeys ( item );

        WebElement goButton = driver.findElement ( By.cssSelector ( "input[value=Go] " ) );
        goButton.click ();

    }


    public void Info() {
        info.click ();
        // return info;
        // driver.getTitle();

    }

    public ContactPage clickContactlink() throws IOException {
        contactlink.click ();
        return new ContactPage ();

    }

    public GalleryPage clickOngallerylink() {
        gallerylink.click ();
        return new GalleryPage ();

    }

    public ContactPage clickOnContactLink() {
        Actions action = new Actions ( driver );
        action.moveToElement ( info ).build ().perform ();
        info.click ();

        return null;
    }

    public void contactdeatils(String name , String email , int phone , String message) {
    }
}

  /*  public ContactPage clickoninfo() throws IOException {
        Actions action = new Actions(driver);

        action.moveToElement(contactlink).build().perform ();
        ContactPage.click ();
        //  return new ContactPage ();
    }
//	public TaskPage clickTasklink() {
//		tasklink.click();
//		return new TaskPage();
//
//*/
