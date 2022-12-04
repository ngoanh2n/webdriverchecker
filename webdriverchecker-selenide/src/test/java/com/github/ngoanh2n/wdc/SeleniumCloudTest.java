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
 * @since 2022-08-20
 */
public class SeleniumCloudTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = CloudDriverProvider.class.getName();
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
        assertFalse(WebDriverChecker.isLocal());
        assertTrue(WebDriverChecker.isRemote());
        assertFalse(WebDriverChecker.isDocker());
        assertTrue(WebDriverChecker.isBrowser());
        assertFalse(WebDriverChecker.isNative());

        //assertFalse(WebDriverChecker.isChrome());
        //assertFalse(WebDriverChecker.isSafari());
        //assertFalse(WebDriverChecker.isFirefox());
        //assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());

        assertTrue(WebDriverChecker.isPCBrowser());
        assertFalse(WebDriverChecker.isPCNative());

        assertFalse(WebDriverChecker.isMacOSNative());
        assertFalse(WebDriverChecker.isWindowsNative());

        assertFalse(WebDriverChecker.isLocalServer());
        assertTrue(WebDriverChecker.isRemoteServer());

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

        //assertFalse(WebDriverChecker.isLambdaTest());
        //assertFalse(WebDriverChecker.isBrowserStack());
        //assertFalse(WebDriverChecker.isSauceLabs());
        //assertFalse(WebDriverChecker.isTestingBot());

        Selenide.closeWebDriver();
        assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    @ExecuteOnTarget("lambdatest")
    void lambdaTest() {
        CloudDriverProvider.caps.setValue("lambdatest-windows-chrome.yml");
        Selenide.open();

        assertFalse(WebDriverChecker.isMacOS());
        assertFalse(WebDriverChecker.isLinux());
        assertTrue(WebDriverChecker.isWindows());

        assertTrue(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());

        assertTrue(WebDriverChecker.isLambdaTest());
        assertFalse(WebDriverChecker.isBrowserStack());
        assertFalse(WebDriverChecker.isSauceLabs());
        assertFalse(WebDriverChecker.isTestingBot());
    }

    @Test
    @ExecuteOnTarget("browserstack")
    void browserStack() {
        CloudDriverProvider.caps.setValue("browserstack-macos-safari.yml");
        Selenide.open();

        assertTrue(WebDriverChecker.isMacOS());
        assertFalse(WebDriverChecker.isLinux());
        assertFalse(WebDriverChecker.isWindows());

        assertFalse(WebDriverChecker.isChrome());
        assertTrue(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());

        assertFalse(WebDriverChecker.isLambdaTest());
        assertTrue(WebDriverChecker.isBrowserStack());
        assertFalse(WebDriverChecker.isSauceLabs());
        assertFalse(WebDriverChecker.isTestingBot());
    }

    @Test
    @ExecuteOnTarget("saucelabs")
    void sauceLabs() {
        CloudDriverProvider.caps.setValue("saucelabs-linux-firefox.yml");
        Selenide.open();

        assertFalse(WebDriverChecker.isMacOS());
        assertTrue(WebDriverChecker.isLinux());
        assertFalse(WebDriverChecker.isWindows());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertTrue(WebDriverChecker.isFirefox());
        assertFalse(WebDriverChecker.isEdge());

        assertFalse(WebDriverChecker.isLambdaTest());
        assertFalse(WebDriverChecker.isBrowserStack());
        assertTrue(WebDriverChecker.isSauceLabs());
        assertFalse(WebDriverChecker.isTestingBot());
    }

    @Test
    @ExecuteOnTarget("testingbot")
    void testingBot() {
        CloudDriverProvider.caps.setValue("testingbot-windows-edge.yml");
        Selenide.open();

        assertFalse(WebDriverChecker.isMacOS());
        assertFalse(WebDriverChecker.isLinux());
        assertTrue(WebDriverChecker.isWindows());

        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());
        assertTrue(WebDriverChecker.isEdge());

        assertFalse(WebDriverChecker.isLambdaTest());
        assertFalse(WebDriverChecker.isBrowserStack());
        assertFalse(WebDriverChecker.isSauceLabs());
        assertTrue(WebDriverChecker.isTestingBot());
    }
}
