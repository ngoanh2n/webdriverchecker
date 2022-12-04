package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.ngoanh2n.ExecuteOnTarget;
import com.github.ngoanh2n.wdc.driver.AppiumDriverProvider;
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
public class AppiumTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browserSize = null;
        Configuration.browser = AppiumDriverProvider.class.getName();
        Selenide.open();
    }

    @AfterEach
    void closeDriver() {
        //assertFalse(WebDriverChecker.isMacOS());
        //assertFalse(WebDriverChecker.isLinux());
        //assertFalse(WebDriverChecker.isWindows());
        //assertFalse(WebDriverChecker.isPC());
        //assertFalse(WebDriverChecker.isIOS());
        //assertFalse(WebDriverChecker.isAndroid());
        //assertTrue(WebDriverChecker.isMobile());

        assertTrue(WebDriverChecker.isAlive());
        assertTrue(WebDriverChecker.isLocal());
        assertTrue(WebDriverChecker.isRemote());
        assertFalse(WebDriverChecker.isDocker());
        //assertFalse(WebDriverChecker.isBrowser());
        //assertFalse(WebDriverChecker.isNative());

        //assertFalse(WebDriverChecker.isChrome());
        //assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertFalse(WebDriverChecker.isPCBrowser());
        //assertFalse(WebDriverChecker.isPCNative());

        //assertFalse(WebDriverChecker.isMacOSNative());
        //assertFalse(WebDriverChecker.isWindowsNative());

        //assertFalse(WebDriverChecker.isIOS());
        //assertFalse(WebDriverChecker.isIOSBrowser());
        //assertFalse(WebDriverChecker.isIOSNative());

        //assertFalse(WebDriverChecker.isAndroid());
        //assertFalse(WebDriverChecker.isAndroidBrowser());
        //assertFalse(WebDriverChecker.isAndroidNative());

        //assertFalse(WebDriverChecker.isMobile());
        //assertFalse(WebDriverChecker.isMobileBrowser());
        //assertFalse(WebDriverChecker.isMobileNative());

        WebDriverRunner.closeWebDriver();
        assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    @ExecuteOnTarget("ios-native")
    void iosNative() {
        assertFalse(WebDriverChecker.isPC());
        assertTrue(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertTrue(WebDriverChecker.isMobile());

        assertFalse(WebDriverChecker.isBrowser());
        assertTrue(WebDriverChecker.isNative());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());

        assertFalse(WebDriverChecker.isPCNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isIOSBrowser());
        assertTrue(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroidBrowser());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobileBrowser());
        assertTrue(WebDriverChecker.isMobileNative());
    }

    @Test
    @ExecuteOnTarget("ios-safari")
    void iosSafari() {
        assertFalse(WebDriverChecker.isPC());
        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertTrue(WebDriverChecker.isMobile());

        assertTrue(WebDriverChecker.isBrowser());
        assertFalse(WebDriverChecker.isNative());

        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());

        assertFalse(WebDriverChecker.isPCNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertTrue(WebDriverChecker.isIOSBrowser());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroidBrowser());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertTrue(WebDriverChecker.isMobileBrowser());
        assertFalse(WebDriverChecker.isMobileNative());
    }

    @Test
    @ExecuteOnTarget("android-native")
    void androidNative() {
        assertFalse(WebDriverChecker.isPC());
        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertTrue(WebDriverChecker.isMobile());

        assertFalse(WebDriverChecker.isBrowser());
        assertTrue(WebDriverChecker.isNative());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());

        assertFalse(WebDriverChecker.isPCNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isIOSBrowser());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroidBrowser());
        assertTrue(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobileBrowser());
        assertTrue(WebDriverChecker.isMobileNative());
    }

    @Test
    @ExecuteOnTarget("android-chrome")
    void androidChrome() {
        assertFalse(WebDriverChecker.isPC());
        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertTrue(WebDriverChecker.isMobile());

        assertTrue(WebDriverChecker.isBrowser());
        assertFalse(WebDriverChecker.isNative());

        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());

        assertFalse(WebDriverChecker.isPCNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isIOSBrowser());
        assertFalse(WebDriverChecker.isIOSNative());

        assertTrue(WebDriverChecker.isAndroidBrowser());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobileBrowser());
        assertFalse(WebDriverChecker.isMobileNative());
    }

    @Test
    @ExecuteOnTarget("macos-native")
    void macOSNative() {
        assertTrue(WebDriverChecker.isPC());
        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isAndroid());
        assertFalse(WebDriverChecker.isMobile());

        assertFalse(WebDriverChecker.isBrowser());
        assertFalse(WebDriverChecker.isNative());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());

        assertTrue(WebDriverChecker.isPCNative());

        assertTrue(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isIOSBrowser());
        assertFalse(WebDriverChecker.isIOSNative());

        assertFalse(WebDriverChecker.isAndroidBrowser());
        assertFalse(WebDriverChecker.isAndroidNative());

        assertFalse(WebDriverChecker.isMobileBrowser());
        assertFalse(WebDriverChecker.isMobileNative());
    }
}
