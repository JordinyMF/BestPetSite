package com.jmf.system.bestpetsite.domain.usecase.user;

import com.jmf.system.bestpetsite.domain.executor.PostExecutionThread;
import com.jmf.system.bestpetsite.domain.executor.ThreadExecutor;
import com.jmf.system.bestpetsite.domain.models.User;
import com.jmf.system.bestpetsite.domain.repository.UserRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class LoginUser extends UseCase<User> {
    private final UserRepository userRepository;
    private User user;
    public LoginUser(UserRepository userRepository,ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }
    public void setParams(User user) {
        this.user = user;
    }
    @Override
    protected void buildUseCase() {
        try {
            User returnedUser = this.userRepository.loginUserEntity(this.user);
            notifyUseCaseSuccess(returnedUser);
        } catch (Exception e) {
            notifyUseCaseError(e);
        }
    }
}
