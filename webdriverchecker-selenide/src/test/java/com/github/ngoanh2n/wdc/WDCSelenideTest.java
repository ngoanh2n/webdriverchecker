package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.RuntimeError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 2.4.0
 * @since 2022-12-23
 */
public class WDCSelenideTest {
    @BeforeAll
    static void beforeAll() {
        Assertions.assertThrows(RuntimeError.class, WebDriverChecker::getWD);
        createWebDriver();
        Assertions.assertNotNull(WebDriverChecker.getWD());
    }

    @BeforeEach
    void beforeEach() {
        Assertions.assertNotNull(WebDriverChecker.getWD());
    }

    @Test
    void test() {
        Assertions.assertNotNull(WebDriverChecker.getWD());
    }

    private static void createWebDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = "chrome";
        Selenide.open();
    }
}
