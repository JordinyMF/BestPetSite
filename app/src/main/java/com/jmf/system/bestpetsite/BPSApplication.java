package com.jmf.system.bestpetsite;

import android.app.Application;
import android.content.Context;

/**
 * Created by JORDINY on 8/11/2017.
 * 
 *
 */

public class BPSApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
    }
}
