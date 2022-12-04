package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.ExecuteOnTarget;
import com.github.ngoanh2n.wdc.driver.CloudDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2022-08-23
 */
public class AppiumCloudTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = CloudDriverProvider.class.getName();
        Configuration.browserSize = null;
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
        assertFalse(WebDriverChecker.isLocal());
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
        assertFalse(WebDriverChecker.isPCNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isLocalServer());
        assertTrue(WebDriverChecker.isRemoteServer());

        //assertFalse(WebDriverChecker.isIOSBrowser());
        //assertFalse(WebDriverChecker.isIOSNative());
        //assertFalse(WebDriverChecker.isIOSVirtual());

        //assertFalse(WebDriverChecker.isAndroidBrowser());
        //assertFalse(WebDriverChecker.isAndroidNative());
        //assertFalse(WebDriverChecker.isAndroidVirtual());

        //assertFalse(WebDriverChecker.isMobileBrowser());
        //assertFalse(WebDriverChecker.isMobileNative());
        //assertFalse(WebDriverChecker.isMobileVirtual());

        //assertFalse(WebDriverChecker.isLambdaTest());
        //assertFalse(WebDriverChecker.isBrowserStack());
        //assertFalse(WebDriverChecker.isSauceLabs());
        //assertFalse(WebDriverChecker.isTestingBot());

        Selenide.closeWebDriver();
        assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    @ExecuteOnTarget("saucelabs")
    void sauceLabsAndroidChrome() {
        CloudDriverProvider.caps.setValue("saucelabs-android-chrome.yml");
        Selenide.open();

        assertFalse(WebDriverChecker.isPC());
        assertFalse(WebDriverChecker.isIOS());
        assertTrue(WebDriverChecker.isAndroid());
        assertTrue(WebDriverChecker.isMobile());

        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());

        assertFalse(WebDriverChecker.isIOSBrowser());
        assertFalse(WebDriverChecker.isIOSNative());
        assertFalse(WebDriverChecker.isIOSVirtual());

        assertTrue(WebDriverChecker.isAndroidBrowser());
        assertFalse(WebDriverChecker.isAndroidNative());
        assertTrue(WebDriverChecker.isAndroidVirtual());

        assertTrue(WebDriverChecker.isMobileBrowser());
        assertFalse(WebDriverChecker.isMobileNative());
        assertTrue(WebDriverChecker.isMobileVirtual());

        assertFalse(WebDriverChecker.isLambdaTest());
        assertFalse(WebDriverChecker.isBrowserStack());
        assertTrue(WebDriverChecker.isSauceLabs());
        assertFalse(WebDriverChecker.isTestingBot());
    }
}
