[![GitHub stars](https://img.shields.io/github/stars/ngoanh2n/webdriverchecker.svg?style=social&label=Star&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/ngoanh2n/webdriverchecker.svg?style=social&label=Watch&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/watchers/)
[![GitHub forks](https://img.shields.io/github/forks/ngoanh2n/webdriverchecker.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/network/members/)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker)
[![GitHub release](https://img.shields.io/github/release/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/releases/)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker)
[![License: MIT](https://img.shields.io/badge/License-MIT-blueviolet.svg)](https://opensource.org/licenses/MIT)
[![badge-jdk](https://img.shields.io/badge/jdk-8-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![GitHub contributors](https://img.shields.io/github/contributors/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/graphs/contributors/)
[![GitHub issues](https://img.shields.io/github/issues/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/issues/)
[![GitHub issues-closed](https://img.shields.io/github/issues-closed/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/issues?q=is%3Aissue+is%3Aclosed)
[![GitHub pull-requests](https://img.shields.io/github/issues-pr/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/pulls/)
[![GitHub pull-requests closed](https://img.shields.io/github/issues-pr-closed/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/pulls?q=is%3Apulls+is%3Aclosed)

# WebDriverChecker
## Gradle Project
Add dependency to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker:1.0.0")
```

## Maven Project
Add dependency to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker</artifactId>
    <version>1.0.0</version>
</dependency>
```

# WebDriverChecker for Selenide
Add dependency to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-selenide:1.0.0")
```

## Maven Project
Add dependency to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-selenide</artifactId>
    <version>1.0.0</version>
</dependency>
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
