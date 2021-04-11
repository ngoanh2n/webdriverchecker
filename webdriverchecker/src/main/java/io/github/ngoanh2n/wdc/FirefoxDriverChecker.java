package io.github.ngoanh2n.wdc;

import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.ngoanh2n.wdc.WDCType.FIREFOX;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class FirefoxDriverChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return getBrowserName().equals(FIREFOX.getName()) || getDriver() instanceof FirefoxDriver;
    }
}
