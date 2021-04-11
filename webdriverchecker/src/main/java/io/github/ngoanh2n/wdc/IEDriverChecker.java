package io.github.ngoanh2n.wdc;

import org.openqa.selenium.ie.InternetExplorerDriver;

import static io.github.ngoanh2n.wdc.WDCType.IE;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class IEDriverChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return browserName().equals(IE.browserName()) || driver() instanceof InternetExplorerDriver;
    }
}