package io.github.ngoanh2n.wdc;

import io.appium.java_client.ios.IOSDriver;

import static io.github.ngoanh2n.wdc.WDCType.IOS;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-11
 */
class IOSChecker extends WebDriverChecker {

    @Override
    protected String getBrowserName() {
        return getCapability("platformName");
    }

    @Override
    public boolean check() {
        return getBrowserName().equals(IOS.getName()) || getDriver() instanceof IOSDriver;
    }
}