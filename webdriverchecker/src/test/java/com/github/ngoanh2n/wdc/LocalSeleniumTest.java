package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.EnabledIfProperty;
import com.github.ngoanh2n.wdc.driver.SeleniumDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

/**
 * @author ngoanh2n
 */
public class LocalSeleniumTest {
    private WebDriver driver;

    @BeforeEach
    void openDriver() {
        driver = SeleniumDriverProvider.createDriver();
    }

    @Test
    @EnabledIfProperty(name = "wdc.os", value = {"macos", "linux", "windows"})
    @EnabledIfProperty(name = "wdc.browser", value = "chrome")
    void isChrome() {
        Assertions.assertTrue(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefox(driver));
        Assertions.assertFalse(WebDriverChecker.isEdge(driver));
        Assertions.assertFalse(WebDriverChecker.isOpera(driver));
        Assertions.assertFalse(WebDriverChecker.isIE(driver));
    }

    @Test
    @EnabledIfProperty(name = "wdc.os", value = "macos")
    @EnabledIfProperty(name = "wdc.browser", value = "safari")
    void isSafari() {
        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertTrue(WebDriverChecker.isSafari(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefox(driver));
        Assertions.assertFalse(WebDriverChecker.isEdge(driver));
        Assertions.assertFalse(WebDriverChecker.isOpera(driver));
        Assertions.assertFalse(WebDriverChecker.isIE(driver));
    }

    @Test
    @EnabledIfProperty(name = "wdc.os", value = {"macos", "linux", "windows"})
    @EnabledIfProperty(name = "wdc.browser", value = "firefox")
    void isFirefox() {
        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));
        Assertions.assertTrue(WebDriverChecker.isFirefox(driver));
        Assertions.assertFalse(WebDriverChecker.isEdge(driver));
        Assertions.assertFalse(WebDriverChecker.isOpera(driver));
        Assertions.assertFalse(WebDriverChecker.isIE(driver));
    }

    @Test
    @EnabledIfProperty(name = "wdc.os", value = {"macos", "linux", "windows"})
    @EnabledIfProperty(name = "wdc.browser", value = "edge")
    void isEdge() {
        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefox(driver));
        Assertions.assertTrue(WebDriverChecker.isEdge(driver));
        Assertions.assertFalse(WebDriverChecker.isOpera(driver));
        Assertions.assertFalse(WebDriverChecker.isIE(driver));
    }

    @Test
    @EnabledIfProperty(name = "wdc.os", value = {"macos", "windows"})
    @EnabledIfProperty(name = "wdc.browser", value = "opera")
    void isOpera() {
        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefox(driver));
        Assertions.assertFalse(WebDriverChecker.isEdge(driver));
        Assertions.assertTrue(WebDriverChecker.isOpera(driver));
        Assertions.assertFalse(WebDriverChecker.isIE(driver));
    }

    @Test
    @EnabledIfProperty(name = "wdc.os", value = "windows")
    @EnabledIfProperty(name = "wdc.browser", value = "ie")
    void isIE() {
        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefox(driver));
        Assertions.assertFalse(WebDriverChecker.isEdge(driver));
        Assertions.assertFalse(WebDriverChecker.isOpera(driver));
        Assertions.assertTrue(WebDriverChecker.isIE(driver));
    }

    @AfterEach
    void closeDriver() {
        //Assertions.assertFalse(WebDriverChecker.isMacOS(driver));
        //Assertions.assertFalse(WebDriverChecker.isLinux(driver));
        //Assertions.assertFalse(WebDriverChecker.isWindows(driver));
        Assertions.assertTrue(WebDriverChecker.isPC(driver));
        Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        Assertions.assertFalse(WebDriverChecker.isMobile(driver));

        Assertions.assertTrue(WebDriverChecker.isAlive(driver));
        Assertions.assertTrue(WebDriverChecker.isLocal(driver));
        Assertions.assertFalse(WebDriverChecker.isRemote(driver));
        Assertions.assertFalse(WebDriverChecker.isDocker(driver));
        Assertions.assertTrue(WebDriverChecker.isBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isNative(driver));

        //Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        //Assertions.assertFalse(WebDriverChecker.isSafari(driver));
        //Assertions.assertFalse(WebDriverChecker.isFirefox(driver));
        //Assertions.assertFalse(WebDriverChecker.isEdge(driver));
        //Assertions.assertFalse(WebDriverChecker.isOpera(driver));
        //Assertions.assertFalse(WebDriverChecker.isIE(driver));
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy(driver));

        Assertions.assertTrue(WebDriverChecker.isPCBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isPCNative(driver));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertTrue(WebDriverChecker.isLocalServer(driver));
        Assertions.assertFalse(WebDriverChecker.isRemoteServer(driver));

        Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isMobile(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(driver));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(driver));
        Assertions.assertFalse(WebDriverChecker.isSauceLabs(driver));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(driver));

        driver.quit();
        Assertions.assertFalse(WebDriverChecker.isAlive(driver));
    }
}
