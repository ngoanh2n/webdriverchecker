package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provide {@link WebDriver} from {@link WebDriverRunner} to {@link WebDriverChecker}.
 *
 * @author ngoanh2n
 */
public class WDCSelenide implements WebDriverProvider {
    private static final Logger log = LoggerFactory.getLogger(WDCSelenide.class);

    /**
     * Default constructor.
     */
    public WDCSelenide() { /* No implementation necessary */ }

    //-------------------------------------------------------------------------------//

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver provide() {
        try {
            return WebDriverRunner.getWebDriver();
        } catch (IllegalStateException ignored) {
            String msg = "WebDriver is quit";
            log.error(msg);
            throw new CheckerException(msg);
        }
    }
}
