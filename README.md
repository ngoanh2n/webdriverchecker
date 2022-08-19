[![GitHub forks](https://img.shields.io/github/forks/ngoanh2n/webdriverchecker.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/network/members/)
[![GitHub stars](https://img.shields.io/github/stars/ngoanh2n/webdriverchecker.svg?style=social&label=Star&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/ngoanh2n/webdriverchecker.svg?style=social&label=Watch&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/watchers/)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker)
[![GitHub release](https://img.shields.io/github/release/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/releases/)
[![badge-jdk](https://img.shields.io/badge/jdk-8-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blueviolet.svg)](https://opensource.org/licenses/MIT)

# WebDriverChecker
You are writing automation test scripts for multiple browsers such as:
- Chrome, Safari.. on PC
- Safari & native app on iOS
- Chrome & native app on Android

And somewhere, you have to check type of browser or platform to navigate your scripts.

Use WebDriverChecker to make it more convenient!

## Gradle Project
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker:2.0.0")
```

## Maven Project
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker</artifactId>
    <version>2.0.0</version>
</dependency>
```

# WebDriverChecker for Selenide
## Gradle Project
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-selenide:2.0.0")
```

## Maven Project
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-selenide</artifactId>
    <version>2.0.0</version>
</dependency>
```

# Usages
```java
WebDriverChecker.isAlive()
WebDriverChecker.isRemote()

WebDriverChecker.isChrome()
WebDriverChecker.isSafari()
WebDriverChecker.isFirefox()
WebDriverChecker.isEdge()
WebDriverChecker.isOpera()
WebDriverChecker.isIE()

WebDriverChecker.isIOS()
WebDriverChecker.isIOSWeb()
WebDriverChecker.isIOSSafari()
WebDriverChecker.isIOSNative()

WebDriverChecker.isAndroid()
WebDriverChecker.isAndroidWeb()
WebDriverChecker.isAndroidChrome()
WebDriverChecker.isAndroidNative()

WebDriverChecker.isMobile()
WebDriverChecker.isMobileWeb()
WebDriverChecker.isMobileNative()

WebDriverChecker.isMacNative()
WebDriverChecker.isWindowsNative()

WebDriverChecker.isEdgeLegacy()
WebDriverChecker.isFirefoxLegacy()
```
