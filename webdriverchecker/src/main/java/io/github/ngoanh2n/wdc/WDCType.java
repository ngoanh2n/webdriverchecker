package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@SuppressWarnings("SpellCheckingInspection")
enum WDCType {

    // Browsers
    EDGE("msedge"),
    OPERA("opera"),
    SAFARI("safari"),
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("internetexplorer"),
    EDGE_LEGACY("microsoftedge"),

    // Platforms
    IOS("ios"),
    ANDROID("android"),
    WINDOWS("windows"),

    // Indentifiers
    MOBILE("mobile"),
    MOBILE_APP("mobileapp"),
    IOS_SAFARI("mobilesafari"),
    ANDROID_CHROME("mobilechrome"),
    FIREFOX_LEGACY("firefoxlegacy");

    private final String value;

    WDCType(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
