package com.github.ngoanh2n.wdc.driver;

import com.github.ngoanh2n.Prop;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2022-08-20
 */
public class CloudDriverProvider {
    public static Prop<String> key = new Prop<>("wdc.key", String.class);
    public static Prop<String> token = new Prop<>("wdc.token", String.class);
    public static Prop<String> domain = new Prop<>("wdc.domain", String.class);

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
            throw new RuntimeException(e);
        }
    }
}
