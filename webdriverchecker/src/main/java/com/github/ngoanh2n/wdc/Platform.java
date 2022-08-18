package com.github.ngoanh2n.wdc;

import static com.github.ngoanh2n.wdc.WDCConstant.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class Platform {
    static class Mac extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(MAC);
        }
    }

    static class Linux extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(LINUX);
        }
    }

    static class Windows extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(WINDOWS);
        }
    }

    static class IOS extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(IOS);
        }
    }

    static class Android extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(ANDROID);
        }
    }
}
