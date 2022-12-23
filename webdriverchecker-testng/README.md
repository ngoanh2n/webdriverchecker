[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-testng/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-testng)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker-testng/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker-testng)

# WebDriverChecker for TestNG
Your automation project is using TestNG as a testing framework, `webdriverchecker-testng` should be used.

It automatically gets WebDriver instance from the current running test by using `org.testng.ITestNGListener` listener.

You don't need to pass the WebDriver instance to the argument of checker methods.

| webdriverchecker   	              | webdriverchecker-testng     |
|---	                              |---	                        |
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
