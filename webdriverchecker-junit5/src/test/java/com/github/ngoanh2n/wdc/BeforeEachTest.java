package com.github.ngoanh2n.wdc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author ngoanh2n
 */
public class BeforeEachTest extends WDCJUnit5Test {
    @BeforeAll
    static void beforeAll() {
        Assertions.assertThrows(CheckerException.NullDriverProvided.class, WebDriverChecker::getDriver);
    }

    @BeforeEach
    void beforeEach() {
        createWebDriver();
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }

    @Test
    void test() {
        Assertions.assertNotNull(WebDriverChecker.getDriver());
    }
}
