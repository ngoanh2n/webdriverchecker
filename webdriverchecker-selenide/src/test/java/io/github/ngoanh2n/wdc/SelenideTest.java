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
public class SelenideTest {

    @Test
    @Order(1)
    void isIETest() {
        openDriver("internet explorer");

        assertTrue(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @Order(2)
    void isEdgeTest() {
        openDriver("edge");

        assertFalse(WebDriverChecker.isIE());
        assertTrue(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @Order(3)
    void isOperaTest() {
        openDriver("opera");

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertTrue(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @Order(4)
    void isChromeTest() {
        openDriver("chrome");

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @Order(5)
    void isSafariTest() {
        openDriver("safari");

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @Order(6)
    void isFirefoxTest() {
        openDriver("firefox");

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertTrue(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    private void openDriver(String name) {
        Configuration.browser = name;
        open();
    }

    @BeforeEach
    void closeDriver() {
        closeWebDriver();
    }
}
