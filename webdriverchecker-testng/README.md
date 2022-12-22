[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-testng/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-testng)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker-testng/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker-testng)

# WebDriverChecker for TestNG
Your automation project is using TestNG as a testing framework, `webdriverchecker-testng` should be used.

It automatically gets WebDriver instance from the current running test by using `org.testng.ITestNGListener`.

You don't need to pass the WebDriver instance to the argument of checker methods.

| webdriverchecker   	            | webdriverchecker-testng     |
|---	                            |---	                      |
| WebDriverChecker.isChrome(driver) | WebDriverChecker.isChrome() |

# Delarations
## Gradle
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-testng:2.3.0")
```

## Maven
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-testng</artifactId>
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
