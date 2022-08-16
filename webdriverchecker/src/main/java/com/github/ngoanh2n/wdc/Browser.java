package com.github.ngoanh2n.wdc;

import static com.github.ngoanh2n.wdc.WDCConstant.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class Browser {
    static class IE extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(IE);
        }
    }

    static class Edge extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(EDGE);
        }
    }

    static class Opera extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(OPERA);
        }
    }

    static class Safari extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(SAFARI);
        }
    }

    static class Chrome extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(CHROME);
        }
    }

    static class Firefox extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(FIREFOX);
        }
    }

    // ------------------------------------

    static class LegacyEdge extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals(EDGE_LEGACY);
        }
    }

    static class LegacyFirefox extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserVersion(args) < 48 && is(new Firefox(), args);
        }
    }
}
