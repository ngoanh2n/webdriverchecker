package com.github.ngoanh2n.wdc.selenium;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class AbstractTest {

    void openDriver(String name) {
        Configuration.browser = name;
        Selenide.open();
    }

    @AfterEach
    void closeDriver() {
        Selenide.closeWebDriver();
    }
}
