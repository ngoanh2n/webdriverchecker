package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.Commons;
import com.github.ngoanh2n.Prop;
import com.github.ngoanh2n.RuntimeError;
import com.google.common.io.CharStreams;
import io.netty.handler.codec.http.HttpRequest;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

import static com.github.ngoanh2n.wdc.WDCType.Browser;
import static com.github.ngoanh2n.wdc.WDCType.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.ServiceLoader.load;

/**
 * Check characteristics and environment for current {@linkplain WebDriver}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public abstract class WebDriverChecker {
    /**
     * Checks whether {@linkplain WebDriver} on macOS.
     *
     * @return true if it's macOS.
     */
    public static boolean isMacOS() {
        return is(new MacOS());
    }

    /**
     * Checks whether {@linkplain WebDriver} on Linux.
     *
     * @return true if it's Linux.
     */
    public static boolean isLinux() {
        return is(new Linux());
    }

    /**
     * Checks whether {@linkplain WebDriver} on Windows.
     *
     * @return true if it's Windows.
     */
    public static boolean isWindows() {
        return is(new Windows());
    }

    /**
     * Checks whether {@linkplain WebDriver} on any a PC platform
     * (a browser or native app on macOS, Linux or Windows).
     *
     * @return true if it's PC platform.
     */
    public static boolean isPC() {
        return is(new PC());
    }

    /**
     * Checks whether {@linkplain WebDriver} on iOS.
     *
     * @return true if it's iOS.
     */
    public static boolean isIOS() {
        return is(new IOS());
    }

    /**
     * Checks whether {@linkplain WebDriver} on Android.
     *
     * @return true if it's Android.
     */
    public static boolean isAndroid() {
        return is(new Android());
    }

    /**
     * Checks whether {@linkplain WebDriver} on iOS or Android.
     *
     * @return true if it's iOS or Android.
     */
    public static boolean isMobile() {
        return is(new Mobile());
    }

    /**
     * Checks whether {@linkplain WebDriver} is alive.
     *
     * @return true if it's alive.
     */
    public static boolean isAlive() {
        return is(new Alive(true));
    }

    /**
     * Checks whether {@linkplain WebDriver} is running locally.
     *
     * @return true if it's running locally.
     */
    public static boolean isLocal() {
        return is(new Local());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running remotely.
     * Client is connecting to cloud (BrowserStack, SauceLabs...), Selenium Grid, Appium Server.
     *
     * @return true if it's running remotely.
     */
    public static boolean isRemote() {
        return is(new Remote());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running in local Docker.
     *
     * @return true if it's running in local Docker.
     */
    public static boolean isDocker() {
        return is(new Docker());
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser.
     *
     * @return true if it's a browser.
     */
    public static boolean isBrowser() {
        return is(new Browser());
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app.
     *
     * @return true if it's a native app.
     */
    public static boolean isNative() {
        return is(new Native());
    }

    /**
     * Checks whether {@linkplain WebDriver} for Chrome browser
     * on any platform (Chrome on macOS, Linux, Windows, Android).
     *
     * @return true if it's Chrome browser.
     */
    public static boolean isChrome() {
        return is(new Chrome());
    }

    /**
     * Checks whether {@linkplain WebDriver} for Safari browser
     * on any platform (Safari on macOS, iOS).
     *
     * @return true if it's Safari browser.
     */
    public static boolean isSafari() {
        return is(new Safari());
    }

    /**
     * Checks whether {@linkplain WebDriver} for Firefox browser
     * on any platform (Firefox on macOS, Linux, Windows).
     *
     * @return true if it's Firefox browser.
     */
    public static boolean isFirefox() {
        return is(new Firefox());
    }

    /**
     * Checks whether {@linkplain WebDriver} for Edge browser
     * on any platform (Edge on macOS, Linux, Windows).
     *
     * @return true if it's Edge browser.
     */
    public static boolean isEdge() {
        return is(new Edge());
    }

    /**
     * Checks whether {@linkplain WebDriver} for Opera browser
     * on any platform (Opera on macOS, Linux, Windows).
     *
     * @return true if it's Opera browser.
     */
    public static boolean isOpera() {
        return is(new Opera());
    }

    /**
     * Checks whether {@linkplain WebDriver} for IE browser.
     *
     * @return true if it's IE browser.
     */
    public static boolean isIE() {
        return is(new IE());
    }

    /**
     * Checks whether {@linkplain WebDriver} for legacy {@code Edge} (Edge HTML) browser.
     *
     * @return true if it's legacy Edge browser.
     */
    public static boolean isEdgeLegacy() {
        return is(new LegacyEdge());
    }

    /**
     * Checks whether {@linkplain WebDriver} for legacy {@code Firefox} (lower than version 48) browser.
     *
     * @return true if it's legacy Firefox browser.
     */
    public static boolean isFirefoxLegacy() {
        return is(new LegacyFirefox());
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @return true if it's a browser on macOS, Linux or Windows.
     */
    public static boolean isPCBrowser() {
        return is(new PCBrowser());
    }

    /**
     * Checks whether {@linkplain WebDriver} for a native app on macOS or Windows.
     *
     * @return true if it's a native app on macOS or Windows.
     */
    public static boolean isPCNative() {
        return is(new PCNative());
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on macOS.
     *
     * @return true if it's a native app on macOS.
     */
    public static boolean isMacOSNative() {
        return is(new MacOSNative());
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on Windows.
     *
     * @return true if it's a native app on Windows.
     */
    public static boolean isWindowsNative() {
        return is(new WindowsNative());
    }

    /**
     * Checks whether {@linkplain WebDriver} is connecting to a local server.
     *
     * @return true if it's connecting to a local server.
     */
    public static boolean isLocalServer() {
        return is(new LocalServer());
    }

    /**
     * Checks whether {@linkplain WebDriver} is connecting to a remote server.
     *
     * @return true if it's connecting to a remote server.
     */
    public static boolean isRemoteServer() {
        return is(new RemoteServer());
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @return true if it's a browser on iOS.
     */
    public static boolean isIOSBrowser() {
        return is(new IOSBrowser());
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on iOS.
     *
     * @return true if it's a native app on iOS.
     */
    public static boolean isIOSNative() {
        return is(new IOSNative());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on iOS simulator.
     *
     * @return true if it's running on iOS virtual device.
     */
    public static boolean isIOSVirtual() {
        return is(new IOSVirtual());
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on Android.
     *
     * @return true if it's a browser on Android.
     */
    public static boolean isAndroidBrowser() {
        return is(new AndroidBrowser());
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on Android.
     *
     * @return true if it's a native app on Android.
     */
    public static boolean isAndroidNative() {
        return is(new AndroidNative());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on Android emulator.
     *
     * @return true if it's running on Android virtual device.
     */
    public static boolean isAndroidVirtual() {
        return is(new AndroidVirtual());
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @return true if it's a browser on iOS or Android.
     */
    public static boolean isMobileBrowser() {
        return is(new MobileBrowser());
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on iOS or Android.
     *
     * @return true if it's a native app on iOS or Android.
     */
    public static boolean isMobileNative() {
        return is(new MobileNative());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on iOS simulator or Android emulator.
     *
     * @return true if it's running on mobile virtual device.
     */
    public static boolean isMobileVirtual() {
        return is(new MobileVirtual());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on LambdaTest.
     *
     * @return true if it's running on LambdaTest.
     */
    public static boolean isLambdaTest() {
        return is(new LambdaTest());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on BrowserStack.
     *
     * @return true if it's running on BrowserStack.
     */
    public static boolean isBrowserStack() {
        return is(new BrowserStack());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on SauceLabs.
     *
     * @return true if it's running on SauceLabs.
     */
    public static boolean isSauceLabs() {
        return is(new SauceLabs());
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on TestingBot.
     *
     * @return true if it's running on TestingBot.
     */
    public static boolean isTestingBot() {
        return is(new TestingBot());
    }

    //===============================================================================//

    /**
     * Checks whether {@linkplain WebDriver} on macOS.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's macOS.
     */
    public static boolean isMacOS(WebDriver wd) {
        return is(new MacOS(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} on Linux.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Linux.
     */
    public static boolean isLinux(WebDriver wd) {
        return is(new Linux(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} on Windows.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Windows.
     */
    public static boolean isWindows(WebDriver wd) {
        return is(new Windows(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} on any a PC platform
     * (a browser or native app on macOS, Linux or Windows).
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's PC platform.
     */
    public static boolean isPC(WebDriver wd) {
        return is(new PC(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} on iOS.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's iOS.
     */
    public static boolean isIOS(WebDriver wd) {
        return is(new IOS(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} on Android.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Android.
     */
    public static boolean isAndroid(WebDriver wd) {
        return is(new Android(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} on iOS or Android.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's iOS or Android.
     */
    public static boolean isMobile(WebDriver wd) {
        return is(new Mobile(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is alive.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's alive.
     */
    public static boolean isAlive(WebDriver wd) {
        return is(new Alive(true), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running locally.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running locally.
     */
    public static boolean isLocal(WebDriver wd) {
        return is(new Local(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running remotely.
     * Client is connecting to cloud (BrowserStack, SauceLabs...), Selenium Grid, Appium Server.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running remotely.
     */
    public static boolean isRemote(WebDriver wd) {
        return is(new Remote(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running in local Docker.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running in local Docker.
     */
    public static boolean isDocker(WebDriver wd) {
        return is(new Docker(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a browser.
     */
    public static boolean isBrowser(WebDriver wd) {
        return is(new Browser(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a native app.
     */
    public static boolean isNative(WebDriver wd) {
        return is(new Native(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for Chrome browser
     * on any platform (Chrome on macOS, Linux, Windows, Android).
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Chrome browser.
     */
    public static boolean isChrome(WebDriver wd) {
        return is(new Chrome(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for Safari browser
     * on any platform (Safari on macOS, iOS).
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Safari browser.
     */
    public static boolean isSafari(WebDriver wd) {
        return is(new Safari(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for Firefox browser
     * on any platform (Firefox on macOS, Linux, Windows).
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Firefox browser.
     */
    public static boolean isFirefox(WebDriver wd) {
        return is(new Firefox(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for Edge browser
     * on any platform (Edge on macOS, Linux, Windows).
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Edge browser.
     */
    public static boolean isEdge(WebDriver wd) {
        return is(new Edge(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for Opera browser
     * on any platform (Opera on macOS, Linux, Windows).
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's Opera browser.
     */
    public static boolean isOpera(WebDriver wd) {
        return is(new Opera(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for IE browser.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's IE browser.
     */
    public static boolean isIE(WebDriver wd) {
        return is(new IE(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for legacy {@code Edge} (Edge HTML) browser.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's legacy Edge browser.
     */
    public static boolean isEdgeLegacy(WebDriver wd) {
        return is(new LegacyEdge(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for legacy {@code Firefox} (lower than version 48) browser.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's legacy Firefox browser.
     */
    public static boolean isFirefoxLegacy(WebDriver wd) {
        return is(new LegacyFirefox(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a browser on macOS, Linux or Windows.
     */
    public static boolean isPCBrowser(WebDriver wd) {
        return is(new PCBrowser(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for a native app on macOS or Windows.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a native app on macOS or Windows.
     */
    public static boolean isPCNative(WebDriver wd) {
        return is(new PCNative(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on macOS.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a native app on macOS.
     */
    public static boolean isMacOSNative(WebDriver wd) {
        return is(new MacOSNative(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on Windows.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a native app on Windows.
     */
    public static boolean isWindowsNative(WebDriver wd) {
        return is(new WindowsNative(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is connecting to a local server.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's connecting to a local server.
     */
    public static boolean isLocalServer(WebDriver wd) {
        return is(new LocalServer(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is connecting to a remote server.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's connecting to a remote server.
     */
    public static boolean isRemoteServer(WebDriver wd) {
        return is(new RemoteServer(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a browser on iOS.
     */
    public static boolean isIOSBrowser(WebDriver wd) {
        return is(new IOSBrowser(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on iOS.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a native app on iOS.
     */
    public static boolean isIOSNative(WebDriver wd) {
        return is(new IOSNative(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on iOS simulator.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running on iOS virtual device.
     */
    public static boolean isIOSVirtual(WebDriver wd) {
        return is(new IOSVirtual(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on Android.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a browser on Android.
     */
    public static boolean isAndroidBrowser(WebDriver wd) {
        return is(new AndroidBrowser(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on Android.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a native app on Android.
     */
    public static boolean isAndroidNative(WebDriver wd) {
        return is(new AndroidNative(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on Android emulator.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running on Android virtual device.
     */
    public static boolean isAndroidVirtual(WebDriver wd) {
        return is(new AndroidVirtual(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a browser on iOS or Android.
     */
    public static boolean isMobileBrowser(WebDriver wd) {
        return is(new MobileBrowser(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} for native app on iOS or Android.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's a native app on iOS or Android.
     */
    public static boolean isMobileNative(WebDriver wd) {
        return is(new MobileNative(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on iOS simulator or Android emulator.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running on mobile virtual device.
     */
    public static boolean isMobileVirtual(WebDriver wd) {
        return is(new MobileVirtual(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on LambdaTest.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running on LambdaTest.
     */
    public static boolean isLambdaTest(WebDriver wd) {
        return is(new LambdaTest(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on BrowserStack.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running on BrowserStack.
     */
    public static boolean isBrowserStack(WebDriver wd) {
        return is(new BrowserStack(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on SauceLabs.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running on SauceLabs.
     */
    public static boolean isSauceLabs(WebDriver wd) {
        return is(new SauceLabs(), wd);
    }

    /**
     * Checks whether {@linkplain WebDriver} is running on TestingBot.
     *
     * @param wd The current {@linkplain WebDriver}.
     * @return true if it's running on TestingBot.
     */
    public static boolean isTestingBot(WebDriver wd) {
        return is(new TestingBot(), wd);
    }

    //===============================================================================//

    private static final Logger log = LoggerFactory.getLogger(WebDriverChecker.class);

    /**
     * Runs a Shell command.
     *
     * @param command The command to run.
     * @return Lines of the result are in print at the terminal.
     */
    protected static String[] runShell(String command) {
        try {
            String os = Prop.string("os.name").getValue();
            String[] commandArgs = os.contains("Windows")
                    ? new String[]{"cmd.exe", "/c", command}
                    : new String[]{"bash", "-c", command};
            Process process = new ProcessBuilder(commandArgs)
                    .directory(new File("."))
                    .redirectErrorStream(false)
                    .start();
            process.waitFor();

            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, UTF_8);
            return CharStreams.toString(isr).split("\r?\n|\r");
        } catch (Exception e) {
            return new String[]{};
        }
    }

    /**
     * Gets current {@linkplain WebDriver}.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty.
     * @return The current {@linkplain WebDriver}.
     */
    protected static RemoteWebDriver getWD(Object... args) {
        if (args.length != 0) {
            Object value = args[0];
            if (value == null) {
                String msg = "WebDriver is null";
                log.error(msg);
                throw new RuntimeError(msg);
            }
            if (!(value instanceof WebDriver)) {
                String msg = "WebDriver is invalid";
                log.error(msg);
                throw new RuntimeError(msg);
            }
            return (RemoteWebDriver) value;
        } else {
            String wdpName = WebDriverProvider.class.getName();
            ServiceLoader<WebDriverProvider> serviceLoader = load(WebDriverProvider.class);
            Iterator<WebDriverProvider> serviceLoaders = serviceLoader.iterator();

            if (!serviceLoaders.hasNext()) {
                String msg = String.format("%s implementation not found", wdpName);
                log.error(msg);
                throw new RuntimeError(msg);
            }

            WebDriverProvider wdp = serviceLoaders.next();
            WebDriver wd = wdp.provide();

            if (wd == null | !(is(new Alive(), wd))) {
                wdpName = wdp.getClass().getName();
                String msg = String.format("%s provides null", wdpName);
                log.error(msg);
                throw new RuntimeError(msg);
            }
            return (RemoteWebDriver) wd;
        }
    }

    /**
     * Checks logic of {@code WebDriverChecker} implementation.
     *
     * @param wdc  A {@code WebDriverChecker} implementation.
     * @param args {@linkplain WebDriver} for the first argument, and can be empty.
     * @return Boolean result.
     */
    protected static boolean is(WebDriverChecker wdc, Object... args) {
        if (!(wdc instanceof Alive)) {
            if (!is(new Alive(), args)) {
                String msg = "WebDriver is null or quit";
                log.error(msg);
                throw new RuntimeError(msg);
            }
        }
        return wdc.check(args);
    }

    //===============================================================================//

    /**
     * Default constructor.
     */
    protected WebDriverChecker() { /* No implementation necessary */ }

    /**
     * Gets platform name of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return Platform name.
     */
    protected String getPlatformName(Object... args) {
        String value = getCapability("platformName", args);
        Platform platform = Platform.valueOf(value);

        if (platform.equals(Platform.ANY)) {
            value = getCapability("platform", args);
            try {
                platform = Platform.valueOf(value);
            } catch (IllegalArgumentException ignored) {
                platform = Platform.fromString(value);
            }
        }

        if (platform.family() != null && !platform.equals(Platform.LINUX)) {
            platform = platform.family();
        }
        return platform.name().toLowerCase();
    }

    /**
     * Gets browser name of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return Browser name.
     */
    protected String getBrowserName(Object... args) {
        String value = getCapability("browserName", args);
        return value.replaceAll("\\s+", "").toLowerCase();
    }

    /**
     * Gets browser version of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return Browser version.
     */
    protected double getBrowserVersion(Object... args) {
        String value = getCapability("browserVersion", args);
        if (value.isEmpty()) {
            value = getCapability("version", args);
        }
        if (value.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(value.split("\\.")[0]);
    }

    /**
     * Gets app name or path of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return App name or path.
     */
    protected String getApp(Object... args) {
        String value = getCapability("app", args);
        return value.toLowerCase();
    }

    /**
     * Gets app package of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return App package.
     */
    protected String getAppPackage(Object... args) {
        String value = getCapability("appPackage", args);
        return value.toLowerCase();
    }

    /**
     * Gets device ID of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return Device ID.
     */
    protected String getDeviceId(Object... args) {
        if (is(new IOS(), args)) {
            return getCapability("appium:udid", args);
        }
        if (is(new Android(), args)) {
            return getCapability("appium:deviceUDID", args);
        }
        return "";
    }

    /**
     * Gets server URL of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return Server URL.
     */
    protected URL getServerURL(Object... args) {
        CommandExecutor ce = getWD(args).getCommandExecutor();
        if (ce instanceof TracedCommandExecutor) {
            ce = Commons.readField(ce, "delegate");
        }
        return Commons.readField(ce, "remoteServer");
    }

    /**
     * Gets a capability value of {@linkplain WebDriver} is running on.
     *
     * @param name The capability to return.
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return Capability value.
     */
    protected String getCapability(String name, Object... args) {
        Object value = getCapabilities(args).getCapability(name);
        return String.valueOf(Optional.ofNullable(value).orElse(""));
    }

    /**
     * Gets {@linkplain Capabilities} of {@linkplain WebDriver} is running on.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return {@linkplain Capabilities} object.
     */
    protected Capabilities getCapabilities(Object... args) {
        WebDriver wd = getWD(args);
        return ((HasCapabilities) wd).getCapabilities();
    }

    /**
     * Gets {@linkplain CommandCodec} of {@linkplain WebDriver}.
     *
     * @param args {@linkplain WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return {@linkplain CommandCodec} object.
     */
    protected CommandCodec<HttpRequest> getCommandCodec(Object... args) {
        CommandExecutor ce = getWD(args).getCommandExecutor();
        return Commons.readField(ce, "commandCodec");
    }

    /**
     * Runs a Selenium command.
     *
     * @param command {@linkplain Command} object to send to the server.
     * @param info    {@linkplain CommandInfo} object to provide URL and {@linkplain HttpMethod}.
     * @param args    {@code WebDriver} for the first argument, and can be empty. <br>
     *                {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return {@linkplain Response} object.
     */
    protected Response runCommand(Command command, CommandInfo info, Object... args) {
        String url = Commons.readField(info, "url");
        HttpMethod method = Commons.readField(info, "method");
        getCommandCodec(args).defineCommand(command.getName(), method, url);

        try {
            return getWD(args).getCommandExecutor().execute(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //===============================================================================//

    /**
     * Checks logic of {@code WebDriverChecker} implementation.
     *
     * @param args {@code WebDriver} for the first argument, and can be empty. <br>
     *             {@code WebDriverChecker} doesn't care from the second argument onwards.
     * @return Boolean result.
     */
    protected abstract boolean check(Object... args);
}
