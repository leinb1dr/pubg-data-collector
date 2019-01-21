package io.leinbach.pubg.exceptions;

/**
 * @author leinb
 * @since 1/20/2019
 */
public class NotFoundException extends HttpExceptions {

    public NotFoundException() {
        super(404);
    }

    public NotFoundException(String message) {
        super(message, 404);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause, 404);
    }

    public NotFoundException(Throwable cause) {
        super(cause, 404);
    }

    public NotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, 404);
    }
}
