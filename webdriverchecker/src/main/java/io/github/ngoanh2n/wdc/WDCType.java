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
    REMOTE("remote"),
    MOBILE("mobile"),
    IOS_APP("iosapp"),
    IOS_SAFARI("iossafari"),
    MOBILE_APP("mobileapp"),
    ANDROID_APP("androidapp"),
    ANDROID_CHROME("androidchrome"),
    FIREFOX_LEGACY("firefoxlegacy");

    private final String value;

    WDCType(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
