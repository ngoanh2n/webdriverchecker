package com.github.ngoanh2n.wdc;

import org.openqa.selenium.WebDriver;

/**
 * Interface for using to serve current your {@linkplain WebDriver} to {@linkplain WebDriverChecker}.<br>
 * Therefore, you don't need to pass {@linkplain WebDriver} to the argument of static APIs.<br>
 * <ul>
 *     <li>When not using SPI {@linkplain WebDriverService}: <pre>{@code WebDriverChecker.isChrome(driver)}</pre>
 *     <li>When applying SPI {@linkplain WebDriverService}: <pre>{@code WebDriverChecker.isChrome()}</pre>
 * </ul>
 * <p>
 * How to build the service provider:<br>
 * <ul>
 *      <li>1. Create a class that implements SPI {@linkplain WebDriverService}
 *      <pre>{@code
 *      package com.company.project.impl;
 *
 *      import org.openqa.selenium.WebDriver;
 *      import com.github.ngoanh2n.wdc.WebDriverService;
 *
 *      public class MyWebDriverService implements WebDriverService {
 *
 *          public WebDriver serve() {
 *              WebDriver driver = MyStaticDriver.getDriver();
 *              return driver;
 *          }
 *      }
 *      }</pre>
 *      <li>2. Create a provider configuration file:
 *      <ul>
 *          <li>Location: {@code resources/META-INF/services}
 *          <li>Name: {@code com.github.ngoanh2n.wdc.WebDriverService}
 *          <li>Content: {@code com.company.project.impl.MyWebDriverService}
 *      </ul>
 * </ul>
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public interface WebDriverService {

    WebDriver serve();
}
