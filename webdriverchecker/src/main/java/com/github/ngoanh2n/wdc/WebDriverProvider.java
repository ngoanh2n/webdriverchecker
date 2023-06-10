package com.github.ngoanh2n.wdc;

import org.openqa.selenium.WebDriver;

/**
 * Provide a {@link WebDriver} to the {@link WebDriverProvider}.<br>
 * Therefore, you don't need to pass {@link WebDriver} to the argument of static APIs.<br>
 * <ul>
 *     <li>When not using SPI {@link WebDriverProvider}: <pre>{@code WebDriverChecker.isChrome(driver)}</pre>
 *     <li>When applying SPI {@link WebDriverProvider}: <pre>{@code WebDriverChecker.isChrome()}</pre>
 * </ul>
 * <p>
 * How to build the service provider:<br>
 * <ul>
 *      <li>1. Create a class that implements SPI {@link WebDriverProvider}
 *      <pre>{@code
 *      package com.company.project.impl;
 *
 *      import org.openqa.selenium.WebDriver;
 *      import com.github.ngoanh2n.wdc.WebDriverProvider;
 *
 *      public class MyWebDriverProvider implements WebDriverProvider {
 *          public WebDriver serve() {
 *              WebDriver driver = MyStaticDriver.getDriver();
 *              return driver;
 *          }
 *      }
 *      }</pre>
 *      <li>2. Create a provider configuration file:
 *      <ul>
 *          <li>Location: {@code resources/META-INF/services}
 *          <li>Name: {@code com.github.ngoanh2n.wdc.WebDriverProvider}
 *          <li>Content: {@code com.company.project.impl.MyWebDriverProvider}
 *      </ul>
 * </ul>
 *
 * @author ngoanh2n
 */
public interface WebDriverProvider {
    /**
     * Provide {@link WebDriver} to {@link WebDriverChecker}.
     *
     * @return The {@link WebDriver} instance you have set up.
     */
    WebDriver provide();
}
