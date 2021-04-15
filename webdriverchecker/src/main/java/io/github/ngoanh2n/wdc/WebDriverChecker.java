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
        return execute(IE, new IE());
    }

    public static boolean isEdge() {
        return execute(EDGE, new Edge());
    }

    public static boolean isOpera() {
        return execute(OPERA, new Opera());
    }

    public static boolean isSafari() {
        return execute(SAFARI, new Safari());
    }

    public static boolean isChrome() {
        return execute(CHROME, new Chrome());
    }

    public static boolean isFirefox() {
        return execute(FIREFOX, new Firefox());
    }

    public static boolean isEdgeLegacy() {
        return execute(EDGE_LEGACY, new EdgeLegacy());
    }

    public static boolean isFirefoxLegacy() {
        return execute(FIREFOX_LEGACY, new FirefoxLegacy());
    }

    public static boolean isMobile() {
        return execute(MOBILE, new Mobile());
    }

    public static boolean isMobileApp() {
        return execute(MOBILE_APP, new MobileApp());
    }

    public static boolean isMobileIOS() {
        return execute(MOBILE_IOS, new MobileIOS());
    }

    public static boolean isMobileAndroid() {
        return execute(MOBILE_ANDROID, new MobileAndroid());
    }

    public static boolean isMobileSafari() {
        return execute(MOBILE_SAFARI, new MobileSafari());
    }

    public static boolean isMobileChrome() {
        return execute(MOBILE_CHROME, new MobileChrome());
    }

    // ------------

    public static boolean isIE(WebDriver wd) {
        return execute(IE, new IE(), wd);
    }

    public static boolean isEdge(WebDriver wd) {
        return execute(EDGE, new Edge(), wd);
    }

    public static boolean isOpera(WebDriver wd) {
        return execute(OPERA, new Opera(), wd);
    }

    public static boolean isSafari(WebDriver wd) {
        return execute(SAFARI, new Safari(), wd);
    }

    public static boolean isChrome(WebDriver wd) {
        return execute(CHROME, new Chrome(), wd);
    }

    public static boolean isFirefox(WebDriver wd) {
        return execute(FIREFOX, new Firefox(), wd);
    }

    public static boolean isEdgeLegacy(WebDriver wd) {
        return execute(EDGE_LEGACY, new EdgeLegacy(), wd);
    }

    public static boolean isFirefoxLegacy(WebDriver wd) {
        return execute(FIREFOX_LEGACY, new FirefoxLegacy(), wd);
    }

    public static boolean isMobile(WebDriver wd) {
        return execute(MOBILE, new Mobile(), wd);
    }

    public static boolean isMobileApp(WebDriver wd) {
        return execute(MOBILE_APP, new MobileApp(), wd);
    }

    public static boolean isMobileIOS(WebDriver wd) {
        return execute(MOBILE_IOS, new MobileIOS(), wd);
    }

    public static boolean isMobileAndroid(WebDriver wd) {
        return execute(MOBILE_ANDROID, new MobileAndroid(), wd);
    }

    public static boolean isMobileSafari(WebDriver wd) {
        return execute(MOBILE_SAFARI, new MobileSafari(), wd);
    }

    public static boolean isMobileChrome(WebDriver wd) {
        return execute(MOBILE_CHROME, new MobileChrome(), wd);
    }

    // ------------

    private static class IE extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(IE.getName());
        }
    }

    private static class Edge extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(EDGE.getName());
        }
    }

    private static class Opera extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(OPERA.getName());
        }
    }

    private static class Safari extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(SAFARI.getName());
        }
    }

    private static class Chrome extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(CHROME.getName());
        }
    }

    private static class Firefox extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(FIREFOX.getName());
        }
    }

    private static class EdgeLegacy extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(EDGE_LEGACY.getName());
        }
    }

    private static class FirefoxLegacy extends WebDriverChecker {

        @Override
        public boolean check() {
            return execute(FIREFOX, new Firefox()) && getBrowserVersion() < 48;
        }
    }

    private static class Mobile extends WebDriverChecker {

        @Override
        public boolean check() {
            return execute(MOBILE_IOS, new MobileIOS()) || execute(MOBILE_ANDROID, new MobileAndroid());
        }
    }

    private static class MobileApp extends WebDriverChecker {

        @Override
        public boolean check() {
            if (!getCapability("app").isEmpty()) {
                return true;
            }
            if (execute(MOBILE_IOS, new MobileIOS())) {
                return getBrowserName().isEmpty();
            }
            if (execute(MOBILE_ANDROID, new MobileAndroid())) {
                String appPackage = getCapability("appPackage");
                return getBrowserName().isEmpty() || !appPackage.equals("com.android.chrome");
            }
            return false;
        }
    }

    private static class MobileIOS extends WebDriverChecker {

        @Override
        public boolean check() {
            return getCapability("platformName").equals(MOBILE_IOS.getName());
        }
    }

    private static class MobileAndroid extends WebDriverChecker {

        @Override
        public boolean check() {
            return getCapability("platformName").equals(MOBILE_ANDROID.getName());
        }
    }

    private static class MobileSafari extends WebDriverChecker {

        @Override
        public boolean check() {
            return execute(MOBILE_IOS, new MobileIOS()) && execute(SAFARI, new Safari());
        }
    }

    private static class MobileChrome extends WebDriverChecker {

        @Override
        public boolean check() {
            return execute(MOBILE_ANDROID, new MobileAndroid()) && execute(CHROME, new Chrome());
        }
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

    protected double getBrowserVersion() {
        Capabilities caps = getCapabilities();
        String[] byPoints = caps.getVersion().split("\\.");
        return Double.parseDouble(byPoints[0]);
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
