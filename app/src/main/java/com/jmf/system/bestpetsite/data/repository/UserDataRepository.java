package com.jmf.system.bestpetsite.data.repository;

import com.jmf.system.bestpetsite.data.entities.UserEntity;
import com.jmf.system.bestpetsite.data.entities.mapper.UserEntityDataMapper;
import com.jmf.system.bestpetsite.data.repository.datasource.user.UserDataSource;
import com.jmf.system.bestpetsite.data.repository.datasource.user.UserDataSourceFactoy;
import com.jmf.system.bestpetsite.domain.models.User;
import com.jmf.system.bestpetsite.domain.repository.UserRepository;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class UserDataRepository implements UserRepository {
    private  final UserDataSourceFactoy userDataSourceFactoy;
    private final UserEntityDataMapper userEntityDataMapper;

    public UserDataRepository(UserDataSourceFactoy userDataSourceFactoy, UserEntityDataMapper userEntityDataMapper) {
        this.userDataSourceFactoy = userDataSourceFactoy;
        this.userEntityDataMapper = userEntityDataMapper;
    }

    @Override
    public User loginUserEntity(User user) throws Exception {
        final UserDataSource userDataSource=this.userDataSourceFactoy.createNetworkUserDataSource();
        UserEntity userEntity=userDataSource.loginUserEntity(userEntityDataMapper.transform(user));
        return userEntityDataMapper.transform(userEntity);
    }
}
