[![Java](https://img.shields.io/badge/Java-17-orange)](https://adoptium.net)
[![Maven](https://img.shields.io/maven-central/v/com.github.ngoanh2n/webdriverchecker?label=Maven)](https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker)
[![GitHub Actions](https://img.shields.io/github/actions/workflow/status/ngoanh2n/webdriverchecker/build.yml?logo=github&label=GitHub%20Actions)](https://github.com/ngoanh2n/webdriverchecker/actions/workflows/build.yml)

**Table of Contents**
<!-- TOC -->
* [WebDriverChecker](#webdriverchecker)
  * [Check](#check)
  * [Version](#version)
* [Extension](#extension)
  * [Selenide](#selenide)
  * [JUnit5](#junit5)
  * [TestNG](#testng)
* [Declaration](#declaration)
  * [Gradle](#gradle)
  * [Maven](#maven)
* [Usage](#usage)
<!-- TOC -->

# WebDriverChecker
You are writing automation test scripts for multiple browsers such as:
- Chrome, Safari.. on PC
- Safari & native application on iOS
- Chrome & native application on Android

And somewhere, you have to check type of browser or platform to navigate your scripts.<br>
Use `WebDriverChecker` to make it more convenient!

## Check
- Browser: Chrome, Firefox, Edge, Opera, Safari, IE
- Platform: MacOS, Linux, Windows, iOS, Android
- State: Alive, Local, Remote, Web, Native, Docker, Virtual Device, Cloud

## Version
- Selenium: 4.24.0
- Selenide: 7.4.3
- JUnit5: 5.11.0
- TestNG: 7.10.2

# Extension
It automatically provides the current `WebDriver` instance to `com.github.ngoanh2n.wdc.WebDriverChecker`.<br>
You don't need to pass the `WebDriver` instance to the argument of checker methods.

| With extension                 | Without extension                    |
|:-------------------------------|:-------------------------------------|
| `WebDriverChecker.isChrome()`  | `WebDriverChecker.isChrome(driver)`  |

## [Selenide](webdriverchecker-selenide#readme)
When using `Selenide` directly.

## [JUnit5](webdriverchecker-junit5#readme)
When using `JUnit Jupiter` as a testing framework.

## [TestNG](webdriverchecker-testng#readme)
When using `TestNG` as a testing framework.

# Declaration
## Gradle
Add to `build.gradle`.
```gradle
implementation("com.github.ngoanh2n:webdriverchecker:2.9.0")
```

## Maven
Add to `pom.xml`.
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker</artifactId>
    <version>2.9.0</version>
</dependency>
```

# Usage
- Browser
  - `WebDriverChecker.isChrome(driver)`
  - `WebDriverChecker.isSafari(driver)`
  - `WebDriverChecker.isFirefox(driver)`
  - `WebDriverChecker.isEdge(driver)`
  - `WebDriverChecker.isOpera(driver)`
  - `WebDriverChecker.isIE(driver)`
  - `WebDriverChecker.isLegacyEdge(driver)`
  - `WebDriverChecker.isLegacyFirefox(driver)`
- Platform
  - `WebDriverChecker.isLinux(driver)`
  - `WebDriverChecker.isMacOS(driver)`
  - `WebDriverChecker.isWindows(driver)`
  - `WebDriverChecker.isPC(driver)`
  - `WebDriverChecker.isIOS(driver)`
  - `WebDriverChecker.isAndroid(driver)`
  - `WebDriverChecker.isMobile(driver)`
- State
  - `WebDriverChecker.isAlive(driver)`
  - `WebDriverChecker.isLocal(driver)`
  - `WebDriverChecker.isRemote(driver)`
  - `WebDriverChecker.isDocker(driver)`
  - `WebDriverChecker.isBrowser(driver)`
  - `WebDriverChecker.isNative(driver)`
- Cloud
  - `WebDriverChecker.isLambdaTest(driver)`
  - `WebDriverChecker.isBrowserStack(driver)`
  - `WebDriverChecker.isSauceLabs(driver)`
  - `WebDriverChecker.isTestingBot(driver)`
- Combination
  - `WebDriverChecker.isLocalServer(driver)`
  - `WebDriverChecker.isRemoteServer(driver)`
  - `WebDriverChecker.isPCBrowser(driver)`
  - `WebDriverChecker.isPCNative(driver)`
  - `WebDriverChecker.isMacOSNative(driver)`
  - `WebDriverChecker.isWindowsNative(driver)`
  - `WebDriverChecker.isIOSBrowser(driver)`
  - `WebDriverChecker.isIOSNative(driver)`
  - `WebDriverChecker.isIOSVirtual(driver)`
  - `WebDriverChecker.isAndroidBrowser(driver)`
  - `WebDriverChecker.isAndroidNative(driver)`
  - `WebDriverChecker.isAndroidVirtual(driver)`
  - `WebDriverChecker.isMobileBrowser(driver)`
  - `WebDriverChecker.isMobileNative(driver)`
  - `WebDriverChecker.isMobileVirtual(driver)`
