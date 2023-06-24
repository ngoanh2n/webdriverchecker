package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.EnabledIfProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ngoanh2n
 */
@EnabledIfProperty(name = "wdc.group", value = "extension-local")
@EnabledIfProperty(name = "wdc.os", value = "windows")
public class WDCSelenideTest {
    @BeforeAll
    static void beforeAll() {
        Assertions.assertThrows(CheckerException.class, WebDriverChecker::getDriver);
        createWebDriver();
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }

    @BeforeEach
    void beforeEach() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }

    @Test
    void test() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }

    private static void createWebDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = "chrome";
        Selenide.open();
    }
}
