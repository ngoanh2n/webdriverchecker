package io.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@SuppressWarnings("SpellCheckingInspection")
enum WDCBrowser {

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
    WINDOWS("windows");

    private final String name;

    WDCBrowser(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
