package com.jmf.system.bestpetsite.presentation.view;

import com.jmf.system.bestpetsite.presentation.models.UserModel;

/**
 * Created by OFELIA on 10/11/2017.
 */

public interface AddUserView extends LoadingView {
    void saveUser(UserModel userModel);

    void onUserSuccess(UserModel userModel);
}
