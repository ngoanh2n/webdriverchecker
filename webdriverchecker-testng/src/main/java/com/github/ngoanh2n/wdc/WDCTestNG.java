package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.WebDriverTestNG;
import org.openqa.selenium.WebDriver;

/**
 * Provide {@link WebDriver} from the current TestNG test to {@link WebDriverChecker}.<br><br>
 *
 * <em>Repository:</em>
 * <ul>
 *     <li><em>GitHub: <a href="https://github.com/ngoanh2n/webdriverchecker">ngoanh2n/webdriverchecker</a></em></li>
 *     <li><em>Maven: <a href="https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker-testng">com.github.ngoanh2n:webdriverchecker-testng</a></em></li>
 * </ul>
 *
 * @author ngoanh2n
 * @since 2020
 */
public class WDCTestNG extends WebDriverTestNG implements WebDriverProvider {
    /**
     * Default constructor.
     */
    public WDCTestNG() { /**/ }

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
