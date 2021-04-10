package io.github.ngoanh2n.wdc;

import org.openqa.selenium.safari.SafariDriver;

import static io.github.ngoanh2n.wdc.WDCType.SAFARI;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class SafariDriverChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return driverName().equals(SAFARI.driverName()) || driver() instanceof SafariDriver;
    }
}
