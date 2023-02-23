package io.algostrategy.client.latoken.exception;

import io.algostrategy.client.latoken.LatokenApiError;

/**
 * An exception which can occur while invoking methods of the Latoken API.
 */
public class LatokenApiException extends RuntimeException {

    private static final long serialVersionUID = -8367853604907027082L;

    private LatokenApiError error;

    public LatokenApiException(LatokenApiError error) {
        this.error = error;
    }

    public LatokenApiException() {
        super();
    }

    public LatokenApiException(String message) {
        super(message);
    }

    public LatokenApiException(Throwable cause) {
        super(cause);
    }

    public LatokenApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from Latoken API.
     */
    public LatokenApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
