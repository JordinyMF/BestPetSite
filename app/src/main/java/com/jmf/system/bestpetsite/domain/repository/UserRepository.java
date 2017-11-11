package com.jmf.system.bestpetsite.domain.repository;

import com.jmf.system.bestpetsite.domain.models.User;

import java.util.List;

/**
 * Created by JORDINY on 10/11/2017.
 */

public interface UserRepository {

  User loginUserEntity(User user) throws Exception;

  List<User> getUserList() throws Exception;

  User insertUser(User user) throws Exception;

  User updateUser(User user) throws Exception;

  User deleteUser(User user) throws Exception;
}
