package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@SuppressWarnings("SpellCheckingInspection")
enum WDCType {

    EDGE("msedge"),
    OPERA("opera"),
    CHROME("chrome"),
    SAFARI("safari"),
    FIREFOX("firefox"),
    IE("internet explorer"),
    MOBILE_IOS("ios"),
    MOBILE_ANDROID("android"),
    MOBILE_NATIVE("native");

    private final String browserName;

    WDCType(String browserName) {
        this.browserName = browserName;
    }

    String getName() {
        return browserName;
    }
}
