package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.WebDriverProvider;
import com.github.ngoanh2n.YamlData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Map;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@ParametersAreNonnullByDefault
public class AppiumDriverProvider implements WebDriverProvider {
    private static final Logger logger = LoggerFactory.getLogger(AppiumDriverProvider.class);

    @Nonnull
    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        AppiumDriverLocalService service = startAppiumServer();
        Capabilities caps = readAppiumCapabilities();

        if (caps.getCapability("platformName").equals("iOS")) {
            return new IOSDriver<>(service, caps);
        } else {
            return new AndroidDriver<>(service, caps);
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
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload");
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
            if (service.isRunning()) {
                service.stop();
                logger.debug("Stopping Appium Server");
            }
        }
    }
}
