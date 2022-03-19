package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class AliveTest {

    @BeforeEach
    void setup() {
        Assertions.assertFalse(WebDriverChecker.isAlive());
        Configuration.browser = "chrome";
        Selenide.open();
        Assertions.assertTrue(WebDriverChecker.isAlive());
        Selenide.closeWebDriver();
    }

    @Test
    void usedDirected() {
        Assertions.assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    void usedUndirected() {
        Assertions.assertThrows(WDCException.NoSuchWDSession.class, WebDriverChecker::isFirefox);
    }
}
