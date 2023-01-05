package com.wbl.base;

import com.wbl.util.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public abstract class Testbase {
    public static WebDriver driver;
    public static Properties prop;
    public static Logger logger;

    public static EventFiringWebDriver e_driver;
    public static WebEventListener eventListener;

    public Testbase() throws IOException {
        try {
            prop = new Properties ();


            FileInputStream ip = new FileInputStream ( "C:\\User\\BDAdmin\\IdeaProjects\\WhiteBoxQAAutomationFramework\\src\\main\\java\\com\\wbl\\config\\configuration.properties.properties" );
            prop.load ( ip );
        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }


    public static void initialiazation() {
        String browserName = prop.getProperty ( "browser" );
        WebDriverManager.chromedriver ().setup ();
        driver = new ChromeDriver ();



        /*    if (browserName.equals ( "chrome" )) {
                System.setProperty ( "webdriver.chrome.driver" , "C:\Users\BDAdmin\Downloads\chromedriver_win32 (2)\chromedriver.exe" );
                driver = new ChromeDriver ();


            } else if (browserName.equals ( "Firefox" )) {
                System.setProperty ( "webdriver.gecko.driver" , "C:\\Users\\BDAdmin\\Downloads\\drivers\\geckodriver.exe" );
                driver = new FirefoxDriver ();

            }*/
      /*  e_driver = new EventFiringWebDriver (driver);
        // Now create object of EventListerHandler to register it with EventFiringWebDriver
        eventListener = new WebEventListener();
        EventFiringWebDriver register = e_driver.register ( (WebDriverEventListener) eventListener );
        driver = e_driver;*/


        driver.manage ().window ().maximize ();
        driver.manage ().deleteAllCookies ();
        driver.manage ().timeouts ().pageLoadTimeout ( TestUtil.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS );
        driver.manage ().timeouts ().implicitlyWait ( TestUtil.IMPLICIT_WAIT , TimeUnit.SECONDS );
        driver.get ( prop.getProperty ( "url" ) );

    }
}






