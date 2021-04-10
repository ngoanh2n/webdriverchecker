package io.github.ngoanh2n.wdc;

import static io.github.ngoanh2n.wdc.DriverInstanceChecker.execute;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
public class WebDriverChecker {

    public static boolean isIE() {
        return execute(new IEDriverInstance());
    }

    public static boolean isEdge() {
        return execute(new EdgeDriverInstance());
    }

    public static boolean isOpera() {
        return execute(new OperaDriverInstance());
    }

    public static boolean isChrome() {
        return execute(new ChromeDriverInstance());
    }

    public static boolean isSafari() {
        return execute(new SafariDriverInstance());
    }

    public static boolean isFirefox() {
        return execute(new FirefoxDriverInstance());
    }
}
