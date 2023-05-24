package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.WebDriverTestNG;
import org.openqa.selenium.WebDriver;

/**
 * Provides {@link WebDriver} from current test to {@link WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class WDCTestNG extends WebDriverTestNG implements WebDriverProvider {
    /**
     * Default constructor.
     */
    public WDCTestNG() { /* No implementation necessary */ }

    //-------------------------------------------------------------------------------//

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver provide() {
        if (iTestResult != null) {
            lookupDriver(iTestResult, BO);
        }
        return driver;
    }
}
