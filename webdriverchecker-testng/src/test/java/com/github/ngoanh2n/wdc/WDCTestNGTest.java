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
 * @version 2.4.0
 * @since 2022-12-22
 */
public abstract class WDCTestNGTest {
    static WebDriver driver;

    @AfterMethod
    void afterMethod() {
        Assert.assertNotNull(WebDriverChecker.getWD());
    }

    @AfterClass
    void afterClass() {
        Assert.assertNotNull(WebDriverChecker.getWD());
        driver.quit();
        Assert.assertThrows(RuntimeError.class, WebDriverChecker::getWD);
    }

    static WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
