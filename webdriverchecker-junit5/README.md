[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-junit5/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-junit5)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker-junit5/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker-junit5)

# WebDriverChecker for JUnit5
Your automation project is using JUnit5 Jupiter as a testing framework, `webdriverchecker-junit5` should be used.

It automatically gets WebDriver instance from the current running test by using `org.junit.jupiter.api.extension.InvocationInterceptor` extension.

Therefore, you don't need to pass the WebDriver instance to the argument of checker methods.

| webdriverchecker   	            | webdriverchecker-junit5     |
|---	                            |---	                      |
| WebDriverChecker.isChrome(driver) | WebDriverChecker.isChrome() |

# Delarations
## Gradle
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-junit5:2.3.0")
```

## Maven
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-junit5</artifactId>
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
