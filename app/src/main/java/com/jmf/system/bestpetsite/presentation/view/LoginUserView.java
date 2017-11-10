package com.jmf.system.bestpetsite.presentation.view;

import com.jmf.system.bestpetsite.presentation.models.UserModel;

/**
 * Created by JORDINY on 10/11/2017.
 */

public interface LoginUserView extends LoadingView {
    void loginUser(UserModel userModel);

    void onUserSuccess(UserModel userModel);
}
