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
    private final String driverName;

    WDCType(String typeName, String driverName) {
        this.typeName = typeName;
        this.driverName = driverName;
    }

    String typeName() {
        return typeName;
    }

    String driverName() {
        return driverName;
    }
}
