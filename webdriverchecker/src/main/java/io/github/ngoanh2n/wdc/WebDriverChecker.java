package io.github.ngoanh2n.wdc;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

import static io.github.ngoanh2n.wdc.Appium.*;
import static io.github.ngoanh2n.wdc.Selenium.*;
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
        return WebDriverChecker.whether(new Alive());
    }

    /**
     * Check whether the current {@linkplain WebDriver} is remote
     *
     * @return true if remote
     */
    public static boolean isRemote() {
        return WebDriverChecker.whether(new Remote());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code IE}
     *
     * @return true if {@code IE}
     */
    public static boolean isIE() {
        return WebDriverChecker.whether(new IE());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Edge}
     *
     * @return true if {@code Edge}
     */
    public static boolean isEdge() {
        return WebDriverChecker.whether(new Edge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Opera}
     *
     * @return true if {@code Opera}
     */
    public static boolean isOpera() {
        return WebDriverChecker.whether(new Opera());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari}
     *
     * @return true if {@code Safari}
     */
    public static boolean isSafari() {
        return WebDriverChecker.whether(new Safari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome}
     *
     * @return true if {@code Chrome}
     */
    public static boolean isChrome() {
        return WebDriverChecker.whether(new Chrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Firefox}
     *
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox() {
        return WebDriverChecker.whether(new Firefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Legacy Edge (Edge HTML)}
     *
     * @return true if {@code Legacy Edge}
     */
    public static boolean isEdgeLegacy() {
        return WebDriverChecker.whether(new LegacyEdge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Legacy Firefox (lower than version 48)}
     *
     * @return true if {@code Legacy Firefox}
     */
    public static boolean isFirefoxLegacy() {
        return WebDriverChecker.whether(new LegacyFirefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS}
     *
     * @return true if {@code iOS}
     */
    public static boolean isIOS() {
        return WebDriverChecker.whether(new IOS());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code iOS}
     *
     * @return true if {@code Native application} on {@code iOS}
     */
    public static boolean isIOSApp() {
        return WebDriverChecker.whether(new IOSApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari() {
        return WebDriverChecker.whether(new IOSSafari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Android}
     *
     * @return true if {@code Android}
     */
    public static boolean isAndroid() {
        return WebDriverChecker.whether(new Android());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code Android}
     *
     * @return true if {@code Native application} on {@code Android}
     */
    public static boolean isAndroidApp() {
        return WebDriverChecker.whether(new AndroidApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome() {
        return WebDriverChecker.whether(new AndroidChrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS} or {@code Android}
     *
     * @return true if {@code iOS} or {@code Android}
     */
    public static boolean isMobile() {
        return WebDriverChecker.whether(new Mobile());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code IOS} or {@code Android}
     *
     * @return true if {@code Native application} on {@code IOS} or {@code Android}
     */
    public static boolean isMobileApp() {
        return WebDriverChecker.whether(new MobileApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     *
     * @return true if {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     */
    public static boolean isMobileWeb() {
        return WebDriverChecker.whether(new MobileBrowser());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Windows application}
     *
     * @return true if {@code Windows application}
     */
    public static boolean isWindowsApp() {
        return WebDriverChecker.whether(new WindowsApp());
    }

    // ------------

    /**
     * Check whether {@linkplain WebDriver} is not quit
     *
     * @return true if running
     */
    public static boolean isAlive(WebDriver wd) {
        return WebDriverChecker.whether(new Alive(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is remote
     *
     * @return true if remote
     */
    public static boolean isRemote(WebDriver wd) {
        return WebDriverChecker.whether(new Remote(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code IE}
     *
     * @return true if {@code IE}
     */
    public static boolean isIE(WebDriver wd) {
        return WebDriverChecker.whether(new IE(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Edge}
     *
     * @return true if {@code Edge}
     */
    public static boolean isEdge(WebDriver wd) {
        return WebDriverChecker.whether(new Edge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Opera}
     *
     * @return true if {@code Opera}
     */
    public static boolean isOpera(WebDriver wd) {
        return WebDriverChecker.whether(new Opera(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari}
     *
     * @return true if {@code Safari}
     */
    public static boolean isSafari(WebDriver wd) {
        return WebDriverChecker.whether(new Safari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Chrome}
     *
     * @return true if {@code Chrome}
     */
    public static boolean isChrome(WebDriver wd) {
        return WebDriverChecker.whether(new Chrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Firefox}
     *
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox(WebDriver wd) {
        return WebDriverChecker.whether(new Firefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Legacy Edge (Edge HTML)}
     *
     * @return true if {@code Legacy Edge}
     */
    public static boolean isEdgeLegacy(WebDriver wd) {
        return WebDriverChecker.whether(new LegacyEdge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Legacy Firefox (lower than version 48)}
     *
     * @return true if {@code Legacy Firefox}
     */
    public static boolean isFirefoxLegacy(WebDriver wd) {
        return WebDriverChecker.whether(new LegacyFirefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code iOS}
     *
     * @return true if {@code iOS}
     */
    public static boolean isIOS(WebDriver wd) {
        return WebDriverChecker.whether(new IOS(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code iOS}
     *
     * @return true if {@code Native application} on {@code iOS}
     */
    public static boolean isIOSApp(WebDriver wd) {
        return WebDriverChecker.whether(new IOSApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari(WebDriver wd) {
        return WebDriverChecker.whether(new IOSSafari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Android}
     *
     * @return true if {@code Android}
     */
    public static boolean isAndroid(WebDriver wd) {
        return WebDriverChecker.whether(new Android(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code Android}
     *
     * @return true if {@code Native application} on {@code Android}
     */
    public static boolean isAndroidApp(WebDriver wd) {
        return WebDriverChecker.whether(new AndroidApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome(WebDriver wd) {
        return WebDriverChecker.whether(new AndroidChrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code IOS} or {@code Android}
     *
     * @return true if {@code IOS} or {@code Android}
     */
    public static boolean isMobile(WebDriver wd) {
        return WebDriverChecker.whether(new Mobile(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code iOS} or {@code Android}
     *
     * @return true if {@code Native application} on {@code iOS} or {@code Android}
     */
    public static boolean isMobileApp(WebDriver wd) {
        return WebDriverChecker.whether(new MobileApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     *
     * @return true if {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     */
    public static boolean isMobileWeb(WebDriver wd) {
        return WebDriverChecker.whether(new MobileBrowser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Windows application}
     *
     * @return true if {@code Windows application}
     */
    public static boolean isWindowsApp(WebDriver wd) {
        return WebDriverChecker.whether(new WindowsApp(), wd);
    }

    // ------------

    protected static boolean whether(WebDriverChecker wdc, Object... args) {
        if (!(wdc instanceof Alive)) {
            if (!whether(new Alive(), args)) {
                throw new WDCException.NoSuchWDSession();
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
        return Double.parseDouble(value.split("\\.")[0]);
    }

    protected String getCapability(String name, Object... args) {
        Object value = getCapabilities(args).getCapability(name);
        return String.valueOf(Optional.ofNullable(value).orElse(""));
    }

    protected Capabilities getCapabilities(Object... args) {
        WebDriver wd = getWD(args);
        if (wd instanceof HasCapabilities) {
            return ((HasCapabilities) wd).getCapabilities();
        } else {
            throw new WDCException.NoSuchCapabilities();
        }
    }

    // ------------

    protected RemoteWebDriver getRemoteWD(Object... args) {
        return ((RemoteWebDriver) getWD(args));
    }

    protected WebDriver getWD(Object... args) {
        if (args.length == 0) {
            return getServiceWD();
        } else {
            return getArgumentWD(args);
        }
    }

    protected WebDriver getServiceWD() {
        ServiceLoader<WebDriverService> service = load(WebDriverService.class);
        Iterator<WebDriverService> serviceLoaders = service.iterator();

        if (serviceLoaders.hasNext()) {
            return serviceLoaders.next().serve();
        } else {
            throw new WDCException.NoSuchServiceWD();
        }
    }

    protected WebDriver getArgumentWD(Object... args) {
        if (args.length == 0) {
            throw new WDCException.NoSuchArgumentWD();
        } else {
            Object value = Optional
                    .ofNullable(args[0])
                    .orElseThrow(WDCException.NullArgumentWD::new);
            if (value instanceof WebDriver) {
                return (WebDriver) value;
            } else {
                throw new WDCException.NoneArgumentWD();
            }
        }
    }
}
