package io.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

import static io.github.ngoanh2n.wdc.WDC.*;
import static java.util.ServiceLoader.load;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public abstract class WebDriverChecker {

    public static boolean isAlive() {
        return WebDriverChecker.is(new Alive());
    }

    public static boolean isRemote() {
        return WebDriverChecker.is(new Remote());
    }

    public static boolean isIE() {
        return WebDriverChecker.is(new IE());
    }

    public static boolean isEdge() {
        return WebDriverChecker.is(new Edge());
    }

    public static boolean isOpera() {
        return WebDriverChecker.is(new Opera());
    }

    public static boolean isSafari() {
        return WebDriverChecker.is(new Safari());
    }

    public static boolean isChrome() {
        return WebDriverChecker.is(new Chrome());
    }

    public static boolean isFirefox() {
        return WebDriverChecker.is(new Firefox());
    }

    public static boolean isEdgeLegacy() {
        return WebDriverChecker.is(new EdgeLegacy());
    }

    public static boolean isFirefoxLegacy() {
        return WebDriverChecker.is(new FirefoxLegacy());
    }

    public static boolean isIOS() {
        return WebDriverChecker.is(new IOS());
    }

    public static boolean isIOSApp() {
        return WebDriverChecker.is(new IOSApp());
    }

    public static boolean isIOSSafari() {
        return WebDriverChecker.is(new IOSSafari());
    }

    public static boolean isAndroid() {
        return WebDriverChecker.is(new Android());
    }

    public static boolean isAndroidApp() {
        return WebDriverChecker.is(new AndroidApp());
    }

    public static boolean isAndroidChrome() {
        return WebDriverChecker.is(new AndroidChrome());
    }

    public static boolean isMobile() {
        return WebDriverChecker.is(new Mobile());
    }

    public static boolean isMobileApp() {
        return WebDriverChecker.is(new MobileApp());
    }

    public static boolean isWindowsApp() {
        return WebDriverChecker.is(new WindowsApp());
    }

    // ------------

    public static boolean isAlive(WebDriver wd) {
        return WebDriverChecker.is(new Alive(), wd);
    }

    public static boolean isRemote(WebDriver wd) {
        return WebDriverChecker.is(new Remote(), wd);
    }

    public static boolean isIE(WebDriver wd) {
        return WebDriverChecker.is(new IE(), wd);
    }

    public static boolean isEdge(WebDriver wd) {
        return WebDriverChecker.is(new Edge(), wd);
    }

    public static boolean isOpera(WebDriver wd) {
        return WebDriverChecker.is(new Opera(), wd);
    }

    public static boolean isSafari(WebDriver wd) {
        return WebDriverChecker.is(new Safari(), wd);
    }

    public static boolean isChrome(WebDriver wd) {
        return WebDriverChecker.is(new Chrome(), wd);
    }

    public static boolean isFirefox(WebDriver wd) {
        return WebDriverChecker.is(new Firefox(), wd);
    }

    public static boolean isEdgeLegacy(WebDriver wd) {
        return WebDriverChecker.is(new EdgeLegacy(), wd);
    }

    public static boolean isFirefoxLegacy(WebDriver wd) {
        return WebDriverChecker.is(new FirefoxLegacy(), wd);
    }

    public static boolean isIOS(WebDriver wd) {
        return WebDriverChecker.is(new IOS(), wd);
    }

    public static boolean isIOSApp(WebDriver wd) {
        return WebDriverChecker.is(new IOSApp(), wd);
    }

    public static boolean isIOSSafari(WebDriver wd) {
        return WebDriverChecker.is(new IOSSafari(), wd);
    }

    public static boolean isAndroid(WebDriver wd) {
        return WebDriverChecker.is(new Android(), wd);
    }

    public static boolean isAndroidApp(WebDriver wd) {
        return WebDriverChecker.is(new AndroidApp(), wd);
    }

    public static boolean isAndroidChrome(WebDriver wd) {
        return WebDriverChecker.is(new AndroidChrome(), wd);
    }

    public static boolean isMobile(WebDriver wd) {
        return WebDriverChecker.is(new Mobile(), wd);
    }

    public static boolean isMobileApp(WebDriver wd) {
        return WebDriverChecker.is(new MobileApp(), wd);
    }

    public static boolean isWindowsApp(WebDriver wd) {
        return WebDriverChecker.is(new WindowsApp(), wd);
    }

    // ------------

    private static class Alive extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getRemoteDriver(args).getSessionId() != null;
        }
    }

    private static class Remote extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            RemoteWebDriver driver = getRemoteDriver(args);
            CommandExecutor command = driver.getCommandExecutor();

            if (command instanceof HttpCommandExecutor) {
                return (!(command instanceof DriverCommandExecutor));
            }
            return false;
        }
    }

    private static class IE extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(IE.getValue());
        }
    }

    private static class Edge extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(EDGE.getValue());
        }
    }

    private static class Opera extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(OPERA.getValue());
        }
    }

    private static class Safari extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(SAFARI.getValue());
        }
    }

    private static class Chrome extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(CHROME.getValue());
        }
    }

    private static class Firefox extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(FIREFOX.getValue());
        }
    }

    private static class EdgeLegacy extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(EDGE_LEGACY.getValue());
        }
    }

    private static class FirefoxLegacy extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new Firefox(), args) && getBrowserVersion(args) < 48;
        }
    }

    private static class IOS extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getPlatformName(args).equals(IOS.getValue());
        }
    }

    private static class IOSApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            if (is(new IOS(), args)) {
                if (!getCapability("app", args).isEmpty()) {
                    return true;
                }
                return getBrowserName(args).isEmpty();
            }
            return false;
        }
    }

    private static class IOSSafari extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new IOS(), args) && is(new Safari(), args);
        }
    }

    private static class Android extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getPlatformName(args).equals(ANDROID.getValue());
        }
    }

    private static class AndroidApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            if (is(new Android())) {
                if (!getCapability("app", args).isEmpty()) {
                    return true;
                }
                String appPackage = getCapability("appPackage", args);
                return getBrowserName(args).isEmpty() || !appPackage.equals("com.android.chrome");
            }
            return false;
        }
    }

    private static class AndroidChrome extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new Android(), args) && is(new Chrome(), args);
        }
    }

    private static class Mobile extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new IOS(), args) || is(new Android(), args);
        }
    }

    private static class MobileApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new IOSApp(), args) || is(new AndroidApp(), args);
        }
    }

    private static class WindowsApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getPlatformName(args).equals(WINDOWS.getValue()) && getBrowserName(args).isEmpty();
        }
    }

    // ------------

    protected abstract boolean execute(Object[] args);

    // ------------

    protected String getPlatformName(Object... args) {
        return getCapability("platformName", args).toLowerCase();
    }

    protected String getBrowserName(Object... args) {
        return getCapability("browserName", args).toLowerCase();
    }

    protected double getBrowserVersion(Object... args) {
        String value = getCapability("browserVersion", args);
        return Double.parseDouble(value.split("\\.")[0]);
    }

    protected String getCapability(String name, Object... args) {
        Object value = getCapabilities(args).getCapability(name);
        return String.valueOf(Optional.ofNullable(value).orElse(""));
    }

    protected Capabilities getCapabilities(Object... args) {
        WebDriver driver = getDriver(args);
        if (driver instanceof HasCapabilities) {
            return ((HasCapabilities) driver).getCapabilities();
        } else {
            throw new WDCException.NoSuchCapabilitiesImplemented();
        }
    }

    protected RemoteWebDriver getRemoteDriver(Object... args) {
        return ((RemoteWebDriver) getDriver(args));
    }

    protected WebDriver getDriver(Object... args) {
        if (args.length == 0) {
            return getServedDriver();
        } else {
            return getProvidedDriver(args[0]);
        }
    }

    protected synchronized WebDriver getServedDriver() {
        ServiceLoader<WebDriverService> service = load(WebDriverService.class);
        Iterator<WebDriverService> serviceLoaders = service.iterator();

        if (serviceLoaders.hasNext()) {
            return serviceLoaders.next().provide();
        } else {
            throw new WDCException.NoSuchWDServiceProvided();
        }
    }

    protected synchronized WebDriver getProvidedDriver(Object wd) {
        Object driver = Optional
                .ofNullable(wd)
                .orElseThrow(WDCException.NullWDPassedByArgument::new);
        if (driver instanceof WebDriver) {
            return (WebDriver) driver;
        } else {
            throw new WDCException.NoneWDPassedByArgument();
        }
    }

    // ------------

    protected static boolean is(WebDriverChecker wdc, Object... args) {
        if (!(wdc instanceof Alive)) {
            if (!is(new Alive(), args)) {
                throw new WDCException.NoSuchWDSession();
            }
        }
        return wdc.execute(args);
    }
}
