package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.ExecuteOnTarget;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class SeleniumTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Selenide.open();
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }

    @Test
    @ExecuteOnTarget("chrome")
    void isChrome() {
        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());

        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @ExecuteOnTarget("safari")
    void isSafari() {
        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @ExecuteOnTarget("firefox")
    void isFirefox() {
        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertTrue(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @ExecuteOnTarget("edge")
    void isEdge() {
        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertTrue(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @ExecuteOnTarget("opera")
    void isOpera() {
        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertTrue(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }

    @Test
    @ExecuteOnTarget("ie")
    void isIE() {
        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertTrue(WebDriverChecker.isIE());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileWeb());
        assertFalse(WebDriverChecker.isMobileNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }
}
