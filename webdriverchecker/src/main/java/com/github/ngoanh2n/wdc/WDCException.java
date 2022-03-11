package com.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-17
 */
public class WDCException extends WebDriverException {

    public WDCException(String message) {
        super(message);
    }

    public static class NoSuchServiceWD extends WDCException {

        public NoSuchServiceWD() {
            super(String.format("No implementation of %s.", WebDriverService.class.getName()));
        }
    }

    public static class NoSuchArgumentWD extends WDCException {

        public NoSuchArgumentWD() {
            super(String.format("No %s by argument", WebDriver.class.getSimpleName()));
        }
    }

    public static class NullArgumentWD extends WDCException {

        public NullArgumentWD() {
            super(String.format("%s passed by argument is null.", WebDriver.class.getSimpleName()));
        }
    }

    public static class NoneArgumentWD extends WDCException {

        public NoneArgumentWD() {
            super(String.format("%s passed by argument is not a implementation.", WebDriver.class.getSimpleName()));
        }
    }

    public static class NoSuchCapabilities extends WDCException {

        public NoSuchCapabilities() {
            super(String.format("%s is not implemented %s.", WebDriver.class.getSimpleName(), Capabilities.class.getSimpleName()));

        }
    }

    public static class NoSuchWDSession extends WDCException {

        public NoSuchWDSession() {
            super(String.format("%s session is not created or closed.", WebDriver.class.getSimpleName()));
        }
    }
}
