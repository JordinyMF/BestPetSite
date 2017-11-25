package com.jmf.system.bestpetsite.presentation.models.mapper;

import com.jmf.system.bestpetsite.domain.models.User;
import com.jmf.system.bestpetsite.presentation.models.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class UserModelDataMapper {

    public UserModel transform(User user) {
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setEmail(user.getEmail());
        userModel.setFirstName(user.getFirstName());
        userModel.setLastName(user.getLastName());
        userModel.setPassword(user.getPassword());
        userModel.setStatus(user.getStatus());
        userModel.setUserToken(user.getUserToken());
        userModel.setMessage(user.getMessage());
        return userModel;
    }

    public List<UserModel> transform(List<User> userList){
        List<UserModel> userModelList=new ArrayList<>();
        for (User user :userList){
            userModelList.add(transform(user));
        }
        return userModelList;
    }
    public User transform(UserModel userModel){
        User user = new User();
        user.setId(userModel.getId());
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(userModel.getPassword());
        user.setStatus(user.getStatus());
        user.setUserToken(userModel.getUserToken());
        user.setMessage(userModel.getMessage());
        return user;
    }
}
