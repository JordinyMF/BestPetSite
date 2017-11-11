package com.jmf.system.bestpetsite.presentation.presenter.user;

import com.jmf.system.bestpetsite.data.entities.mapper.UserEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.UserDataRepository;
import com.jmf.system.bestpetsite.data.repository.datasource.user.UserDataSourceFactoy;
import com.jmf.system.bestpetsite.domain.exception.DefaultErrorBundle;
import com.jmf.system.bestpetsite.domain.exception.ErrorBundle;
import com.jmf.system.bestpetsite.domain.executor.JobExecutor;
import com.jmf.system.bestpetsite.domain.executor.UIThread;
import com.jmf.system.bestpetsite.domain.models.User;
import com.jmf.system.bestpetsite.domain.repository.UserRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;
import com.jmf.system.bestpetsite.domain.usecase.user.AddUser;
import com.jmf.system.bestpetsite.presentation.exception.ErrorMessageFactory;
import com.jmf.system.bestpetsite.presentation.models.CustomerModel;
import com.jmf.system.bestpetsite.presentation.models.UserModel;
import com.jmf.system.bestpetsite.presentation.models.mapper.UserModelDataMapper;
import com.jmf.system.bestpetsite.presentation.presenter.BasePresenter;
import com.jmf.system.bestpetsite.presentation.view.AddUserView;

/**
 * Created by OFELIA on 10/11/2017.
 */

public class AddUserPresenter extends BasePresenter<AddUserView> {

    private final AddUser addUser;
    private final UserModelDataMapper userModelDataMapper;

    public AddUserPresenter(AddUserView view) {
        super(view);
        final UserRepository customerRepository = new UserDataRepository(
                new UserDataSourceFactoy(), new UserEntityDataMapper());
        this.addUser = new AddUser(new JobExecutor(), new UIThread(), customerRepository);
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
        addUser.cancel();
        view = null;
    }
    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(view.context(), errorBundle.getException());
        view.showError(errorMessage);
    }
    private void showLoadingView(){
        view.showLoading();
    }
    private void hideLoadingView(){
        view.hideLoading();
    }
    private void notifySaveUserSuccess(User user) {
        view.onUserSuccess(userModelDataMapper.transform(user));
    }

    public void saveUser(UserModel userModel){
        showLoadingView();
        addUser.setParams(userModelDataMapper.transform(userModel));
        addUser.execute(new UseCase.Callback<User>() {
            @Override
            public void onSuccess(User user) {
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
