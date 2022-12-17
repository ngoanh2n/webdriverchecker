package com.github.ngoanh2n;

import com.github.ngoanh2n.wdc.WebDriverChecker;
import com.github.ngoanh2n.wdc.WebDriverService;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.openqa.selenium.WebDriver;

/**
 * Provide WebDriver from current test to {@linkplain WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 2.3.0
 * @since 2022-12-18
 */
public class WDCJUnit5 implements WebDriverService, InvocationInterceptor {
    private static WebDriver driver;

    @Override
    public WebDriver serve() {
        return driver;
    }
}
