package com.github.ngoanh2n.wdc;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class BeforeClassTest extends WDCTestNGTest {
    @BeforeClass
    protected void beforeClass() {
        Assert.assertThrows(CheckerException.NullDriverProvided.class, WebDriverChecker::getDriver);
        createWebDriver();
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }

    @BeforeMethod
    protected void beforeMethod() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }

    @Test
    protected void test() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }
}
