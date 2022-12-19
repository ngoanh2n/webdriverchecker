package com.github.ngoanh2n.wdc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 2.3.0
 * @since 2022-12-18
 */
public abstract class WDCJUnit5Test {
    static WebDriver driver;

    @AfterEach
    void afterEach() {
        Assertions.assertDoesNotThrow(() -> WebDriverChecker.getWD());
    }

    @AfterAll
    static void afterAll() {
        Assertions.assertDoesNotThrow(() -> WebDriverChecker.getWD());
        driver.quit();
        driver = null;
    }

    static WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
