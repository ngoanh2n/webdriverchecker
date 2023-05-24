package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.WebDriverJUnit5;
import org.openqa.selenium.WebDriver;

/**
 * Provides {@link WebDriver} from current test to {@link WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
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
