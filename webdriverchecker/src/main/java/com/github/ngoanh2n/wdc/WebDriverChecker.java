package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.Commons;
import com.github.ngoanh2n.Property;
import com.google.common.io.CharStreams;
import io.netty.handler.codec.http.HttpRequest;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.http.HttpMethod;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
import java.util.ServiceLoader;

import static com.github.ngoanh2n.wdc.CheckerType.Browser;
import static com.github.ngoanh2n.wdc.CheckerType.*;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Check characteristics and environment for the current {@link WebDriver}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public abstract class WebDriverChecker {
    /**
     * Default constructor.
     */
    protected WebDriverChecker() { /* No implementation necessary */ }

    //-------------------------------------------------------------------------------//

    /**
     * Check whether {@link WebDriver} on macOS.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's macOS.
     */
    public static boolean isMacOS(WebDriver... driver) {
        return is(new MacOS(), driver);
    }

    /**
     * Check whether {@link WebDriver} on Linux.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Linux.
     */
    public static boolean isLinux(WebDriver... driver) {
        return is(new Linux(), driver);
    }

    /**
     * Check whether {@link WebDriver} on Windows.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Windows.
     */
    public static boolean isWindows(WebDriver... driver) {
        return is(new Windows(), driver);
    }

    /**
     * Check whether {@link WebDriver} on any a PC platform
     * (a browser or native app on macOS, Linux or Windows).
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's PC platform.
     */
    public static boolean isPC(WebDriver... driver) {
        return is(new PC(), driver);
    }

    /**
     * Check whether {@link WebDriver} on iOS.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's iOS.
     */
    public static boolean isIOS(WebDriver... driver) {
        return is(new IOS(), driver);
    }

    /**
     * Check whether {@link WebDriver} on Android.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Android.
     */
    public static boolean isAndroid(WebDriver... driver) {
        return is(new Android(), driver);
    }

    /**
     * Check whether {@link WebDriver} on iOS or Android.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's iOS or Android.
     */
    public static boolean isMobile(WebDriver... driver) {
        return is(new Mobile(), driver);
    }

    /**
     * Check whether {@link WebDriver} is alive.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's alive.
     */
    public static boolean isAlive(WebDriver... driver) {
        return is(new Alive(true), driver);
    }

    /**
     * Check whether {@link WebDriver} is running locally.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running locally.
     */
    public static boolean isLocal(WebDriver... driver) {
        return is(new Local(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running remotely.
     * Client is connecting to cloud (BrowserStack, SauceLabs...), Selenium Grid, Appium Server.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running remotely.
     */
    public static boolean isRemote(WebDriver... driver) {
        return is(new Remote(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running in local Docker.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running in local Docker.
     */
    public static boolean isDocker(WebDriver... driver) {
        return is(new Docker(), driver);
    }

    /**
     * Check whether {@link WebDriver} for a browser.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a browser.
     */
    public static boolean isBrowser(WebDriver... driver) {
        return is(new Browser(), driver);
    }

    /**
     * Check whether {@link WebDriver} for native app.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a native app.
     */
    public static boolean isNative(WebDriver... driver) {
        return is(new Native(), driver);
    }

    /**
     * Check whether {@link WebDriver} for Chrome browser
     * on any platform (Chrome on macOS, Linux, Windows, Android).
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Chrome browser.
     */
    public static boolean isChrome(WebDriver... driver) {
        return is(new Chrome(), driver);
    }

    /**
     * Check whether {@link WebDriver} for Safari browser
     * on any platform (Safari on macOS, iOS).
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Safari browser.
     */
    public static boolean isSafari(WebDriver... driver) {
        return is(new Safari(), driver);
    }

    /**
     * Check whether {@link WebDriver} for Firefox browser
     * on any platform (Firefox on macOS, Linux, Windows).
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Firefox browser.
     */
    public static boolean isFirefox(WebDriver... driver) {
        return is(new Firefox(), driver);
    }

    /**
     * Check whether {@link WebDriver} for Edge browser
     * on any platform (Edge on macOS, Linux, Windows).
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Edge browser.
     */
    public static boolean isEdge(WebDriver... driver) {
        return is(new Edge(), driver);
    }

    /**
     * Check whether {@link WebDriver} for Opera browser
     * on any platform (Opera on macOS, Linux, Windows).
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's Opera browser.
     */
    public static boolean isOpera(WebDriver... driver) {
        return is(new Opera(), driver);
    }

    /**
     * Check whether {@link WebDriver} for IE browser.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's IE browser.
     */
    public static boolean isIE(WebDriver... driver) {
        return is(new IE(), driver);
    }

    /**
     * Check whether {@link WebDriver} for legacy {@code Edge} (Edge HTML) browser.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's legacy Edge browser.
     */
    public static boolean isEdgeLegacy(WebDriver... driver) {
        return is(new LegacyEdge(), driver);
    }

    /**
     * Check whether {@link WebDriver} for legacy {@code Firefox} (lower than version 48) browser.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's legacy Firefox browser.
     */
    public static boolean isFirefoxLegacy(WebDriver... driver) {
        return is(new LegacyFirefox(), driver);
    }

    /**
     * Check whether {@link WebDriver} for a browser on macOS, Linux or Windows.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a browser on macOS, Linux or Windows.
     */
    public static boolean isPCBrowser(WebDriver... driver) {
        return is(new PCBrowser(), driver);
    }

    /**
     * Check whether {@link WebDriver} for a native app on macOS or Windows.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a native app on macOS or Windows.
     */
    public static boolean isPCNative(WebDriver... driver) {
        return is(new PCNative(), driver);
    }

    /**
     * Check whether {@link WebDriver} for native app on macOS.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a native app on macOS.
     */
    public static boolean isMacOSNative(WebDriver... driver) {
        return is(new MacOSNative(), driver);
    }

    /**
     * Check whether {@link WebDriver} for native app on Windows.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a native app on Windows.
     */
    public static boolean isWindowsNative(WebDriver... driver) {
        return is(new WindowsNative(), driver);
    }

    /**
     * Check whether {@link WebDriver} is connecting to a local server.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's connecting to a local server.
     */
    public static boolean isLocalServer(WebDriver... driver) {
        return is(new LocalServer(), driver);
    }

    /**
     * Check whether {@link WebDriver} is connecting to a remote server.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's connecting to a remote server.
     */
    public static boolean isRemoteServer(WebDriver... driver) {
        return is(new RemoteServer(), driver);
    }

    /**
     * Check whether {@link WebDriver} for a browser on iOS.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a browser on iOS.
     */
    public static boolean isIOSBrowser(WebDriver... driver) {
        return is(new IOSBrowser(), driver);
    }

    /**
     * Check whether {@link WebDriver} for native app on iOS.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a native app on iOS.
     */
    public static boolean isIOSNative(WebDriver... driver) {
        return is(new IOSNative(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running on iOS simulator.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running on iOS virtual device.
     */
    public static boolean isIOSVirtual(WebDriver... driver) {
        return is(new IOSVirtual(), driver);
    }

    /**
     * Check whether {@link WebDriver} for a browser on Android.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a browser on Android.
     */
    public static boolean isAndroidBrowser(WebDriver... driver) {
        return is(new AndroidBrowser(), driver);
    }

    /**
     * Check whether {@link WebDriver} for native app on Android.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a native app on Android.
     */
    public static boolean isAndroidNative(WebDriver... driver) {
        return is(new AndroidNative(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running on Android emulator.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running on Android virtual device.
     */
    public static boolean isAndroidVirtual(WebDriver... driver) {
        return is(new AndroidVirtual(), driver);
    }

    /**
     * Check whether {@link WebDriver} for a browser on iOS or Android.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a browser on iOS or Android.
     */
    public static boolean isMobileBrowser(WebDriver... driver) {
        return is(new MobileBrowser(), driver);
    }

    /**
     * Check whether {@link WebDriver} for native app on iOS or Android.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's a native app on iOS or Android.
     */
    public static boolean isMobileNative(WebDriver... driver) {
        return is(new MobileNative(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running on iOS simulator or Android emulator.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running on mobile virtual device.
     */
    public static boolean isMobileVirtual(WebDriver... driver) {
        return is(new MobileVirtual(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running on LambdaTest.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running on LambdaTest.
     */
    public static boolean isLambdaTest(WebDriver... driver) {
        return is(new LambdaTest(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running on BrowserStack.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running on BrowserStack.
     */
    public static boolean isBrowserStack(WebDriver... driver) {
        return is(new BrowserStack(), driver);
    }

    /**
     * Check whether {@link WebDriver} is running on SauceLabs.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running on SauceLabs.
     */
    public static boolean isSauceLabs(WebDriver... driver) {
        return is(new SauceLabs(), driver);
    }

    //-------------------------------------------------------------------------------//

    /**
     * Check whether {@link WebDriver} is running on TestingBot.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return true if it's running on TestingBot.
     */
    public static boolean isTestingBot(WebDriver... driver) {
        return is(new TestingBot(), driver);
    }

    /**
     * Run a Shell command.
     *
     * @param command The command to run.
     * @return Lines of the result are in print at the terminal.
     */
    protected static String[] runShell(String command) {
        try {
            String os = Property.ofString("os.name").getValue();
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
     * Get the current {@link WebDriver}.
     *
     * @param args The {@link WebDriver} for the first argument, and can be empty.<br>
     *             {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return The current {@link WebDriver}.
     */
    protected static RemoteWebDriver getDriver(WebDriver... args) {
        if (args.length != 0) {
            if (args[0] != null) {
                return (RemoteWebDriver) args[0];
            }
            throw new CheckerException("You have passed a nullable WebDriver");
        } else {
            ServiceLoader<WebDriverProvider> serviceLoader = ServiceLoader.load(WebDriverProvider.class);
            Iterator<WebDriverProvider> serviceLoaders = serviceLoader.iterator();

            if (serviceLoaders.hasNext()) {
                WebDriverProvider provider = serviceLoaders.next();
                WebDriver driver = provider.provide();

                if (driver == null || !(is(new Alive(), driver))) {
                    String providerName = provider.getClass().getName();
                    throw new CheckerException(providerName + " is providing nullable WebDriver");
                }
                return (RemoteWebDriver) serviceLoaders.next().provide();
            }
            throw new CheckerException("You have not implemented WebDriverProvider");
        }
    }

    //-------------------------------------------------------------------------------//

    /**
     * Check logic of {@code WebDriverChecker} implementation.
     *
     * @param wdc  A {@code WebDriverChecker} implementation.
     * @param args {@link WebDriver} for the first argument, and can be empty.
     * @return Boolean result.
     */
    protected static boolean is(WebDriverChecker wdc, WebDriver... args) {
        if (!(wdc instanceof Alive)) {
            if (!is(new Alive(), args)) {
                throw new CheckerException("WebDriver is null or quit");
            }
        }
        if (args.length == 0) {
            return wdc.check();
        } else {
            return wdc.check(args[0]);
        }
    }

    /**
     * Get platform name of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return Platform name.
     */
    protected String getPlatformName(WebDriver... driver) {
        String value = getCapability("platformName", driver);
        Platform platform = Platform.valueOf(value);

        if (platform.equals(Platform.ANY)) {
            value = getCapability("platform", driver);
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
     * Get browser name of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return Browser name.
     */
    protected String getBrowserName(WebDriver... driver) {
        String value = getCapability("browserName", driver);
        return value.replaceAll("\\s+", "").toLowerCase();
    }

    /**
     * Get browser version of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return Browser version.
     */
    protected double getBrowserVersion(WebDriver... driver) {
        String value = getCapability("browserVersion", driver);
        if (value.isEmpty()) {
            value = getCapability("version", driver);
        }
        if (value.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(value.split("\\.")[0]);
    }

    /**
     * Get app name or path of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return App name or path.
     */
    protected String getApp(WebDriver... driver) {
        String value = getCapability("app", driver);
        return value.toLowerCase();
    }

    /**
     * Get app package of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return App package.
     */
    protected String getAppPackage(WebDriver... driver) {
        String value = getCapability("appPackage", driver);
        return value.toLowerCase();
    }

    /**
     * Get device ID of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return Device ID.
     */
    protected String getDeviceId(WebDriver... driver) {
        if (is(new IOS(), driver)) {
            return getCapability("appium:udid", driver);
        }
        if (is(new Android(), driver)) {
            return getCapability("appium:deviceUDID", driver);
        }
        return "";
    }

    /**
     * Get server URL of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return Server URL.
     */
    protected URL getServerURL(WebDriver... driver) {
        CommandExecutor ce = getDriver(driver).getCommandExecutor();
        if (ce instanceof TracedCommandExecutor) {
            ce = Commons.readField(ce, "delegate");
        }
        return Commons.readField(ce, "remoteServer");
    }

    /**
     * Get a capability value of {@link WebDriver} is running on.
     *
     * @param name   The capability to return.
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return Capability value.
     */
    protected String getCapability(String name, WebDriver... driver) {
        Object value = getCapabilities(driver).getCapability(name);
        return String.valueOf(Optional.ofNullable(value).orElse(""));
    }

    /**
     * Get {@link Capabilities} of {@link WebDriver} is running on.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return {@link Capabilities} object.
     */
    protected Capabilities getCapabilities(WebDriver... driver) {
        WebDriver wd = getDriver(driver);
        return ((HasCapabilities) wd).getCapabilities();
    }

    /**
     * Get {@link CommandCodec} of {@link WebDriver}.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return {@link CommandCodec} object.
     */
    protected CommandCodec<HttpRequest> getCommandCodec(WebDriver... driver) {
        CommandExecutor ce = getDriver(driver).getCommandExecutor();
        return Commons.readField(ce, "commandCodec");
    }

    /**
     * Run a Selenium command.
     *
     * @param command {@link Command} object to send to the server.
     * @param info    {@link CommandInfo} object to provide URL and {@link HttpMethod}.
     * @param driver  The {@link WebDriver} for the first argument, and can be empty.<br>
     *                {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return {@link Response} object.
     */
    protected Response runCommand(Command command, CommandInfo info, WebDriver... driver) {
        String url = Commons.readField(info, "url");
        HttpMethod method = Commons.readField(info, "method");
        getCommandCodec(driver).defineCommand(command.getName(), method, url);

        try {
            return getDriver(driver).getCommandExecutor().execute(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //-------------------------------------------------------------------------------//

    /**
     * Check logic of {@code WebDriverChecker} implementation.
     *
     * @param driver The {@link WebDriver} for the first argument, and can be empty.<br>
     *               {@link WebDriverChecker} doesn't care from the second argument onwards.
     * @return A {@link Boolean} result.
     */
    protected abstract boolean check(WebDriver... driver);
}
