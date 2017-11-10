package com.jmf.system.bestpetsite.presentation.view;

/**
 * Created by JORDINY on 9/11/2017.
 */

public interface LoadingView extends BaseView {
    void showLoading();

    void hideLoading();

    void showError(String errorMessage);
}
