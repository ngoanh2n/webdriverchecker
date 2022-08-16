package com.github.ngoanh2n.wdc;

import static com.github.ngoanh2n.wdc.Browser.Chrome;
import static com.github.ngoanh2n.wdc.Browser.Safari;
import static com.github.ngoanh2n.wdc.Platform.*;
import static com.github.ngoanh2n.wdc.State.App;
import static com.github.ngoanh2n.wdc.State.Browser;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class Combine {
    static class IOSWeb extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Browser(), args);
        }
    }

    static class IOSApp extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new App(), args);
        }
    }

    static class IOSSafari extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Safari(), args);
        }
    }

    // ------------------------------------

    static class AndroidWeb extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Browser(), args);
        }
    }

    static class AndroidApp extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new App(), args);
        }
    }

    static class AndroidChrome extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Chrome(), args);
        }
    }

    // ------------------------------------

    static class Mobile extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) || is(new Android(), args);
        }
    }

    static class MobileApp extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Mobile(), args) && is(new App(), args);
        }
    }

    static class MobileWeb extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Mobile(), args) && is(new Browser(), args);
        }
    }

    // ------------------------------------

    static class WindowsApp extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Windows()) && is(new App());
        }
    }
}
