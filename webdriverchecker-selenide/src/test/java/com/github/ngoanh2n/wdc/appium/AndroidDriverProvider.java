package com.github.ngoanh2n.wdc.appium;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;

public class AndroidDriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        AppiumDriverLocalService service = AbstractAppiumTest.startAppiumServer();
        Capabilities caps = AbstractAppiumTest.readCaps();
        return new AndroidDriver<>(service, caps);
    }
}
