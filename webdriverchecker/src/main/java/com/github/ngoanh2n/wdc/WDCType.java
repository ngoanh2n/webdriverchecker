package com.github.ngoanh2n.wdc;

import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.service.DriverCommandExecutor;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.ngoanh2n.wdc.WDCEx.NoSuchWebDriverSession;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
class WDCType {
    static class MacOS extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("mac");
        }
    }

    static class Linux extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("linux");
        }
    }

    static class Windows extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("windows");
        }
    }

    static class PC extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new MacOS(), args) || is(new Linux(), args) || is(new Windows(), args);
        }
    }

    static class IOS extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("ios");
        }
    }

    static class Android extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getPlatformName(args).equals("android");
        }
    }

    static class Mobile extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) || is(new Android(), args);
        }
    }

    // ------------------------------------------------

    static class Alive extends WebDriverChecker {
        private final boolean directed;

        Alive() {
            this(false);
        }

        Alive(boolean directed) {
            this.directed = directed;
        }

        @Override
        protected boolean check(Object... args) {
            try {
                return getWD(args).getSessionId() != null;
            } catch (NoSuchWebDriverSession exception) {
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
        protected boolean check(Object... args) {
            host = host == null ? getServerURL(args).getHost() : host;
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
        protected boolean check(Object... args) {
            CommandExecutor ce = getWD(args).getCommandExecutor();
            return !(ce instanceof DriverCommandExecutor);
        }
    }

    static class Docker extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            if (isRunning() && is(new Local(), args)) {
                String regex = String.format("^(map.*)(0.0.0.0 %s)(.*)$", getServerURL(args).getPort());
                String[] outputs = runShell("docker inspect -f {{.NetworkSettings.Ports}} $(docker ps -aq)");

                for (String output : outputs) {
                    if (output.trim().matches(regex)) {
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(output.trim());

                        if (matcher.matches()) {
                            String host = matcher.group(2).split("\\s+")[0];
                            return is(new Local(host), args);
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
        protected boolean check(Object... args) {
            return !getBrowserName(args).isEmpty();
        }
    }

    static class Native extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            if (!getApp(args).isEmpty()) {
                return true;
            }
            if (!getAppPackage(args).isEmpty()) {
                if (is(new Android(), args)) {
                    return !getAppPackage(args).equals("com.android.chrome");
                }
                return true;
            }
            return false;
        }
    }

    // ------------------------------------------------

    static class Chrome extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("chrome");
        }
    }

    static class Safari extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("safari");
        }
    }

    static class Firefox extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("firefox");
        }
    }

    static class Edge extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("msedge");
        }
    }

    static class Opera extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("opera");
        }
    }

    static class IE extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("internetexplorer");
        }
    }

    static class LegacyEdge extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserName(args).equals("microsoftedge");
        }
    }

    static class LegacyFirefox extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return getBrowserVersion(args) < 48 && is(new Firefox(), args);
        }
    }

    // ------------------------------------------------

    static class PCBrowser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new PC(), args) && is(new Browser(), args);
        }
    }

    static class PCNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new PC(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------------------

    static class MacOSNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new MacOS(), args) && is(new Native(), args);
        }
    }

    static class WindowsNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Windows(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------------------

    static class IOSBrowser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Browser(), args);
        }
    }

    static class IOSNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new IOS(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------------------

    static class AndroidBrowser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Browser(), args);
        }
    }

    static class AndroidNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Android(), args) && is(new Native(), args);
        }
    }

    // ------------------------------------------------

    static class MobileBrowser extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Mobile(), args) && is(new Browser(), args);
        }
    }

    static class MobileNative extends WebDriverChecker {
        @Override
        protected boolean check(Object... args) {
            return is(new Mobile(), args) && is(new Native(), args);
        }
    }
}
