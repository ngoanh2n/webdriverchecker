package io.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class WebDriverChecker {

    private Capabilities getCapabilities() {
        WebDriver driver = InstanceProviderLoader.load().provide();
        return ((RemoteWebDriver) driver).getCapabilities();
    }
}
