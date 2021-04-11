package io.github.ngoanh2n.wdc;

import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.ngoanh2n.wdc.WDCType.CHROME;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class ChromeDriverChecker extends WebDriverChecker {

    @Override
    public boolean check() {
        return getBrowserName().equals(CHROME.getName()) || getDriver() instanceof ChromeDriver;
    }
}