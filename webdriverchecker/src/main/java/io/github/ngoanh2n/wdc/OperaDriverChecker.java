package io.github.ngoanh2n.wdc;

import org.openqa.selenium.opera.OperaDriver;

import static io.github.ngoanh2n.wdc.WDCType.OPERA;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class OperaDriverChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return getBrowserName().equals(OPERA.getName()) || getDriver() instanceof OperaDriver;
    }
}