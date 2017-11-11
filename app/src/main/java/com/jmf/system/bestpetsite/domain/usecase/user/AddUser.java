package com.jmf.system.bestpetsite.domain.usecase.user;

import com.jmf.system.bestpetsite.domain.executor.PostExecutionThread;
import com.jmf.system.bestpetsite.domain.executor.ThreadExecutor;
import com.jmf.system.bestpetsite.domain.models.User;
import com.jmf.system.bestpetsite.domain.repository.UserRepository;
import com.jmf.system.bestpetsite.domain.usecase.UseCase;

/**
 * Created by OFELIA on 10/11/2017.
 */

public class AddUser extends UseCase<User> {
    private final UserRepository userRepository;
    private User user;

    public AddUser(ThreadExecutor threadExecutor,
                       PostExecutionThread postExecutionThread, UserRepository userRepository) {
        super(threadExecutor, postExecutionThread);

        this.userRepository = userRepository;
    }

    public void setParams(User user){this.user=user;}

    @Override
    protected void buildUseCase() {
        try{
            User returnedUser=this.userRepository.insertUser(this.user);
            notifyUseCaseSuccess(returnedUser);
        }catch (Exception e){
            notifyUseCaseError(e);
        }
    }
}
