package com.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

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
        return whether(new State.Alive(true));
    }

    /**
     * Check whether the current {@linkplain WebDriver} is remote
     *
     * @return true if remote
     */
    public static boolean isRemote() {
        return whether(new State.Remote());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code IE}
     *
     * @return true if {@code IE}
     */
    public static boolean isIE() {
        return whether(new Selenium.IE());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Edge}
     *
     * @return true if {@code Edge}
     */
    public static boolean isEdge() {
        return whether(new Selenium.Edge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Opera}
     *
     * @return true if {@code Opera}
     */
    public static boolean isOpera() {
        return whether(new Selenium.Opera());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari}
     *
     * @return true if {@code Safari}
     */
    public static boolean isSafari() {
        return whether(new Selenium.Safari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome}
     *
     * @return true if {@code Chrome}
     */
    public static boolean isChrome() {
        return whether(new Selenium.Chrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Firefox}
     *
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox() {
        return whether(new Selenium.Firefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Legacy Edge (Edge HTML)}
     *
     * @return true if {@code Legacy Edge}
     */
    public static boolean isEdgeLegacy() {
        return whether(new Selenium.LegacyEdge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Legacy Firefox (lower than version 48)}
     *
     * @return true if {@code Legacy Firefox}
     */
    public static boolean isFirefoxLegacy() {
        return whether(new Selenium.LegacyFirefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS}
     *
     * @return true if {@code iOS}
     */
    public static boolean isIOS() {
        return whether(new Appium.IOS());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code iOS}
     *
     * @return true if {@code Native application} on {@code iOS}
     */
    public static boolean isIOSApp() {
        return whether(new Appium.IOSApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari() {
        return whether(new Appium.IOSSafari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Android}
     *
     * @return true if {@code Android}
     */
    public static boolean isAndroid() {
        return whether(new Appium.Android());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code Android}
     *
     * @return true if {@code Native application} on {@code Android}
     */
    public static boolean isAndroidApp() {
        return whether(new Appium.AndroidApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome() {
        return whether(new Appium.AndroidChrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS} or {@code Android}
     *
     * @return true if {@code iOS} or {@code Android}
     */
    public static boolean isMobile() {
        return whether(new Appium.Mobile());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code IOS} or {@code Android}
     *
     * @return true if {@code Native application} on {@code IOS} or {@code Android}
     */
    public static boolean isMobileApp() {
        return whether(new Appium.MobileApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     *
     * @return true if {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     */
    public static boolean isMobileWeb() {
        return whether(new Appium.MobileBrowser());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Windows application}
     *
     * @return true if {@code Windows application}
     */
    public static boolean isWindowsApp() {
        return whether(new Appium.WindowsApp());
    }

    // ------------

    /**
     * Check whether {@linkplain WebDriver} is not quit
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if running
     */
    public static boolean isAlive(WebDriver wd) {
        return whether(new State.Alive(true), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is remote
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if remote
     */
    public static boolean isRemote(WebDriver wd) {
        return whether(new State.Remote(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code IE}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code IE}
     */
    public static boolean isIE(WebDriver wd) {
        return whether(new Selenium.IE(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Edge}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Edge}
     */
    public static boolean isEdge(WebDriver wd) {
        return whether(new Selenium.Edge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Opera}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Opera}
     */
    public static boolean isOpera(WebDriver wd) {
        return whether(new Selenium.Opera(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Safari}
     */
    public static boolean isSafari(WebDriver wd) {
        return whether(new Selenium.Safari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Chrome}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Chrome}
     */
    public static boolean isChrome(WebDriver wd) {
        return whether(new Selenium.Chrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Firefox}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox(WebDriver wd) {
        return whether(new Selenium.Firefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Legacy Edge (Edge HTML)}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Legacy Edge}
     */
    public static boolean isEdgeLegacy(WebDriver wd) {
        return whether(new Selenium.LegacyEdge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Legacy Firefox (lower than version 48)}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Legacy Firefox}
     */
    public static boolean isFirefoxLegacy(WebDriver wd) {
        return whether(new Selenium.LegacyFirefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code iOS}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code iOS}
     */
    public static boolean isIOS(WebDriver wd) {
        return whether(new Appium.IOS(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code iOS}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Native application} on {@code iOS}
     */
    public static boolean isIOSApp(WebDriver wd) {
        return whether(new Appium.IOSApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari(WebDriver wd) {
        return whether(new Appium.IOSSafari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Android}
     */
    public static boolean isAndroid(WebDriver wd) {
        return whether(new Appium.Android(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Native application} on {@code Android}
     */
    public static boolean isAndroidApp(WebDriver wd) {
        return whether(new Appium.AndroidApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome(WebDriver wd) {
        return whether(new Appium.AndroidChrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code IOS} or {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code IOS} or {@code Android}
     */
    public static boolean isMobile(WebDriver wd) {
        return whether(new Appium.Mobile(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code iOS} or {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Native application} on {@code iOS} or {@code Android}
     */
    public static boolean isMobileApp(WebDriver wd) {
        return whether(new Appium.MobileApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     */
    public static boolean isMobileWeb(WebDriver wd) {
        return whether(new Appium.MobileBrowser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Windows application}
     *
     * @param wd is the current {@linkplain WebDriver}
     * @return true if {@code Windows application}
     */
    public static boolean isWindowsApp(WebDriver wd) {
        return whether(new Appium.WindowsApp(), wd);
    }

    // ------------

    protected static boolean whether(WebDriverChecker wdc, Object... args) {
        if (!(wdc instanceof State.Alive)) {
            if (!whether(new State.Alive(), args)) {
                throw new NoSuchWDSession();
            }
        }
        return wdc.check(args);
    }

    // ------------

    protected abstract boolean check(Object[] args);

    // ------------

    protected String getPlatformName(Object... args) {
        String value = getCapability("platformName", args);
        return value.toLowerCase();
    }

    protected String getBrowserName(Object... args) {
        String value = getCapability("browserName", args);
        return value.replaceAll("\\s+", "").toLowerCase();
    }

    protected double getBrowserVersion(Object... args) {
        String value = getCapability("browserVersion", args);
        if (value.isEmpty()) {
            value = getCapability("version", args);
        }
        return Double.parseDouble(value.split("\\.")[0]);
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

    // ------------

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
