package com.github.ngoanh2n.wdc;

import static com.github.ngoanh2n.wdc.Browser.Chrome;
import static com.github.ngoanh2n.wdc.Browser.Safari;
import static com.github.ngoanh2n.wdc.Platform.*;
import static com.github.ngoanh2n.wdc.State.Browser;
import static com.github.ngoanh2n.wdc.State.Native;

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

    static class IOSSafari extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Safari(), args);
        }
    }

    static class IOSNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------

    static class AndroidWeb extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Browser(), args);
        }
    }

    static class AndroidChrome extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Chrome(), args);
        }
    }

    static class AndroidNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------

    static class Mobile extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) || is(new Android(), args);
        }
    }

    static class MobileWeb extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Mobile(), args) && is(new Browser(), args);
        }
    }

    static class MobileNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Mobile(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------

    static class MacOSNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new MacOS(), args) && is(new Native(), args);
        }
    }

    static class WindowsNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Windows(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------

    static class PC extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new MacOS(), args) || is(new Linux(), args) || is(new Windows(), args);
        }
    }

    static class PCWeb extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new PC(), args) && is(new Browser(), args);
        }
    }

    static class PCNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new PC(), args) && is(new Native(), args);
        }
    }
}
