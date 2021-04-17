package io.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
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
            super(String.format("No implementation of %s provided.", WebDriverService.class.getName()));
        }
    }

    public final static class NullWDPassedByArgument extends WDCException {

        NullWDPassedByArgument() {
            super(String.format("The passed %s by argument is null.", WebDriver.class.getSimpleName()));
        }
    }

    public final static class NoneWDPassedByArgument extends WDCException {

        NoneWDPassedByArgument() {
            super(String.format("The passed %s by argument is not a implementation.", WebDriver.class.getSimpleName()));
        }
    }

    public final static class NoSuchCapabilitiesImplemented extends WDCException {

        NoSuchCapabilitiesImplemented() {
            super(String.format("No %s of %s implemented.", Capabilities.class.getSimpleName(), WebDriver.class.getSimpleName()));

        }
    }

    public final static class NoSuchWDSession extends WDCException {

        NoSuchWDSession() {
            super(String.format("%s session is not created or closed.", WebDriver.class.getSimpleName()));
        }
    }
}
