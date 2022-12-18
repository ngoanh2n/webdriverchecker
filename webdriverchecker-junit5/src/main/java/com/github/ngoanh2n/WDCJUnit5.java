package com.github.ngoanh2n;

import com.github.ngoanh2n.wdc.WebDriverChecker;
import com.github.ngoanh2n.wdc.WebDriverProvider;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Provide WebDriver from current test to {@linkplain WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 * @version 2.3.0
 * @since 2022-12-18
 */
public class WDCJUnit5 implements InvocationInterceptor, WebDriverProvider {
    private static final String PRE = "BE";
    private static final String POST = "AF";
    private static final Logger LOGGER = LoggerFactory.getLogger(WDCJUnit5.class);
    private static WebDriver driver;

    //===============================================================================//

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptBeforeAllMethod(Invocation<Void> invocation,
                                         ReflectiveInvocationContext<Method> invocationContext,
                                         ExtensionContext extensionContext) throws Throwable {
        findDriver(invocationContext, PRE);
        invocation.proceed();
        findDriver(invocationContext, POST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptBeforeEachMethod(Invocation<Void> invocation,
                                          ReflectiveInvocationContext<Method> invocationContext,
                                          ExtensionContext extensionContext) throws Throwable {
        findDriver(invocationContext, PRE);
        invocation.proceed();
        findDriver(invocationContext, POST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
                                    ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws Throwable {
        findDriver(invocationContext, PRE);
        invocation.proceed();
        findDriver(invocationContext, POST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T interceptTestFactoryMethod(Invocation<T> invocation,
                                            ReflectiveInvocationContext<Method> invocationContext,
                                            ExtensionContext extensionContext) throws Throwable {
        findDriver(invocationContext, PRE);
        T result = invocation.proceed();
        findDriver(invocationContext, POST);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptTestTemplateMethod(Invocation<Void> invocation,
                                            ReflectiveInvocationContext<Method> invocationContext,
                                            ExtensionContext extensionContext) throws Throwable {
        findDriver(invocationContext, PRE);
        invocation.proceed();
        findDriver(invocationContext, POST);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver provide() {
        return driver;
    }

    //===============================================================================//

    private void findDriver(ReflectiveInvocationContext<Method> context, String aspect) throws IllegalAccessException {
        Class<?> clazz = context.getTargetClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(clazz);

            if (value instanceof WebDriver) {
                driver = (WebDriver) value;
                break;
            }
        }

        Method method = (Method) FieldUtils.readField(context, "method", true);
        String annotation = getSignatureAnnotationName(method);
        LOGGER.debug("{} @{} {} -> {}", aspect, annotation, method, driver);
    }

    private String getSignatureAnnotationName(Method method) {
        Class<?>[] signatures = new Class[]{
                BeforeAll.class, BeforeEach.class, Test.class, RepeatedTest.class,
                ParameterizedTest.class, TestFactory.class, TestTemplate.class
        };
        Annotation[] declarations = method.getDeclaredAnnotations();

        for (Class<?> signature : signatures) {
            for (Annotation declaration : declarations) {
                if (signature.getName().equals(declaration.annotationType().getName())) {
                    return signature.getSimpleName();
                }
            }
        }
        return "UnknownSignature";
    }
}
