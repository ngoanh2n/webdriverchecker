package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.WebDriverProvider;
import com.github.ngoanh2n.YamlData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.util.Map;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class AppiumDriverProvider implements WebDriverProvider {

    private static final Logger logger = LoggerFactory.getLogger(AppiumDriverProvider.class);

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        AppiumDriverLocalService service = startAppiumServer();
        Capabilities capabilities = readAppiumCapabilities();

        if (capabilities.getCapability("platformName").equals("iOS")) {
            return new IOSDriver<>(service, capabilities);
        } else {
            return new AndroidDriver<>(service, capabilities);
        }
    }

    private static Capabilities readAppiumCapabilities() {
        String capsFileName = System.getProperty("appium.capabilities");
        Map<String, Object> map = YamlData.toMapFromResource(capsFileName);
        DesiredCapabilities caps = new DesiredCapabilities();
        map.forEach(caps::setCapability);
        logger.debug("Reading Capabilities");
        return caps;
    }

    private static AppiumDriverLocalService startAppiumServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4724);
        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        Runtime.getRuntime().addShutdownHook(new StopAppiumServerThread(service));

        if (!service.isRunning()) {
            service.start();
            logger.debug("Starting Appium Server");
        }
        return service;
    }

    private final static class StopAppiumServerThread extends Thread {

        private final AppiumDriverLocalService service;

        private StopAppiumServerThread(AppiumDriverLocalService service) {
            this.service = service;
        }

        @Override
        public void run() {
            if (service != null && service.isRunning()) {
                service.stop();
                logger.debug("Stopping Appium Server");
            }
        }
    }
}
