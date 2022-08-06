package com.github.ngoanh2n.wdc;

/**
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 1.0.0
 * @since 2021-04-10
 */
@SuppressWarnings("SpellCheckingInspection")
enum WDCType {

    // Browsers
    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("msedge"),
    OPERA("opera"),
    SAFARI("safari"),
    IE("internetexplorer"),
    EDGE_LEGACY("microsoftedge"),

    // Platforms
    MACOS("mac"),
    LINUX("linux"),
    WINDOWS("windows"),
    IOS("ios"),
    ANDROID("android");

    private final String name;

    WDCType(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }
}
