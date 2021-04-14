package io.github.ngoanh2n.wdc;

import org.openqa.selenium.edge.EdgeDriver;

import static io.github.ngoanh2n.wdc.WDCType.EDGE;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class EdgeChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return getBrowserName().equals(EDGE.getName()) || getDriver() instanceof EdgeDriver;
    }
}