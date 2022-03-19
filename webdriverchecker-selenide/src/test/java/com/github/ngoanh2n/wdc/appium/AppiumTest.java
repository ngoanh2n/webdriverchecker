package com.github.ngoanh2n.wdc.appium;

import com.github.ngoanh2n.wdc.WebDriverChecker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class AppiumTest extends AbstractAppiumTest {

    @Test
    void androidApp() {
        assertFalse(WebDriverChecker.isIE());
        assertFalse(WebDriverChecker.isEdge());
        assertFalse(WebDriverChecker.isOpera());
        assertFalse(WebDriverChecker.isChrome());
        assertFalse(WebDriverChecker.isSafari());
        assertFalse(WebDriverChecker.isFirefox());

        assertFalse(WebDriverChecker.isIOS());
        assertFalse(WebDriverChecker.isIOSApp());
        assertFalse(WebDriverChecker.isIOSWeb());
        assertFalse(WebDriverChecker.isIOSSafari());

        assertTrue(WebDriverChecker.isAndroid());
        assertTrue(WebDriverChecker.isAndroidApp());
        assertFalse(WebDriverChecker.isAndroidWeb());
        assertFalse(WebDriverChecker.isAndroidChrome());

        assertTrue(WebDriverChecker.isMobile());
        assertTrue(WebDriverChecker.isMobileApp());
        assertFalse(WebDriverChecker.isMobileWeb());

        assertFalse(WebDriverChecker.isWindowsApp());
        assertFalse(WebDriverChecker.isEdgeLegacy());
        assertFalse(WebDriverChecker.isFirefoxLegacy());
    }
}
