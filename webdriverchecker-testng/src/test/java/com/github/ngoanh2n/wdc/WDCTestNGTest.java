package com.github.ngoanh2n.wdc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public abstract class WDCTestNGTest {
    protected static WebDriver driver;

    @AfterMethod
    protected void afterMethod() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }

    @AfterClass
    protected void afterClass() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
        driver.quit();
        Assert.assertThrows(CheckerException.ClosedDriverProvided.class, WebDriverChecker::getDriver);
        driver = null;
    }

    protected static void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
}
