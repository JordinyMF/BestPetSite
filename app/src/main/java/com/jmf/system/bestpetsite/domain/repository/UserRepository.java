package com.jmf.system.bestpetsite.domain.repository;

import com.jmf.system.bestpetsite.domain.models.User;

/**
 * Created by JORDINY on 10/11/2017.
 */

public interface UserRepository {

  User loginUserEntity(User user) throws Exception;
}
