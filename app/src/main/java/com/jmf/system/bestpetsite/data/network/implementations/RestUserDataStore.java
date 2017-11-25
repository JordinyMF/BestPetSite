package com.jmf.system.bestpetsite.data.network.implementations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jmf.system.bestpetsite.BPSApplication;
import com.jmf.system.bestpetsite.data.entities.BaseResponseEntity;
import com.jmf.system.bestpetsite.data.entities.UserEntity;
import com.jmf.system.bestpetsite.data.exception.NetworkConnectionException;
import com.jmf.system.bestpetsite.data.network.interfaces.UserDataStore;
import com.jmf.system.bestpetsite.data.network.retrofit.ApiClient;

import java.util.List;

import retrofit2.Response;

/**
 * Created by JORDINY on 10/11/2017.
 */

public class RestUserDataStore implements UserDataStore {
    private String errorConnection="no hay conexión a internet";

    @Override
    public UserEntity loginUserEntity(UserEntity userEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<UserEntity> response = ApiClient.getApiToken().loginUserEntity("password",userEntity.getUserName(),userEntity.getPassword()).execute();
        if (response.isSuccessful()) {
            return response.body();
        } else if (response.code()==400) {
            if(response.body().getError()==-1){
                throw new NetworkConnectionException(response.body().getMessage());
            }else {
                throw new NetworkConnectionException();
            }

        }else{
            throw new NetworkConnectionException();
        }
    }

    @Override
    public List<UserEntity> getUserEntityList() throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<List<UserEntity>>> response = ApiClient.getApi().getUserList().execute();
        if (response.isSuccessful()) {
            if (response.body().isOk()) {
                return response.body().getContent();
            } else {
                throw new NetworkConnectionException(response.body().getResponse().getMessage());
            }
        } else {
            throw new NetworkConnectionException();
        }
    }

    @Override
    public UserEntity insertUserEntity(UserEntity userEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<UserEntity>> response = ApiClient.getApiToken().insertUser(userEntity).execute();
        if (response.isSuccessful()) {
            if (response.body().isOk()) {
                return response.body().getContent();
            } else {
                throw new NetworkConnectionException(response.body().getResponse().getMessage());
            }
        } else {
            throw new NetworkConnectionException();
        }
    }

    @Override
    public UserEntity updateUserEntity(UserEntity userEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<UserEntity>> response = ApiClient.getApi().updateUser(userEntity).execute();
        if (response.isSuccessful()) {
            if (response.body().isOk()) {
                return response.body().getContent();
            } else {
                throw new NetworkConnectionException(response.body().getResponse().getMessage());
            }
        } else {
            throw new NetworkConnectionException();
        }
    }

    @Override
    public UserEntity deleteUserEntity(UserEntity userEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<UserEntity>> response = ApiClient.getApi().deleteUser(userEntity.getId()).execute();
        if (response.isSuccessful()) {
            if (response.body().isOk()) {
                return response.body().getContent();
            } else {
                throw new NetworkConnectionException(response.body().getResponse().getMessage());
            }
        } else {
            throw new NetworkConnectionException();
        }
    }

    private boolean isThereInternetConnection() {
        boolean isConnected;
        ConnectivityManager connectivityManager =
                (ConnectivityManager) BPSApplication.context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

        return isConnected;
    }
}
