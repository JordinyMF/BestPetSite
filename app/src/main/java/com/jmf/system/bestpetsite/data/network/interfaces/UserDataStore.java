package com.jmf.system.bestpetsite.data.network.interfaces;

import com.jmf.system.bestpetsite.data.entities.UserEntity;

import java.util.List;

/**
 * Created by JORDINY on 10/11/2017.
 */

public interface UserDataStore {
    UserEntity loginUserEntity(UserEntity userEntity) throws Exception;

    List<UserEntity> getUserEntityList() throws Exception;

    UserEntity insertUserEntity(UserEntity userEntity) throws Exception;

    UserEntity updateUserEntity(UserEntity userEntity) throws Exception;

    UserEntity deleteUserEntity(UserEntity userEntity) throws Exception;

}
