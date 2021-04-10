package io.github.ngoanh2n.wdc;

import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class ChromeDriverInstance extends DriverInstanceChecker<Boolean> {

    private static final String NAME = "chrome";

    @Override
    public Boolean check() {
        return getBrowserName().equals(NAME) || getDriver() instanceof ChromeDriver;
    }
}