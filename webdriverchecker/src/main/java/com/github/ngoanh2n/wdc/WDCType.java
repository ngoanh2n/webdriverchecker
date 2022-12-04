package com.github.ngoanh2n.wdc;

import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

import static com.github.ngoanh2n.wdc.WDCEx.NoSuchWebDriverSession;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class WDCType {
    static class MacOS extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("mac");
        }
    }

    static class Linux extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("linux");
        }
    }

    static class Windows extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("windows");
        }
    }

    static class PC extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new MacOS(), args) || is(new Linux(), args) || is(new Windows(), args);
        }
    }

    static class IOS extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("ios");
        }
    }

    static class Android extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("android");
        }
    }

    static class Mobile extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) || is(new Android(), args);
        }
    }

    // ------------------------------------------------

    static class Alive extends WebDriverChecker {
        private final boolean directed;

        Alive() {
            this(false);
        }

        Alive(boolean directed) {
            this.directed = directed;
        }

        @Override
        protected boolean check(Object... args) {
            try {
                return getWD(args).getSessionId() != null;
            } catch (NoSuchWebDriverSession exception) {
                if (directed) {
                    return false;
                }
                throw exception;
            }
        }
    }

    static class Remote extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            CommandExecutor ce = getWD(args).getCommandExecutor();
            return !(ce instanceof DriverCommandExecutor);
        }
    }

    static class Browser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return !getBrowserName(args).isEmpty();
        }
    }

    static class Native extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            if (!getApp(args).isEmpty()) {
                return true;
            }
            if (!getAppPackage(args).isEmpty()) {
                if (is(new Android(), args)) {
                    return !getAppPackage(args).equals("com.android.chrome");
                }
                return true;
            }
            return false;
        }
    }

    // ------------------------------------------------

    static class Chrome extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("chrome");
        }
    }

    static class Safari extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("safari");
        }
    }

    static class Firefox extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("firefox");
        }
    }

    static class Edge extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("msedge");
        }
    }

    static class Opera extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("opera");
        }
    }

    static class IE extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("internetexplorer");
        }
    }

    static class LegacyEdge extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("microsoftedge");
        }
    }

    static class LegacyFirefox extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserVersion(args) < 48 && is(new Firefox(), args);
        }
    }

    // ------------------------------------------------

    static class PCBrowser extends WebDriverChecker {
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

    // ------------------------------------------------

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

    // ------------------------------------------------

    static class IOSBrowser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Browser(), args);
        }
    }

    static class IOSNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------------------

    static class AndroidBrowser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Browser(), args);
        }
    }

    static class AndroidNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------------------

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
}
