package com.github.ngoanh2n.wdc;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Provide {@link WebDriver} from {@link WebDriverRunner} to {@link WebDriverChecker}.<br><br>
 *
 * <em>Repository:</em>
 * <ul>
 *     <li><em>GitHub: <a href="https://github.com/ngoanh2n/webdriverchecker">ngoanh2n/webdriverchecker</a></em></li>
 *     <li><em>Maven: <a href="https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker-selenide">com.github.ngoanh2n:webdriverchecker-selenide</a></em></li>
 * </ul>
 *
 * @author ngoanh2n
 * @since 2020
 */
public class WDCSelenide implements WebDriverProvider {
    private static final Logger log = LoggerFactory.getLogger(WDCSelenide.class);

    /**
     * Default constructor.
     */
    public WDCSelenide() { /**/ }

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
