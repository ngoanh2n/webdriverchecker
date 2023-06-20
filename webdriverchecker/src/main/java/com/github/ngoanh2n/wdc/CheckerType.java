package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.TracedCommandExecutor;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * List of {@link WebDriverChecker} implementations.<br><br>
 *
 * <em>Repository:</em>
 * <ul>
 *     <li><em>GitHub: <a href="https://github.com/ngoanh2n/webdriverchecker">ngoanh2n/webdriverchecker</a></em></li>
 *     <li><em>Maven: <a href="https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker">com.github.ngoanh2n:webdriverchecker</a></em></li>
 * </ul>
 *
 * @author ngoanh2n
 * @since 2020
 */
class CheckerType {
    static class MacOS extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getPlatformName(driver).equals("mac");
        }
    }

    static class Linux extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getPlatformName(driver).equals("linux");
        }
    }

    static class Windows extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getPlatformName(driver).equals("windows");
        }
    }

    static class PC extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new MacOS(), driver) || is(new Linux(), driver) || is(new Windows(), driver);
        }
    }

    static class IOS extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getPlatformName(driver).equals("ios");
        }
    }

    static class Android extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getPlatformName(driver).equals("android");
        }
    }

    static class Mobile extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new IOS(), driver) || is(new Android(), driver);
        }
    }

    //-------------------------------------------------------------------------------//

    static class Alive extends WebDriverChecker {
        private final boolean directed;

        Alive() {
            this(false);
        }

        Alive(boolean directed) {
            this.directed = directed;
        }

        @Override
        protected boolean check(WebDriver... driver) {
            try {
                return getDriver(driver).getSessionId() != null;
            } catch (RuntimeError exception) {
                if (directed) {
                    return false;
                }
                throw exception;
            }
        }
    }

    static class Local extends WebDriverChecker {
        private String host;

        Local() {
        }

        Local(String host) {
            this.host = host;
        }

        @Override
        protected boolean check(WebDriver... driver) {
            host = host == null ? getServerURL(driver).getHost() : host;
            try {
                InetAddress address = InetAddress.getByName(host);
                if (address.isAnyLocalAddress() || address.isLoopbackAddress()) {
                    return true;
                }
                return NetworkInterface.getByInetAddress(address) != null;
            } catch (Exception ignored) {
                return false;
            }
        }
    }

    static class Remote extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            CommandExecutor ce = getDriver(driver).getCommandExecutor();
            return !(ce instanceof DriverCommandExecutor);
        }
    }

    static class Docker extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            if (isRunning() && is(new Local(), driver)) {
                String regex = String.format("^(map.*)(0.0.0.0 %s)(.*)$", getServerURL(driver).getPort());
                String[] outputs = runShell("docker inspect -f {{.NetworkSettings.Ports}} $(docker ps -aq)");

                for (String output : outputs) {
                    if (output.trim().matches(regex)) {
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(output.trim());

                        if (matcher.matches()) {
                            String host = matcher.group(2).split("\\s+")[0];
                            return is(new Local(host), driver);
                        }
                    }
                }
            }
            return false;
        }

        protected boolean isRunning() {
            if (Arrays.toString(runShell("docker -v")).contains("Docker version")) {
                String[] outputs = runShell("docker inspect -f {{.State.Status}} $(docker ps -aq)");
                return outputs[0].matches("(exited|running)");
            }
            return false;
        }
    }

    static class Browser extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return !getBrowserName(driver).isEmpty();
        }
    }

    static class Native extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            if (!getApp(driver).isEmpty()) {
                return true;
            }
            if (!getAppPackage(driver).isEmpty()) {
                if (is(new Android(), driver)) {
                    return !getAppPackage(driver).equals("com.android.chrome");
                }
                return true;
            }
            return false;
        }
    }

    //-------------------------------------------------------------------------------//

    static class Chrome extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserName(driver).equals("chrome");
        }
    }

    static class Safari extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserName(driver).equals("safari");
        }
    }

    static class Firefox extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserName(driver).equals("firefox");
        }
    }

    static class Edge extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserName(driver).equals("msedge");
        }
    }

    static class Opera extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserName(driver).equals("opera");
        }
    }

    static class IE extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserName(driver).equals("internetexplorer");
        }
    }

    static class LegacyEdge extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserName(driver).equals("microsoftedge");
        }
    }

    static class LegacyFirefox extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return getBrowserVersion(driver) < 48 && is(new Firefox(), driver);
        }
    }

    //-------------------------------------------------------------------------------//

    static class PCBrowser extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new PC(), driver) && is(new Browser(), driver);
        }
    }

    static class PCNative extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new PC(), driver) && is(new Native(), driver);
        }
    }

    //-------------------------------------------------------------------------------//

    static class MacOSNative extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new MacOS(), driver) && is(new Native(), driver);
        }
    }

    static class WindowsNative extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new Windows(), driver) && is(new Native(), driver);
        }
    }

    //-------------------------------------------------------------------------------//

    static class LocalServer extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            if (is(new Local(), driver)) {
                CommandExecutor ce = getDriver(driver).getCommandExecutor();
                if (ce instanceof DriverCommandExecutor) {
                    return true;
                }
                String aceName = "io.appium.java_client.remote.AppiumCommandExecutor";
                return ce.getClass().getName().equals(aceName);
            }
            return false;
        }
    }

    static class RemoteServer extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            if (!is(new Local(), driver)) {
                CommandExecutor ce = getDriver(driver).getCommandExecutor();
                return ce instanceof HttpCommandExecutor || ce instanceof TracedCommandExecutor;
            }
            return false;
        }
    }

    //-------------------------------------------------------------------------------//

    static class IOSBrowser extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new IOS(), driver) && is(new Browser(), driver);
        }
    }

    static class IOSNative extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new IOS(), driver) && is(new Native(), driver);
        }
    }

    static class IOSVirtual extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new IOS(), driver) && is(new MobileVirtual(), driver);
        }
    }

    //-------------------------------------------------------------------------------//

    static class AndroidBrowser extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new Android(), driver) && is(new Browser(), driver);
        }
    }

    static class AndroidNative extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new Android(), driver) && is(new Native(), driver);
        }
    }

    static class AndroidVirtual extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new Android(), driver) && is(new MobileVirtual(), driver);
        }
    }

    //-------------------------------------------------------------------------------//

    static class MobileBrowser extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new Mobile(), driver) && is(new Browser(), driver);
        }
    }

    static class MobileNative extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            return is(new Mobile(), driver) && is(new Native(), driver);
        }
    }

    static class MobileVirtual extends WebDriverChecker {
        @Override
        protected boolean check(WebDriver... driver) {
            if (is(new Mobile(), driver)) {
                String deviceId = getDeviceId(driver);
                String[] connectedDeviceIds = getConnectedVDIds(driver);
                return Arrays.asList(connectedDeviceIds).contains(deviceId);
            }
            return false;
        }

        protected String[] getConnectedVDIds(WebDriver... driver) {
            String command = is(new Android(), driver)
                    ? "adb devices"
                    : "xcrun simctl list";
            String regex = is(new Android(), driver)
                    ? "^(emulator-\\d{4})(.*)$"
                    : "^(.*) \\((.*)\\) \\((Booted)\\)$";

            String[] outputs = runShell(command);
            LinkedList<String> deviceIds = new LinkedList<>();

            for (String output : outputs) {
                if (output.trim().matches(regex)) {
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(output.trim());

                    if (matcher.matches()) {
                        int position = is(new Android(), driver) ? 1 : 2;
                        String deviceId = matcher.group(position);
                        deviceIds.add(deviceId);
                    }
                }
            }
            return deviceIds.toArray(new String[]{});
        }
    }

    //-------------------------------------------------------------------------------//

    static class LambdaTest extends Cloud {
        @Override
        String regex() {
            return "^(hub.)(lambdatest.com)$";
        }
    }

    static class BrowserStack extends Cloud {
        @Override
        String regex() {
            return "^(hub.)(browserstack.com)$";
        }
    }

    static class SauceLabs extends Cloud {
        @Override
        String regex() {
            return "^(ondemand.)(.*)(.saucelabs.com)$";
        }
    }

    static class TestingBot extends Cloud {
        @Override
        String regex() {
            return "^(hub.)(testingbot.com)$";
        }
    }

    static abstract class Cloud extends WebDriverChecker {

        abstract String regex();

        @Override
        protected boolean check(WebDriver... driver) {
            if (is(new Remote(), driver)) {
                URL serverURL = getServerURL(driver);
                return serverURL.getHost().matches(regex());
            }
            return false;
        }
    }
}
