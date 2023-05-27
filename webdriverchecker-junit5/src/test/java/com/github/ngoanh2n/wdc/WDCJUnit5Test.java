package com.github.ngoanh2n.wdc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public abstract class WDCJUnit5Test {
    protected static WebDriver driver;

    @AfterAll
    protected static void afterAll() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
        driver.quit();
        Assertions.assertThrows(CheckerException.ClosedDriverProvided.class, WebDriverChecker::getDriver);
        driver = null;
    }

    protected static void createWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    protected void afterEach() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }
}
