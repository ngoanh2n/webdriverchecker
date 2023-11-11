[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-junit5/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-junit5)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker-junit5/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker-junit5)
[![badge-jdk](https://img.shields.io/badge/jdk-11-blue.svg)](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blueviolet.svg)](https://opensource.org/licenses/MIT)

# WebDriverChecker for JUnit5
**Table of Contents**
<!-- TOC -->
* [Declaration](#declaration)
    * [Gradle](#gradle)
    * [Maven](#maven)
* [Test Structure](#test-structure)
<!-- TOC -->

When using JUnit Jupiter as a testing framework, `webdriverchecker-junit5` should be used.
- `WebDriverChecker` automatically get `WebDriver` instance from the current running test by using `org.junit.jupiter.api.extension.InvocationInterceptor` extension.
- You don't need to pass the `WebDriver` instance to the argument of checker methods.

| webdriverchecker                     | webdriverchecker-junit5        |
|:-------------------------------------|:-------------------------------|
| `WebDriverChecker.isChrome(driver)`  | `WebDriverChecker.isChrome()`  |

# Declaration
## Gradle
Add to `build.gradle`.
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-junit5:2.8.0")
```

## Maven
Add to `pom.xml`.
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-junit5</artifactId>
    <version>2.8.0</version>
</dependency>
```

# Test Structure
1. Must declare a field of `WebDriver` type with any modifiers at current class or parent/abstract class.
2. `WebDriverChecker` can detect `WebDriver` instance after the field is assigned a value.

```java
public class MyTest {
    private WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        // WebDriverChecker could find WebDriver instance from here.
        // WebDriverChecker.isChrome(driver) <=> WebDriverChecker.isChrome()
    }
}
```
