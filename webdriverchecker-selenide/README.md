[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-selenide/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-selenide)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker-selenide/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker-selenide)

# WebDriverChecker for Selenide
Your automation project is using Selenide directly, `webdriverchecker-selenide` should be used.

It automatically gets WebDriver instance from `com.codeborne.selenide.impl.WebDriverContainer` via `com.codeborne.selenide.WebDriverRunner.getWebDriver()` method.

Therefore, you don't need to pass the WebDriver instance to the argument of checker methods.

| webdriverchecker   	            | webdriverchecker-selenide   |
|---	                            |---	                      |
| WebDriverChecker.isChrome(driver) | WebDriverChecker.isChrome() |

# Delarations
## Gradle
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-selenide:2.3.0")
```

## Maven
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-selenide</artifactId>
    <version>2.3.0</version>
</dependency>
```

# Usages
```java
WebDriverChecker.isMacOS()
WebDriverChecker.isLinux()
WebDriverChecker.isWindows()
WebDriverChecker.isPC()
WebDriverChecker.isIOS()
WebDriverChecker.isAndroid()
WebDriverChecker.isMobile()

WebDriverChecker.isAlive()
WebDriverChecker.isLocal()
WebDriverChecker.isRemote()
WebDriverChecker.isDocker()
WebDriverChecker.isBrowser()
WebDriverChecker.isNative()

WebDriverChecker.isChrome()
WebDriverChecker.isSafari()
WebDriverChecker.isFirefox()
WebDriverChecker.isEdge()
WebDriverChecker.isOpera()
WebDriverChecker.isIE()
WebDriverChecker.isLegacyEdge()
WebDriverChecker.isLegacyFirefox()

WebDriverChecker.isPCBrowser()
WebDriverChecker.isPCNative()

WebDriverChecker.isMacOSNative()
WebDriverChecker.isWindowsNative()

WebDriverChecker.isLocalServer()
WebDriverChecker.isRemoteServer()

WebDriverChecker.isIOSBrowser()
WebDriverChecker.isIOSNative()
WebDriverChecker.isIOSVirtual()

WebDriverChecker.isAndroidBrowser()
WebDriverChecker.isAndroidNative()
WebDriverChecker.isAndroidVirtual()

WebDriverChecker.isMobileBrowser()
WebDriverChecker.isMobileNative()
WebDriverChecker.isMobileVirtual()

WebDriverChecker.isLambdaTest()
WebDriverChecker.isBrowserStack()
WebDriverChecker.isSauceLabs()
WebDriverChecker.isTestingBot()
```
