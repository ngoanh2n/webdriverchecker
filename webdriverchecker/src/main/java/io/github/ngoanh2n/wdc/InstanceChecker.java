package io.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
abstract class InstanceChecker<T> {

    protected abstract T check();

    protected String getBrowserName() {
        Capabilities caps = getCapabilities();
        return caps.getBrowserName().toLowerCase();
    }

    protected Capabilities getCapabilities() {
        return getRemoteDriver().getCapabilities();
    }

    protected RemoteWebDriver getRemoteDriver() {
        WebDriver driver = getDriver();
        return ((RemoteWebDriver) driver);
    }

    protected WebDriver getDriver() {
        return load().provide();
    }

    private static synchronized InstanceProvider load() {
        ServiceLoader<InstanceProvider> service = ServiceLoader.load(InstanceProvider.class);
        Iterator<InstanceProvider> serviceLoaders = service.iterator();

        if (serviceLoaders.hasNext()) {
            return serviceLoaders.next();
        } else {
            throw new IllegalStateException("No implementation of InstanceProvider provided");
        }
    }
}
