package io.github.ngoanh2n.wdc;

import org.openqa.selenium.safari.SafariDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class SafariInstance extends InstanceChecker<Boolean> {

    private static final String NAME = "safari";

    @Override
    public Boolean check() {
        return getBrowserName().equals(NAME) || getDriver() instanceof SafariDriver;
    }
}
