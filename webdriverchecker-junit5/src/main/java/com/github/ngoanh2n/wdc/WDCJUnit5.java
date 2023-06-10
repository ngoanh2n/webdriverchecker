package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.WebDriverJUnit5;
import org.openqa.selenium.WebDriver;

/**
 * Provide {@link WebDriver} from the current JUnit5 test to {@link WebDriverChecker}.
 *
 * @author ngoanh2n
 */
public class WDCJUnit5 extends WebDriverJUnit5 implements WebDriverProvider {
    /**
     * Default constructor.
     */
    public WDCJUnit5() { /* No implementation necessary */ }

    //-------------------------------------------------------------------------------//

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver provide() {
        if (invocationContext != null) {
            lookupDriver(invocationContext, BO);
        }
        return driver;
    }
}
