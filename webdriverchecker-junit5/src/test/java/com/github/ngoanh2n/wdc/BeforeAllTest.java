package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class BeforeAllTest extends WDCJUnit5Test {
    @BeforeAll
    static void beforeAll() {
        Assertions.assertThrows(RuntimeError.class, WebDriverChecker::getWD);
        driver = createWebDriver();
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
}
