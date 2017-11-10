package com.jmf.system.bestpetsite.presentation.presenter;

import com.jmf.system.bestpetsite.presentation.view.BaseView;

/**
 * Created by JORDINY on 9/11/2017.
 */

public abstract class BasePresenter <V extends BaseView> {

    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }

    public abstract void resume();

    public abstract void pause();

    public abstract void destroy();
}

