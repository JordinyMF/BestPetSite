package com.jmf.system.bestpetsite.data.exception;

/**
 * Created by JORDINY on 8/11/2017.
 */

public class NetworkConnectionException extends Exception {
    public NetworkConnectionException() {
        super();
    }

    public NetworkConnectionException(final String message) {
        super(message);
    }

    public NetworkConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NetworkConnectionException(final Throwable cause) {
        super(cause);
    }
}
