package com.jmf.system.bestpetsite.data.entities.mapper;

import com.jmf.system.bestpetsite.data.entities.UserEntity;
import com.jmf.system.bestpetsite.domain.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 9/11/2017.
 */

public class UserEntityDataMapper {

    public User transform(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setFirstName(userEntity.getFirstName());
        user.setLastName(userEntity.getLastName());
        user.setPassword(userEntity.getPassword());
        user.setStatus(userEntity.getStatus());
        user.setUserToken(userEntity.getAccessToken());
        return user;
    }

    public List<User> transform(List<UserEntity> userEntityList){
        List<User> userList=new ArrayList<>();
        for (UserEntity userEntity:userEntityList){
            userList.add(transform(userEntity));
        }
        return userList;
    }
    public UserEntity transform(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLastName(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userEntity.setStatus(user.getStatus());
        userEntity.setUserName(user.getEmail());
        userEntity.setAccessToken(user.getUserToken());

        return userEntity;
    }
}
