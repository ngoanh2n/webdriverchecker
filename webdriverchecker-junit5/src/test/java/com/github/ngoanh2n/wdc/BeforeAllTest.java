package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 2.3.0
 * @since 2022-12-18
 */
public class BeforeAllTest extends WDCJUnit5Test {
    @BeforeAll
    static void beforeAll() {
        driver = createWebDriver();
        Assertions.assertThrows(RuntimeError.class, WebDriverChecker::isChrome);
    }

    @BeforeEach
    void beforeEach() {
        Assertions.assertDoesNotThrow(() -> WebDriverChecker.isChrome());
    }

    @Test
    void test() {
        Assertions.assertDoesNotThrow(() -> WebDriverChecker.isChrome());
    }
}
