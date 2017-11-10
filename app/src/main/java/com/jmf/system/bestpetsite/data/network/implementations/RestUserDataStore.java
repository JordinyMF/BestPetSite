package com.jmf.system.bestpetsite.data.network.implementations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jmf.system.bestpetsite.BPSApplication;
import com.jmf.system.bestpetsite.data.entities.UserEntity;
import com.jmf.system.bestpetsite.data.exception.NetworkConnectionException;
import com.jmf.system.bestpetsite.data.network.interfaces.UserDataStore;
import com.jmf.system.bestpetsite.data.network.retrofit.ApiClient;

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
        Response<UserEntity> response = ApiClient.getApiToken().loginUserEntity(userEntity).execute();
        if (response.isSuccessful()) {
            return response.body();
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
