package com.github.ngoanh2n.wdc;

import org.openqa.selenium.WebDriver;

/**
 * Provide a {@link WebDriver} to the {@link WebDriverChecker}.<br>
 * Therefore, you don't need to pass {@link WebDriver} to the argument of static APIs.
 * <ul>
 *     <li>With SPI {@link WebDriverProvider} <pre>{@code WebDriverChecker.isChrome()}</pre></li>
 *     <li>Without SPI {@link WebDriverProvider} <pre>{@code WebDriverChecker.isChrome(driver)}</pre></li>
 * </ul>
 *
 * <b>Build the service provider:</b>
 * <ol>
 *      <li>Create a class that implements SPI {@link WebDriverProvider}
 *          <pre>{@code
 *              package com.company.project.impl;
 *
 *              import org.openqa.selenium.WebDriver;
 *              import com.github.ngoanh2n.wdc.WebDriverProvider;
 *
 *              public class MyWebDriverProvider implements WebDriverProvider {
 *                  public WebDriver serve() {
 *                      WebDriver driver = MyStaticDriver.getDriver();
 *                      return driver;
 *                  }
 *              }
 *          }</pre>
 *      </li>
 *      <li>Create a provider configuration file
 *          <ol>
 *              <li>Location: {@code resources/META-INF/services}</li>
 *              <li>Name: {@code com.github.ngoanh2n.wdc.WebDriverProvider}</li>
 *              <li>Content: {@code com.company.project.impl.MyWebDriverProvider}</li>
 *          </ol>
 *      </li>
 * </ol>
 *
 * <em>Repository:</em>
 * <ul>
 *     <li><em>GitHub: <a href="https://github.com/ngoanh2n/webdriverchecker">ngoanh2n/webdriverchecker</a></em></li>
 *     <li><em>Maven: <a href="https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker">com.github.ngoanh2n:webdriverchecker</a></em></li>
 * </ul>
 *
 * @author ngoanh2n
 * @since 2020
 */
public interface WebDriverProvider {
    /**
     * Provide {@link WebDriver} to {@link WebDriverChecker}.
     *
     * @return The {@link WebDriver} instance you have set up.
     */
    WebDriver provide();
}
