package io.github.ngoanh2n.wdc;

import org.openqa.selenium.WebDriverException;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-17
 */
public class WDCException extends WebDriverException {

    public WDCException(String cause) {
        super(cause);
    }

    public final static class NoSuchWDServiceProvided extends WDCException {

        NoSuchWDServiceProvided() {
            super("No implementation of WebDriverService provided.");
        }
    }

    public final static class NullWDPassedByArgument extends WDCException {

        NullWDPassedByArgument() {
            super("The passed WebDriver by argument is null.");
        }
    }

    public final static class NoneWDPassedByArgument extends WDCException {

        NoneWDPassedByArgument() {
            super("The passed WebDriver by argument is not a implementation.");
        }
    }

    public final static class NoSuchCapabilitiesImplemented extends WDCException {

        NoSuchCapabilitiesImplemented() {
            super("No Capabilities of WebDriver implemented.");
        }
    }

    public final static class NoSuchWDSession extends WDCException {

        NoSuchWDSession() {
            super("WedDriver session is not created or closed");
        }
    }
}
