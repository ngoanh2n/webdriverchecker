package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.junit5.RunOnProp;
import com.github.ngoanh2n.wdc.driver.CloudDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2022-08-20
 */
public class CloudSeleniumTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = CloudDriverProvider.class.getName();
    }

    @AfterEach
    void closeDriver() {
        //Assertions.assertFalse(WebDriverChecker.isMacOS());
        //Assertions.assertFalse(WebDriverChecker.isLinux());
        //Assertions.assertFalse(WebDriverChecker.isWindows());
        Assertions.assertTrue(WebDriverChecker.isPC());
        Assertions.assertFalse(WebDriverChecker.isIOS());
        Assertions.assertFalse(WebDriverChecker.isAndroid());
        Assertions.assertFalse(WebDriverChecker.isMobile());

        Assertions.assertTrue(WebDriverChecker.isAlive());
        Assertions.assertFalse(WebDriverChecker.isLocal());
        Assertions.assertTrue(WebDriverChecker.isRemote());
        Assertions.assertFalse(WebDriverChecker.isDocker());
        Assertions.assertTrue(WebDriverChecker.isBrowser());
        Assertions.assertFalse(WebDriverChecker.isNative());

        //Assertions.assertFalse(WebDriverChecker.isChrome());
        //Assertions.assertFalse(WebDriverChecker.isSafari());
        //Assertions.assertFalse(WebDriverChecker.isFirefox());
        //Assertions.assertFalse(WebDriverChecker.isEdge());
        Assertions.assertFalse(WebDriverChecker.isOpera());
        Assertions.assertFalse(WebDriverChecker.isIE());
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy());
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy());

        Assertions.assertTrue(WebDriverChecker.isPCBrowser());
        Assertions.assertFalse(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertFalse(WebDriverChecker.isLocalServer());
        Assertions.assertTrue(WebDriverChecker.isRemoteServer());

        Assertions.assertFalse(WebDriverChecker.isIOS());
        Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        Assertions.assertFalse(WebDriverChecker.isIOSNative());
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        Assertions.assertFalse(WebDriverChecker.isAndroid());
        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual());

        Assertions.assertFalse(WebDriverChecker.isMobile());
        Assertions.assertFalse(WebDriverChecker.isMobileBrowser());
        Assertions.assertFalse(WebDriverChecker.isMobileNative());
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual());

        //Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        //Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        //Assertions.assertFalse(WebDriverChecker.isSauceLabs());
        //Assertions.assertFalse(WebDriverChecker.isTestingBot());

        Selenide.closeWebDriver();
        Assertions.assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "lambdatest")
    @RunOnProp(name = "wdc.caps", value = "cloud-lambdatest-windows-chrome.yml")
    void lambdaTest() {
        Selenide.open();

        Assertions.assertFalse(WebDriverChecker.isMacOS());
        Assertions.assertFalse(WebDriverChecker.isLinux());
        Assertions.assertTrue(WebDriverChecker.isWindows());

        Assertions.assertTrue(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());

        Assertions.assertTrue(WebDriverChecker.isLambdaTest());
        Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        Assertions.assertFalse(WebDriverChecker.isSauceLabs());
        Assertions.assertFalse(WebDriverChecker.isTestingBot());
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "browserstack")
    @RunOnProp(name = "wdc.caps", value = "cloud-browserstack-macos-safari.yml")
    void browserStack() {
        Selenide.open();

        Assertions.assertTrue(WebDriverChecker.isMacOS());
        Assertions.assertFalse(WebDriverChecker.isLinux());
        Assertions.assertFalse(WebDriverChecker.isWindows());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertTrue(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());

        Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        Assertions.assertTrue(WebDriverChecker.isBrowserStack());
        Assertions.assertFalse(WebDriverChecker.isSauceLabs());
        Assertions.assertFalse(WebDriverChecker.isTestingBot());
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "saucelabs")
    @RunOnProp(name = "wdc.caps", value = "cloud-saucelabs-linux-firefox.yml")
    void sauceLabs() {
        Selenide.open();

        Assertions.assertFalse(WebDriverChecker.isMacOS());
        Assertions.assertTrue(WebDriverChecker.isLinux());
        Assertions.assertFalse(WebDriverChecker.isWindows());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertTrue(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());

        Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        Assertions.assertTrue(WebDriverChecker.isSauceLabs());
        Assertions.assertFalse(WebDriverChecker.isTestingBot());
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "testingbot")
    @RunOnProp(name = "wdc.caps", value = "cloud-testingbot-windows-edge.yml")
    void testingBot() {
        Selenide.open();

        Assertions.assertFalse(WebDriverChecker.isMacOS());
        Assertions.assertFalse(WebDriverChecker.isLinux());
        Assertions.assertTrue(WebDriverChecker.isWindows());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertTrue(WebDriverChecker.isEdge());

        Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        Assertions.assertFalse(WebDriverChecker.isSauceLabs());
        Assertions.assertTrue(WebDriverChecker.isTestingBot());
    }
}
