package com.jmf.system.bestpetsite.presentation.exception;

import android.content.Context;

import com.jmf.system.bestpetsite.R;
import com.jmf.system.bestpetsite.data.exception.NetworkConnectionException;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class ErrorMessageFactory {
    public ErrorMessageFactory() {

    }

    public static String create(Context context, Exception exception) {
        String message = context.getString(R.string.exception_message_generic);
        if (exception instanceof NetworkConnectionException) {
            message = context.getString(R.string.exception_message_no_connection);
        }
        return message;
    }
}
