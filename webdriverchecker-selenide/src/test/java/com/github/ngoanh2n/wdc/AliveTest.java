package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class AliveTest {
    @BeforeEach
    void setup() {
        assertFalse(WebDriverChecker.isAlive());

        Selenide.open();
        assertTrue(WebDriverChecker.isAlive());
        Selenide.closeWebDriver();
    }

    @Test
    void usedDirected() {
        assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    void usedUndirected() {
        assertThrows(WDCException.NoSuchWDSession.class, WebDriverChecker::isFirefox);
    }
}
