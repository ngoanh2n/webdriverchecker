package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

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
        openDriver("ie");

        assertFalse(WebDriverChecker.isRemote());

        assertTrue(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSApp());
        assertFalse(WebDriverChecker.isIOSSafari());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidApp());
        assertFalse(WebDriverChecker.isAndroidChrome());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());
        assertFalse(WebDriverChecker.isWindowsApp());
    }

    @Test
    @Order(2)
    void isEdgeTest() {
        openDriver("edge");

        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isIE());
        assertTrue(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSApp());
        assertFalse(WebDriverChecker.isIOSSafari());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidApp());
        assertFalse(WebDriverChecker.isAndroidChrome());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());
        assertFalse(WebDriverChecker.isWindowsApp());
    }

    @Test
    @Order(3)
    void isOperaTest() {
        openDriver("opera");

        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertTrue(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSApp());
        assertFalse(WebDriverChecker.isIOSSafari());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidApp());
        assertFalse(WebDriverChecker.isAndroidChrome());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());
        assertFalse(WebDriverChecker.isWindowsApp());
    }

    @Test
    @Order(4)
    void isChromeTest() {
        openDriver("chrome");

        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSApp());
        assertFalse(WebDriverChecker.isIOSSafari());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidApp());
        assertFalse(WebDriverChecker.isAndroidChrome());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());
        assertFalse(WebDriverChecker.isWindowsApp());
    }

    @Test
    @Order(5)
    void isSafariTest() {
        openDriver("safari");

        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSApp());
        assertFalse(WebDriverChecker.isIOSSafari());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidApp());
        assertFalse(WebDriverChecker.isAndroidChrome());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());
        assertFalse(WebDriverChecker.isWindowsApp());
    }

    @Test
    @Order(6)
    void isFirefoxTest() {
        openDriver("firefox");

        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertTrue(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSApp());
        assertFalse(WebDriverChecker.isIOSSafari());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidApp());
        assertFalse(WebDriverChecker.isAndroidChrome());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileApp());
        assertFalse(WebDriverChecker.isWindowsApp());
    }

    private void openDriver(String name) {
        Configuration.browser = name;
        Selenide.open();
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }
}
