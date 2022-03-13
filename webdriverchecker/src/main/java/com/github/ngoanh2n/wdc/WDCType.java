package com.github.ngoanh2n.wdc;

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
    MAC("mac"),
    LINUX("linux"),
    ANDROID("android"),
    WINDOWS("windows");

    private final String name;

    WDCType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
