package io.github.ngoanh2n.wdc;

import org.openqa.selenium.opera.OperaDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class OperaDriverInstance extends DriverInstanceChecker<Boolean> {

    private static final String NAME = "opera";

    @Override
    public Boolean check() {
        return getBrowserName().equals(NAME) || getDriver() instanceof OperaDriver;
    }
}