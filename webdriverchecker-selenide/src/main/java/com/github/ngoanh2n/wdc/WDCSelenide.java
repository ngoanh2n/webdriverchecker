package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.WebDriverRunner;
import com.github.ngoanh2n.RuntimeError;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provides {@linkplain WebDriver} from {@linkplain WebDriverRunner} to {@linkplain WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class WDCSelenide implements WebDriverProvider {
    private static final Logger LOGGER = LoggerFactory.getLogger(WDCSelenide.class);

    //===============================================================================//

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver provide() {
        try {
            return WebDriverRunner.getWebDriver();
        } catch (IllegalStateException ignored) {
            String msg = "WebDriver is quit";
            LOGGER.error(msg);
            throw new RuntimeError(msg);
        }
    }
}
