package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.WebDriverJUnit5;
import org.openqa.selenium.WebDriver;

/**
 * Provide {@link WebDriver} from the current JUnit5 test to {@link WebDriverChecker}.<br><br>
 *
 * <em>Repository:</em>
 * <ul>
 *     <li><em>GitHub: <a href="https://github.com/ngoanh2n/webdriverchecker">ngoanh2n/webdriverchecker</a></em></li>
 *     <li><em>Maven: <a href="https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker-junit5">com.github.ngoanh2n:webdriverchecker-junit5</a></em></li>
 * </ul>
 *
 * @author ngoanh2n
 * @since 2020
 */
public class WDCJUnit5 extends WebDriverJUnit5 implements WebDriverProvider {
    /**
     * Default constructor.
     */
    public WDCJUnit5() { /**/ }

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
