[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-junit5/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.ngoanh2n/webdriverchecker-junit5)
[![javadoc](https://javadoc.io/badge2/com.github.ngoanh2n/webdriverchecker-junit5/javadoc.svg)](https://javadoc.io/doc/com.github.ngoanh2n/webdriverchecker-junit5)

# WebDriverChecker for JUnit5
Your automation project is using JUnit Jupiter as a testing framework, `webdriverchecker-junit5` should be used.

It automatically gets WebDriver instance from the current running test by using `org.junit.jupiter.api.extension.InvocationInterceptor` extension.

You don't need to pass the WebDriver instance to the argument of checker methods.

| webdriverchecker   	              | webdriverchecker-junit5     |
|---	                              |---	                        |
| WebDriverChecker.isChrome(driver) | WebDriverChecker.isChrome() |

# Declarations
## Gradle
Add to `build.gradle`
```gradle
implementation("com.github.ngoanh2n:webdriverchecker-junit5:2.4.0")
```

## Maven
Add to `pom.xml`
```xml
<dependency>
    <groupId>com.github.ngoanh2n</groupId>
    <artifactId>webdriverchecker-junit5</artifactId>
    <version>2.4.0</version>
</dependency>
```

# Test Structure
1. Must declare a field of WebDriver type with any modifiers at current class or parent/abstract class.
2. WebDriverChecker will find WebDriver instance after the field is assigned a value.

```java
public class MyTest {
    private WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        // WebDriverChecker can find WebDriver instance from here.
        // WebDriverChecker.isChrome(driver) <=> WebDriverChecker.isChrome()
    }
}
```
