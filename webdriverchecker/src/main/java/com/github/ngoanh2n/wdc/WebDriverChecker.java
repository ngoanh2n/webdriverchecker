package com.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;

import static com.github.ngoanh2n.wdc.Browser.IE;
import static com.github.ngoanh2n.wdc.Browser.*;
import static com.github.ngoanh2n.wdc.Combine.*;
import static com.github.ngoanh2n.wdc.Platform.Android;
import static com.github.ngoanh2n.wdc.Platform.IOS;
import static com.github.ngoanh2n.wdc.State.Alive;
import static com.github.ngoanh2n.wdc.State.Remote;
import static com.github.ngoanh2n.wdc.WDCConstant.*;
import static com.github.ngoanh2n.wdc.WDCException.*;
import static java.util.ServiceLoader.load;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public abstract class WebDriverChecker {
    /**
     * Check whether {@linkplain WebDriver} is alive.
     *
     * @return true if running
     */
    public static boolean isAlive() {
        return is(new Alive(true));
    }

    /**
     * Check whether {@linkplain WebDriver} is running remotely.
     *
     * @return true if it's running remotely
     */
    public static boolean isRemote() {
        return is(new Remote());
    }

    /**
     * Check whether {@linkplain WebDriver} for Chrome browser
     * on any platform (Chrome on macOS, Linux, Windows, Android).
     *
     * @return true if it's Chrome browser
     */
    public static boolean isChrome() {
        return is(new Chrome());
    }

    /**
     * Check whether {@linkplain WebDriver} for Safari browser
     * on any platform (Safari on macOS, iOS).
     *
     * @return true if it's Safari browser
     */
    public static boolean isSafari() {
        return is(new Safari());
    }

    /**
     * Check whether {@linkplain WebDriver} for Firefox browser
     * on any platform (Firefox on macOS, Linux, Windows).
     *
     * @return true if it's Firefox browser
     */
    public static boolean isFirefox() {
        return is(new Firefox());
    }

    /**
     * Check whether {@linkplain WebDriver} for Edge browser
     * on any platform (Edge on macOS, Linux, Windows).
     *
     * @return true if it's Edge browser
     */
    public static boolean isEdge() {
        return is(new Edge());
    }

    /**
     * Check whether {@linkplain WebDriver} for Opera browser
     * on any platform (Opera on macOS, Linux, Windows).
     *
     * @return true if it's Opera browser
     */
    public static boolean isOpera() {
        return is(new Opera());
    }

    /**
     * Check whether {@linkplain WebDriver} for IE browser.
     *
     * @return true if it's IE browser
     */
    public static boolean isIE() {
        return is(new IE());
    }

    /**
     * Check whether {@linkplain WebDriver} for legacy Edge (Edge HTML) browser.
     *
     * @return true if it's legacy Edge browser
     */
    public static boolean isEdgeLegacy() {
        return is(new LegacyEdge());
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code legacy Firefox (lower than version 48)} browser.
     *
     * @return true if it's legacy Firefox browser
     */
    public static boolean isFirefoxLegacy() {
        return is(new LegacyFirefox());
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS.
     *
     * @return true if it's iOS
     */
    public static boolean isIOS() {
        return is(new IOS());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @return true if it's a browser on iOS
     */
    public static boolean isIOSWeb() {
        return is(new IOSWeb());
    }

    /**
     * Check whether {@linkplain WebDriver} for Safari browser on iOS.
     *
     * @return true if it's Safari browser on iOS
     */
    public static boolean isIOSSafari() {
        return is(new IOSSafari());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS.
     *
     * @return true if it's a native app on iOS
     */
    public static boolean isIOSNative() {
        return is(new IOSNative());
    }

    /**
     * Check whether {@linkplain WebDriver} on Android.
     *
     * @return true if it's Android
     */
    public static boolean isAndroid() {
        return is(new Android());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on Android.
     *
     * @return true if it's a browser on Android
     */
    public static boolean isAndroidWeb() {
        return is(new AndroidWeb());
    }

    /**
     * Check whether {@linkplain WebDriver} for Chrome browser on Android.
     *
     * @return true if it's Chrome browser on Android
     */
    public static boolean isAndroidChrome() {
        return is(new AndroidChrome());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Android.
     *
     * @return true if it's a native app on Android
     */
    public static boolean isAndroidNative() {
        return is(new AndroidNative());
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS or Android.
     *
     * @return true if it's iOS or Android
     */
    public static boolean isMobile() {
        return is(new Mobile());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @return true if it's a browser on iOS or Android
     */
    public static boolean isMobileWeb() {
        return is(new MobileWeb());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS or Android.
     *
     * @return true if it's a native app on iOS or Android
     */
    public static boolean isMobileNative() {
        return is(new MobileNative());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on macOS.
     *
     * @return true if it's a native app on macOS
     */
    public static boolean isMacOSNative() {
        return is(new MacOSNative());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Windows.
     *
     * @return true if it's a native app on Windows
     */
    public static boolean isWindowsNative() {
        return is(new WindowsNative());
    }

    /**
     * Check whether {@linkplain WebDriver} on any a PC platform
     * (a browser or native app on macOS, Linux or Windows).
     *
     * @return true if it's PC platform
     */
    public static boolean isPC() {
        return is(new PC());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @return true if it's a browser on macOS, Linux or Windows
     */
    public static boolean isPCWeb() {
        return is(new PCWeb());
    }

    // ------------------------------------

    /**
     * Check whether {@linkplain WebDriver} is alive.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if running
     */
    public static boolean isAlive(WebDriver wd) {
        return is(new Alive(true), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running remotely.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running remotely
     */
    public static boolean isRemote(WebDriver wd) {
        return is(new Remote(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Chrome browser
     * on any platform (Chrome on macOS, Linux, Windows, Android).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Chrome browser
     */
    public static boolean isChrome(WebDriver wd) {
        return is(new Chrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Safari browser
     * on any platform (Safari on macOS, iOS).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Safari browser
     */
    public static boolean isSafari(WebDriver wd) {
        return is(new Safari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Firefox browser
     * on any platform (Firefox on macOS, Linux, Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Firefox browser
     */
    public static boolean isFirefox(WebDriver wd) {
        return is(new Firefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Edge browser
     * on any platform (Edge on macOS, Linux, Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Edge browser
     */
    public static boolean isEdge(WebDriver wd) {
        return is(new Edge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Opera browser
     * on any platform (Opera on macOS, Linux, Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Opera browser
     */
    public static boolean isOpera(WebDriver wd) {
        return is(new Opera(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for IE browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's IE browser
     */
    public static boolean isIE(WebDriver wd) {
        return is(new IE(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for legacy Edge (Edge HTML) browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's legacy Edge browser
     */
    public static boolean isEdgeLegacy(WebDriver wd) {
        return is(new LegacyEdge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code legacy Firefox (lower than version 48)} browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's legacy Firefox browser
     */
    public static boolean isFirefoxLegacy(WebDriver wd) {
        return is(new LegacyFirefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's iOS
     */
    public static boolean isIOS(WebDriver wd) {
        return is(new IOS(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on iOS
     */
    public static boolean isIOSWeb(WebDriver wd) {
        return is(new IOSWeb(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Safari browser on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Safari browser on iOS
     */
    public static boolean isIOSSafari(WebDriver wd) {
        return is(new IOSSafari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on iOS
     */
    public static boolean isIOSNative(WebDriver wd) {
        return is(new IOSNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Android
     */
    public static boolean isAndroid(WebDriver wd) {
        return is(new Android(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on Android
     */
    public static boolean isAndroidWeb(WebDriver wd) {
        return is(new AndroidWeb(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for Chrome browser on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Chrome browser on Android
     */
    public static boolean isAndroidChrome(WebDriver wd) {
        return is(new AndroidChrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on Android
     */
    public static boolean isAndroidNative(WebDriver wd) {
        return is(new AndroidNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's iOS or Android
     */
    public static boolean isMobile(WebDriver wd) {
        return is(new Mobile(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on iOS or Android
     */
    public static boolean isMobileWeb(WebDriver wd) {
        return is(new MobileWeb(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on iOS or Android
     */
    public static boolean isMobileNative(WebDriver wd) {
        return is(new MobileNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on macOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on macOS
     */
    public static boolean isMacOSNative(WebDriver wd) {
        return is(new MacOSNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app on Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on Windows
     */
    public static boolean isWindowsNative(WebDriver wd) {
        return is(new WindowsNative(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on any a PC platform
     * (a browser or native app on macOS, Linux or Windows).
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's PC platform
     */
    public static boolean isPC(WebDriver wd) {
        return is(new PC(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on macOS, Linux or Windows
     */
    public static boolean isPCWeb(WebDriver wd) {
        return is(new PCWeb());
    }

    // ------------------------------------

    protected static boolean is(WebDriverChecker wdc, Object... args) {
        if (!(wdc instanceof Alive)) {
            if (!is(new Alive(), args)) {
                throw new NoSuchWDSession();
            }
        }
        return wdc.check(args);
    }

    // ------------------------------------

    protected abstract boolean check(Object[] args);

    // ------------------------------------

    protected String getPlatformName(Object... args) {
        String value = getCapability(PLATFORM_NAME, args);
        return value.toLowerCase();
    }

    protected String getBrowserName(Object... args) {
        String value = getCapability(BROWSER_NAME, args);
        return value.replaceAll("\\s+", "").toLowerCase();
    }

    protected double getBrowserVersion(Object... args) {
        String value = getCapability(BROWSER_VERSION, args);
        if (value.isEmpty()) {
            value = getCapability(VERSION, args);
        }
        if (value.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(value.split("\\.")[0]);
    }

    protected String getAppPackage(Object... args) {
        String value = getCapability(APP_PACKAGE, args);
        return value.toLowerCase();
    }

    protected boolean hasCapability(String name, Object... args) {
        List<String> names = new ArrayList<>(getCapabilities(args).getCapabilityNames());
        for (String n : names) {
            if (n.equalsIgnoreCase(name)) return true;
        }
        return false;
    }

    protected boolean isValidCapability(String name, Object... args) {
        return !getCapability(name, args).isEmpty();
    }

    protected String getCapability(String name, Object... args) {
        Object value = getCapabilities(args).getCapability(name);
        return String.valueOf(Optional.ofNullable(value).orElse(""));
    }

    protected Capabilities getCapabilities(Object... args) {
        WebDriver wd = getWD(args);
        if (!(wd instanceof HasCapabilities)) {
            throw new NoSuchCapabilities();
        }
        return ((HasCapabilities) wd).getCapabilities();
    }

    // ------------------------------------

    protected WebDriver getWD(Object... args) {
        if (args.length == 0) {
            return getServiceWD();
        }
        return getArgumentWD(args);
    }

    protected WebDriver getServiceWD() {
        ServiceLoader<WebDriverService> service = load(WebDriverService.class);
        Iterator<WebDriverService> serviceLoaders = service.iterator();

        if (!serviceLoaders.hasNext()) {
            throw new NoSuchServiceWD();
        }
        return serviceLoaders.next().serve();
    }

    protected WebDriver getArgumentWD(Object... args) {
        if (args.length != 0) {
            Object value = Optional
                    .ofNullable(args[0])
                    .orElseThrow(NullArgumentWD::new);
            if (value instanceof WebDriver) {
                return (WebDriver) value;
            }
            throw new NoneArgumentWD();
        }
        throw new NoSuchArgumentWD();
    }

    protected RemoteWebDriver getRemoteWD(Object... args) {
        return ((RemoteWebDriver) getWD(args));
    }
}
