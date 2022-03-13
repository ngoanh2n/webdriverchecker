package com.github.ngoanh2n.wdc;

import static com.github.ngoanh2n.wdc.Browser.*;
import static com.github.ngoanh2n.wdc.WDCType.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class Appium {

    static class App extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return !getCapability("app", args).isEmpty();
        }
    }

    // ------------------------------------

    static class IOS extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(IOS.getName());
        }
    }

    static class IOSApp extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            if (whether(new IOS(), args)) {
                return whether(new App(), args) || !whether(new HasBrowserName(), args);
            }
            return false;
        }
    }

    static class IOSSafari extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return whether(new IOS(), args) && whether(new Safari(), args);
        }
    }

    // ------------------------------------

    static class Android extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(ANDROID.getName());
        }
    }

    static class AndroidApp extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            if (whether(new Android(), args)) {
                return whether(new App(), args) || !whether(new HasBrowserName(), args);
            }
            return false;
        }
    }

    static class AndroidChrome extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return whether(new Android(), args) && whether(new Chrome(), args);
        }
    }

    // ------------------------------------

    static class Mobile extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return whether(new IOS(), args) || whether(new Android(), args);
        }
    }

    static class MobileApp extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return whether(new IOSApp(), args) || whether(new AndroidApp(), args);
        }
    }

    static class MobileBrowser extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return whether(new IOSSafari(), args) || whether(new AndroidChrome(), args);
        }
    }

    // ------------------------------------

    static class WindowsApp extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return !whether(new HasBrowserName(), args) && getPlatformName(args).equals(WINDOWS.getName());
        }
    }
}
