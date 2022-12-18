package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.Commons;
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

import static com.github.ngoanh2n.wdc.WDCEx.*;
import static com.github.ngoanh2n.wdc.WDCType.Browser;
import static com.github.ngoanh2n.wdc.WDCType.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.ServiceLoader.load;

/**
 * Check characteristics and environment for current {@linkplain WebDriver}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public abstract class WebDriverChecker {
    /**
     * Check whether {@linkplain WebDriver} on macOS.
     *
     * @return true if it's macOS
     */
    public static boolean isMacOS() {
        return is(new MacOS());
    }

    /**
     * Check whether {@linkplain WebDriver} on Linux.
     *
     * @return true if it's Linux
     */
    public static boolean isLinux() {
        return is(new Linux());
    }

    /**
     * Check whether {@linkplain WebDriver} on Windows.
     *
     * @return true if it's Windows
     */
    public static boolean isWindows() {
        return is(new Windows());
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
     * Check whether {@linkplain WebDriver} on iOS.
     *
     * @return true if it's iOS
     */
    public static boolean isIOS() {
        return is(new IOS());
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
     * Check whether {@linkplain WebDriver} on iOS or Android.
     *
     * @return true if it's iOS or Android
     */
    public static boolean isMobile() {
        return is(new Mobile());
    }

    /**
     * Check whether {@linkplain WebDriver} is alive.
     *
     * @return true if it's alive
     */
    public static boolean isAlive() {
        return is(new Alive(true));
    }

    /**
     * Check whether {@linkplain WebDriver} is running locally.
     *
     * @return true if it's running locally
     */
    public static boolean isLocal() {
        return is(new Local());
    }

    /**
     * Check whether {@linkplain WebDriver} is running remotely.
     * Client is connecting to cloud (BrowserStack, SauceLabs...), Selenium Grid, Appium Server.
     *
     * @return true if it's running remotely
     */
    public static boolean isRemote() {
        return is(new Remote());
    }

    /**
     * Check whether {@linkplain WebDriver} is running in local Docker.
     *
     * @return true if it's running in local Docker
     */
    public static boolean isDocker() {
        return is(new Docker());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser.
     *
     * @return true if it's a browser
     */
    public static boolean isBrowser() {
        return is(new Browser());
    }

    /**
     * Check whether {@linkplain WebDriver} for native app.
     *
     * @return true if it's a native app
     */
    public static boolean isNative() {
        return is(new Native());
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
     * Check whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @return true if it's a browser on macOS, Linux or Windows
     */
    public static boolean isPCBrowser() {
        return is(new PCBrowser());
    }

    /**
     * Check whether {@linkplain WebDriver} for a native app on macOS or Windows.
     *
     * @return true if it's a native app on macOS or Windows
     */
    public static boolean isPCNative() {
        return is(new PCNative());
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
     * Check whether {@linkplain WebDriver} is connecting to a local server.
     *
     * @return true if it's connecting to a local server
     */
    public static boolean isLocalServer() {
        return is(new LocalServer());
    }

    /**
     * Check whether {@linkplain WebDriver} is connecting to a remote server.
     *
     * @return true if it's connecting to a remote server
     */
    public static boolean isRemoteServer() {
        return is(new RemoteServer());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @return true if it's a browser on iOS
     */
    public static boolean isIOSBrowser() {
        return is(new IOSBrowser());
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
     * Check whether {@linkplain WebDriver} is running on iOS simulator.
     *
     * @return true if it's running on iOS virtual device
     */
    public static boolean isIOSVirtual() {
        return is(new IOSVirtual());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on Android.
     *
     * @return true if it's a browser on Android
     */
    public static boolean isAndroidBrowser() {
        return is(new AndroidBrowser());
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
     * Check whether {@linkplain WebDriver} is running on Android emulator.
     *
     * @return true if it's running on Android virtual device
     */
    public static boolean isAndroidVirtual() {
        return is(new AndroidVirtual());
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @return true if it's a browser on iOS or Android
     */
    public static boolean isMobileBrowser() {
        return is(new MobileBrowser());
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
     * Check whether {@linkplain WebDriver} is running on iOS simulator or Android emulator.
     *
     * @return true if it's running on mobile virtual device
     */
    public static boolean isMobileVirtual() {
        return is(new MobileVirtual());
    }

    /**
     * Check whether {@linkplain WebDriver} is running on LambdaTest.
     *
     * @return true if it's running on LambdaTest
     */
    public static boolean isLambdaTest() {
        return is(new LambdaTest());
    }

    /**
     * Check whether {@linkplain WebDriver} is running on BrowserStack.
     *
     * @return true if it's running on BrowserStack
     */
    public static boolean isBrowserStack() {
        return is(new BrowserStack());
    }

    /**
     * Check whether {@linkplain WebDriver} is running on SauceLabs.
     *
     * @return true if it's running on SauceLabs
     */
    public static boolean isSauceLabs() {
        return is(new SauceLabs());
    }

    /**
     * Check whether {@linkplain WebDriver} is running on TestingBot.
     *
     * @return true if it's running on TestingBot
     */
    public static boolean isTestingBot() {
        return is(new TestingBot());
    }

    // ------------------------------------------------

    /**
     * Check whether {@linkplain WebDriver} on macOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's macOS
     */
    public static boolean isMacOS(WebDriver wd) {
        return is(new MacOS(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on Linux.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Linux
     */
    public static boolean isLinux(WebDriver wd) {
        return is(new Linux(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} on Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's Windows
     */
    public static boolean isWindows(WebDriver wd) {
        return is(new Windows(), wd);
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
     * Check whether {@linkplain WebDriver} on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's iOS
     */
    public static boolean isIOS(WebDriver wd) {
        return is(new IOS(), wd);
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
     * Check whether {@linkplain WebDriver} on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's iOS or Android
     */
    public static boolean isMobile(WebDriver wd) {
        return is(new Mobile(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is alive.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's alive
     */
    public static boolean isAlive(WebDriver wd) {
        return is(new Alive(true), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running locally.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running locally
     */
    public static boolean isLocal(WebDriver wd) {
        return is(new Local(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running remotely.
     * Client is connecting to cloud (BrowserStack, SauceLabs...), Selenium Grid, Appium Server.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running remotely
     */
    public static boolean isRemote(WebDriver wd) {
        return is(new Remote(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running in local Docker.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running in local Docker
     */
    public static boolean isDocker(WebDriver wd) {
        return is(new Docker(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser
     */
    public static boolean isBrowser(WebDriver wd) {
        return is(new Browser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for native app.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app
     */
    public static boolean isNative(WebDriver wd) {
        return is(new Native(), wd);
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
     * Check whether {@linkplain WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on macOS, Linux or Windows
     */
    public static boolean isPCBrowser(WebDriver wd) {
        return is(new PCBrowser(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a native app on macOS or Windows.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a native app on macOS or Windows
     */
    public static boolean isPCNative(WebDriver wd) {
        return is(new PCNative(), wd);
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
     * Check whether {@linkplain WebDriver} is connecting to a local server.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's connecting to a local server
     */
    public static boolean isLocalServer(WebDriver wd) {
        return is(new LocalServer(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is connecting to a remote server.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's connecting to a remote server
     */
    public static boolean isRemoteServer(WebDriver wd) {
        return is(new RemoteServer(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on iOS
     */
    public static boolean isIOSBrowser(WebDriver wd) {
        return is(new IOSBrowser(), wd);
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
     * Check whether {@linkplain WebDriver} is running on iOS simulator.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running on iOS virtual device
     */
    public static boolean isIOSVirtual(WebDriver wd) {
        return is(new IOSVirtual(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on Android
     */
    public static boolean isAndroidBrowser(WebDriver wd) {
        return is(new AndroidBrowser(), wd);
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
     * Check whether {@linkplain WebDriver} is running on Android emulator.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running on Android virtual device
     */
    public static boolean isAndroidVirtual(WebDriver wd) {
        return is(new AndroidVirtual(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} for a browser on iOS or Android.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's a browser on iOS or Android
     */
    public static boolean isMobileBrowser(WebDriver wd) {
        return is(new MobileBrowser(), wd);
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
     * Check whether {@linkplain WebDriver} is running on iOS simulator or Android emulator.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running on mobile virtual device
     */
    public static boolean isMobileVirtual(WebDriver wd) {
        return is(new MobileVirtual(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running on LambdaTest.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running on LambdaTest
     */
    public static boolean isLambdaTest(WebDriver wd) {
        return is(new LambdaTest(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running on BrowserStack.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running on BrowserStack
     */
    public static boolean isBrowserStack(WebDriver wd) {
        return is(new BrowserStack(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running on SauceLabs.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running on SauceLabs
     */
    public static boolean isSauceLabs(WebDriver wd) {
        return is(new SauceLabs(), wd);
    }

    /**
     * Check whether {@linkplain WebDriver} is running on TestingBot.
     *
     * @param wd is current {@linkplain WebDriver}
     * @return true if it's running on TestingBot
     */
    public static boolean isTestingBot(WebDriver wd) {
        return is(new TestingBot(), wd);
    }

    // ------------------------------------------------

    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverChecker.class);

    protected static boolean is(WebDriverChecker wdc, Object... args) {
        if (!(wdc instanceof Alive)) {
            if (!is(new Alive(), args)) {
                throw new NoSuchWebDriverSession();
            }
        }
        return wdc.check(args);
    }

    protected static String[] runShell(String command) {
        try {
            String[] commandArgs = System.getProperty("os.name").contains("Windows")
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

    // ------------------------------------------------

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

    protected String getBrowserName(Object... args) {
        String value = getCapability("browserName", args);
        return value.replaceAll("\\s+", "").toLowerCase();
    }

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

    protected String getApp(Object... args) {
        String value = getCapability("app", args);
        return value.toLowerCase();
    }

    protected String getAppPackage(Object... args) {
        String value = getCapability("appPackage", args);
        return value.toLowerCase();
    }

    protected String getDeviceId(Object... args) {
        if (is(new IOS(), args)) {
            return getCapability("appium:udid", args);
        }
        if (is(new Android(), args)) {
            return getCapability("appium:deviceUDID", args);
        }
        return "";
    }

    protected URL getServerURL(Object... args) {
        CommandExecutor ce = getWD(args).getCommandExecutor();
        if (ce instanceof TracedCommandExecutor) {
            ce = Commons.getPrivateValue(TracedCommandExecutor.class, ce, "delegate");
        }
        return Commons.getPrivateValue(HttpCommandExecutor.class, ce, "remoteServer");
    }

    protected Response runCommand(Command command, CommandInfo info, Object... args) {
        String url = Commons.getPrivateValue(CommandInfo.class, info, "url");
        HttpMethod method = Commons.getPrivateValue(CommandInfo.class, info, "method");
        getCommandCodec(args).defineCommand(command.getName(), method, url);

        try {
            return getWD(args).getCommandExecutor().execute(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected CommandCodec<HttpRequest> getCommandCodec(Object... args) {
        CommandExecutor ce = getWD(args).getCommandExecutor();
        return Commons.getPrivateValue(HttpCommandExecutor.class, ce, "commandCodec");
    }

    protected String getCapability(String name, Object... args) {
        Object value = getCapabilities(args).getCapability(name);
        return String.valueOf(Optional.ofNullable(value).orElse(""));
    }

    protected Capabilities getCapabilities(Object... args) {
        WebDriver wd = getWD(args);
        if (wd == null) {
            throw new NoSuchCapabilities();
        }
        return ((HasCapabilities) wd).getCapabilities();
    }

    protected RemoteWebDriver getWD(Object... args) {
        if (args.length != 0) {
            Object value = Optional
                    .ofNullable(args[0])
                    .orElseThrow(NullArgumentWebDriver::new);

            if (!(value instanceof WebDriver)) {
                LOGGER.error("WebDriver from args");
                throw new NoneArgumentWebDriver();
            }
            return (RemoteWebDriver) value;
        } else {
            ServiceLoader<WebDriverProvider> providers = load(WebDriverProvider.class);
            Iterator<WebDriverProvider> serviceLoaders = providers.iterator();

            if (!serviceLoaders.hasNext()) {
                LOGGER.error("WebDriver from ServiceLoader");
                throw new NoSuchWebDriverProvider();
            }

            WebDriverProvider wdProvider = serviceLoaders.next();
            WebDriver wd = wdProvider.provide();

            if (wd == null) {
                String msgService = "WebDriver from ServiceLoader {}";
                String providerName = wdProvider.getClass().getName();
                LOGGER.error(msgService, providerName);
                throw new NoSuchWebDriverProvider();
            }
            return (RemoteWebDriver) wd;
        }
    }

    // ------------------------------------------------

    protected abstract boolean check(Object... args);
}
