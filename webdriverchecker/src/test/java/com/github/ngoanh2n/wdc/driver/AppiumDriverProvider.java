package com.github.ngoanh2n.wdc.driver;

import com.github.ngoanh2n.Prop;
import com.github.ngoanh2n.YamlData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class AppiumDriverProvider {
    private static final Logger log = LoggerFactory.getLogger(AppiumDriverProvider.class);
    public static Prop<String> caps = new Prop<>("wdc.caps", String.class);

    public static WebDriver createDriver() {
        AppiumDriverLocalService localService = startAppiumServer();
        Capabilities caps = readCaps();
        return new AppiumDriver(localService, caps);
    }

    public static Capabilities readCaps() {
        DesiredCapabilities caps = new DesiredCapabilities();
        Map<String, Object> providedCaps = YamlData.toMapFromResource(AppiumDriverProvider.caps.getValue());
        providedCaps.forEach(caps::setCapability);

        System.getProperties().forEach((key, value) -> {
            if (String.valueOf(key).startsWith("appium:")) {
                caps.setCapability(String.valueOf(key), String.valueOf(value));
            }
        });
        return caps;
    }

    private static AppiumDriverLocalService startAppiumServer() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/")
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload");
        AppiumDriverLocalService localService = AppiumDriverLocalService.buildService(serviceBuilder);
        Runtime.getRuntime().addShutdownHook(new StopAppiumServerThread(localService));

        if (!localService.isRunning()) {
            localService.start();
            log.debug("Starting Appium server");
        }
        return localService;
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
                log.debug("Stopping Appium server");
            }
        }
    }
}
