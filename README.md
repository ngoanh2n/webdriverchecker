# WebDriverChecker
## Gradle Project
Add dependency to `build.gradle`
```gradle
dependencies {
    testImplementation("com.github.ngoanh2n:webdriverchecker:1.0.0")
}
```

## Maven Project
Add dependency to `pom.xml`
```xml
<dependencies>
    [...]
    <dependency>
        <groupId>com.github.ngoanh2n</groupId>
        <artifactId>webdriverchecker</artifactId>
        <version>1.0.0</version>
        <scope>test</scope>
    </dependency>
    [...]
</dependencies>
```

# WebDriverChecker for Selenide
Add dependency to `build.gradle`
```gradle
dependencies {
    testImplementation("com.github.ngoanh2n:webdriverchecker-selenide:1.0.0")
}
```

## Maven Project
Add dependency to `pom.xml`
```xml
<dependencies>
    [...]
    <dependency>
        <groupId>com.github.ngoanh2n</groupId>
        <artifactId>webdriverchecker-selenide</artifactId>
        <version>1.0.0</version>
        <scope>test</scope>
    </dependency>
    [...]
</dependencies>
```

# Usages
```java
WebDriverChecker.isAlive()
WebDriverChecker.isRemote()

WebDriverChecker.isIE()
WebDriverChecker.isEdge()
WebDriverChecker.isOpera()
WebDriverChecker.isChrome()
WebDriverChecker.isSafari()
WebDriverChecker.isFirefox()

WebDriverChecker.isEdgeLegacy()
WebDriverChecker.isFirefoxLegacy()

WebDriverChecker.isIOS()
WebDriverChecker.isIOSApp()
WebDriverChecker.isIOSSafari()

WebDriverChecker.isAndroid()
WebDriverChecker.isAndroidApp()
WebDriverChecker.isAndroidChrome()

WebDriverChecker.isMobile()
WebDriverChecker.isMobileApp()
WebDriverChecker.isWindowsApp()
```
