package org.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebPageTest {

    static WebDriver driver;

    @BeforeTest
    public void  openBrowser()throws InterruptedException{
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver-win64\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.get("https://jssateb.ac.in");
    }
    @Test
    public void titleValidationTest() {
        String actualTitle=driver.getTitle();
        String expected="JSSATEB";
        Assert.assertEquals(actualTitle,expected);
        Assert.assertTrue(actualTitle.contains("JSSATEB"),"title should contain jssateb");

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
    }

}