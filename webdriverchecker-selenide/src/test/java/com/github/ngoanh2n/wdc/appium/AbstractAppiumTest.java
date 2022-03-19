package com.github.ngoanh2n.wdc.appium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.ngoanh2n.YamlData;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public abstract class AbstractAppiumTest {

    private static final Logger logger = LoggerFactory.getLogger(AbstractAppiumTest.class);

    @BeforeAll
    static void setup() {
        Configuration.timeout = 10 * 1000;
        Configuration.pollingInterval = 500;
        Configuration.browser = AndroidDriverProvider.class.getName();
        Configuration.browserSize = null;
        Selenide.open();
    }

    public static Capabilities readCaps() {
        Map<String, Object> map = YamlData.toMap("android-emulator.yml");
        DesiredCapabilities caps = new DesiredCapabilities();
        map.forEach(caps::setCapability);
        logger.debug("Reading Capabilities");
        return caps;
    }

    public static AppiumDriverLocalService startAppiumServer() {
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
