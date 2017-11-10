package com.jmf.system.bestpetsite.domain.exception;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class DefaultErrorBundle implements ErrorBundle {

    private static final String DEFAULT_ERROR_MESSAGE = "Unknown error";

    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public Exception getException() {
        return exception;
    }

    @Override
    public String getErrorMessage() {
        return this.exception != null ? this.exception.getMessage() : DEFAULT_ERROR_MESSAGE;
    }
}
