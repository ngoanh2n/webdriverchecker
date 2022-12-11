package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.Prop;
import com.github.ngoanh2n.junit5.RunOnProp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class LocalSeleniumTest {
    @BeforeEach
    void openDriver() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = Prop.string("wdc.browser").getValue();

        if (Configuration.browser.equals("opera")) {
            WebDriverManager wdm = WebDriverManager.operadriver();
            wdm.setup();
            String binPath = wdm.getDownloadedDriverPath();
            System.setProperty("webdriver.opera.driver", binPath);
        }
        Selenide.open();
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "linux", "windows"})
    @RunOnProp(name = "wdc.browser", value = "chrome")
    void isChrome() {
        Assertions.assertTrue(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());
        Assertions.assertFalse(WebDriverChecker.isOpera());
        Assertions.assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "macos")
    @RunOnProp(name = "wdc.browser", value = "safari")
    void isSafari() {
        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertTrue(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());
        Assertions.assertFalse(WebDriverChecker.isOpera());
        Assertions.assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "linux", "windows"})
    @RunOnProp(name = "wdc.browser", value = "firefox")
    void isFirefox() {
        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertTrue(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());
        Assertions.assertFalse(WebDriverChecker.isOpera());
        Assertions.assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "linux", "windows"})
    @RunOnProp(name = "wdc.browser", value = "edge")
    void isEdge() {
        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertTrue(WebDriverChecker.isEdge());
        Assertions.assertFalse(WebDriverChecker.isOpera());
        Assertions.assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = {"macos", "windows"})
    @RunOnProp(name = "wdc.browser", value = "opera")
    void isOpera() {
        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());
        Assertions.assertTrue(WebDriverChecker.isOpera());
        Assertions.assertFalse(WebDriverChecker.isIE());
    }

    @Test
    @RunOnProp(name = "wdc.os", value = "windows")
    @RunOnProp(name = "wdc.browser", value = "ie")
    void isIE() {
        Assertions.assertFalse(WebDriverChecker.isChrome());
        Assertions.assertFalse(WebDriverChecker.isSafari());
        Assertions.assertFalse(WebDriverChecker.isFirefox());
        Assertions.assertFalse(WebDriverChecker.isEdge());
        Assertions.assertFalse(WebDriverChecker.isOpera());
        Assertions.assertTrue(WebDriverChecker.isIE());
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
        Assertions.assertTrue(WebDriverChecker.isLocal());
        Assertions.assertFalse(WebDriverChecker.isRemote());
        Assertions.assertFalse(WebDriverChecker.isDocker());
        Assertions.assertTrue(WebDriverChecker.isBrowser());
        Assertions.assertFalse(WebDriverChecker.isNative());

        //Assertions.assertFalse(WebDriverChecker.isChrome());
        //Assertions.assertFalse(WebDriverChecker.isSafari());
        //Assertions.assertFalse(WebDriverChecker.isFirefox());
        //Assertions.assertFalse(WebDriverChecker.isEdge());
        //Assertions.assertFalse(WebDriverChecker.isOpera());
        //Assertions.assertFalse(WebDriverChecker.isIE());
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy());
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy());

        Assertions.assertTrue(WebDriverChecker.isPCBrowser());
        Assertions.assertFalse(WebDriverChecker.isPCNative());

        Assertions.assertFalse(WebDriverChecker.isMacOSNative());
        Assertions.assertFalse(WebDriverChecker.isWindowsNative());

        Assertions.assertTrue(WebDriverChecker.isLocalServer());
        Assertions.assertFalse(WebDriverChecker.isRemoteServer());

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

        Assertions.assertFalse(WebDriverChecker.isLambdaTest());
        Assertions.assertFalse(WebDriverChecker.isBrowserStack());
        Assertions.assertFalse(WebDriverChecker.isSauceLabs());
        Assertions.assertFalse(WebDriverChecker.isTestingBot());

        Selenide.closeWebDriver();
        Assertions.assertFalse(WebDriverChecker.isAlive());
    }
}
