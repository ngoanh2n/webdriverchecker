package io.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;

import static io.github.ngoanh2n.wdc.WDCType.*;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public abstract class WebDriverChecker {

    public static boolean isIE() {
        return execute(IE, new IEChecker());
    }

    public static boolean isEdge() {
        return execute(EDGE, new EdgeChecker());
    }

    public static boolean isOpera() {
        return execute(OPERA, new OperaChecker());
    }

    public static boolean isSafari() {
        return execute(SAFARI, new SafariChecker());
    }

    public static boolean isChrome() {
        return execute(CHROME, new ChromeChecker());
    }

    public static boolean isFirefox() {
        return execute(FIREFOX, new FirefoxChecker());
    }

    public static boolean isIOS() {
        return execute(IOS, new IOSChecker());
    }

    public static boolean isAndroid() {
        return execute(ANDROID, new AndroidChecker());
    }

    public static boolean isMobile() {
        return execute(MOBILE, new MobileChecker());
    }

    public static boolean isMobileApp() {
        return execute(MOBILE_APP, new MobileAppChecker());
    }

    public static boolean isEdgeLegacy() {
        return execute(EDGE_LEGACY, new EdgeLegacyChecker());
    }

    // ------------

    public static boolean isIE(WebDriver wd) {
        return execute(IE, new IEChecker(), wd);
    }

    public static boolean isEdge(WebDriver wd) {
        return execute(EDGE, new EdgeChecker(), wd);
    }

    public static boolean isOpera(WebDriver wd) {
        return execute(OPERA, new OperaChecker(), wd);
    }

    public static boolean isSafari(WebDriver wd) {
        return execute(SAFARI, new SafariChecker(), wd);
    }

    public static boolean isChrome(WebDriver wd) {
        return execute(CHROME, new ChromeChecker(), wd);
    }

    public static boolean isFirefox(WebDriver wd) {
        return execute(FIREFOX, new FirefoxChecker(), wd);
    }

    public static boolean isIOS(WebDriver wd) {
        return execute(IOS, new IOSChecker(), wd);
    }

    public static boolean isAndroid(WebDriver wd) {
        return execute(ANDROID, new AndroidChecker(), wd);
    }

    public static boolean isMobile(WebDriver wd) {
        return execute(MOBILE, new MobileChecker(), wd);
    }

    public static boolean isMobileApp(WebDriver wd) {
        return execute(MOBILE_APP, new MobileAppChecker(), wd);
    }

    public static boolean isEdgeLegacy(WebDriver wd) {
        return execute(EDGE_LEGACY, new EdgeLegacyChecker(), wd);
    }

    // ------------

    static boolean execute(WebDriverChecker wdc) {
        return wdc.check();
    }

    static boolean execute(WDCType type, WebDriverChecker wdc) {
        instances.putIfAbsent(type, wdc);
        return execute(instances.get(type));
    }

    static boolean execute(WDCType type, WebDriverChecker wdc, WebDriver wd) {
        instances.putIfAbsent(type, wdc);
        return execute(instances.get(type).useDriver(wd));
    }

    // ------------

    protected WebDriver driver;
    protected static Map<WDCType, WebDriverChecker> instances = new EnumMap<>(WDCType.class);

    protected abstract boolean check();

    protected WebDriverChecker useDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    protected String getBrowserName() {
        Capabilities caps = getCapabilities();
        return caps.getBrowserName().replaceAll("\\s+", "").toLowerCase();
    }

    protected Capabilities getCapabilities() {
        return getRemoteDriver().getCapabilities();
    }

    protected RemoteWebDriver getRemoteDriver() {
        WebDriver driver = getDriver();
        return ((RemoteWebDriver) driver);
    }

    protected WebDriver getDriver() {
        return driver != null ? driver : getServedDriver();
    }

    String getCapability(String name) {
        Object capability = getCapabilities().getCapability(name);
        return String.valueOf(Optional.ofNullable(capability).orElse(""));
    }

    synchronized WebDriver getServedDriver() {
        ServiceLoader<WebDriverService> service = ServiceLoader.load(WebDriverService.class);
        Iterator<WebDriverService> serviceLoaders = service.iterator();

        if (serviceLoaders.hasNext()) {
            return serviceLoaders.next().provide();
        } else {
            throw new IllegalStateException("No implementation of WebDriverService provided");
        }
    }
}
