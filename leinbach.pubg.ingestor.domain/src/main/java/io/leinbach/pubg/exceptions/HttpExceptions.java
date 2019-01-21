package io.leinbach.pubg.exceptions;

/**
 * @author leinb
 * @since 1/20/2019
 */
public class HttpExceptions extends RuntimeException{
    private final int statusCode;

    public HttpExceptions(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpExceptions(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public HttpExceptions(String message, Throwable cause, int statusCode) {
        super(message, cause);
        this.statusCode = statusCode;
    }

    public HttpExceptions(Throwable cause, int statusCode) {
        super(cause);
        this.statusCode = statusCode;
    }

    public HttpExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int statusCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
