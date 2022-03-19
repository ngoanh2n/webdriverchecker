package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.YamlData;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public abstract class AbstractAppiumTest {

    private static final Logger logger = LoggerFactory.getLogger(AbstractAppiumTest.class);

    public static Capabilities readCaps() {
        Map<String, Object> map = YamlData.toMap("android-emulator.yml");
        DesiredCapabilities caps = new DesiredCapabilities();
        map.forEach(caps::setCapability);
        logger.debug("Reading Capabilities");
        return caps;
    }

    private final static class StopAppiumServerThread extends Thread {

        private final AppiumDriverLocalService
    }
}
