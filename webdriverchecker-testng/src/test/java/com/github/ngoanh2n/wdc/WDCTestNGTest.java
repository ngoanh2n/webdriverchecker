package com.github.ngoanh2n.wdc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

/**
 * @author ngoanh2n
 */
public abstract class WDCTestNGTest {
    protected static WebDriver driver;

    protected static void createWebDriver() {
        driver = new ChromeDriver();
    }

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
}
