package com.github.ngoanh2n.wdc;

import static com.github.ngoanh2n.wdc.WDCType.ANDROID;
import static com.github.ngoanh2n.wdc.WDCType.IOS;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class Platform {

    static class IOS extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(IOS.getName());
        }
    }

    static class Android extends WebDriverChecker {

        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals(ANDROID.getName());
        }
    }
}
