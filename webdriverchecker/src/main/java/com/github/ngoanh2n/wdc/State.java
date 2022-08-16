package com.github.ngoanh2n.wdc;

import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

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

    static class Remote extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            RemoteWebDriver wd = getRemoteWD(args);
            CommandExecutor cmd = wd.getCommandExecutor();

            if (cmd instanceof HttpCommandExecutor) {
                return !(cmd instanceof DriverCommandExecutor);
            }
            return false;
        }
    }

    static class App extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return hasCapability(APP, args)
                    || (hasCapability(APP_PACKAGE, args)
                    && hasCapability(APP_ACTIVITY, args));
        }
    }

    static class Browser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return !getBrowserName(args).isEmpty();
        }
    }
}
