package com.github.ngoanh2n.wdc.driver;

import com.github.ngoanh2n.Property;
import com.github.ngoanh2n.RuntimeError;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

/**
 * @author ngoanh2n
 */
public abstract class SeleniumDriverProvider {
    public static WebDriver createDriver() {
        String browser = Property.ofString("wdc.browser").getValue();

        switch (browser) {
            case "chrome":
                return WebDriverManager.chromedriver().create();
            case "safari":
                return WebDriverManager.safaridriver().create();
            case "firefox":
                return WebDriverManager.firefoxdriver().create();
            case "edge":
                return WebDriverManager.edgedriver().create();
            case "opera":
                return WebDriverManager.operadriver().create();
            case "ie":
                return WebDriverManager.iedriver().create();
            default:
                throw new RuntimeError("Unknown browser: " + browser);
        }
    }
}
