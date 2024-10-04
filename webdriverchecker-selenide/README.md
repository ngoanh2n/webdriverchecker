[![Java](https://img.shields.io/badge/Java-17-orange)](https://adoptium.net)
[![Maven](https://img.shields.io/maven-central/v/com.github.ngoanh2n/webdriverchecker-selenide?label=Maven)](https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker-selenide)
[![GitHub Actions](https://img.shields.io/github/actions/workflow/status/ngoanh2n/webdriverchecker/build.yml?logo=github&label=GitHub%20Actions)](https://github.com/ngoanh2n/webdriverchecker/actions/workflows/build.yml)

# WebDriverChecker for Selenide
**Table of Contents**
<!-- TOC -->
* [Declaration](#declaration)
  * [Gradle](#gradle)
  * [Maven](#maven)
* [Test Structure](#test-structure)
<!-- TOC -->

When using Selenide directly, `webdriverchecker-selenide` should be used.
- `WebDriverChecker` automatically get `WebDriver` instance from `com.codeborne.selenide.impl.WebDriverContainer` via `com.codeborne.selenide.WebDriverRunner.getWebDriver()` method.
- You don't need to pass the `WebDriver` instance to the argument of checker methods.

| webdriverchecker                     | webdriverchecker-selenide      |
|:-------------------------------------|:-------------------------------|
| `WebDriverChecker.isChrome(driver)`  | `WebDriverChecker.isChrome()`  |

# Declaration
## Gradle
Add to `build.gradle`.
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-selenide:2.9.0")
```

## Maven
Add to `pom.xml`.
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-selenide</artifactId>
    <version>2.9.0</version>
</dependency>
```

# Test Structure
```java
public class MyTest {
    public void test() {
        Selenide.open("https://github.com/ngoanh2n");
        // WebDriverShooter could find WebDriver instance from here.
        // WebDriverShooter.page(driver) <=> WebDriverShooter.page()
    }
}
```
