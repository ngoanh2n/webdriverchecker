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
        //assertFalse(WebDriverChecker.isMacOS());
        //assertFalse(WebDriverChecker.isLinux());
        //assertFalse(WebDriverChecker.isWindows());
        assertTrue(WebDriverChecker.isPC());
        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());

        assertTrue(WebDriverChecker.isAlive());
        assertFalse(WebDriverChecker.isRemote());
        assertTrue(WebDriverChecker.isBrowser());
        assertFalse(WebDriverChecker.isNative());

        //assertFalse(WebDriverChecker.isChrome());
        //assertFalse(WebDriverChecker.isSafari());
        //assertFalse(WebDriverChecker.isFirefox());
        //assertFalse(WebDriverChecker.isEdge());
        //assertFalse(WebDriverChecker.isOpera());
        //assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isPCBrowser());
        assertFalse(WebDriverChecker.isPCNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSBrowser());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidBrowser());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileBrowser());
        assertFalse(WebDriverChecker.isMobileNative());

        Selenide.closeWebDriver();
        assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    @ExecuteOnTarget("chrome")
    void isChrome() {
        assertTrue(WebDriverChecker.isChrome());
    }

    @Test
    @ExecuteOnTarget("safari")
    void isSafari() {
        assertTrue(WebDriverChecker.isSafari());
    }

    @Test
    @ExecuteOnTarget("firefox")
    void isFirefox() {
        assertTrue(WebDriverChecker.isFirefox());
    }

    @Test
    @ExecuteOnTarget("edge")
    void isEdge() {
        assertTrue(WebDriverChecker.isEdge());
    }

    @Test
    @ExecuteOnTarget("opera")
    void isOpera() {
        assertTrue(WebDriverChecker.isOpera());
    }

    @Test
    @ExecuteOnTarget("ie")
    void isIE() {
        assertTrue(WebDriverChecker.isIE());
    }
}
