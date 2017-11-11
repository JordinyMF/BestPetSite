package com.jmf.system.bestpetsite.data.repository.datasource.user;

import com.jmf.system.bestpetsite.data.entities.UserEntity;
import com.jmf.system.bestpetsite.data.network.implementations.RestUserDataStore;
import com.jmf.system.bestpetsite.data.network.interfaces.UserDataStore;

import java.util.List;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class NetworkUserDataSource implements UserDataSource {
    private final UserDataStore userDataStore;

    public NetworkUserDataSource() {
        this.userDataStore = new RestUserDataStore();
    }

    @Override
    public UserEntity loginUserEntity(UserEntity userEntity) throws Exception {
        return userDataStore.loginUserEntity(userEntity);
    }

    @Override
    public List<UserEntity> getUserEntityList() throws Exception {
        return userDataStore.getUserEntityList();
    }

    @Override
    public UserEntity insertUserEntity(UserEntity userEntity) throws Exception {
        return userDataStore.insertUserEntity(userEntity);
    }

    @Override
    public UserEntity updateUserEntity(UserEntity userEntity) throws Exception {
        return userDataStore.updateUserEntity(userEntity);
    }

    @Override
    public UserEntity deleteUserEntity(UserEntity userEntity) throws Exception {
        return userDataStore.deleteUserEntity(userEntity);
    }
}
