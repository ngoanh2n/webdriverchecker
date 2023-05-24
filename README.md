[![GitHub forks](https://img.shields.io/github/forks/ngoanh2n/webdriverchecker.svg?style=social&label=Fork&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/network/members/)
[![GitHub stars](https://img.shields.io/github/stars/ngoanh2n/webdriverchecker.svg?style=social&label=Star&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/stargazers/)
[![GitHub watchers](https://img.shields.io/github/watchers/ngoanh2n/webdriverchecker.svg?style=social&label=Watch&maxAge=2592000)](https://github.com/ngoanh2n/webdriverchecker/watchers/)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker)
[![GitHub release](https://img.shields.io/github/release/ngoanh2n/webdriverchecker.svg)](https://github.com/ngoanh2n/webdriverchecker/releases/)
[![badge-jdk](https://img.shields.io/badge/jdk-8-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blueviolet.svg)](https://opensource.org/licenses/MIT)

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [WebDriverChecker](#webdriverchecker)
  - [Checks](#checks)
  - [Versions](#versions)
- [Extensions](#extensions)
    - [Selenide](#selenide)
    - [JUnit5](#junit5)
    - [TestNG](#testng)
- [Declarations](#declarations)
  - [Gradle](#gradle)
  - [Maven](#maven)
- [Usages](#usages)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

# WebDriverChecker
You are writing automation test scripts for multiple browsers such as:
- Chrome, Safari.. on PC
- Safari & native application on iOS
- Chrome & native application on Android

And somewhere, you have to check type of browser or platform to navigate your scripts.

Use WebDriverChecker to make it more convenient!

## Checks
- Browsers: Chrome, Firefox, Edge, Opera, Safari, IE
- Platforms: MacOS, Linux, Windows, iOS, Android
- States: Alive, Local, Remote, Web, Native, Docker, Virtual Device, Cloud

## Versions
- Selenium: 4.8.3
- Selenide: 6.13.0
- JUnit5: 5.9.2
- TestNG: 7.7.1

# Extensions
It automatically provides the current WebDriver instance to `com.github.ngoanh2n.wdc.WebDriverChecker`.

You don't need to pass the WebDriver instance to the argument of checker methods.

### [Selenide](webdriverchecker-selenide#readme)
When your automation project is using `Selenide` directly.

### [JUnit5](webdriverchecker-junit5#readme)
When your automation project is using `JUnit Jupiter` as a testing framework.

### [TestNG](webdriverchecker-testng#readme)
When your automation project is using `TestNG` as a testing framework.

# Declarations
## Gradle
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker:2.6.0")
```

## Maven
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker</artifactId>
    <version>2.6.0</version>
</dependency>
```

# Usages
```java
WebDriverChecker.isMacOS(driver)
WebDriverChecker.isLinux(driver)
WebDriverChecker.isWindows(driver)
WebDriverChecker.isPC(driver)
WebDriverChecker.isIOS(driver)
WebDriverChecker.isAndroid(driver)
WebDriverChecker.isMobile(driver)

WebDriverChecker.isAlive(driver)
WebDriverChecker.isLocal(driver)
WebDriverChecker.isRemote(driver)
WebDriverChecker.isDocker(driver)
WebDriverChecker.isBrowser(driver)
WebDriverChecker.isNative(driver)

WebDriverChecker.isChrome(driver)
WebDriverChecker.isSafari(driver)
WebDriverChecker.isFirefox(driver)
WebDriverChecker.isEdge(driver)
WebDriverChecker.isOpera(driver)
WebDriverChecker.isIE(driver)
WebDriverChecker.isLegacyEdge(driver)
WebDriverChecker.isLegacyFirefox(driver)

WebDriverChecker.isPCBrowser(driver)
WebDriverChecker.isPCNative(driver)

WebDriverChecker.isMacOSNative(driver)
WebDriverChecker.isWindowsNative(driver)

WebDriverChecker.isLocalServer(driver)
WebDriverChecker.isRemoteServer(driver)

WebDriverChecker.isIOSBrowser(driver)
WebDriverChecker.isIOSNative(driver)
WebDriverChecker.isIOSVirtual(driver)

WebDriverChecker.isAndroidBrowser(driver)
WebDriverChecker.isAndroidNative(driver)
WebDriverChecker.isAndroidVirtual(driver)

WebDriverChecker.isMobileBrowser(driver)
WebDriverChecker.isMobileNative(driver)
WebDriverChecker.isMobileVirtual(driver)

WebDriverChecker.isLambdaTest(driver)
WebDriverChecker.isBrowserStack(driver)
WebDriverChecker.isSauceLabs(driver)
WebDriverChecker.isTestingBot(driver)
```
