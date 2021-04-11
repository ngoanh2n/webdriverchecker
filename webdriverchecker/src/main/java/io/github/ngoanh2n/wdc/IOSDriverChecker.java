package io.github.ngoanh2n.wdc;

import io.appium.java_client.ios.IOSDriver;

import static io.github.ngoanh2n.wdc.WDCType.MOBILE_IOS;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-11
 */
class IOSDriverChecker extends WebDriverChecker {

    @Override
    protected String getBrowserName() {
        return getCapability("platformName").toLowerCase();
    }

    @Override
    public boolean check() {
        return getBrowserName().equals(MOBILE_IOS.getName()) || getDriver() instanceof IOSDriver;
    }
}