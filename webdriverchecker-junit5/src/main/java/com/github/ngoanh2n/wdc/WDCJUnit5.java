package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.Commons;
import com.github.ngoanh2n.RuntimeError;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private static final String BE = "BE";
    private static final String BO = "BO";
    private static final String AF = "AF";
    private static final Logger LOGGER = LoggerFactory.getLogger(WDCJUnit5.class);
    private static ReflectiveInvocationContext<Method> invocationContext;
    private WebDriver driver;

    //===============================================================================//

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptBeforeAllMethod(Invocation<Void> invocation,
                                         ReflectiveInvocationContext<Method> invocationContext,
                                         ExtensionContext extensionContext) throws Throwable {
        getWD(invocationContext, BE);
        invocation.proceed();
        getWD(invocationContext, AF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptBeforeEachMethod(Invocation<Void> invocation,
                                          ReflectiveInvocationContext<Method> invocationContext,
                                          ExtensionContext extensionContext) throws Throwable {
        getWD(invocationContext, BE);
        invocation.proceed();
        getWD(invocationContext, AF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptTestMethod(Invocation<Void> invocation,
                                    ReflectiveInvocationContext<Method> invocationContext,
                                    ExtensionContext extensionContext) throws Throwable {
        getWD(invocationContext, BE);
        invocation.proceed();
        getWD(invocationContext, AF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <T> T interceptTestFactoryMethod(Invocation<T> invocation,
                                            ReflectiveInvocationContext<Method> invocationContext,
                                            ExtensionContext extensionContext) throws Throwable {
        getWD(invocationContext, BE);
        T result = invocation.proceed();
        getWD(invocationContext, AF);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void interceptTestTemplateMethod(Invocation<Void> invocation,
                                            ReflectiveInvocationContext<Method> invocationContext,
                                            ExtensionContext extensionContext) throws Throwable {
        getWD(invocationContext, BE);
        invocation.proceed();
        getWD(invocationContext, AF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver provide() {
        if (invocationContext != null) {
            getWD(invocationContext, BO);
        }
        return driver;
    }

    //===============================================================================//

    private void getWD(ReflectiveInvocationContext<Method> context, String aspect) {
        invocationContext = context;
        Class<?> clazz = context.getTargetClass();
        Field[] fields = FieldUtils.getAllFields(clazz);

        for (Field field : fields) {
            field.setAccessible(true);
            Object value;

            try {
                value = field.get(clazz);
            } catch (IllegalAccessException e) {
                String fieldName = field.getName();
                String clazzName = clazz.getName();
                String msg = String.format("Read field %s in class %s", fieldName, clazzName);
                LOGGER.error(msg);
                throw new RuntimeError(msg, e);
            }

            if (value instanceof WebDriver) {
                driver = (WebDriver) value;
                break;
            }
        }

        Method method = Commons.readField(context, "method");
        String annotation = Commons.getJUnit5SignatureAnnotation(context).getSimpleName();
        LOGGER.debug("{} @{} {} -> {}", aspect, annotation, method, driver);
    }
}
