package io.github.ngoanh2n.wdc;

import org.openqa.selenium.edge.EdgeDriver;

import static io.github.ngoanh2n.wdc.WDCType.EDGE_LEGACY;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-14
 */
class EdgeLegacyChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return getBrowserName().equals(EDGE_LEGACY.getName()) || getDriver() instanceof EdgeDriver;
    }
}