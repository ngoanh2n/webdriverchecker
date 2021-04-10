package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class WebDriverChecker {

    public static boolean isEdge() {
        return is(new EdgeDriverChecker());
    }

    public static boolean isOpera() {
        return is(new OperaDriverChecker());
    }

    public static boolean isChrome() {
        return is(new ChromeDriverChecker());
    }

    public static boolean isFirefox() {
        return is(new FirefoxDriverChecker());
    }

    public static boolean isSafari() {
        return is(new SafariDriverChecker());
    }

    private static boolean is(InstanceChecker<Boolean> ic) {
        return ic.check();
    }
}
