package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@SuppressWarnings("SpellCheckingInspection")
enum WDCType {

    EDGE("edge", "msedge"),
    OPERA("opera", "opera"),
    CHROME("chrome", "chrome"),
    SAFARI("safari", "safari"),
    FIREFOX("firefox", "firefox"),
    IE("ie", "internet explorer"),
    MOBILE_ANDROID("android", "android");

    private final String typeName;
    private final String browserName;

    WDCType(String typeName, String browserName) {
        this.typeName = typeName;
        this.browserName = browserName;
    }

    String typeName() {
        return typeName;
    }

    String browserName() {
        return browserName;
    }
}
