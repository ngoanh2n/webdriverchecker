[![Java](https://img.shields.io/badge/Java-17-orange)](https://adoptium.net)
[![Maven](https://img.shields.io/maven-central/v/com.github.ngoanh2n/webdriverchecker-testng?label=Maven)](https://mvnrepository.com/artifact/com.github.ngoanh2n/webdriverchecker-testng)
[![GitHub Actions](https://img.shields.io/github/actions/workflow/status/ngoanh2n/webdriverchecker/build.yml?logo=github&label=GitHub%20Actions)](https://github.com/ngoanh2n/webdriverchecker/actions/workflows/build.yml)

# WebDriverChecker for TestNG
**Table of Contents**
<!-- TOC -->
* [Declaration](#declaration)
  * [Gradle](#gradle)
  * [Maven](#maven)
* [Test Structure](#test-structure)
<!-- TOC -->

When using TestNG as a testing framework, `webdriverchecker-testng` should be used.
- `WebDriverChecker` automatically get `WebDriver` instance from the current running test by using `org.testng.ITestNGListener` listener.
- You don't need to pass the `WebDriver` instance to the argument of checker methods.

| webdriverchecker                     | webdriverchecker-testng        |
|:-------------------------------------|:-------------------------------|
| `WebDriverChecker.isChrome(driver)`  | `WebDriverChecker.isChrome()`  |

# Declaration
## Gradle
Add to `build.gradle`.
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-testng:2.9.0")
```

## Maven
Add to `pom.xml`.
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-testng</artifactId>
    <version>2.9.0</version>
</dependency>
```

# Test Structure
1. Must declare a field of `WebDriver` type with any modifiers at current class or parent/abstract class.
2. `WebDriverChecker` can detect `WebDriver` instance after the field is assigned a value.

```java
public class MyTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        // WebDriverChecker could find WebDriver instance from here.
        // WebDriverChecker.isChrome(driver) <=> WebDriverChecker.isChrome()
    }
}
```
