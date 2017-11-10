package com.jmf.system.bestpetsite.data.repository.datasource.user;

import com.jmf.system.bestpetsite.data.entities.UserEntity;
import com.jmf.system.bestpetsite.data.network.implementations.RestUserDataStore;
import com.jmf.system.bestpetsite.data.network.interfaces.UserDataStore;

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
}
