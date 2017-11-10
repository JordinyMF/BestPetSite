package com.jmf.system.bestpetsite.data.network.interfaces;

import com.jmf.system.bestpetsite.data.entities.UserEntity;

/**
 * Created by JORDINY on 10/11/2017.
 */

public interface UserDataStore {
    UserEntity loginUserEntity(UserEntity userEntity) throws Exception;
}
