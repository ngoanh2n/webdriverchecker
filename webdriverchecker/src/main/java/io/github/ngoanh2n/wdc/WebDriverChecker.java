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
        return is(IE, new IE());
    }

    public static boolean isEdge() {
        return is(EDGE, new Edge());
    }

    public static boolean isOpera() {
        return is(OPERA, new Opera());
    }

    public static boolean isSafari() {
        return is(SAFARI, new Safari());
    }

    public static boolean isChrome() {
        return is(CHROME, new Chrome());
    }

    public static boolean isFirefox() {
        return is(FIREFOX, new Firefox());
    }

    public static boolean isEdgeLegacy() {
        return is(EDGE_LEGACY, new EdgeLegacy());
    }

    public static boolean isFirefoxLegacy() {
        return is(FIREFOX_LEGACY, new FirefoxLegacy());
    }

    public static boolean isIOS() {
        return is(IOS, new IOS());
    }

    public static boolean isIOSApp() {
        return is(IOS_APP, new IOSApp());
    }

    public static boolean isIOSSafari() {
        return is(IOS_SAFARI, new IOSSafari());
    }

    public static boolean isAndroid() {
        return is(ANDROID, new Android());
    }

    public static boolean isAndroidChrome() {
        return is(ANDROID_CHROME, new AndroidChrome());
    }

    public static boolean isMobile() {
        return is(MOBILE, new Mobile());
    }

    public static boolean isMobileApp() {
        return is(MOBILE_APP, new MobileApp());
    }

    public static boolean isWindowsApp() {
        return is(WINDOWS, new WindowsApp());
    }

    // ------------

    public static boolean isIE(WebDriver wd) {
        return is(IE, new IE(), wd);
    }

    public static boolean isEdge(WebDriver wd) {
        return is(EDGE, new Edge(), wd);
    }

    public static boolean isOpera(WebDriver wd) {
        return is(OPERA, new Opera(), wd);
    }

    public static boolean isSafari(WebDriver wd) {
        return is(SAFARI, new Safari(), wd);
    }

    public static boolean isChrome(WebDriver wd) {
        return is(CHROME, new Chrome(), wd);
    }

    public static boolean isFirefox(WebDriver wd) {
        return is(FIREFOX, new Firefox(), wd);
    }

    public static boolean isEdgeLegacy(WebDriver wd) {
        return is(EDGE_LEGACY, new EdgeLegacy(), wd);
    }

    public static boolean isFirefoxLegacy(WebDriver wd) {
        return is(FIREFOX_LEGACY, new FirefoxLegacy(), wd);
    }

    public static boolean isIOS(WebDriver wd) {
        return is(IOS, new IOS(), wd);
    }

    public static boolean isIOSApp(WebDriver wd) {
        return is(IOS_APP, new IOSApp(), wd);
    }

    public static boolean isIOSSafari(WebDriver wd) {
        return is(IOS_SAFARI, new IOSSafari(), wd);
    }

    public static boolean isAndroid(WebDriver wd) {
        return is(ANDROID, new Android(), wd);
    }

    public static boolean isAndroidChrome(WebDriver wd) {
        return is(ANDROID_CHROME, new AndroidChrome(), wd);
    }

    public static boolean isMobile(WebDriver wd) {
        return is(MOBILE, new Mobile(), wd);
    }

    public static boolean isMobileApp(WebDriver wd) {
        return is(MOBILE_APP, new MobileApp(), wd);
    }

    public static boolean isWindowsApp(WebDriver wd) {
        return is(WINDOWS, new WindowsApp(), wd);
    }

    // ------------

    private static class IE extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(IE.getValue());
        }
    }

    private static class Edge extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(EDGE.getValue());
        }
    }

    private static class Opera extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(OPERA.getValue());
        }
    }

    private static class Safari extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(SAFARI.getValue());
        }
    }

    private static class Chrome extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(CHROME.getValue());
        }
    }

    private static class Firefox extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(FIREFOX.getValue());
        }
    }

    private static class EdgeLegacy extends WebDriverChecker {

        @Override
        public boolean check() {
            return getBrowserName().equals(EDGE_LEGACY.getValue());
        }
    }

    private static class FirefoxLegacy extends WebDriverChecker {

        @Override
        public boolean check() {
            return is(FIREFOX, new Firefox()) && getBrowserVersion() < 48;
        }
    }

    private static class IOS extends WebDriverChecker {

        @Override
        public boolean check() {
            return getPlatformName().equals(IOS.getValue());
        }
    }

    private static class IOSApp extends WebDriverChecker {

        @Override
        public boolean check() {
            return is(IOS, new IOS()) && (!getCapability("app").isEmpty() || getBrowserName().isEmpty());
        }
    }

    private static class IOSSafari extends WebDriverChecker {

        @Override
        public boolean check() {
            return is(IOS, new IOS()) && is(SAFARI, new Safari());
        }
    }

    private static class Android extends WebDriverChecker {

        @Override
        public boolean check() {
            return getPlatformName().equals(ANDROID.getValue());
        }
    }

    private static class AndroidChrome extends WebDriverChecker {

        @Override
        public boolean check() {
            return is(ANDROID, new Android()) && is(CHROME, new Chrome());
        }
    }

    private static class Mobile extends WebDriverChecker {

        @Override
        public boolean check() {
            return is(IOS, new IOS()) || is(ANDROID, new Android());
        }
    }

    private static class MobileApp extends WebDriverChecker {

        @Override
        public boolean check() {
            if (!getCapability("app").isEmpty()) {
                return true;
            }
            if (is(IOS, new IOS())) {
                return getBrowserName().isEmpty();
            }
            if (is(ANDROID, new Android())) {
                String appPackage = getCapability("appPackage");
                return getBrowserName().isEmpty() || !appPackage.equals("com.android.chrome");
            }
            return false;
        }
    }

    private static class WindowsApp extends WebDriverChecker {

        @Override
        public boolean check() {
            return getPlatformName().equals(WINDOWS.getValue()) && getBrowserName().isEmpty();
        }
    }

    // ------------

    static boolean is(WebDriverChecker wdc) {
        return wdc.check();
    }

    static boolean is(WDCType type, WebDriverChecker wdc) {
        instances.putIfAbsent(type, wdc);
        return is(instances.get(type));
    }

    static boolean is(WDCType type, WebDriverChecker wdc, WebDriver wd) {
        instances.putIfAbsent(type, wdc);
        return is(instances.get(type).useDriver(wd));
    }

    // ------------

    protected WebDriver driver;
    protected static Map<WDCType, WebDriverChecker> instances = new EnumMap<>(WDCType.class);

    // ------------
    protected abstract boolean check();

    protected WebDriverChecker useDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    protected String getPlatformName() {
        Capabilities caps = getCapabilities();
        return caps.getPlatform().name().toLowerCase();
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

    protected String getCapability(String name) {
        Object capability = getCapabilities().getCapability(name);
        return String.valueOf(Optional.ofNullable(capability).orElse(""));
    }

    protected synchronized WebDriver getServedDriver() {
        ServiceLoader<WebDriverService> service = ServiceLoader.load(WebDriverService.class);
        Iterator<WebDriverService> serviceLoaders = service.iterator();

        if (serviceLoaders.hasNext()) {
            return serviceLoaders.next().provide();
        } else {
            throw new IllegalStateException("No implementation of WebDriverService provided");
        }
    }
}
