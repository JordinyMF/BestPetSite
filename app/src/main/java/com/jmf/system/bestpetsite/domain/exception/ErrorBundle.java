package com.jmf.system.bestpetsite.domain.exception;

/**
 * Created by JORDINY on 9/11/2017.
 */

public interface ErrorBundle {
    Exception getException();

    String getErrorMessage();
}
