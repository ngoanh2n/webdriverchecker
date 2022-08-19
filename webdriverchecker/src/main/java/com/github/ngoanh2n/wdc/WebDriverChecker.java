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
     * Check whether the current {@linkplain WebDriver} is not quit
     *
     * @return true if running
     */
    public static boolean isAlive() {
        return is(new Alive(true));
    }

    /**
     * Check whether the current {@linkplain WebDriver} is running remotely
     *
     * @return true if running remotely
     */
    public static boolean isRemote() {
        return is(new Remote());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome}
     *
     * @return true if {@code Chrome}
     */
    public static boolean isChrome() {
        return is(new Chrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari}
     *
     * @return true if {@code Safari}
     */
    public static boolean isSafari() {
        return is(new Safari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Firefox}
     *
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox() {
        return is(new Firefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Edge}
     *
     * @return true if {@code Edge}
     */
    public static boolean isEdge() {
        return is(new Edge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Opera}
     *
     * @return true if {@code Opera}
     */
    public static boolean isOpera() {
        return is(new Opera());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code IE}
     *
     * @return true if {@code IE}
     */
    public static boolean isIE() {
        return is(new IE());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code legacy Edge (Edge HTML)}
     *
     * @return true if {@code legacy Edge}
     */
    public static boolean isEdgeLegacy() {
        return is(new LegacyEdge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code legacy Firefox (lower than version 48)}
     *
     * @return true if {@code legacy Firefox}
     */
    public static boolean isFirefoxLegacy() {
        return is(new LegacyFirefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} on {@code iOS}
     *
     * @return true if {@code iOS}
     */
    public static boolean isIOS() {
        return is(new IOS());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for any {@code browser} on {@code iOS}
     *
     * @return true if it was a {@code browser} on {@code iOS}
     */
    public static boolean isIOSWeb() {
        return is(new IOSWeb());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari() {
        return is(new IOSSafari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code iOS}
     *
     * @return true if {@code native app} on {@code iOS}
     */
    public static boolean isIOSNative() {
        return is(new IOSNative());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Android}
     *
     * @return true if {@code Android}
     */
    public static boolean isAndroid() {
        return is(new Android());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for any {@code browser} on {@code Android}
     *
     * @return true if it was a {@code browser} on {@code Android}
     */
    public static boolean isAndroidWeb() {
        return is(new AndroidWeb());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome() {
        return is(new AndroidChrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code Android}
     *
     * @return true if {@code native app} on {@code Android}
     */
    public static boolean isAndroidNative() {
        return is(new AndroidNative());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS}/{@code Android}
     *
     * @return true if {@code iOS}/{@code Android}
     */
    public static boolean isMobile() {
        return is(new Mobile());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for any {@code browser} on {@code iOS}/{@code Android}
     *
     * @return true if it was a {@code browser} on {@code iOS}/{@code Android}
     */
    public static boolean isMobileWeb() {
        return is(new MobileWeb());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code iOS}/{@code Android}
     *
     * @return true if {@code native app} on {@code iOS}/{@code Android}
     */
    public static boolean isMobileNative() {
        return is(new MobileNative());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code Mac}
     *
     * @return true if {@code native app} on {@code Mac}
     */
    public static boolean isMacNative() {
        return is(new MacNative());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code Windows}
     *
     * @return true if {@code native app} on {@code Windows}
     */
    public static boolean isWindowsNative() {
        return is(new WindowsNative());
    }

    // ------------------------------------

    /**
     * Check whether the current {@linkplain WebDriver} is not quit
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if running
     */
    public static boolean isAlive(WebDriver wd) {
        return is(new Alive(true), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} is running remotely
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if running remotely
     */
    public static boolean isRemote(WebDriver wd) {
        return is(new Remote(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Chrome}
     */
    public static boolean isChrome(WebDriver wd) {
        return is(new Chrome(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Safari}
     */
    public static boolean isSafari(WebDriver wd) {
        return is(new Safari(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Firefox}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox(WebDriver wd) {
        return is(new Firefox(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Edge}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Edge}
     */
    public static boolean isEdge(WebDriver wd) {
        return is(new Edge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Opera}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Opera}
     */
    public static boolean isOpera(WebDriver wd) {
        return is(new Opera(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code IE}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code IE}
     */
    public static boolean isIE(WebDriver wd) {
        return is(new IE(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code legacy Edge (Edge HTML)}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code legacy Edge}
     */
    public static boolean isEdgeLegacy(WebDriver wd) {
        return is(new LegacyEdge(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code legacy Firefox (lower than version 48)}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code legacy Firefox}
     */
    public static boolean isFirefoxLegacy(WebDriver wd) {
        return is(new LegacyFirefox(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code iOS}
     */
    public static boolean isIOS(WebDriver wd) {
        return is(new IOS(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for any {@code browser} on {@code iOS}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if it was a {@code browser} on {@code iOS}
     */
    public static boolean isIOSWeb(WebDriver wd) {
        return is(new IOSWeb(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari(WebDriver wd) {
        return is(new IOSSafari(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code iOS}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code native app} on {@code iOS}
     */
    public static boolean isIOSNative(WebDriver wd) {
        return is(new IOSNative(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Android}
     */
    public static boolean isAndroid(WebDriver wd) {
        return is(new Android(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for any {@code browser} on {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if it was a {@code browser} on {@code Android}
     */
    public static boolean isAndroidWeb(WebDriver wd) {
        return is(new AndroidWeb(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome(WebDriver wd) {
        return is(new AndroidChrome(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code native app} on {@code Android}
     */
    public static boolean isAndroidNative(WebDriver wd) {
        return is(new AndroidNative(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS}/{@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code iOS}/{@code Android}
     */
    public static boolean isMobile(WebDriver wd) {
        return is(new Mobile(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for any {@code browser} on {@code iOS}/{@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if it was a {@code browser} on {@code iOS}/{@code Android}
     */
    public static boolean isMobileWeb(WebDriver wd) {
        return is(new MobileWeb(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code iOS}/{@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code native app} on {@code iOS}/{@code Android}
     */
    public static boolean isMobileNative(WebDriver wd) {
        return is(new MobileNative(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code Mac}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code native app} on {@code Mac}
     */
    public static boolean isMacNative(WebDriver wd) {
        return is(new MacNative(), wd);
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code native app} on {@code Windows}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code native app} on {@code Windows}
     */
    public static boolean isWindowsNative(WebDriver wd) {
        return is(new WindowsNative(), wd);
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
