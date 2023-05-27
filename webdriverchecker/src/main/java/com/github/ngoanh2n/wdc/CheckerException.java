package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;
import org.openqa.selenium.WebDriver;

/**
 * Runtime exception for {@link WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class CheckerException extends RuntimeError {
    /**
     * Construct a new {@link CheckerException} with the specified detail message.
     *
     * @param message The detail message, is saved for later retrieval by the {@link #getMessage()} method.
     */
    public CheckerException(String message) {
        super(message);
    }

    /**
     * Construct a new {@link CheckerException} with the specified cause and a detail message.
     *
     * @param cause The cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A {@code null} value is
     *              permitted, and indicates that the cause is nonexistent or unknown).
     */
    public CheckerException(Throwable cause) {
        super(cause);
    }

    /**
     * Construct a new {@link CheckerException} with the specified detail message and cause.
     *
     * @param message The detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A {@code null} value is
     *                permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public CheckerException(String message, Throwable cause) {
        super(message, cause);
    }

    //===============================================================================//

    /**
     * Runtime exception when {@link WebDriverChecker} could not detect any {@link WebDriver}<br>
     * via {@link WebDriverProvider#provide()}<br>
     * or {@link WebDriverChecker#is(WebDriverChecker, WebDriver...)}.
     */
    public static final class NoneDriver extends CheckerException {
        /**
         * Construct a new {@link NullDriverPassed} with the specified detail message.
         */
        public NoneDriver() {
            super("No WebDriver is passed or provided");
        }
    }

    /**
     * Runtime exception when the found {@link WebDriver} is closed.
     */
    public static final class ClosedDriver extends CheckerException {
        /**
         * Construct a new {@link NullDriverPassed} with the specified detail message.
         */
        public ClosedDriver() {
            super("The WebDriver is closed");
        }
    }

    /**
     * Runtime exception when the provided {@link WebDriver} is closed.
     */
    public static final class ClosedDriverProvided extends CheckerException {
        /**
         * Construct a new {@link NullDriverPassed} with the specified detail message.
         */
        public ClosedDriverProvided() {
            super("The provided WebDriver is closed");
        }
    }

    /**
     * Runtime exception when you have provided a null {@link WebDriver}<br>
     * via {@link WebDriverProvider#provide()}.
     */
    public static final class NullDriverProvided extends CheckerException {
        /**
         * Construct a new {@link NullDriverPassed} with the specified detail message.
         */
        public NullDriverProvided() {
            super("The provided WebDriver is null");
        }
    }

    /**
     * Runtime exception when you have passed a null {@link WebDriver}<br>
     * via {@link WebDriverChecker#is(WebDriverChecker, WebDriver...)}.
     */
    public static final class NullDriverPassed extends CheckerException {
        /**
         * Construct a new {@link NullDriverPassed} with the specified detail message.
         */
        public NullDriverPassed() {
            super("The passed WebDriver is null");
        }
    }
}
