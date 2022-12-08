package com.github.ngoanh2n.wdc.driver;

import com.github.ngoanh2n.Prop;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2022-08-20
 */
public class CloudDriverProvider extends AppiumDriverProvider {
    public static Prop<String> key = new Prop<>("wdc.key", String.class);
    public static Prop<String> token = new Prop<>("wdc.token", String.class);
    public static Prop<String> domain = new Prop<>("wdc.domain", String.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        Capabilities caps = readCaps();
        URL address = createRemoteAddress();
        return new RemoteWebDriver(address, caps);
    }

    private URL createRemoteAddress() {
        String address = "https://" + key.getValue() + ":" + token.getValue() + "@" + domain.getValue();
        try {
            return new URL(address);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
