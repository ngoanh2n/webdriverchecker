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
    private static WebDriver wd;

    @BeforeAll
    static void setAppWorkingDir() {
        String appWorkingDirPath = new File("build/resources/test").getAbsolutePath();
        System.setProperty("appium:appWorkingDir", appWorkingDirPath);
    }

    @BeforeEach
    void openDriver() {
        wd = AppiumDriverProvider.createDriver();
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-ios-native.yml")
    void iosNative() {
        Assertions.assertFalse(WebDriverChecker.isPC(wd));
        Assertions.assertTrue(WebDriverChecker.isIOS(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        Assertions.assertTrue(WebDriverChecker.isMobile(wd));

        Assertions.assertFalse(WebDriverChecker.isBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isNative(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));

        Assertions.assertFalse(WebDriverChecker.isPCNative(wd));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isIOSNative(wd));
        Assertions.assertTrue(WebDriverChecker.isIOSVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isMobileNative(wd));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "safari")
    @RunOnProp(name = "wdc.caps", value = "local-ios-safari.yml")
    void iosSafari() {
        Assertions.assertFalse(WebDriverChecker.isPC(wd));
        Assertions.assertTrue(WebDriverChecker.isIOS(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        Assertions.assertTrue(WebDriverChecker.isMobile(wd));

        Assertions.assertTrue(WebDriverChecker.isBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isNative(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertTrue(WebDriverChecker.isSafari(wd));

        Assertions.assertFalse(WebDriverChecker.isPCNative(wd));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertTrue(WebDriverChecker.isIOSBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(wd));
        Assertions.assertTrue(WebDriverChecker.isIOSVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(wd));

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(wd));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"windows", "linux"})
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-android-native.yml")
    void androidNative() {
        Assertions.assertFalse(WebDriverChecker.isPC(wd));
        Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        Assertions.assertTrue(WebDriverChecker.isAndroid(wd));
        Assertions.assertTrue(WebDriverChecker.isMobile(wd));

        Assertions.assertFalse(WebDriverChecker.isBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isNative(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));

        Assertions.assertFalse(WebDriverChecker.isPCNative(wd));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isAndroidNative(wd));
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isMobileNative(wd));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"windows", "linux"})
    @RunOnProp(name = "wdc.browser", value = "chrome")
    @RunOnProp(name = "wdc.caps", value = "local-android-chrome.yml")
    void androidChrome() {
        Assertions.assertFalse(WebDriverChecker.isPC(wd));
        Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        Assertions.assertTrue(WebDriverChecker.isAndroid(wd));
        Assertions.assertTrue(WebDriverChecker.isMobile(wd));

        Assertions.assertTrue(WebDriverChecker.isBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isNative(wd));

        Assertions.assertTrue(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));

        Assertions.assertFalse(WebDriverChecker.isPCNative(wd));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(wd));

        Assertions.assertTrue(WebDriverChecker.isAndroidBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(wd));
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual(wd));

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(wd));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-macos-native.yml")
    void macOSNative() {
        Assertions.assertTrue(WebDriverChecker.isPC(wd));
        Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        Assertions.assertFalse(WebDriverChecker.isMobile(wd));

        Assertions.assertFalse(WebDriverChecker.isBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isNative(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));

        Assertions.assertTrue(WebDriverChecker.isPCNative(wd));

        Assertions.assertTrue(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual(wd));
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "windows")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-windows-native.yml")
    void windowsNative() {
        Assertions.assertTrue(WebDriverChecker.isPC(wd));
        Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        Assertions.assertFalse(WebDriverChecker.isMobile(wd));

        Assertions.assertFalse(WebDriverChecker.isBrowser(wd));
        Assertions.assertTrue(WebDriverChecker.isNative(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));

        Assertions.assertTrue(WebDriverChecker.isPCNative(wd));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertTrue(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(wd));
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual(wd));
    }

    @AfterEach
    void closeDriver() {
        //Assertions.assertFalse(WebDriverChecker.isMacOS(wd));
        //Assertions.assertFalse(WebDriverChecker.isLinux(wd));
        //Assertions.assertFalse(WebDriverChecker.isWindows(wd));
        //Assertions.assertFalse(WebDriverChecker.isPC(wd));
        //Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        //Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        //Assertions.assertTrue(WebDriverChecker.isMobile(wd));

        Assertions.assertTrue(WebDriverChecker.isAlive(wd));
        Assertions.assertTrue(WebDriverChecker.isLocal(wd));
        Assertions.assertTrue(WebDriverChecker.isRemote(wd));
        Assertions.assertFalse(WebDriverChecker.isDocker(wd));
        //Assertions.assertFalse(WebDriverChecker.isBrowser(wd));
        //Assertions.assertFalse(WebDriverChecker.isNative(wd));

        //Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        //Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        Assertions.assertFalse(WebDriverChecker.isIE(wd));
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy(wd));

        Assertions.assertFalse(WebDriverChecker.isPCBrowser(wd));
        //Assertions.assertFalse(WebDriverChecker.isPCNative(wd));

        //Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        //Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertTrue(WebDriverChecker.isLocalServer(wd));
        Assertions.assertFalse(WebDriverChecker.isRemoteServer(wd));

        //Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        //Assertions.assertFalse(WebDriverChecker.isIOSBrowser(wd));
        //Assertions.assertFalse(WebDriverChecker.isIOSNative(wd));
        //Assertions.assertFalse(WebDriverChecker.isIOSVirtual(wd));

        //Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        //Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(wd));
        //Assertions.assertFalse(WebDriverChecker.isAndroidNative(wd));
        //Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(wd));

        //Assertions.assertFalse(WebDriverChecker.isMobile(wd));
        //Assertions.assertFalse(WebDriverChecker.isMobileBrowser(wd));
        //Assertions.assertFalse(WebDriverChecker.isMobileNative(wd));
        //Assertions.assertFalse(WebDriverChecker.isMobileVirtual(wd));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(wd));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(wd));
        Assertions.assertFalse(WebDriverChecker.isSauceLabs(wd));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(wd));

        wd.quit();
        Assertions.assertFalse(WebDriverChecker.isAlive(wd));
    }
}
