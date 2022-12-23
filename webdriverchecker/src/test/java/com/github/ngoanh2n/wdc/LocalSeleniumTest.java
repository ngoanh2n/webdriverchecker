package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.junit5.RunOnProp;
import com.github.ngoanh2n.wdc.driver.SeleniumDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class LocalSeleniumTest {
    private WebDriver wd;

    @BeforeEach
    void openDriver() {
        wd = SeleniumDriverProvider.createDriver();
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "linux", "windows"})
    @RunOnProp(name = "wdc.browser", value = "chrome")
    void isChrome() {
        Assertions.assertTrue(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        Assertions.assertFalse(WebDriverChecker.isIE(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "safari")
    void isSafari() {
        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertTrue(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        Assertions.assertFalse(WebDriverChecker.isIE(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "linux", "windows"})
    @RunOnProp(name = "wdc.browser", value = "firefox")
    void isFirefox() {
        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertTrue(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        Assertions.assertFalse(WebDriverChecker.isIE(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "linux", "windows"})
    @RunOnProp(name = "wdc.browser", value = "edge")
    void isEdge() {
        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertTrue(WebDriverChecker.isEdge(wd));
        Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        Assertions.assertFalse(WebDriverChecker.isIE(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "windows"})
    @RunOnProp(name = "wdc.browser", value = "opera")
    void isOpera() {
        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        Assertions.assertTrue(WebDriverChecker.isOpera(wd));
        Assertions.assertFalse(WebDriverChecker.isIE(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "windows")
    @RunOnProp(name = "wdc.browser", value = "ie")
    void isIE() {
        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        Assertions.assertTrue(WebDriverChecker.isIE(wd));
    }

    @AfterEach
    void closeDriver() {
        //Assertions.assertFalse(WebDriverChecker.isMacOS(wd));
        //Assertions.assertFalse(WebDriverChecker.isLinux(wd));
        //Assertions.assertFalse(WebDriverChecker.isWindows(wd));
        Assertions.assertTrue(WebDriverChecker.isPC(wd));
        Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        Assertions.assertFalse(WebDriverChecker.isMobile(wd));

        Assertions.assertTrue(WebDriverChecker.isAlive(wd));
        Assertions.assertTrue(WebDriverChecker.isLocal(wd));
        Assertions.assertFalse(WebDriverChecker.isRemote(wd));
        Assertions.assertFalse(WebDriverChecker.isDocker(wd));
        Assertions.assertTrue(WebDriverChecker.isBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isNative(wd));

        //Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        //Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        //Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        //Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        //Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        //Assertions.assertFalse(WebDriverChecker.isIE(wd));
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy(wd));

        Assertions.assertTrue(WebDriverChecker.isPCBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isPCNative(wd));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertTrue(WebDriverChecker.isLocalServer(wd));
        Assertions.assertFalse(WebDriverChecker.isRemoteServer(wd));

        Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isMobile(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(wd));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(wd));
        Assertions.assertFalse(WebDriverChecker.isSauceLabs(wd));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(wd));

        wd.quit();
        Assertions.assertFalse(WebDriverChecker.isAlive(wd));
    }
}
