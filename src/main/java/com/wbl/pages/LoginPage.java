package com.wbl.pages;

import com.wbl.base.Testbase;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.plugin.dom.html.HTMLInputElement;

import java.io.IOException;

public class LoginPage extends Testbase {



    @FindBy(xpath = "//*[@id='logo']")
    WebElement Logo;
    @FindBy(xpath= "/html/body/header/div[2]/div/ul/li[2]/a[1]")
    WebElement loginbtn;
    @FindBy(id="username")
    WebElement email;

    //@FindBy(xpath = "//input[@type='submit']")
    //WebElement continuebtn;

    @FindBy(xpath = "//*[@id='password']")
    WebElement password;

    @FindBy(xpath = "//*[@id='login']")
    WebElement loginsubmit;


    public LoginPage() throws IOException {
        super();
        PageFactory.initElements ( driver , this );
        logger = Logger.getLogger("WhiteBoxQAAutomationFramework");
        PropertyConfigurator.configure("Log4j.properties");
        logger.info("******loginStarted***");
    }



    public String verifySigninPageTitle() {

        return driver.getTitle ();

    }

    public HomePage login(String un , String pwd) throws IOException {

       // Logo.click ();
       // loginbtn.click ();
        email.sendKeys ( un );
        password.sendKeys ( pwd );
        loginsubmit.click ();
        return new HomePage ();


    }

}
