package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.EnabledIfProperty;
import com.github.ngoanh2n.SetProperty;
import com.github.ngoanh2n.wdc.driver.CloudDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

/**
 * @author ngoanh2n
 */
@EnabledIfProperty(name = "wdc.group", value = "appium-cloud")
public class CloudAppiumTest {
    private WebDriver driver;

    @BeforeEach
    void openDriver() {
        driver = CloudDriverProvider.createDriver();
    }

    @Test
    @EnabledIfProperty(name = "wdc.cloud", value = "saucelabs")
    @SetProperty(name = "wdc.caps", value = "cloud-saucelabs-android-chrome.yml")
    void sauceLabs() {
        Assertions.assertFalse(WebDriverChecker.isPC(driver));
        Assertions.assertFalse(WebDriverChecker.isIOS(driver));
        Assertions.assertTrue(WebDriverChecker.isAndroid(driver));
        Assertions.assertTrue(WebDriverChecker.isMobile(driver));

        Assertions.assertTrue(WebDriverChecker.isChrome(driver));
        Assertions.assertFalse(WebDriverChecker.isSafari(driver));

        Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        Assertions.assertTrue(WebDriverChecker.isAndroidBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        Assertions.assertTrue(WebDriverChecker.isAndroidVirtual(driver));

        Assertions.assertTrue(WebDriverChecker.isMobileBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        Assertions.assertTrue(WebDriverChecker.isMobileVirtual(driver));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(driver));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(driver));
        Assertions.assertTrue(WebDriverChecker.isSauceLabs(driver));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(driver));
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
        Assertions.assertFalse(WebDriverChecker.isLocal(driver));
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

        Assertions.assertFalse(WebDriverChecker.isPCBrowser(driver));
        Assertions.assertFalse(WebDriverChecker.isPCNative(driver));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(driver));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(driver));

        Assertions.assertFalse(WebDriverChecker.isLocalServer(driver));
        Assertions.assertTrue(WebDriverChecker.isRemoteServer(driver));

        //Assertions.assertFalse(WebDriverChecker.isIOSBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isIOSNative(driver));
        //Assertions.assertFalse(WebDriverChecker.isIOSVirtual(driver));

        //Assertions.assertFalse(WebDriverChecker.isAndroidBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isAndroidNative(driver));
        //Assertions.assertFalse(WebDriverChecker.isAndroidVirtual(driver));

        //Assertions.assertFalse(WebDriverChecker.isMobileBrowser(driver));
        //Assertions.assertFalse(WebDriverChecker.isMobileNative(driver));
        //Assertions.assertFalse(WebDriverChecker.isMobileVirtual(driver));

        //Assertions.assertFalse(WebDriverChecker.isLambdaTest(driver));
        //Assertions.assertFalse(WebDriverChecker.isBrowserStack(driver));
        //Assertions.assertFalse(WebDriverChecker.isSauceLabs(driver));
        //Assertions.assertFalse(WebDriverChecker.isTestingBot(driver));

        driver.quit();
        Assertions.assertFalse(WebDriverChecker.isAlive(driver));
    }
}
