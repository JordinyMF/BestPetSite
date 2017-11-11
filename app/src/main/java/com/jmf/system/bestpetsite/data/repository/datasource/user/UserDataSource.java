package com.jmf.system.bestpetsite.data.repository.datasource.user;

import com.jmf.system.bestpetsite.data.entities.UserEntity;

import java.util.List;

/**
 * Created by JORDINY on 10/11/2017.
 */

public interface UserDataSource {
    UserEntity loginUserEntity(UserEntity userEntity) throws Exception;

    List<UserEntity> getUserEntityList() throws Exception;

    UserEntity insertUserEntity(UserEntity userEntity) throws Exception;

    UserEntity updateUserEntity(UserEntity userEntity) throws Exception;

    UserEntity deleteUserEntity(UserEntity userEntity) throws Exception;
}
