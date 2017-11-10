package com.jmf.system.bestpetsite.domain.executor;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class UIThread implements PostExecutionThread {

    private Handler uiHandler = new Handler(Looper.getMainLooper());
    @Override
    public void execute(@NonNull Runnable runnable) {
        uiHandler.post(runnable);
    }
}
