package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.WebDriverProvider;
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
        AppiumDriverLocalService localService = startAppiumServer();
        Capabilities caps = readAppiumCapabilities();
        return new AppiumDriver(localService, caps);
    }

    private static Capabilities readAppiumCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        Prop<String> capsProp = new Prop<>("ngoanh2n.caps", String.class);
        Map<String, Object> capsMap = YamlData.toMapFromResource(capsProp.getValue());
        capsMap.forEach(caps::setCapability);
        logger.debug("Reading capabilities");
        return caps;
    }

    private static AppiumDriverLocalService startAppiumServer() {
        AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
                .withArgument(() -> "--allow-insecure", "chromedriver_autodownload");
        AppiumDriverLocalService localService = AppiumDriverLocalService.buildService(serviceBuilder);
        Runtime.getRuntime().addShutdownHook(new StopAppiumServerThread(localService));

        if (!localService.isRunning()) {
            localService.start();
            logger.debug("Starting Appium server");
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
                logger.debug("Stopping Appium server");
            }
        }
    }
}
