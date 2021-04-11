package io.github.ngoanh2n.wdc;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;

import static io.github.ngoanh2n.wdc.WDCType.MOBILE_IOS;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-11
 */
class IOSDriverChecker extends WebDriverChecker {

    @Override
    protected String browserName() {
        Capabilities caps = capabilities();
        return caps.getCapability("platformName").toString().toLowerCase();
    }

    @Override
    public boolean check() {
        return browserName().equals(MOBILE_IOS.browserName()) || driver() instanceof IOSDriver;
    }
}