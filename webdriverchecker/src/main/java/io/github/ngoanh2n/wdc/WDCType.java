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
    SAFARI("safari"),
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("internetexplorer"),

    IOS("ios"),
    ANDROID("android"),

    MOBILE("mobile"),
    MOBILE_APP("mobileapp");

    private final String browserName;

    WDCType(String browserName) {
        this.browserName = browserName;
    }

    String getName() {
        return browserName;
    }
}
