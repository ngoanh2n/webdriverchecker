package com.github.ngoanh2n.wdc;

import com.github.ngoanh2n.RuntimeError;

/**
 * Runtime exception for {@link WebDriverChecker}.
 *
 * @author Ho Huu Ngoan (ngoanh2n@gmail.com)
 */
public class CheckerException extends RuntimeError {
    /**
     * Construct a new runtime exception with the specified detail message.
     *
     * @param message The detail message, is saved for later retrieval by the {@link #getMessage()} method.
     */
    public CheckerException(String message) {
        super(message);
    }

    /**
     * Construct a new runtime exception with the specified cause and a detail message.
     *
     * @param cause The cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A {@code null} value is
     *              permitted, and indicates that the cause is nonexistent or unknown).
     */
    public CheckerException(Throwable cause) {
        super(cause);
    }

    /**
     * Construct a new runtime exception with the specified detail message and cause.
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
}
