package com.github.ngoanh2n.wdc.driver;

import com.github.ngoanh2n.Property;
import com.github.ngoanh2n.wdc.CheckerException;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author ngoanh2n
 */
public class CloudDriverProvider {
    public static Property<String> key = Property.ofString("wdc.key");
    public static Property<String> token = Property.ofString("wdc.token");
    public static Property<String> domain = Property.ofString("wdc.domain");

    public static WebDriver createDriver() {
        URL address = createRemoteAddress();
        Capabilities caps = AppiumDriverProvider.readCaps();
        return new RemoteWebDriver(address, caps);
    }

    private static URL createRemoteAddress() {
        String address = "https://" + key.getValue() + ":" + token.getValue() + "@" + domain.getValue();
        try {
            return new URL(address);
        } catch (MalformedURLException e) {
            throw new CheckerException(e);
        }
    }
}
