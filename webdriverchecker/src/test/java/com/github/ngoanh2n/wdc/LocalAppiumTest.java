package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.junit5.RunOnProp;
import com.github.ngoanh2n.wdc.driver.AppiumDriverProvider;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class LocalAppiumTest {
    private static WebDriver driver;

    @BeforeAll
    static void setAppWorkingDir() {
        String appWorkingDirPath = new File("build/resources/test").getAbsolutePath();
        System.setProperty("appium:appWorkingDir", appWorkingDirPath);
    }

    @BeforeEach
    void openDriver() {
        driver = AppiumDriverProvider.createDriver();
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-ios-native.yml")
    void iosNative() {
        Assertions.assertFalse(WebDriverChecker.isPC(driver));
        Assertions.assertTrue(WebDriverChecker.isIOS(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        Assertions.assertTrue(WebDriverChecker.isMobile(driver));

        Assertions.assertFalse(WebDriverChecker.isBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isNative(driver));

        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));

        Assertions.assertFalse(WebDriverChecker.isPCNative(driver));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isIOSNative(driver));
        Assertions.assertTrue(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isMobileNative(driver));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(driver));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "safari")
    @RunOnProp(name = "wdc.caps", value = "local-ios-safari.yml")
    void iosSafari() {
        Assertions.assertFalse(WebDriverChecker.isPC(driver));
        Assertions.assertTrue(WebDriverChecker.isIOS(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        Assertions.assertTrue(WebDriverChecker.isMobile(driver));

        Assertions.assertTrue(WebDriverChecker.isBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isNative(driver));

        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertTrue(WebDriverChecker.isSafari(driver));

        Assertions.assertFalse(WebDriverChecker.isPCNative(driver));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertTrue(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        Assertions.assertTrue(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(driver));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"windows", "linux"})
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-android-native.yml")
    void androidNative() {
        Assertions.assertFalse(WebDriverChecker.isPC(driver));
        Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        Assertions.assertTrue(WebDriverChecker.isAndroid(driver));
        Assertions.assertTrue(WebDriverChecker.isMobile(driver));

        Assertions.assertFalse(WebDriverChecker.isBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isNative(driver));

        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));

        Assertions.assertFalse(WebDriverChecker.isPCNative(driver));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isMobileNative(driver));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(driver));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"windows", "linux"})
    @RunOnProp(name = "wdc.browser", value = "chrome")
    @RunOnProp(name = "wdc.caps", value = "local-android-chrome.yml")
    void androidChrome() {
        Assertions.assertFalse(WebDriverChecker.isPC(driver));
        Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        Assertions.assertTrue(WebDriverChecker.isAndroid(driver));
        Assertions.assertTrue(WebDriverChecker.isMobile(driver));

        Assertions.assertTrue(WebDriverChecker.isBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isNative(driver));

        Assertions.assertTrue(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));

        Assertions.assertFalse(WebDriverChecker.isPCNative(driver));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertTrue(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(driver));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-macos-native.yml")
    void macOSNative() {
        Assertions.assertTrue(WebDriverChecker.isPC(driver));
        Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        Assertions.assertFalse(WebDriverChecker.isMobile(driver));

        Assertions.assertFalse(WebDriverChecker.isBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isNative(driver));

        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));

        Assertions.assertTrue(WebDriverChecker.isPCNative(driver));

        Assertions.assertTrue(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual(driver));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "windows")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-windows-native.yml")
    void windowsNative() {
        Assertions.assertTrue(WebDriverChecker.isPC(driver));
        Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        Assertions.assertFalse(WebDriverChecker.isMobile(driver));

        Assertions.assertFalse(WebDriverChecker.isBrowser(driver));
        Assertions.assertTrue(WebDriverChecker.isNative(driver));

        Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));

        Assertions.assertTrue(WebDriverChecker.isPCNative(driver));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertTrue(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual(driver));
    }

    @AfterEach
    void closeDriver() {
        //Assertions.assertFalse(WebDriverChecker.isMacOS(driver));
        //Assertions.assertFalse(WebDriverChecker.isLinux(driver));
        //Assertions.assertFalse(WebDriverChecker.isWindows(driver));
        //Assertions.assertFalse(WebDriverChecker.isPC(driver));
        //Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        //Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        //Assertions.assertTrue(WebDriverChecker.isMobile(driver));

        Assertions.assertTrue(WebDriverChecker.isAlive(driver));
        Assertions.assertTrue(WebDriverChecker.isLocal(driver));
        Assertions.assertTrue(WebDriverChecker.isRemote(driver));
        Assertions.assertFalse(WebDriverChecker.isDocker(driver));
        //Assertions.assertFalse(WebDriverChecker.isBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isNative(driver));

        //Assertions.assertFalse(WebDriverChecker.isChrome(driver));
        //Assertions.assertFalse(WebDriverChecker.isSafari(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefox(driver));
        Assertions.assertFalse(WebDriverChecker.isEdge(driver));
        Assertions.assertFalse(WebDriverChecker.isOpera(driver));
        Assertions.assertFalse(WebDriverChecker.isIE(driver));
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy(driver));
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy(driver));

        Assertions.assertFalse(WebDriverChecker.isPCBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isPCNative(driver));

        //Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        //Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertTrue(WebDriverChecker.isLocalServer(driver));
        Assertions.assertFalse(WebDriverChecker.isRemoteServer(driver));

        //Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        //Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        //Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        //Assertions.assertFalse(WebDriverChecker.isAndroid(driver));
        //Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        //Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(driver));

        //Assertions.assertFalse(WebDriverChecker.isMobile(driver));
        //Assertions.assertFalse(WebDriverChecker.isMobileBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        //Assertions.assertFalse(WebDriverChecker.isMobileVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(driver));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(driver));
        Assertions.assertFalse(WebDriverChecker.isSauceLabs(driver));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(driver));

        driver.quit();
        Assertions.assertFalse(WebDriverChecker.isAlive(driver));
    }
}
