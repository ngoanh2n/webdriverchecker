package com.github.ngoanh2n.wdc;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class BeforeMethodTest extends WDCTestNGTest {
    @BeforeClass
    protected void beforeClass() {
        Assert.assertThrows(CheckerException.NullDriverProvided.class, WebDriverChecker::getDriver);
    }

    @BeforeMethod
    protected void beforeMethod() {
        createWebDriver();
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }

    @Test
    protected void test() {
        Assert.assertNotNull(WebDriverChecker.getDriver());
    }
}
