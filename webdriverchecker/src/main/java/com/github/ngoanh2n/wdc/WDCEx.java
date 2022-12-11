package com.github.ngoanh2n.wdc;

import org.openqa.selenium.WebDriverException;

/**
 * Exceptions will be thrown from {@linkplain WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-17
 */
public class WDCEx extends WebDriverException {
    public WDCEx(String message) {
        super(message);
    }

    public static class NoSuchCapabilities extends WDCEx {
        public NoSuchCapabilities() {
            super("WebDriver is not implemented HasCapabilities.");

        }
    }

    public static class NoSuchServiceWebDriver extends WDCEx {
        public NoSuchServiceWebDriver() {
            super("No implementation of WebDriverService.");
        }
    }

    public static class NullArgumentWebDriver extends WDCEx {
        public NullArgumentWebDriver() {
            super("Null WebDriver provided by argument.");
        }
    }

    public static class NoneArgumentWebDriver extends WDCEx {
        public NoneArgumentWebDriver() {
            super("None WebDriver implementation provided by argument.");
        }
    }

    public static class NoSuchWebDriverSession extends WDCEx {
        public NoSuchWebDriverSession() {
            super("WebDriver session is not created or closed.");
        }
    }
}
