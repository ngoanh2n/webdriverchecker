package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class WebDriverChecker {

    public static boolean isIE() {
        return InstanceChecker.execute(new IEInstance());
    }

    public static boolean isEdge() {
        return InstanceChecker.execute(new EdgeInstance());
    }

    public static boolean isOpera() {
        return InstanceChecker.execute(new OperaInstance());
    }

    public static boolean isChrome() {
        return InstanceChecker.execute(new ChromeInstance());
    }

    public static boolean isSafari() {
        return InstanceChecker.execute(new SafariInstance());
    }

    public static boolean isFirefox() {
        return InstanceChecker.execute(new FirefoxInstance());
    }
}
