package com.github.ngoanh2n.wdc;

import static com.github.ngoanh2n.wdc.Platform.Android;
import static com.github.ngoanh2n.wdc.WDCConstant.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class State {
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
                return getRemoteWD(args).getSessionId() != null;
            } catch (WDCException.NoSuchWDSession exception) {
                if (directed) return false;
                throw exception;
            }
        }
    }

    static class Native extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            if (isValidCapability(APP, args)) {
                return true;
            }
            if (isValidCapability(APP_PACKAGE, args)) {
                if (is(new Android())) {
                    return !getAppPackage(args).equals(PKG_CHROME);
                }
                return true;
            }
            return false;
        }
    }

    static class Browser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return isValidCapability(BROWSER_NAME, args);
        }
    }
}
