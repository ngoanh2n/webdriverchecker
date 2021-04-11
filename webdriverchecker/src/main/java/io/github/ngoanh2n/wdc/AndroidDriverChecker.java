package io.github.ngoanh2n.wdc;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;

import static io.github.ngoanh2n.wdc.WDCType.MOBILE_ANDROID;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-11
 */
class AndroidDriverChecker extends WebDriverChecker {

    @Override
    protected String driverName() {
        Capabilities caps = capabilities();
        return caps.getCapability("platformName").toString().toLowerCase();
    }

    @Override
    public boolean check() {
        return driverName().equals(MOBILE_ANDROID.driverName()) || driver() instanceof AndroidDriver;
    }
}