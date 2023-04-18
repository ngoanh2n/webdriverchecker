package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;
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
    static WebDriver driver;

    @AfterMethod
    void afterMethod() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }

    @AfterClass
    void afterClass() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
        driver.quit();
        Assert.assertThrows(RuntimeError.class, WebDriverChecker::getDriver);
    }

    static WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
