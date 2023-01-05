package com.wbl;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.wbl.pages.ExcelOperations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Testclass {
    static ExcelOperations excel = new ExcelOperations();
  //  static String excelFilePath = Constants."C:\User\BDAdmin\IdeaProjects\WhiteBoxQAAutomationFramework\src\main\java\com\wbl\resources\Book1.xlsx" + Constants.LoginTestdata

    static WebDriver driver;

    @BeforeClass
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver ();
    }


    @Test
    public void loginTest() throws InterruptedException, IOException
    {

        driver.get("http:whiteboxqa.com/index.php");

                driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage ().timeouts ().implicitlyWait ( 5000, TimeUnit.SECONDS);
        String TESTDATA_SHEET_PATH = "C:\\User\\BDAdmin\\IdeaProjects\\WhiteBoxQAAutomationFramework\\src\\main\\java\\com\\wbl\\resources\\Book1.xlsx";
        String  Testdatapath=  TESTDATA_SHEET_PATH.replace ( "\\","/" );
        excel.setExcelFile(Testdatapath, "LoginTestData");
        BasicConfigurator.configure ();

        for(int i=1;i<=excel.getRowCountInSheet();i++)
        {
            System.out.println (excel.getCellData(i, 0));
            WebElement workEmail =
                    driver.findElement( By.xpath ( "//*[@id='username']" ));
                    workEmail.sendKeys(excel.getCellData(i, 0));

            WebElement passWord =
                    driver.findElement(By.xpath ( "//*[@id='password']" ));
            passWord.clear();
            passWord.sendKeys(excel.getCellData(i, 1));

            WebElement createAccountButton =
                    driver.findElement(By.xpath ( "//*[@id='login']" ));
            createAccountButton.click();

            String title = driver.getTitle();
            if(title.equals("QA/QE/SDET Training."))
            {
                excel.setCellValue(i, 1, "Passed",Testdatapath);
            }
            else
            {
                excel.setCellValue(i, 2, "Failed", Testdatapath);
            }
        }

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}

