package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.EnabledIfProperty;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author ngoanh2n
 */
@EnabledIfProperty(name = "wdc.group", value = "extension-local")
@EnabledIfProperty(name = "wdc.os", value = "windows")
public abstract class WDCJUnit5Test {
    protected static WebDriver driver;

    protected static void createWebDriver() {
        driver = new ChromeDriver();
    }

    @AfterAll
    protected static void afterAll() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
        driver.quit();
        Assertions.assertThrows(CheckerException.ClosedDriverProvided.class, WebDriverChecker::getDriver);
        driver = null;
    }

    @AfterEach
    protected void afterEach() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }
}
