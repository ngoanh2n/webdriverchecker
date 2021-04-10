package io.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class SeleniumTest {

    @Test
    void isChromeTest() {
        openBrowser("chrome");
        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isSafari());
    }

    @Test
    void isFirefoxTest() {
        openBrowser("firefox");
        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isSafari());
    }

    @Test
    void isSafariTest() {
        openBrowser("safari");
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isFirefox());
        assertTrue(WebDriverChecker.isSafari());
    }

    private void openBrowser(String name) {
        Configuration.browser = name;
        open();
    }

    @BeforeEach
    void closeDriver() {
        closeWebDriver();
    }
}
