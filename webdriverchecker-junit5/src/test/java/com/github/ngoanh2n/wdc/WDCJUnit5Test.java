package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;
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
    static WebDriver driver;

    @AfterEach
    void afterEach() {
        Assertions.assertNotNull(WebDriverChecker.getWD());
    }

    @AfterAll
    static void afterAll() {
        Assertions.assertNotNull(WebDriverChecker.getWD());
        driver.quit();
        Assertions.assertThrows(RuntimeError.class, WebDriverChecker::getWD);
    }

    static WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
