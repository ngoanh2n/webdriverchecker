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
        assertTrue(WebDriverChecker.isLocal());
        assertFalse(WebDriverChecker.isRemote());
        assertFalse(WebDriverChecker.isDocker());
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

        assertTrue(WebDriverChecker.isLocalServer());
        assertFalse(WebDriverChecker.isRemoteServer());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSBrowser());
        assertFalse(WebDriverChecker.isIOSNative());
        assertFalse(WebDriverChecker.isIOSVirtual());

        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isAndroidBrowser());
        assertFalse(WebDriverChecker.isAndroidNative());
        assertFalse(WebDriverChecker.isAndroidVirtual());

        assertFalse(WebDriverChecker.isMobile());
        assertFalse(WebDriverChecker.isMobileBrowser());
        assertFalse(WebDriverChecker.isMobileNative());
        assertFalse(WebDriverChecker.isMobileVirtual());

        assertFalse(WebDriverChecker.isLambdaTest());
        assertFalse(WebDriverChecker.isBrowserStack());
        assertFalse(WebDriverChecker.isSauceLabs());
        assertFalse(WebDriverChecker.isTestingBot());

        Selenide.closeWebDriver();
        assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    @ExecuteOnTarget({"macos", "linux", "windows"})
    void isChrome() {
        Configuration.browser = "chrome";
        Selenide.open();

        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @ExecuteOnTarget("macos")
    void isSafari() {
        Configuration.browser = "safari";
        Selenide.open();

        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @ExecuteOnTarget({"macos", "linux", "windows"})
    void isFirefox() {
        Configuration.browser = "firefox";
        Selenide.open();

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertTrue(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @ExecuteOnTarget({"macos", "linux", "windows"})
    void isEdge() {
        Configuration.browser = "edge";
        Selenide.open();

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertTrue(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @ExecuteOnTarget({"macos", "windows"})
    void isOpera() {
        Configuration.browser = "opera";
        Selenide.open();

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertTrue(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @ExecuteOnTarget("windows")
    void isIE() {
        Configuration.browser = "ie";
        Selenide.open();

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertTrue(WebDriverChecker.isIE());
    }
}
