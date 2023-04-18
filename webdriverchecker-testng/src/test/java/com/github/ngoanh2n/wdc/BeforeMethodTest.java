package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class BeforeMethodTest extends WDCTestNGTest {
    @BeforeClass
    void beforeClass() {
        Assert.assertThrows(RuntimeError.class, WebDriverChecker::getDriver);
    }

    @BeforeMethod
    void beforeMethod() {
        driver = createWebDriver();
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }

    @Test
    void test() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }
}
