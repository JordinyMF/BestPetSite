package com.jmf.system.bestpetsite.data.network.implementations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.jmf.system.bestpetsite.BPSApplication;
import com.jmf.system.bestpetsite.data.entities.BaseResponseEntity;
import com.jmf.system.bestpetsite.data.entities.PetControlTypeEntity;
import com.jmf.system.bestpetsite.data.exception.NetworkConnectionException;
import com.jmf.system.bestpetsite.data.network.interfaces.PetControlTypeDataStore;
import com.jmf.system.bestpetsite.data.network.retrofit.ApiClient;

import retrofit2.Response;

/**
 * Created by JORDINY on 25/11/2017.
 */

public class RestPetControlTypeDataStore implements PetControlTypeDataStore {
    private String errorConnection="no hay conexión a internet";

    @Override
    public PetControlTypeEntity insertPetControlTypeEntity(PetControlTypeEntity petControlTypeEntity) throws Exception {
        if (!isThereInternetConnection()) {
            throw new NetworkConnectionException(errorConnection);
        }
        Response<BaseResponseEntity<PetControlTypeEntity>> response = ApiClient.getApiToken().insertPetControlType(petControlTypeEntity).execute();
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
