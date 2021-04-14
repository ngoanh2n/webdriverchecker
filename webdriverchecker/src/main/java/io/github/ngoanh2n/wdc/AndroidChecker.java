package io.github.ngoanh2n.wdc;

import io.appium.java_client.android.AndroidDriver;

import static io.github.ngoanh2n.wdc.WDCType.ANDROID;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-11
 */
class AndroidChecker extends WebDriverChecker {

    @Override
    protected String getBrowserName() {
        return getCapability("platformName");
    }

    @Override
    public boolean check() {
        return getBrowserName().equals(ANDROID.getName()) || getDriver() instanceof AndroidDriver;
    }
}