package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.github.ngoanh2n.junit5.RunOnProp;
import com.github.ngoanh2n.wdc.driver.AppiumDriverProvider;
import org.junit.jupiter.api.*;

import java.io.File;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class LocalAppiumTest {
    @BeforeAll
    static void setAppWorkingDir() {
        String appWorkingDirPath = new File("build/resources/test").getAbsolutePath();
        System.setProperty("appium:appWorkingDir", appWorkingDirPath);
    }

    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browserSize = null;
        Configuration.browser = AppiumDriverProvider.class.getName();
        Selenide.open();
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-ios-native.yml")
    void iosNative() {
        Assertions.assertFalse(WebDriverChecker.isPC());
        Assertions.assertTrue(WebDriverChecker.isIOS());
        Assertions.assertFalse(WebDriverChecker.isAndroid());
        Assertions.assertTrue(WebDriverChecker.isMobile());

        Assertions.assertFalse(WebDriverChecker.isBrowser());
        Assertions.assertTrue(WebDriverChecker.isNative());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());

        Assertions.assertFalse(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        Assertions.assertTrue(WebDriverChecker.isIOSNative());
        Assertions.assertTrue(WebDriverChecker.isIOSVirtual());

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual());

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser());
        Assertions.assertTrue(WebDriverChecker.isMobileNative());
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "safari")
    @RunOnProp(name = "wdc.caps", value = "local-ios-safari.yml")
    void iosSafari() {
        Assertions.assertFalse(WebDriverChecker.isPC());
        Assertions.assertTrue(WebDriverChecker.isIOS());
        Assertions.assertFalse(WebDriverChecker.isAndroid());
        Assertions.assertTrue(WebDriverChecker.isMobile());

        Assertions.assertTrue(WebDriverChecker.isBrowser());
        Assertions.assertFalse(WebDriverChecker.isNative());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertTrue(WebDriverChecker.isSafari());

        Assertions.assertFalse(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertTrue(WebDriverChecker.isIOSBrowser());
        Assertions.assertFalse(WebDriverChecker.isIOSNative());
        Assertions.assertTrue(WebDriverChecker.isIOSVirtual());

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual());

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser());
        Assertions.assertFalse(WebDriverChecker.isMobileNative());
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"windows", "linux"})
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-android-native.yml")
    void androidNative() {
        Assertions.assertFalse(WebDriverChecker.isPC());
        Assertions.assertFalse(WebDriverChecker.isIOS());
        Assertions.assertTrue(WebDriverChecker.isAndroid());
        Assertions.assertTrue(WebDriverChecker.isMobile());

        Assertions.assertFalse(WebDriverChecker.isBrowser());
        Assertions.assertTrue(WebDriverChecker.isNative());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());

        Assertions.assertFalse(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        Assertions.assertFalse(WebDriverChecker.isIOSNative());
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        Assertions.assertTrue(WebDriverChecker.isAndroidNative());
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual());

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser());
        Assertions.assertTrue(WebDriverChecker.isMobileNative());
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"windows", "linux"})
    @RunOnProp(name = "wdc.browser", value = "chrome")
    @RunOnProp(name = "wdc.caps", value = "local-android-chrome.yml")
    void androidChrome() {
        Assertions.assertFalse(WebDriverChecker.isPC());
        Assertions.assertFalse(WebDriverChecker.isIOS());
        Assertions.assertTrue(WebDriverChecker.isAndroid());
        Assertions.assertTrue(WebDriverChecker.isMobile());

        Assertions.assertTrue(WebDriverChecker.isBrowser());
        Assertions.assertFalse(WebDriverChecker.isNative());

        Assertions.assertTrue(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());

        Assertions.assertFalse(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        Assertions.assertFalse(WebDriverChecker.isIOSNative());
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        Assertions.assertTrue(WebDriverChecker.isAndroidBrowser());
        Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual());

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser());
        Assertions.assertFalse(WebDriverChecker.isMobileNative());
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-macos-native.yml")
    void macOSNative() {
        Assertions.assertTrue(WebDriverChecker.isPC());
        Assertions.assertFalse(WebDriverChecker.isIOS());
        Assertions.assertFalse(WebDriverChecker.isAndroid());
        Assertions.assertFalse(WebDriverChecker.isMobile());

        Assertions.assertFalse(WebDriverChecker.isBrowser());
        Assertions.assertTrue(WebDriverChecker.isNative());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());

        Assertions.assertTrue(WebDriverChecker.isPCNative());

        Assertions.assertTrue(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        Assertions.assertFalse(WebDriverChecker.isIOSNative());
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual());

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser());
        Assertions.assertFalse(WebDriverChecker.isMobileNative());
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "windows")
    @RunOnProp(name = "wdc.browser", value = "native")
    @RunOnProp(name = "wdc.caps", value = "local-windows-native.yml")
    void windowsNative() {
        Assertions.assertTrue(WebDriverChecker.isPC());
        Assertions.assertFalse(WebDriverChecker.isIOS());
        Assertions.assertFalse(WebDriverChecker.isAndroid());
        Assertions.assertFalse(WebDriverChecker.isMobile());

        Assertions.assertFalse(WebDriverChecker.isBrowser());
        Assertions.assertTrue(WebDriverChecker.isNative());

        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());

        Assertions.assertTrue(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertTrue(WebDriverChecker.isWindowsNative());

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        Assertions.assertFalse(WebDriverChecker.isIOSNative());
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        Assertions.assertFalse(WebDriverChecker.isAndroidVirtual());

        Assertions.assertFalse(WebDriverChecker.isMobileBrowser());
        Assertions.assertFalse(WebDriverChecker.isMobileNative());
        Assertions.assertFalse(WebDriverChecker.isMobileVirtual());
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
        Assertions.assertTrue(WebDriverChecker.isLocal());
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
        //Assertions.assertFalse(WebDriverChecker.isPCNative());

        //Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        //Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertTrue(WebDriverChecker.isLocalServer());
        Assertions.assertFalse(WebDriverChecker.isRemoteServer());

        //Assertions.assertFalse(WebDriverChecker.isIOS());
        //Assertions.assertFalse(WebDriverChecker.isIOSBrowser());
        //Assertions.assertFalse(WebDriverChecker.isIOSNative());
        //Assertions.assertFalse(WebDriverChecker.isIOSVirtual());

        //Assertions.assertFalse(WebDriverChecker.isAndroid());
        //Assertions.assertFalse(WebDriverChecker.isAndroidBrowser());
        //Assertions.assertFalse(WebDriverChecker.isAndroidNative());
        //Assertions.assertFalse(WebDriverChecker.isAndroidVirtual());

        //Assertions.assertFalse(WebDriverChecker.isMobile());
        //Assertions.assertFalse(WebDriverChecker.isMobileBrowser());
        //Assertions.assertFalse(WebDriverChecker.isMobileNative());
        //Assertions.assertFalse(WebDriverChecker.isMobileVirtual());

        Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        Assertions.assertFalse(WebDriverChecker.isSauceLabs());
        Assertions.assertFalse(WebDriverChecker.isTestingBot());

        WebDriverRunner.closeWebDriver();
        Assertions.assertFalse(WebDriverChecker.isAlive());
    }
}
