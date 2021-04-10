package io.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SeleniumTest {

    @Test
    @Order(1)
    void isIETest() {
        openBrowser("internet explorer");
        assertTrue(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
    }

    @Test
    @Order(2)
    void isEdgeTest() {
        openBrowser("edge");
        assertFalse(WebDriverChecker.isIE());
        assertTrue(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
    }

    @Test
    @Order(3)
    void isOperaTest() {
        openBrowser("opera");
        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertTrue(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
    }

    @Test
    @Order(4)
    void isChromeTest() {
        openBrowser("chrome");
        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
    }

    @Test
    @Order(5)
    void isSafariTest() {
        openBrowser("safari");
        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
    }

    @Test
    @Order(6)
    void isFirefoxTest() {
        openBrowser("firefox");
        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertTrue(WebDriverChecker.isFirefox());
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
