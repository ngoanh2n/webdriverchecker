package io.github.ngoanh2n.wdc;

import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

import static io.github.ngoanh2n.wdc.WDCType.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class Selenium {

    static class Browser extends WebDriverChecker {

        @Override
        protected boolean check(Object[] args) {
            return !getBrowserName(args).isEmpty();
        }
    }

    static class Alive extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getRemoteWD(args).getSessionId() != null;
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

    // ------------------------------------

    static class IE extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(IE.getName());
        }
    }

    static class Edge extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(EDGE.getName());
        }
    }

    static class Opera extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(OPERA.getName());
        }
    }

    static class Safari extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(SAFARI.getName());
        }
    }

    static class Chrome extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(CHROME.getName());
        }
    }

    static class Firefox extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(FIREFOX.getName());
        }
    }

    // ------------------------------------

    static class LegacyEdge extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(EDGE_LEGACY.getName());
        }
    }

    static class LegacyFirefox extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getBrowserVersion(args) < 48 && whether(new Firefox(), args);
        }
    }
}
