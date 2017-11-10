package com.jmf.system.bestpetsite.data.repository.datasource.user;

import com.jmf.system.bestpetsite.data.entities.UserEntity;

/**
 * Created by JORDINY on 10/11/2017.
 */

public interface UserDataSource {
    UserEntity loginUserEntity(UserEntity userEntity) throws Exception;
}
