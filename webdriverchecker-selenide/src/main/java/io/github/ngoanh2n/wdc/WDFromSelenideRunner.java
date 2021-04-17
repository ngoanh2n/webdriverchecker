package io.github.ngoanh2n.wdc;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class WDFromSelenideRunner implements WebDriverService {

    @Override
    public WebDriver serve() {
        try {
            return WebDriverRunner.getWebDriver();
        } catch (IllegalStateException ignored) {
            throw new WDCException.NoSuchWDSession();
        }
    }
}
