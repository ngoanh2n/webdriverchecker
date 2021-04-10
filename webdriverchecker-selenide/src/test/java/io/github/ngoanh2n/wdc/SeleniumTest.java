package io.github.ngoanh2n.wdc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class SeleniumTest {

    @Test
    void isChromeTest() {
        assertTrue(WebDriverChecker.isChrome());
    }

    @BeforeEach
    void openDriver() {
        open("https://github.com");
    }

    @BeforeEach
    void closeDriver() {
        closeWebDriver();
    }
}
