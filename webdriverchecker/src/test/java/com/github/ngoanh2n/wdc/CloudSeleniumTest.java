package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.junit5.RunOnProp;
import com.github.ngoanh2n.wdc.driver.CloudDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2022-08-20
 */
public class CloudSeleniumTest {
    private WebDriver wd;

    @BeforeEach
    void openDriver() {
        wd = CloudDriverProvider.createDriver();
    }

    @AfterEach
    void closeDriver() {
        //Assertions.assertFalse(WebDriverChecker.isMacOS(wd));
        //Assertions.assertFalse(WebDriverChecker.isLinux()wd);
        //Assertions.assertFalse(WebDriverChecker.isWindows(wd));
        Assertions.assertTrue(WebDriverChecker.isPC(wd));
        Assertions.assertFalse(WebDriverChecker.isIOS(wd));
        Assertions.assertFalse(WebDriverChecker.isAndroid(wd));
        Assertions.assertFalse(WebDriverChecker.isMobile(wd));

        Assertions.assertTrue(WebDriverChecker.isAlive(wd));
        Assertions.assertFalse(WebDriverChecker.isLocal(wd));
        Assertions.assertTrue(WebDriverChecker.isRemote(wd));
        Assertions.assertFalse(WebDriverChecker.isDocker(wd));
        Assertions.assertTrue(WebDriverChecker.isBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isNative(wd));

        //Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        //Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        //Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        //Assertions.assertFalse(WebDriverChecker.isEdge(wd));
        Assertions.assertFalse(WebDriverChecker.isOpera(wd));
        Assertions.assertFalse(WebDriverChecker.isIE(wd));
        Assertions.assertFalse(WebDriverChecker.isEdgeLegacy(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefoxLegacy(wd));

        Assertions.assertTrue(WebDriverChecker.isPCBrowser(wd));
        Assertions.assertFalse(WebDriverChecker.isPCNative(wd));

        Assertions.assertFalse(WebDriverChecker.isMacOSNative(wd));
        Assertions.assertFalse(WebDriverChecker.isWindowsNative(wd));

        Assertions.assertFalse(WebDriverChecker.isLocalServer(wd));
        Assertions.assertTrue(WebDriverChecker.isRemoteServer(wd));

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

        //Assertions.assertFalse(WebDriverChecker.isLambdaTest(wd));
        //Assertions.assertFalse(WebDriverChecker.isBrowserStack(wd));
        //Assertions.assertFalse(WebDriverChecker.isSauceLabs(wd));
        //Assertions.assertFalse(WebDriverChecker.isTestingBot(wd));

        wd.quit();
        Assertions.assertFalse(WebDriverChecker.isAlive(wd));
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "lambdatest")
    @RunOnProp(name = "wdc.caps", value = "cloud-lambdatest-windows-chrome.yml")
    void lambdaTest() {
        Assertions.assertFalse(WebDriverChecker.isMacOS(wd));
        Assertions.assertFalse(WebDriverChecker.isLinux(wd));
        Assertions.assertTrue(WebDriverChecker.isWindows(wd));

        Assertions.assertTrue(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));

        Assertions.assertTrue(WebDriverChecker.isLambdaTest(wd));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(wd));
        Assertions.assertFalse(WebDriverChecker.isSauceLabs(wd));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(wd));
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "browserstack")
    @RunOnProp(name = "wdc.caps", value = "cloud-browserstack-macos-safari.yml")
    void browserStack() {
        Assertions.assertTrue(WebDriverChecker.isMacOS(wd));
        Assertions.assertFalse(WebDriverChecker.isLinux(wd));
        Assertions.assertFalse(WebDriverChecker.isWindows(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertTrue(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(wd));
        Assertions.assertTrue(WebDriverChecker.isBrowserStack(wd));
        Assertions.assertFalse(WebDriverChecker.isSauceLabs(wd));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(wd));
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "saucelabs")
    @RunOnProp(name = "wdc.caps", value = "cloud-saucelabs-linux-firefox.yml")
    void sauceLabs() {
        Assertions.assertFalse(WebDriverChecker.isMacOS(wd));
        Assertions.assertTrue(WebDriverChecker.isLinux(wd));
        Assertions.assertFalse(WebDriverChecker.isWindows(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertTrue(WebDriverChecker.isFirefox(wd));
        Assertions.assertFalse(WebDriverChecker.isEdge(wd));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(wd));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(wd));
        Assertions.assertTrue(WebDriverChecker.isSauceLabs(wd));
        Assertions.assertFalse(WebDriverChecker.isTestingBot(wd));
    }

    @Test
    @RunOnProp(name = "wdc.target", value = "testingbot")
    @RunOnProp(name = "wdc.caps", value = "cloud-testingbot-windows-edge.yml")
    void testingBot() {
        Assertions.assertFalse(WebDriverChecker.isMacOS(wd));
        Assertions.assertFalse(WebDriverChecker.isLinux(wd));
        Assertions.assertTrue(WebDriverChecker.isWindows(wd));

        Assertions.assertFalse(WebDriverChecker.isChrome(wd));
        Assertions.assertFalse(WebDriverChecker.isSafari(wd));
        Assertions.assertFalse(WebDriverChecker.isFirefox(wd));
        Assertions.assertTrue(WebDriverChecker.isEdge(wd));

        Assertions.assertFalse(WebDriverChecker.isLambdaTest(wd));
        Assertions.assertFalse(WebDriverChecker.isBrowserStack(wd));
        Assertions.assertFalse(WebDriverChecker.isSauceLabs(wd));
        Assertions.assertTrue(WebDriverChecker.isTestingBot(wd));
    }
}
