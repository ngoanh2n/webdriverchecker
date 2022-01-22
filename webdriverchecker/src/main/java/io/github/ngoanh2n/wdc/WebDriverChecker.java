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

import static io.github.ngoanh2n.wdc.WebDriverChecker.Type.*;
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
        return WebDriverChecker.is(new Alive());
    }

    /**
     * Check whether the current {@linkplain WebDriver} is remote
     *
     * @return true if remote
     */
    public static boolean isRemote() {
        return WebDriverChecker.is(new Remote());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code IE}
     *
     * @return true if {@code IE}
     */
    public static boolean isIE() {
        return WebDriverChecker.is(new IE());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Edge}
     *
     * @return true if {@code Edge}
     */
    public static boolean isEdge() {
        return WebDriverChecker.is(new Edge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Opera}
     *
     * @return true if {@code Opera}
     */
    public static boolean isOpera() {
        return WebDriverChecker.is(new Opera());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari}
     *
     * @return true if {@code Safari}
     */
    public static boolean isSafari() {
        return WebDriverChecker.is(new Safari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome}
     *
     * @return true if {@code Chrome}
     */
    public static boolean isChrome() {
        return WebDriverChecker.is(new Chrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Firefox}
     *
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox() {
        return WebDriverChecker.is(new Firefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Legacy Edge (Edge HTML)}
     *
     * @return true if {@code Legacy Edge}
     */
    public static boolean isEdgeLegacy() {
        return WebDriverChecker.is(new LegacyEdge());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Legacy Firefox (lower than version 48)}
     *
     * @return true if {@code Legacy Firefox}
     */
    public static boolean isFirefoxLegacy() {
        return WebDriverChecker.is(new LegacyFirefox());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS}
     *
     * @return true if {@code iOS}
     */
    public static boolean isIOS() {
        return WebDriverChecker.is(new IOS());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code iOS}
     *
     * @return true if {@code Native application} on {@code iOS}
     */
    public static boolean isIOSApp() {
        return WebDriverChecker.is(new IOSApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari() {
        return WebDriverChecker.is(new IOSSafari());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Android}
     *
     * @return true if {@code Android}
     */
    public static boolean isAndroid() {
        return WebDriverChecker.is(new Android());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code Android}
     *
     * @return true if {@code Native application} on {@code Android}
     */
    public static boolean isAndroidApp() {
        return WebDriverChecker.is(new AndroidApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome() {
        return WebDriverChecker.is(new AndroidChrome());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code iOS} or {@code Android}
     *
     * @return true if {@code iOS} or {@code Android}
     */
    public static boolean isMobile() {
        return WebDriverChecker.is(new Mobile());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Native application} on {@code IOS} or {@code Android}
     *
     * @return true if {@code Native application} on {@code IOS} or {@code Android}
     */
    public static boolean isMobileApp() {
        return WebDriverChecker.is(new MobileApp());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     *
     * @return true if {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     */
    public static boolean isMobileWeb() {
        return WebDriverChecker.is(new MobileBrowser());
    }

    /**
     * Check whether the current {@linkplain WebDriver} for {@code Windows application}
     *
     * @return true if {@code Windows application}
     */
    public static boolean isWindowsApp() {
        return WebDriverChecker.is(new WindowsApp());
    }

    // ------------

    /**
     * Check whether {@linkplain WebDriver} is not quit
     *
     * @return true if running
     */
    public static boolean isAlive(WebDriver wd) {
        return WebDriverChecker.is(new Alive(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is remote
     *
     * @return true if remote
     */
    public static boolean isRemote(WebDriver wd) {
        return WebDriverChecker.is(new Remote(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code IE}
     *
     * @return true if {@code IE}
     */
    public static boolean isIE(WebDriver wd) {
        return WebDriverChecker.is(new IE(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Edge}
     *
     * @return true if {@code Edge}
     */
    public static boolean isEdge(WebDriver wd) {
        return WebDriverChecker.is(new Edge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Opera}
     *
     * @return true if {@code Opera}
     */
    public static boolean isOpera(WebDriver wd) {
        return WebDriverChecker.is(new Opera(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari}
     *
     * @return true if {@code Safari}
     */
    public static boolean isSafari(WebDriver wd) {
        return WebDriverChecker.is(new Safari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Chrome}
     *
     * @return true if {@code Chrome}
     */
    public static boolean isChrome(WebDriver wd) {
        return WebDriverChecker.is(new Chrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Firefox}
     *
     * @return true if {@code Firefox}
     */
    public static boolean isFirefox(WebDriver wd) {
        return WebDriverChecker.is(new Firefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Legacy Edge (Edge HTML)}
     *
     * @return true if {@code Legacy Edge}
     */
    public static boolean isEdgeLegacy(WebDriver wd) {
        return WebDriverChecker.is(new LegacyEdge(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Legacy Firefox (lower than version 48)}
     *
     * @return true if {@code Legacy Firefox}
     */
    public static boolean isFirefoxLegacy(WebDriver wd) {
        return WebDriverChecker.is(new LegacyFirefox(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code iOS}
     *
     * @return true if {@code iOS}
     */
    public static boolean isIOS(WebDriver wd) {
        return WebDriverChecker.is(new IOS(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code iOS}
     *
     * @return true if {@code Native application} on {@code iOS}
     */
    public static boolean isIOSApp(WebDriver wd) {
        return WebDriverChecker.is(new IOSApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari} on {@code iOS}
     *
     * @return true if {@code Safari} on {@code iOS}
     */
    public static boolean isIOSSafari(WebDriver wd) {
        return WebDriverChecker.is(new IOSSafari(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Android}
     *
     * @return true if {@code Android}
     */
    public static boolean isAndroid(WebDriver wd) {
        return WebDriverChecker.is(new Android(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code Android}
     *
     * @return true if {@code Native application} on {@code Android}
     */
    public static boolean isAndroidApp(WebDriver wd) {
        return WebDriverChecker.is(new AndroidApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Chrome} on {@code Android}
     *
     * @return true if {@code Chrome} on {@code Android}
     */
    public static boolean isAndroidChrome(WebDriver wd) {
        return WebDriverChecker.is(new AndroidChrome(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code IOS} or {@code Android}
     *
     * @return true if {@code IOS} or {@code Android}
     */
    public static boolean isMobile(WebDriver wd) {
        return WebDriverChecker.is(new Mobile(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Native application} on {@code iOS} or {@code Android}
     *
     * @return true if {@code Native application} on {@code iOS} or {@code Android}
     */
    public static boolean isMobileApp(WebDriver wd) {
        return WebDriverChecker.is(new MobileApp(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     *
     * @return true if {@code Safari} on {@code IOS} or {@code Chrome} {@code Android}
     */
    public static boolean isMobileWeb(WebDriver wd) {
        return WebDriverChecker.is(new MobileBrowser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for {@code Windows application}
     *
     * @return true if {@code Windows application}
     */
    public static boolean isWindowsApp(WebDriver wd) {
        return WebDriverChecker.is(new WindowsApp(), wd);
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

    // ------------

    protected abstract boolean execute(Object[] args);

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
            Object value = Optional.ofNullable(args[0])
                    .orElseThrow(WDCException.NullArgumentWD::new);
            if (value instanceof WebDriver) {
                return (WebDriver) value;
            } else {
                throw new WDCException.NoneArgumentWD();
            }
        }
    }

    protected RemoteWebDriver getRemoteWD(Object... args) {
        return ((RemoteWebDriver) getWD(args));
    }

    // ------------------------------------

    protected enum Type {

        // Browsers
        EDGE("msedge"),
        OPERA("opera"),
        SAFARI("safari"),
        CHROME("chrome"),
        FIREFOX("firefox"),
        IE("internetexplorer"),
        EDGE_LEGACY("microsoftedge"),

        // Platforms
        IOS("ios"),
        ANDROID("android"),
        WINDOWS("windows");

        private final String name;

        Type(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    // ------------------------------------

    public static class Alive extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getRemoteWD(args).getSessionId() != null;
        }
    }

    public static class Remote extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            RemoteWebDriver wd = getRemoteWD(args);
            CommandExecutor command = wd.getCommandExecutor();

            if (command instanceof HttpCommandExecutor) {
                return (!(command instanceof DriverCommandExecutor));
            }
            return false;
        }
    }

    public static class IE extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(IE.getName());
        }
    }

    public static class Edge extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(EDGE.getName());
        }
    }

    public static class Opera extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(OPERA.getName());
        }
    }

    public static class Safari extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(SAFARI.getName());
        }
    }

    public static class Chrome extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(CHROME.getName());
        }
    }

    public static class Firefox extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(FIREFOX.getName());
        }
    }

    // ------------------------------------

    public static class LegacyEdge extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getBrowserName(args).equals(EDGE_LEGACY.getName());
        }
    }

    public static class LegacyFirefox extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new Firefox(), args) && getBrowserVersion(args) < 48;
        }
    }

    // ------------------------------------

    public static class IOS extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getPlatformName(args).equals(IOS.getName());
        }
    }

    public static class IOSApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            if (is(new IOS(), args)) {
                return is(new ExistedApp(), args) || !is(new ExistedBrowser(), args);
            }
            return false;
        }
    }

    public static class IOSSafari extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new IOS(), args) && is(new Safari(), args);
        }
    }

    // ------------------------------------

    public static class Android extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getPlatformName(args).equals(ANDROID.getName());
        }
    }

    public static class AndroidApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            if (is(new Android(), args)) {
                return is(new ExistedApp(), args) || !is(new ExistedBrowser(), args);
            }
            return false;
        }
    }

    public static class AndroidChrome extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new Android(), args) && is(new Chrome(), args);
        }
    }

    // ------------------------------------

    public static class Mobile extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new IOS(), args) || is(new Android(), args);
        }
    }

    public static class MobileApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new IOSApp(), args) || is(new AndroidApp(), args);
        }
    }

    public static class MobileBrowser extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return is(new IOSSafari(), args) || is(new AndroidChrome(), args);
        }
    }

    public static class WindowsApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object... args) {
            return getPlatformName(args).equals(WINDOWS.getName()) && !is(new ExistedBrowser(), args);
        }
    }

    // ------------------------------------

    public static class ExistedApp extends WebDriverChecker {

        @Override
        protected boolean execute(Object[] args) {
            return !getCapability("app", args).isEmpty();
        }
    }

    public static class ExistedBrowser extends WebDriverChecker {

        @Override
        protected boolean execute(Object[] args) {
            return !getBrowserName(args).isEmpty();
        }
    }
}
