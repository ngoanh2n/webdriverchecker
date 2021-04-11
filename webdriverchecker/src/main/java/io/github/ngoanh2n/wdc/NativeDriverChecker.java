package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-11
 */
class NativeDriverChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return !getCapability("app").isEmpty();
    }
}