package com.wbl.pages;

import com.wbl.base.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class ContactPage extends Testbase {
    @FindBy(xpath = "//*[@id=\"navbar-collapse\"]/ul/li[6]")
    WebElement info;
    @FindBy(xpath = "//*[@id='navbar-collapse']/ul/li[6]/ul/li[2]/a")
    WebElement contactlink;


    @FindBy(xpath = "//*[@id='contact_body']/div[1]/input")
    WebElement name;

    @FindBy(xpath = "//input[@id='email'")
    WebElement email;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement phone;

    @FindBy(xpath = "//*[@id='message']")
    WebElement message;

    @FindBy(xpath = "//*[@id='submit']")
    WebElement submit;


    // Initializing the Page Objects:
    public ContactPage() throws IOException {
        super ();
        PageFactory.initElements ( driver , this );
    }


    public static void click() {
    }


    public boolean verifyContactsLabel() {
        return contactlink.isDisplayed ();
    }


    public void createNewContacts(String firstName , String email , int phone , String message) {
        driver.findElement ( By.xpath ( "//*[@id='contact_body']/div[1]/input" ) ).sendKeys ();
        driver.findElement ( By.xpath ( "//input[@id='email']" ) ).sendKeys ();
        driver.findElement ( By.xpath ( "//*[@id='message']-message" ) ).sendKeys ();
        driver.findElement ( By.xpath ( "//*[@id='submit']" ) ).click ();
    }

    public void createNewContact(String name , String email , int phone , String message) {
        driver.findElement ( By.xpath ( "//*[@id='contact_body']/div[1]/input" ) ).sendKeys ();
        driver.findElement ( By.xpath ( "//input[@id='email']" ) ).sendKeys ();
        driver.findElement ( By.xpath ( "//*[@id='message']-message" ) ).sendKeys ();
        driver.findElement ( By.xpath ( "//*[@id='submit']" ) ).click ();
    }
}
/*

    public void createNewContact( String firstName, String email, int phone ,String message){


        firstName.sendKeys("su");
        email.sendKeys("email");
        phone.sendKeys("phone");
        message.sendKeys ("hello");
        submit.click();

    }




}

    */
