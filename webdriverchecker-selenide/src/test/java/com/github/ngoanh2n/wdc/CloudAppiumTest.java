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
 * @since 2022-08-23
 */
public class CloudAppiumTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = CloudDriverProvider.class.getName();
        Configuration.browserSize = null;
    }

    @AfterEach
    void closeDriver() {
        //Assertions.assertFalse(WebDriverChecker.isMacOS());
        //Assertions.assertFalse(WebDriverChecker.isLinux());
        //Assertions.assertFalse(WebDriverChecker.isWindows());
        //Assertions.assertFalse(WebDriverChecker.isPC());
        //Assertions.assertFalse(WebDriverChecker.isIOS());
        //Assertions.assertFalse(WebDriverChecker.isAndroid());
        //Assertions.assertTrue(WebDriverChecker.isMobile());

        Assertions.assertTrue(WebDriverChecker.isAlive());
        Assertions.assertFalse(WebDriverChecker.isLocal());
        Assertions.assertTrue(WebDriverChecker.isRemote());
        Assertions.assertFalse(WebDriverChecker.isDocker());
        //Assertions.assertFalse(WebDriverChecker.isBrowser());
        //Assertions.assertFalse(WebDriverChecker.isNative());

        //Assertions.assertFalse(WebDriverChecker.isChrome());
        //Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());
        Assertions.assertFalse(WebDriverChecker.isOpera());
        Assertions.assertFalse(WebDriverChecker.isIE());
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy());
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy());

        Assertions.assertFalse(WebDriverChecker.isPCBrowser());
        Assertions.assertFalse(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertFalse(WebDriverChecker.isLocalServer());
        Assertions.assertTrue(WebDriverChecker.isRemoteServer());

        //Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        //Assertions.assertFalse(WebDriverChecker.isIOSNative());
        //Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        //Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        //Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        //Assertions.assertFalse(WebDriverChecker.isAndroidVirtual());

        //Assertions.assertFalse(WebDriverChecker.isMobileBrowser());
        //Assertions.assertFalse(WebDriverChecker.isMobileNative());
        //Assertions.assertFalse(WebDriverChecker.isMobileVirtual());

        //Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        //Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        //Assertions.assertFalse(WebDriverChecker.isSauceLabs());
        //Assertions.assertFalse(WebDriverChecker.isTestingBot());

        Selenide.closeWebDriver();
        Assertions.assertFalse(WebDriverChecker.isAlive());
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "saucelabs")
    @RunOnProp(name = "wdc.caps", value = "cloud-saucelabs-android-chrome.yml")
    void sauceLabs() {
        Selenide.open();

        Assertions.assertFalse(WebDriverChecker.isPC());
        Assertions.assertFalse(WebDriverChecker.isIOS());
        Assertions.assertTrue(WebDriverChecker.isAndroid());
        Assertions.assertTrue(WebDriverChecker.isMobile());

        Assertions.assertTrue(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        Assertions.assertFalse(WebDriverChecker.isIOSNative());
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        Assertions.assertTrue(WebDriverChecker.isAndroidBrowser());
        Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual());

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser());
        Assertions.assertFalse(WebDriverChecker.isMobileNative());
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual());

        Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        Assertions.assertTrue(WebDriverChecker.isSauceLabs());
        Assertions.assertFalse(WebDriverChecker.isTestingBot());
    }
}
