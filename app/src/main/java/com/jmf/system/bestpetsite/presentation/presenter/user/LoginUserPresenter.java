package com.jmf.system.bestpetsite.presentation.presenter.user;

import com.jmf.system.bestpetsite.data.entities.mapper.UserEntityDataMapper;
import com.jmf.system.bestpetsite.data.network.retrofit.Token;
import com.jmf.system.bestpetsite.data.repository.UserDataRepository;
import com.jmf.system.bestpetsite.data.repository.datasource.user.UserDataSourceFactoy;
import com.jmf.system.bestpetsite.domain.exception.DefaultErrorBundle;
import com.jmf.system.bestpetsite.domain.exception.ErrorBundle;
import com.jmf.system.bestpetsite.domain.executor.JobExecutor;
import com.jmf.system.bestpetsite.domain.executor.UIThread;
import com.jmf.system.bestpetsite.domain.models.User;
import com.jmf.system.bestpetsite.domain.repository.UserRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;
import com.jmf.system.bestpetsite.domain.usecase.user.LoginUser;
import com.jmf.system.bestpetsite.presentation.exception.ErrorMessageFactory;
import com.jmf.system.bestpetsite.presentation.models.UserModel;
import com.jmf.system.bestpetsite.presentation.models.mapper.UserModelDataMapper;
import com.jmf.system.bestpetsite.presentation.presenter.BasePresenter;
import com.jmf.system.bestpetsite.presentation.view.LoginUserView;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class LoginUserPresenter extends BasePresenter<LoginUserView> {
    private final LoginUser loginUser;
    private final UserModelDataMapper userModelDataMapper;

    public LoginUserPresenter(LoginUserView view) {
        super(view);
        final UserRepository userRepository = new UserDataRepository(
                new UserDataSourceFactoy(), new UserEntityDataMapper());

        this.loginUser = new LoginUser(userRepository,new JobExecutor(), new UIThread() );
        this.userModelDataMapper = new UserModelDataMapper();
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }

    private void showLoadingView() {
        view.showLoading();
    }

    private void hideLoadingView() {
        view.hideLoading();
    }

    private void notifySaveUserSuccess(User user) {
        view.onUserSuccess(userModelDataMapper.transform(user));
    }

    public void loginUser(UserModel userModel) {
        showLoadingView();
        loginUser.setParams(userModelDataMapper.transform(userModel));
        loginUser.execute(new UseCase.Callback<User>() {
            @Override
            public void onSuccess(User user) {
                Token token = new Token(user.getUserToken());
                hideLoadingView();
                notifySaveUserSuccess(user);
            }

            @Override
            public void onError(Throwable e) {
                hideLoadingView();
                showErrorMessage(new DefaultErrorBundle((Exception) e));
            }
        });
    }
}
