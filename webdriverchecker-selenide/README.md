[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-selenide/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-selenide)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker-selenide/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker-selenide)
[![badge-jdk](https://img.shields.io/badge/jdk-8-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blueviolet.svg)](https://opensource.org/licenses/MIT)

# WebDriverChecker for Selenide
Your automation project is using Selenide directly, `webdriverchecker-selenide` should be used.

It automatically gets WebDriver instance from `com.codeborne.selenide.impl.WebDriverContainer` via `com.codeborne.selenide.WebDriverRunner.getWebDriver()` method.

You don't need to pass the WebDriver instance to the argument of checker methods.

| webdriverchecker   	              | webdriverchecker-selenide   |
|---	                              |---	                        |
| WebDriverChecker.isChrome(driver) | WebDriverChecker.isChrome() |

# Declarations
## Gradle
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-selenide:2.5.0")
```

## Maven
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-selenide</artifactId>
    <version>2.5.0</version>
</dependency>
```
